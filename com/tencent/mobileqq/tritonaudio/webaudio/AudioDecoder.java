package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes19.dex */
class AudioDecoder {
    private static final long DEFAULT_TIMEOUT = 2000;
    private static final String TAG = "AudioDecoder";
    private MediaCodec mediaCodec;
    private MediaExtractor mediaExtractor;
    private MediaFormat oformat;
    private OnDecodeProcessListener onDecodeProcessListener;
    private boolean isFirst = true;
    private int decodeId = -1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface OnDecodeProcessListener {
        void onDecodeProcess(byte[] bArr, MediaFormat mediaFormat, boolean z16, boolean z17);
    }

    @RequiresApi(api = 16)
    private byte[] doDecode() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z16 = false;
        boolean z17 = false;
        while (true) {
            if (z16) {
                break;
            }
            if (!z17) {
                try {
                    try {
                        int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(2000L);
                        if (dequeueInputBuffer >= 0) {
                            int readSampleData = this.mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                            if (readSampleData < 0) {
                                this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                z17 = true;
                            } else {
                                this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mediaExtractor.getSampleTime(), 0);
                                this.mediaExtractor.advance();
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        byteArrayOutputStream.close();
                        this.mediaCodec.stop();
                        this.mediaCodec.release();
                        this.mediaExtractor.release();
                        return null;
                    }
                } finally {
                }
            }
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 2000L);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    int i3 = bufferInfo.size;
                    if (i3 != 0) {
                        byte[] bArr = new byte[i3];
                        outputBuffers[dequeueOutputBuffer].get(bArr);
                        OnDecodeProcessListener onDecodeProcessListener = this.onDecodeProcessListener;
                        if (onDecodeProcessListener != null) {
                            onDecodeProcessListener.onDecodeProcess(bArr, this.oformat, this.isFirst, false);
                            this.isFirst = false;
                        }
                        byteArrayOutputStream.write(bArr);
                    }
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        z16 = true;
                    }
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.mediaCodec.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                this.oformat = this.mediaCodec.getOutputFormat();
            }
            e16.printStackTrace();
            try {
                byteArrayOutputStream.close();
                this.mediaCodec.stop();
                this.mediaCodec.release();
                this.mediaExtractor.release();
                return null;
            } catch (Exception e17) {
                Log.e(TAG, "doDecode: ", e17);
                return null;
            }
        }
        OnDecodeProcessListener onDecodeProcessListener2 = this.onDecodeProcessListener;
        if (onDecodeProcessListener2 != null) {
            onDecodeProcessListener2.onDecodeProcess(null, this.oformat, false, true);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            this.mediaCodec.stop();
            this.mediaCodec.release();
            this.mediaExtractor.release();
        } catch (Exception e18) {
            Log.e(TAG, "doDecode: ", e18);
        }
        return byteArray;
    }

    @RequiresApi(api = 16)
    private boolean initMediaCodec() {
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= this.mediaExtractor.getTrackCount()) {
                    break;
                }
                MediaFormat trackFormat = this.mediaExtractor.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (string.startsWith("audio")) {
                    this.mediaExtractor.selectTrack(i3);
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                    this.mediaCodec = createDecoderByType;
                    createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                    break;
                }
                i3++;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        }
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec == null) {
            return false;
        }
        mediaCodec.start();
        return true;
    }

    @RequiresApi(api = 16)
    private boolean initMediaExtractor(String str) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            return true;
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @RequiresApi(api = 21)
    private void testRawData(byte[] bArr) {
        int i3;
        if (this.oformat.getInteger("channel-count") == 1) {
            i3 = 4;
        } else {
            i3 = 12;
        }
        ReportAudioTrack reportAudioTrack = new ReportAudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(this.oformat.getInteger("sample-rate")).setChannelMask(i3).setEncoding(this.oformat.getInteger("pcm-encoding")).build(), bArr.length, 0, 0);
        reportAudioTrack.write(bArr, 0, bArr.length);
        reportAudioTrack.play();
    }

    @RequiresApi(api = 16)
    public byte[] decodeByPath(String str, int i3) {
        this.decodeId = i3;
        if (initMediaExtractor(str) && initMediaCodec()) {
            return doDecode();
        }
        return null;
    }

    @RequiresApi(api = 23)
    public byte[] decodeInMemory(byte[] bArr, int i3) {
        this.decodeId = i3;
        if (initMediaExtractor(bArr) && initMediaCodec()) {
            return doDecode();
        }
        return null;
    }

    @RequiresApi(api = 16)
    public int getBitsPerChannel() {
        int i3;
        MediaFormat mediaFormat = this.oformat;
        if (mediaFormat == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (mediaFormat.containsKey("pcm-encoding")) {
                i3 = this.oformat.getInteger("pcm-encoding");
            } else {
                i3 = 2;
            }
            if (i3 == 3) {
                return 8;
            }
            return 16;
        }
        return mediaFormat.getInteger("bit-width");
    }

    @RequiresApi(api = 16)
    public int getChannelCount() {
        MediaFormat mediaFormat = this.oformat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger("channel-count");
    }

    @RequiresApi(api = 16)
    public int getSampleRate() {
        MediaFormat mediaFormat = this.oformat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger("sample-rate");
    }

    public void setOnDecodeProcessListener(OnDecodeProcessListener onDecodeProcessListener) {
        this.onDecodeProcessListener = onDecodeProcessListener;
    }

    @RequiresApi(api = 23)
    private boolean initMediaExtractor(byte[] bArr) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(new MyMediaDataSource(bArr));
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @RequiresApi(api = 23)
    /* loaded from: classes19.dex */
    public class MyMediaDataSource extends MediaDataSource {
        private byte[] inputData;

        public MyMediaDataSource(byte[] bArr) {
            this.inputData = bArr;
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            if (this.inputData == null) {
                return -1L;
            }
            return r0.length;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
            byte[] bArr2 = this.inputData;
            if (bArr2 == null || j3 < 0 || j3 >= bArr2.length) {
                return -1;
            }
            long j16 = i16;
            if (j3 + j16 >= bArr2.length) {
                j16 = bArr2.length - j3;
            }
            int i17 = (int) j16;
            System.arraycopy(bArr2, (int) j3, bArr, i3, i17);
            return i17;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
