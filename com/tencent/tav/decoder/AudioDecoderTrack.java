package com.tencent.tav.decoder;

import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.Player;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioDecoderTrack implements IDecoderTrack {
    private static String TAG = "AudioDecoderTrack";
    private float _speed;
    private boolean asyncEnable;
    private AudioInfo audioInfo;
    private AudioMixer audioMixer;
    private AudioDecoder currentDecoder;
    private final Object currentDecoderLock;
    private CMTime currentSegmentStartTime;
    private AudioDecoderCreateThread decoderCreateThread;
    private final DecoderThread decoderThread;
    private CMTime duration;
    private ByteBuffer emptyAudioBuffer;
    private boolean isEmptyFrame;
    private boolean isReleased;

    @NonNull
    private CMSampleState lastSampleState;
    private DecoderWrapper nextDecoder;
    private final Object nextDecoderLock;
    private boolean started;
    private boolean preRead = false;
    private CMTime frameDuration = new CMTime(92880, 1000000);
    private int frameRate = 11;
    private float volume = 1.0f;
    private int trackID = -1;
    private ArrayList<DecoderTrackSegment> segments = new ArrayList<>();
    private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Audio;
    private int segmentIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class AudioDecoderCreateThread extends BaseThread {
        DecoderAssetTrack extractor;
        private Surface outputSurface;
        private int segmentIndex;

        /* JADX WARN: Removed duplicated region for block: B:54:0x0104  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void createDecoder() {
            IAudioDecoder iAudioDecoder;
            Throwable th5;
            Exception e16;
            AudioDecoderTrack audioDecoderTrack;
            if (AudioDecoderTrack.this.segments == null || this.segmentIndex >= AudioDecoderTrack.this.segments.size() || AudioDecoderTrack.this.isReleased || TextUtils.isEmpty(this.extractor.assetPath)) {
                Logger.e(AudioDecoderTrack.TAG, "createDecoder skip - " + this.extractor.assetPath);
                return;
            }
            try {
                try {
                    iAudioDecoder = AudioDecoderTrack.this.newDecoder(this.extractor);
                    if (iAudioDecoder != null) {
                        try {
                            try {
                                iAudioDecoder.start(((DecoderTrackSegment) AudioDecoderTrack.this.segments.get(this.segmentIndex)).getTimeRange(), ((DecoderTrackSegment) AudioDecoderTrack.this.segments.get(this.segmentIndex)).getDecoderStartTime());
                                AudioDecoderTrack.this.nextDecoder = new DecoderWrapper();
                                AudioDecoderTrack.this.nextDecoder.decoder = iAudioDecoder;
                                AudioDecoderTrack.this.nextDecoder.extractor = this.extractor;
                                AudioDecoderTrack.this.nextDecoder.segmentIndex = this.segmentIndex;
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (AudioDecoderTrack.this.isReleased) {
                                    Logger.d(AudioDecoderTrack.TAG, "createDecoder: released");
                                    if (iAudioDecoder != null) {
                                        try {
                                            iAudioDecoder.release();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    try {
                                        if (AudioDecoderTrack.this.nextDecoder != null) {
                                            AudioDecoderTrack.this.nextDecoder.release();
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e17) {
                            e16 = e17;
                            e16.printStackTrace();
                            if (iAudioDecoder != null) {
                                try {
                                    iAudioDecoder.release();
                                } catch (Exception unused3) {
                                }
                            }
                            if (AudioDecoderTrack.this.isReleased) {
                                Logger.d(AudioDecoderTrack.TAG, "createDecoder: released");
                                if (iAudioDecoder != null) {
                                    try {
                                        iAudioDecoder.release();
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (AudioDecoderTrack.this.nextDecoder != null) {
                                    audioDecoderTrack = AudioDecoderTrack.this;
                                    audioDecoderTrack.nextDecoder.release();
                                }
                                return;
                            }
                            return;
                        }
                    }
                    Logger.d(AudioDecoderTrack.TAG, "DecoderCreateThread success - " + this.extractor.assetPath);
                } catch (Exception e18) {
                    iAudioDecoder = null;
                    e16 = e18;
                } catch (Throwable th7) {
                    iAudioDecoder = null;
                    th5 = th7;
                    if (AudioDecoderTrack.this.isReleased) {
                    }
                    throw th5;
                }
                if (AudioDecoderTrack.this.isReleased) {
                    Logger.d(AudioDecoderTrack.TAG, "createDecoder: released");
                    if (iAudioDecoder != null) {
                        try {
                            iAudioDecoder.release();
                        } catch (Exception unused5) {
                        }
                    }
                    if (AudioDecoderTrack.this.nextDecoder != null) {
                        audioDecoderTrack = AudioDecoderTrack.this;
                        audioDecoderTrack.nextDecoder.release();
                    }
                }
            } catch (Exception unused6) {
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z16;
            String str = AudioDecoderTrack.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AudioDecoderCreateThread start - ");
            sb5.append(this.extractor.assetPath);
            sb5.append(" - ");
            if (this.outputSurface != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            Logger.d(str, sb5.toString());
            if (AudioDecoderTrack.this.isReleased) {
                AudioDecoderTrack.this.decoderCreateThread = null;
                return;
            }
            synchronized (AudioDecoderTrack.this.nextDecoderLock) {
                if (AudioDecoderTrack.this.nextDecoder == null || !AudioDecoderTrack.isSameExtractor(AudioDecoderTrack.this.nextDecoder.extractor, this.extractor)) {
                    if (AudioDecoderTrack.this.nextDecoder != null) {
                        Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread create - " + this.extractor.assetPath);
                        if (AudioDecoderTrack.this.nextDecoder.decoder != null && AudioDecoderTrack.this.nextDecoder.decoder != AudioDecoderTrack.this.currentDecoder) {
                            AudioDecoderTrack.this.nextDecoder.release();
                            AudioDecoderTrack.this.nextDecoder = null;
                        }
                        createDecoder();
                    } else {
                        createDecoder();
                    }
                }
            }
            AudioDecoderTrack.this.decoderCreateThread = null;
            if (AudioDecoderTrack.this.isReleased) {
                synchronized (AudioDecoderTrack.this.nextDecoderLock) {
                    if (AudioDecoderTrack.this.nextDecoder != null) {
                        AudioDecoderTrack.this.nextDecoder.release();
                        AudioDecoderTrack.this.nextDecoder = null;
                    }
                }
            }
            Logger.d(AudioDecoderTrack.TAG, "AudioDecoderCreateThread finish - " + this.extractor.assetPath);
        }

        AudioDecoderCreateThread(DecoderAssetTrack decoderAssetTrack, Surface surface, int i3) {
            super("AudioDCreateThread " + decoderAssetTrack.assetPath);
            this.extractor = decoderAssetTrack;
            this.outputSurface = surface;
            this.segmentIndex = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class CacheBuffer {
        private CMTime frameTime;
        private CMTime preFrameTime;
        private CMSampleBuffer sampleBuffer;

        CacheBuffer() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "AudioAsyncDecoderThread";
        private final Object nextFrameDecoderLock;
        private CacheBuffer pcmFrame;

        public DecoderThread() {
            super(NAME);
            this.nextFrameDecoderLock = new Object();
        }

        @Override // com.tencent.tav.decoder.ReActionThread
        protected void doAction() {
            CMSampleBuffer cMSampleBuffer;
            synchronized (this.nextFrameDecoderLock) {
                if (this.pcmFrame != null) {
                    if (AudioDecoderTrack.this.lastSampleState.getTime() == CMTime.CMTimeInvalid) {
                        Logger.v(AudioDecoderTrack.TAG, "doAction: CMTime.CMTimeZero");
                        cMSampleBuffer = AudioDecoderTrack.this.doReadSample(CMTime.CMTimeZero);
                    } else if (!AudioDecoderTrack.this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero)) {
                        Logger.v(AudioDecoderTrack.TAG, "doAction: lastSampleTime.add(frameDuration)");
                        AudioDecoderTrack audioDecoderTrack = AudioDecoderTrack.this;
                        cMSampleBuffer = audioDecoderTrack.doReadSample(audioDecoderTrack.lastSampleState.getTime().add(AudioDecoderTrack.this.frameDuration));
                    } else {
                        cMSampleBuffer = null;
                    }
                    if (cMSampleBuffer != null) {
                        if (cMSampleBuffer.getSampleByteBuffer() != null) {
                            Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
                            cMSampleBuffer.setSampleByteBuffer(AudioDecoderTrack.this.processFrame(cMSampleBuffer.getSampleByteBuffer(), 1.0f, AudioDecoderTrack.this._speed, AudioDecoderTrack.this.getAudioInfo()));
                            Logger.v(AudioDecoderTrack.TAG, "doAction: processFrame finish [volume " + AudioDecoderTrack.this.volume + "] [_speed " + AudioDecoderTrack.this._speed + "]");
                        }
                        CacheBuffer cacheBuffer = new CacheBuffer();
                        this.pcmFrame = cacheBuffer;
                        cacheBuffer.preFrameTime = AudioDecoderTrack.this.lastSampleState.getTime();
                        this.pcmFrame.frameTime = cMSampleBuffer.getTime();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class DecoderWrapper {
        IAudioDecoder decoder;
        DecoderAssetTrack extractor;
        int segmentIndex;

        DecoderWrapper() {
            this.segmentIndex = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            Logger.d(AudioDecoderTrack.TAG, "Audio DecoderWrapper release: ");
            try {
                IAudioDecoder iAudioDecoder = this.decoder;
                if (iAudioDecoder != null) {
                    iAudioDecoder.release();
                }
            } catch (Error | Exception unused) {
            }
        }
    }

    public AudioDecoderTrack() {
        CMTime cMTime = CMTime.CMTimeZero;
        this.currentSegmentStartTime = cMTime;
        this.lastSampleState = new CMSampleState();
        this.decoderCreateThread = null;
        this.nextDecoderLock = new Object();
        this.currentDecoderLock = new Object();
        this.isReleased = false;
        this.decoderThread = new DecoderThread();
        this.audioMixer = new AudioMixer();
        this.audioInfo = new AudioInfo();
        this.isEmptyFrame = false;
        this._speed = 1.0f;
        this.started = false;
        this.duration = cMTime;
        this.asyncEnable = Player.getPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_AUDIO_SYNC_ENABLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r8.segments.get(r5.segmentIndex) == r9) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        r6.start(r9.getTimeRange(), r9.getDecoderStartTime());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        r8.nextDecoder = null;
        com.tencent.tav.decoder.logger.Logger.d(com.tencent.tav.decoder.AudioDecoderTrack.TAG, "hint decoder - audio  " + r6.getSourcePath());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e1, code lost:
    
        if (r8.segments.get(r5.segmentIndex) == r9) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00e3, code lost:
    
        r6.start(r9.getTimeRange(), r9.getDecoderStartTime());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ee, code lost:
    
        com.tencent.tav.decoder.logger.Logger.d(com.tencent.tav.decoder.AudioDecoderTrack.TAG, "hint decoder - audio  " + r6.getSourcePath() + ", segmentIndex: " + r8.segmentIndex + ", nextDecoder.segmentIndex: " + r8.nextDecoder.segmentIndex);
        r8.nextDecoder = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0125, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0184, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized IDecoder createDecoder(@NonNull DecoderTrackSegment decoderTrackSegment, CMTime cMTime) {
        DecoderAssetTrack videoAsset = decoderTrackSegment.getVideoAsset();
        Logger.d(TAG, "createDecoder - " + videoAsset.assetPath + " - audio");
        int i3 = 5;
        loop0: while (true) {
            IAudioDecoder iAudioDecoder = null;
            while (iAudioDecoder == null && i3 > 0) {
                i3--;
                AudioDecoderCreateThread audioDecoderCreateThread = this.decoderCreateThread;
                if (audioDecoderCreateThread != null) {
                    int i16 = audioDecoderCreateThread.segmentIndex;
                    if (i16 < this.segments.size() && isSameExtractor(this.segments.get(i16).getVideoAsset(), videoAsset)) {
                        synchronized (this.nextDecoderLock) {
                            DecoderWrapper decoderWrapper = this.nextDecoder;
                            if (decoderWrapper != null && isSameExtractor(decoderWrapper.extractor, videoAsset) && (r6 = (r5 = this.nextDecoder).decoder) != null) {
                                break loop0;
                            }
                        }
                    }
                } else {
                    Logger.d(TAG, "check  decoder - " + videoAsset.assetPath);
                    DecoderWrapper decoderWrapper2 = this.nextDecoder;
                    if (decoderWrapper2 != null && isSameExtractor(decoderWrapper2.extractor, videoAsset) && this.nextDecoder.decoder != null) {
                        synchronized (this.nextDecoderLock) {
                            DecoderWrapper decoderWrapper3 = this.nextDecoder;
                            if (decoderWrapper3 != null && decoderWrapper3.extractor == videoAsset && (r6 = decoderWrapper3.decoder) != null) {
                                break loop0;
                            }
                        }
                    }
                }
                if (decoderTrackSegment.getTimeRange() == null) {
                    return null;
                }
                try {
                    iAudioDecoder = newDecoder(videoAsset);
                    if (iAudioDecoder != null) {
                        iAudioDecoder.start(decoderTrackSegment.getTimeRange(), cMTime);
                        Logger.d(TAG, "createDecoder new Decoder success - " + videoAsset.assetPath);
                    }
                } catch (Exception e16) {
                    Logger.e(TAG, " createDecoder " + e16.getMessage() + e16);
                    if (iAudioDecoder != null) {
                        try {
                            iAudioDecoder.release();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    private synchronized void createNextDecoder(int i3) {
        ArrayList<DecoderTrackSegment> arrayList = this.segments;
        if (arrayList != null && this.preRead) {
            int i16 = i3 + 1;
            if (i16 >= arrayList.size()) {
                return;
            }
            if (this.decoderCreateThread == null) {
                DecoderAssetTrack videoAsset = this.segments.get(i16).getVideoAsset();
                if (videoAsset != null) {
                    DecoderWrapper decoderWrapper = this.nextDecoder;
                    if (decoderWrapper == null || !isSameExtractor(decoderWrapper.extractor, videoAsset)) {
                        try {
                            AudioDecoderCreateThread audioDecoderCreateThread = new AudioDecoderCreateThread(videoAsset, null, i16);
                            this.decoderCreateThread = audioDecoderCreateThread;
                            audioDecoderCreateThread.start();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                } else if (this.nextDecoder != null && i3 >= 0 && i3 < this.segments.size()) {
                    DecoderWrapper decoderWrapper2 = this.nextDecoder;
                    if (decoderWrapper2.segmentIndex != i3) {
                        decoderWrapper2.decoder.start(this.segments.get(i3).getTimeRange());
                        this.nextDecoder.segmentIndex = i3;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CMSampleBuffer doReadSample(CMTime cMTime) {
        ByteBuffer outputBuffer;
        CMSampleBuffer cMSampleBuffer;
        synchronized (this) {
            if (this.isReleased) {
                Logger.e(TAG, "doReadSample: has released");
                return new CMSampleBuffer(CMSampleState.fromError(-1L));
            }
            CMSampleState fromError = CMSampleState.fromError(-1L);
            this.isEmptyFrame = false;
            int i3 = this.segmentIndex;
            if (i3 == -1) {
                Logger.i(TAG, "doReadSample: segmentIndex == -1");
                if (this.lastSampleState.getStateCode() < -1) {
                    cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100L));
                } else {
                    cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1L));
                }
                return cMSampleBuffer;
            }
            DecoderTrackSegment decoderTrackSegment = this.segments.get(i3);
            while (true) {
                if (this.currentDecoder == null) {
                    CMTime cMTime2 = CMTime.CMTimeZero;
                    if (!this.lastSampleState.isInvalid()) {
                        cMTime2 = this.lastSampleState.getTime().add(this.frameDuration);
                    }
                    if (cMTime2.smallThan(this.currentSegmentStartTime.add(decoderTrackSegment.getScaledDuration()))) {
                        this.isEmptyFrame = true;
                        Logger.v(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
                        return new CMSampleBuffer(cMTime2, outputBuffer());
                    }
                } else if (this.lastSampleState.getTime().sub(this.currentSegmentStartTime).multi(this._speed).bigThan(decoderTrackSegment.getScaledDuration().multi(this._speed))) {
                    fromError = CMSampleState.fromError(-1L);
                } else {
                    fromError = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
                }
                ByteBuffer byteBuffer = null;
                if (fromError.getStateCode() == -1) {
                    CMTime add = decoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime);
                    CMTime add2 = this.lastSampleState.getTime().add(this.frameDuration);
                    if (add.bigThan(add2)) {
                        AudioDecoder audioDecoder = this.currentDecoder;
                        if (audioDecoder == null) {
                            outputBuffer = getEmptyAudioBuffer();
                        } else {
                            outputBuffer = audioDecoder.outputBuffer();
                        }
                        Logger.v(TAG, "doReadSample: finish && !end");
                        if (outputBuffer == null) {
                            outputBuffer = getEmptyAudioBuffer();
                        }
                        return new CMSampleBuffer(add2, outputBuffer);
                    }
                    if (!nextSegment(true)) {
                        Logger.v(TAG, "doReadSample: finish && end && next failed");
                        CMSampleState fromError2 = CMSampleState.fromError(-1L);
                        AudioDecoder audioDecoder2 = this.currentDecoder;
                        if (audioDecoder2 != null) {
                            byteBuffer = audioDecoder2.outputBuffer();
                        }
                        return new CMSampleBuffer(fromError2, byteBuffer);
                    }
                    decoderTrackSegment = this.segments.get(this.segmentIndex);
                } else {
                    if (fromError.getStateCode() >= 0) {
                        CMTime divide = fromError.getTime().sub(decoderTrackSegment.getDecoderStartTime()).divide(this._speed);
                        if (divide.getTimeUs() > decoderTrackSegment.getScaledDuration().getTimeUs()) {
                            divide = decoderTrackSegment.getScaledDuration();
                        }
                        CMSampleState cMSampleState = new CMSampleState(divide.add(this.currentSegmentStartTime));
                        Logger.v(TAG, "doReadSample: [success] " + cMSampleState);
                        AudioDecoder audioDecoder3 = this.currentDecoder;
                        if (audioDecoder3 != null) {
                            byteBuffer = audioDecoder3.outputBuffer();
                        }
                        return new CMSampleBuffer(cMSampleState, byteBuffer);
                    }
                    if (fromError.getStateCode() != -3 && fromError.getStateCode() != -100) {
                        return new CMSampleBuffer(this.lastSampleState);
                    }
                    return new CMSampleBuffer(fromError);
                }
            }
        }
    }

    private void doReleaseCurrentDecoder() {
        AudioDecoder audioDecoder = this.currentDecoder;
        if (audioDecoder != null && audioDecoder.getSourcePath() != null) {
            final AudioDecoder audioDecoder2 = this.currentDecoder;
            this.currentDecoder = null;
            ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.AudioDecoderTrack.1
                @Override // java.lang.Runnable
                public void run() {
                    audioDecoder2.release();
                }
            });
        }
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z16) {
        boolean z17;
        CMTime cMTime2 = CMTime.CMTimeZero;
        Iterator<DecoderTrackSegment> it = this.segments.iterator();
        boolean z18 = false;
        int i3 = 0;
        while (true) {
            z17 = true;
            if (!it.hasNext()) {
                break;
            }
            CMTime scaledDuration = it.next().getScaledDuration();
            if (cMTime.compare(cMTime2) >= 0 && cMTime.smallThan(cMTime2.add(scaledDuration))) {
                z18 = true;
                break;
            }
            cMTime2 = cMTime2.add(scaledDuration);
            i3++;
        }
        if (!z18 && cMTime.equalsTo(cMTime2) && i3 > 0 && z16) {
            i3--;
        } else {
            z17 = z18;
        }
        if (!z17) {
            return -1;
        }
        return i3;
    }

    private CMTime getSegmentStartTime(int i3) {
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i16 = 0; i16 < i3; i16++) {
            cMTime = CMTime.add(cMTime, this.segments.get(i16).getScaledDuration());
        }
        return cMTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSameExtractor(DecoderAssetTrack decoderAssetTrack, DecoderAssetTrack decoderAssetTrack2) {
        String str;
        if (decoderAssetTrack != null && decoderAssetTrack2 != null && (str = decoderAssetTrack.assetPath) != null && str.equals(decoderAssetTrack2.assetPath)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public IAudioDecoder newDecoder(DecoderAssetTrack decoderAssetTrack) throws Exception {
        IVideoDecoder.Params params = new IVideoDecoder.Params();
        params.sourceType = decoderAssetTrack.sourceType;
        params.filePath = decoderAssetTrack.assetPath;
        return AVDecoderFactory.getInstance().createAudioDecoder(params);
    }

    private boolean nextSegment(boolean z16) {
        CMTime cMTime;
        Logger.d(TAG, "nextSegment:" + z16);
        int i3 = this.segmentIndex + 1;
        this.segmentIndex = i3;
        boolean z17 = false;
        if (i3 >= this.segments.size()) {
            this.segmentIndex = -1;
            return false;
        }
        CMTime segmentStartTime = getSegmentStartTime(this.segmentIndex);
        this.currentSegmentStartTime = segmentStartTime;
        CMSampleState cMSampleState = new CMSampleState(segmentStartTime);
        this.lastSampleState = cMSampleState;
        if (cMSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
            this.lastSampleState = new CMSampleState();
        }
        DecoderTrackSegment decoderTrackSegment = this.segments.get(this.segmentIndex);
        if (decoderTrackSegment.getVideoAsset() != null) {
            releaseCurrentDecoder();
            if (z16) {
                cMTime = this.segments.get(this.segmentIndex).getDecoderStartTime();
            } else {
                cMTime = CMTime.CMTimeInvalid;
            }
            IDecoder createDecoder = createDecoder(decoderTrackSegment, cMTime);
            synchronized (this.currentDecoderLock) {
                this.currentDecoder = (AudioDecoder) createDecoder;
                AudioMixer audioMixer = this.audioMixer;
                if (audioMixer != null) {
                    audioMixer.release();
                }
                this.audioMixer = new AudioMixer();
                AudioDecoder audioDecoder = this.currentDecoder;
                if (audioDecoder != null && audioDecoder.hasTrack() && z16) {
                    this.currentDecoder.seekTo(decoderTrackSegment.getDecoderStartTime());
                }
            }
        } else {
            Logger.d(TAG, "nextSegment: videoAsset is null");
            releaseCurrentDecoder();
        }
        if (decoderTrackSegment.getScaledDuration().getTimeUs() > 0) {
            this._speed = (((float) decoderTrackSegment.getTimeRange().getDurationUs()) * 1.0f) / ((float) decoderTrackSegment.getScaledDuration().getTimeUs());
        }
        String str = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("nextSegment:");
        if (this.currentDecoder == null) {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append(" ");
        sb5.append(this._speed);
        Logger.d(str, sb5.toString());
        return true;
    }

    private void releaseCurrentDecoder() {
        synchronized (this.currentDecoderLock) {
            doReleaseCurrentDecoder();
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        if (this.asyncEnable && this.decoderThread.pcmFrame == null) {
            synchronized (this.decoderThread) {
                if (this.decoderThread.pcmFrame == null) {
                    this.decoderThread.action();
                }
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0 && this.segments.size() != 0) {
            CMTime start = cMTimeRange.getStart();
            CMTime end = cMTimeRange.getEnd();
            CMTime duration = duration();
            clipRangeAndRemoveRange(cMTimeRange);
            if (start.getValue() != 0) {
                this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, start), (DecoderAssetTrack) null));
            }
            if (end.getTimeUs() < duration.getTimeUs()) {
                this.segments.add(new DecoderTrackSegment(new CMTimeRange(end, new CMTime(duration.getTimeSeconds() - end.getTimeSeconds())), (DecoderAssetTrack) null));
            }
        }
    }

    public void clipRangeAndRemoveRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0 && this.segments.size() != 0) {
            CMTime start = cMTimeRange.getStart();
            CMTime end = cMTimeRange.getEnd();
            int findSegmentIndexAt = findSegmentIndexAt(start, false);
            if (findSegmentIndexAt == -1) {
                return;
            }
            int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
            if (findSegmentIndexAt2 == -1) {
                findSegmentIndexAt2 = this.segments.size() - 1;
            } else if (getSegmentStartTime(findSegmentIndexAt2) == end) {
                findSegmentIndexAt2--;
            }
            CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
            CMTime segmentStartTime2 = getSegmentStartTime(findSegmentIndexAt2);
            DecoderTrackSegment decoderTrackSegment = this.segments.get(findSegmentIndexAt);
            DecoderTrackSegment decoderTrackSegment2 = this.segments.get(findSegmentIndexAt2);
            CMTime sub = cMTimeRange.getEnd().sub(segmentStartTime2);
            decoderTrackSegment2.setTimeRange(new CMTimeRange(decoderTrackSegment2.getTimeRange().getStart(), sub.divide((((float) decoderTrackSegment2.getScaledDuration().getTimeUs()) * 1.0f) / ((float) decoderTrackSegment2.getTimeRange().getDurationUs()))));
            decoderTrackSegment2.setScaledDuration(sub);
            float timeUs = (((float) decoderTrackSegment.getScaledDuration().getTimeUs()) * 1.0f) / ((float) decoderTrackSegment.getTimeRange().getDurationUs());
            CMTime sub2 = cMTimeRange.getStart().sub(segmentStartTime);
            CMTime divide = sub2.divide(timeUs);
            decoderTrackSegment.setTimeRange(new CMTimeRange(decoderTrackSegment.getTimeRange().getStart().add(divide), decoderTrackSegment.getTimeRange().getDuration().sub(divide)));
            decoderTrackSegment.setScaledDuration(decoderTrackSegment.getScaledDuration().sub(sub2));
            for (int size = this.segments.size() - 1; size >= 0; size--) {
                if (size > findSegmentIndexAt2 || size < findSegmentIndexAt) {
                    this.segments.remove(size);
                }
            }
        }
    }

    public CMTime duration() {
        return getSegmentStartTime(this.segments.size());
    }

    public AudioInfo getAudioInfo() {
        AudioDecoder audioDecoder = this.currentDecoder;
        if (audioDecoder != null) {
            return audioDecoder.getAudioInfo();
        }
        return this.audioInfo;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.lastSampleState.getTime();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        CMTime cMTime = this.duration;
        CMTime cMTime2 = CMTime.CMTimeZero;
        if (cMTime == cMTime2) {
            Iterator<DecoderTrackSegment> it = this.segments.iterator();
            while (it.hasNext()) {
                cMTime2 = cMTime2.add(it.next().getScaledDuration());
            }
            this.duration = cMTime2;
        }
        return this.duration;
    }

    public ByteBuffer getEmptyAudioBuffer() {
        if (this.emptyAudioBuffer == null) {
            AudioInfo audioInfo = this.audioInfo;
            long timeUs = ((audioInfo.channelCount * audioInfo.sampleRate) * this.frameDuration.getTimeUs()) / 1000000;
            int i3 = (int) timeUs;
            ByteBuffer allocate = ByteBuffer.allocate(i3 * 2);
            this.emptyAudioBuffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            short[] sArr = new short[i3];
            for (int i16 = 0; i16 < timeUs; i16++) {
                sArr[i16] = 0;
            }
            this.emptyAudioBuffer.asShortBuffer().put(sArr, 0, i3);
        }
        this.emptyAudioBuffer.position(0);
        return this.emptyAudioBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.frameRate;
    }

    public int getTrackID() {
        return this.trackID;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackID;
    }

    public ByteBuffer outputBuffer() {
        if (this.isEmptyFrame) {
            return getEmptyAudioBuffer();
        }
        AudioDecoder audioDecoder = this.currentDecoder;
        if (audioDecoder == null) {
            return null;
        }
        return audioDecoder.outputBuffer();
    }

    public synchronized ByteBuffer processFrame(ByteBuffer byteBuffer, float f16, float f17, AudioInfo audioInfo) {
        if (this.audioMixer.getDestAudioChannelCount() != audioInfo.channelCount) {
            this.audioMixer.release();
            this.audioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
        }
        return this.audioMixer.processBytes(byteBuffer, f17, f16, 1.0f);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        return readSample(CMTime.CMTimeInvalid);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        Logger.d(TAG, "release: start ");
        if (this.asyncEnable) {
            this.decoderThread.release();
        }
        this.isReleased = true;
        AudioDecoder audioDecoder = this.currentDecoder;
        if (audioDecoder != null) {
            audioDecoder.release();
            this.currentDecoder = null;
        }
        synchronized (this.nextDecoderLock) {
            DecoderWrapper decoderWrapper = this.nextDecoder;
            if (decoderWrapper != null) {
                decoderWrapper.release();
                this.nextDecoder = null;
            }
        }
        Logger.d(TAG, "release: finish ");
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        Logger.v(TAG, "seekTo:[time " + cMTime + "] [needRead " + z16 + "] [quickSeek " + z17 + "]");
        if (!this.isReleased) {
            synchronized (this.decoderThread.nextFrameDecoderLock) {
                this.decoderThread.pcmFrame = null;
            }
            if (!this.started) {
                Logger.d(TAG, "seekTo: [failed] un started");
                return null;
            }
            int findSegmentIndexAt = findSegmentIndexAt(cMTime, true);
            if (findSegmentIndexAt == -1) {
                this.segmentIndex = -1;
                Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
                return null;
            }
            CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
            if (this.segmentIndex != findSegmentIndexAt || this.currentDecoder == null) {
                this.segmentIndex = findSegmentIndexAt - 1;
                nextSegment(false);
            }
            CMTime multi = cMTime.sub(segmentStartTime).multi(this._speed);
            DecoderTrackSegment decoderTrackSegment = this.segments.get(this.segmentIndex);
            AudioDecoder audioDecoder = this.currentDecoder;
            if (audioDecoder == null) {
                CMSampleState cMSampleState = new CMSampleState(cMTime);
                this.lastSampleState = cMSampleState;
                if (cMSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
                    this.lastSampleState = new CMSampleState();
                }
                Logger.d(TAG, "seekTo: [failed] currentDecoder == null ");
                return new CMSampleBuffer(this.lastSampleState);
            }
            audioDecoder.seekTo(decoderTrackSegment.getDecoderStartTime().add(multi));
            if (cMTime.bigThan(this.frameDuration)) {
                this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
            } else {
                this.lastSampleState = new CMSampleState(cMTime);
            }
            Logger.v(TAG, "seekTo: [success] [lastSampleState " + this.lastSampleState + "]");
            return new CMSampleBuffer(this.lastSampleState);
        }
        Logger.e(TAG, "seekTo: [failed] has released");
        return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }

    public void setAudioInfo(@NonNull AudioInfo audioInfo) {
        this.audioInfo = audioInfo.m262clone();
        if (audioInfo.sampleCount > 0 && audioInfo.sampleRate > 0) {
            this.frameDuration = new CMTime((((audioInfo.sampleCount * 100000) * 2) / audioInfo.channelCount) / audioInfo.sampleRate, 100000);
            Logger.d(TAG, "setAudioInfo frameDuration:" + this.frameDuration);
        }
        if (this.emptyAudioBuffer != null) {
            this.emptyAudioBuffer = null;
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
        this.decodeType = decodeType;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        this.frameDuration = this.frameDuration.divide(i3 / this.frameRate);
        this.frameRate = i3;
    }

    public void setTrackID(int i3) {
        this.trackID = i3;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.clear();
        this.segments.addAll(list);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
        this.volume = f16;
    }

    public float speed() {
        return this._speed;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        start(null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        Logger.v(TAG, "readSample: [start]" + cMTime);
        if (!this.isReleased) {
            synchronized (this.decoderThread.nextFrameDecoderLock) {
                if (this.decoderThread.pcmFrame != null && this.decoderThread.pcmFrame.frameTime == this.lastSampleState.getTime()) {
                    CMSampleBuffer cMSampleBuffer = this.decoderThread.pcmFrame.sampleBuffer;
                    this.lastSampleState = new CMSampleState(this.decoderThread.pcmFrame.frameTime);
                    createNextDecoder(this.segmentIndex);
                    Logger.v(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleState);
                    return cMSampleBuffer;
                }
                CMSampleBuffer doReadSample = doReadSample(cMTime);
                if (doReadSample.getSampleByteBuffer() != null) {
                    float f16 = this._speed;
                    if (f16 > 0.1f && f16 < 16.0f) {
                        Logger.v(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]");
                        doReadSample.setSampleByteBuffer(processFrame(doReadSample.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
                        Logger.v(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]");
                    }
                }
                this.lastSampleState = doReadSample.getState();
                createNextDecoder(this.segmentIndex);
                Logger.v(TAG, "readSample: [success]  - " + this.lastSampleState);
                return doReadSample;
            }
        }
        Logger.e(TAG, "readSample: [error] has released");
        return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        start(surfaceCreator, null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        if (this.segments.size() == 0) {
            release();
            return;
        }
        this.isReleased = false;
        if (this.asyncEnable) {
            this.decoderThread.start();
        }
        this.started = true;
        this.segmentIndex = -1;
        clipRangeAndRemoveRange(cMTimeRange);
        nextSegment(true);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
    }
}
