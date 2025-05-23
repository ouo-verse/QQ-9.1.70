package com.tencent.mobileqq.triton.screenrecord.encoder;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MediaAudioEncoder extends MediaEncoder {
    private static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    private static final int BIT_RATE = 64000;
    private static final boolean DEBUG = true;
    private static final int FRAMES_PER_BUFFER = 25;
    private static final String MIME_TYPE = "audio/mp4a-latm";
    private static final int SAMPLES_PER_FRAME = 1024;
    private static final int SAMPLE_RATE = 44100;
    private static final String TAG = "MediaAudioEncoder";
    private AudioReader mAudioReader;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class AudioReader extends BaseThread {
        private final Object mLock;
        private boolean mStopped;

        AudioReader() {
            this.mLock = new Object();
        }

        private int calcBufferSize() {
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            if (25600 >= minBufferSize) {
                return 25600;
            }
            return ((minBufferSize / 1024) + 1) * 1024 * 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        
            if (r4.getState() != 1) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private AudioRecord createAudioRecord(int i3) {
            int[] iArr = MediaAudioEncoder.AUDIO_SOURCES;
            int length = iArr.length;
            int i16 = 0;
            AudioRecord audioRecord = null;
            while (i16 < length) {
                try {
                    audioRecord = new AudioRecord(iArr[i16], 44100, 16, 2, i3);
                } catch (Exception unused) {
                }
            }
            return audioRecord;
            audioRecord = null;
            if (audioRecord == null) {
                i16++;
            } else {
                return audioRecord;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        
            if (r3 <= 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        
            r2.position(r3);
            r2.flip();
            r4 = r7.this$0;
            r4.encode(r2, r3, r4.getPTSUs());
            r7.this$0.frameAvailableSoon();
         */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                AudioRecord createAudioRecord = createAudioRecord(calcBufferSize());
                try {
                    if (createAudioRecord != null) {
                        try {
                            Logger.d(MediaAudioEncoder.TAG, "AudioThread:start audio recording");
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                            AudioMonitor.startRecording(createAudioRecord);
                            while (true) {
                                try {
                                    try {
                                        allocateDirect.clear();
                                        int read = createAudioRecord.read(allocateDirect, 1024);
                                        synchronized (this.mLock) {
                                            if (this.mStopped) {
                                                break;
                                            }
                                        }
                                    } finally {
                                        createAudioRecord.stop();
                                    }
                                } catch (Exception e16) {
                                    Logger.e(MediaAudioEncoder.TAG, "read audio failed", e16);
                                }
                            }
                        } catch (Exception e17) {
                            Logger.e(MediaAudioEncoder.TAG, "startRecording failed", e17);
                        }
                    } else {
                        Logger.e(MediaAudioEncoder.TAG, "failed to initialize AudioRecord");
                    }
                } finally {
                    createAudioRecord.release();
                }
            } catch (Exception e18) {
                Logger.e(MediaAudioEncoder.TAG, "AudioThread#run", e18);
            }
            Logger.d(MediaAudioEncoder.TAG, "AudioThread:finished");
        }

        public void terminate(boolean z16) {
            synchronized (this.mLock) {
                this.mStopped = true;
            }
            if (z16) {
                try {
                    join();
                } catch (InterruptedException e16) {
                    Logger.e(MediaAudioEncoder.TAG, "terminate interrupted", e16);
                }
            }
        }
    }

    public MediaAudioEncoder(MediaMuxerController mediaMuxerController) {
        super(mediaMuxerController);
    }

    private static MediaCodecInfo selectAudioCodec(String str) {
        Logger.d(TAG, "selectAudioCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int i16 = 0;
                while (true) {
                    if (i16 < supportedTypes.length) {
                        Logger.i(TAG, "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i16]);
                        if (supportedTypes[i16].equalsIgnoreCase(str) && mediaCodecInfo == null) {
                            mediaCodecInfo = codecInfoAt;
                            break;
                        }
                        i16++;
                    }
                }
            }
        }
        return mediaCodecInfo;
    }

    private void startAudioReader() {
        if (this.mAudioReader == null) {
            AudioReader audioReader = new AudioReader();
            this.mAudioReader = audioReader;
            audioReader.start();
        }
    }

    private void stopAudioReader() {
        AudioReader audioReader = this.mAudioReader;
        if (audioReader != null) {
            audioReader.terminate(true);
            this.mAudioReader = null;
        }
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    protected MediaCodec createMediaCodec() throws IOException {
        MediaCodecInfo selectAudioCodec = selectAudioCodec("audio/mp4a-latm");
        if (selectAudioCodec != null) {
            Logger.i(TAG, "selected codec: " + selectAudioCodec.getName());
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("channel-mask", 16);
            createAudioFormat.setInteger("bitrate", BIT_RATE);
            createAudioFormat.setInteger("channel-count", 1);
            Logger.i(TAG, "format: " + createAudioFormat);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        Logger.e(TAG, "Unable to find an appropriate codec for audio/mp4a-latm");
        throw new IOException("no codec for audio/mp4a-latm");
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    protected void onMediaCodecCreated(MediaCodec mediaCodec) {
        mediaCodec.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    public void start() {
        super.start();
        startAudioReader();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    public void stop() {
        super.stop();
        stopAudioReader();
    }
}
