package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes18.dex */
public class HWVideoDecoder {
    private static final int ACTION_PAUSE = 1;
    private static final int ACTION_PLAY = 0;
    private static final int ACTION_SEEK = 2;
    private static final int ACTION_SEEK_NEXT = 3;
    public static final int MAX_FRAME_SEEK_INTERVAL = 100000;
    private static final int MAX_SEEK_WAIT_TIME = 1000;
    private static final int MSG_PLAY = 1;
    private static final int MSG_SOME_THING = 2;
    public static final int SPEED_TYPE_FAST = 1;
    public static final int SPEED_TYPE_LITTLE_FAST = 3;
    public static final int SPEED_TYPE_REAL_TIME = 0;
    public static final int SPEED_TYPE_REVERSE = 5;
    public static final int SPEED_TYPE_SLOW = 2;
    public static final int SPEED_TYPE_VERY_SLOW = 4;
    private static final String TAG = "HWVideoDecoder";
    public static String debugDecodeFilePath = Environment.getExternalStorageDirectory() + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo";
    private DecodeRunnable currentDecodeRunnable;
    private Thread currentDecodeThread;
    private DecodeOutputSurface decodeOutputSurface;
    private PKManager mPKManager;
    private PlayHandler mPlayHandler;
    private HandlerThread mPlayThread;
    private Logger logger = SdkContext.getInstance().getLogger();
    private Object mSeekingFlag = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class DecodeRunnable implements Runnable {
        private static final String TAG = "HWVideoDecoder.DecodeRunnable";
        private final DecodeConfig currentDecodeConfig;
        private final HWDecodeListener decodeListener;
        private MediaCodec decoder;
        private final DecodeConfig dirtyDecodeConfig;
        private MediaExtractor extractor;
        private final String filePath;
        MediaCodec.BufferInfo info;
        ByteBuffer[] inputBuffers;
        public boolean isDebug;
        private Logger logger;
        private PKManager mPKManager;
        private String mTag;
        ByteBuffer[] outputBuffers;
        private Object seekingFlag;
        private Surface surface;
        public final long videoDurationMs;
        private boolean inputDone = false;
        private boolean outputDone = false;
        boolean interruptedFlag = false;
        long startMs = System.currentTimeMillis();
        long decodeProgressUs = 0;
        private long lastFrameSampleTimeUs = 0;
        private long lastFramePresentationTimeUs = 0;
        private long endFrameSampleTime = 0;
        private int prolongFrameCount = 0;
        private final AtomicLong seekToTaskUs = new AtomicLong(-1);
        private final AtomicLong mNextToTaskUs = new AtomicLong(-1);
        private ArrayList<timeStampPair> arrTimeStampPairs = new ArrayList<>();
        public int mRotation = 0;
        private volatile AtomicBoolean pauseFlag = new AtomicBoolean(false);
        private final Object pauseLock = new Object();
        private long mSeekTarget = 0;

        public DecodeRunnable(String str, Surface surface, HWDecodeListener hWDecodeListener, Object obj) {
            this.mTag = TAG;
            this.isDebug = false;
            this.mTag = "HWVideoDecoder.DecodeRunnable." + hashCode();
            Logger logger = SdkContext.getInstance().getLogger();
            this.logger = logger;
            logger.i(TAG, "create DecodeRunnable filePath: " + str);
            this.surface = surface;
            this.decodeListener = hWDecodeListener == null ? new EmptyHWDecodeListener() : hWDecodeListener;
            this.filePath = str;
            long durationOfVideo = VideoUtil.getDurationOfVideo(str);
            this.videoDurationMs = durationOfVideo;
            this.seekingFlag = obj;
            this.dirtyDecodeConfig = new DecodeConfig(str, 0, true, false, 0L, durationOfVideo);
            this.currentDecodeConfig = new DecodeConfig(str, 0, true, false, 0L, durationOfVideo);
            this.isDebug = new File(HWVideoDecoder.debugDecodeFilePath).exists();
        }

        private boolean dequeueDataFromCodec(boolean z16) {
            boolean z17;
            long j3;
            int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.info, 10000L);
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        MediaCodec.BufferInfo bufferInfo = this.info;
                        if ((bufferInfo.flags & 4) != 0) {
                            if (this.logger.isEnable()) {
                                this.logger.d(this.mTag, "output EOS " + this.pauseFlag.get());
                            }
                            this.outputDone = true;
                            this.decodeProgressUs = Long.MAX_VALUE;
                        } else {
                            this.decodeProgressUs = bufferInfo.presentationTimeUs;
                        }
                        if (!this.currentDecodeConfig.noSleep && z16 && !this.pauseFlag.get() && this.mSeekTarget == -1) {
                            while (this.info.presentationTimeUs / 1000 > System.currentTimeMillis() - this.startMs) {
                                try {
                                    LockMethodProxy.sleep(10L);
                                } catch (InterruptedException e16) {
                                    if (this.logger.isEnable()) {
                                        this.logger.e(this.mTag, "Thread.sleep error, ", e16);
                                    }
                                    this.interruptedFlag = true;
                                }
                            }
                        }
                        DecodeConfig decodeConfig = this.currentDecodeConfig;
                        if (decodeConfig.noSleep && decodeConfig.syncDecode && this.mPKManager != null) {
                            this.logger.d(PKFilter.TAG, "this is " + hashCode() + " current = " + (this.info.presentationTimeUs / 1000) + ", sync decoder=" + (this.mPKManager.getSyncDecodeTimeUs() / 1000));
                            while (this.info.presentationTimeUs > this.mPKManager.getSyncDecodeTimeUs()) {
                                try {
                                    LockMethodProxy.sleep(5L);
                                } catch (InterruptedException e17) {
                                    if (this.logger.isEnable()) {
                                        this.logger.e(this.mTag, "Thread.sleep error, ", e17);
                                    }
                                    this.interruptedFlag = true;
                                }
                            }
                        }
                        boolean z18 = false;
                        if (z16 && this.info.size != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (this.pauseFlag.get() && !isCloseSeekTarget(this.lastFrameSampleTimeUs, this.mSeekTarget) && !this.outputDone) {
                            if (this.logger.isEnable() && this.isDebug) {
                                this.logger.d(TAG, "seek, doRender = " + z17 + " ; output sampleTime = " + this.info.presentationTimeUs);
                            }
                            this.decoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            if (this.mSeekTarget >= 0) {
                                this.startMs = System.currentTimeMillis() - (this.info.presentationTimeUs / 1000);
                            }
                            seekFinishNotify();
                            this.mSeekTarget = -1L;
                            if (this.logger.isEnable() && this.isDebug) {
                                this.logger.d(TAG, "doRender = " + z17 + " ; output sampleTime = " + this.info.presentationTimeUs);
                            }
                            this.decoder.releaseOutputBuffer(dequeueOutputBuffer, z17);
                            if (z17) {
                                try {
                                    if (this.currentDecodeConfig.speedType != 0) {
                                        ArrayList<timeStampPair> arrayList = this.arrTimeStampPairs;
                                        if (arrayList != null && arrayList.size() > 0) {
                                            long j16 = this.arrTimeStampPairs.get(0).orgSampleTime;
                                            long abs = Math.abs(this.arrTimeStampPairs.get(0).presentTime - this.info.presentationTimeUs);
                                            int i3 = 0;
                                            while (true) {
                                                if (i3 < this.arrTimeStampPairs.size()) {
                                                    timeStampPair timestamppair = this.arrTimeStampPairs.get(i3);
                                                    long j17 = timestamppair.presentTime;
                                                    long j18 = this.info.presentationTimeUs;
                                                    if (j17 == j18) {
                                                        j3 = timestamppair.orgSampleTime;
                                                        this.arrTimeStampPairs.remove(i3);
                                                        if (this.logger.isEnable() && this.isDebug) {
                                                            this.logger.d(this.mTag, "size : " + this.arrTimeStampPairs.size() + "  remove " + j3);
                                                        }
                                                        z18 = true;
                                                    } else {
                                                        long abs2 = Math.abs(j17 - j18);
                                                        if (abs2 < abs) {
                                                            j16 = timestamppair.orgSampleTime;
                                                            abs = abs2;
                                                        }
                                                        i3++;
                                                    }
                                                } else {
                                                    j3 = -1;
                                                    break;
                                                }
                                            }
                                            if (!z18) {
                                                j3 = j16;
                                            }
                                        } else {
                                            j3 = -1;
                                        }
                                    } else {
                                        j3 = this.info.presentationTimeUs;
                                    }
                                    this.decodeListener.onDecodeFrame(this.info.presentationTimeUs * 1000, j3 * 1000);
                                } catch (InterruptedException e18) {
                                    this.logger.e(this.mTag, "arrTimeStamp error, ", e18);
                                    this.interruptedFlag = true;
                                }
                            }
                        }
                    } else if (this.logger.isEnable()) {
                        this.logger.d(this.mTag, "dequeueOutputBuffer timed out!");
                    }
                } else if (this.logger.isEnable()) {
                    this.logger.d(this.mTag, "New format " + this.decoder.getOutputFormat());
                }
            } else {
                if (this.logger.isEnable()) {
                    this.logger.d(this.mTag, "INFO_OUTPUT_BUFFERS_CHANGED");
                }
                this.outputBuffers = this.decoder.getOutputBuffers();
            }
            return true;
        }

        private long getEndFrameSampleTime() {
            this.extractor.seekTo((this.videoDurationMs - 1) * 1000, 2);
            long sampleTime = this.extractor.getSampleTime();
            SLog.d(PKFilter.TAG, "getEndFrameSampleTime and durationMS=" + this.videoDurationMs + " and result=" + sampleTime);
            this.extractor.seekTo(0L, 1);
            return sampleTime;
        }

        private long getPresentationTime(int i3, long j3, long j16) {
            long j17;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return j3 + j16;
                            }
                            return j3 - j16;
                        }
                        j17 = j16 * 4;
                    } else {
                        j17 = (int) (((float) j16) / 1.5f);
                    }
                } else {
                    Long.signum(j16);
                    j17 = j16 * 2;
                }
            } else {
                j17 = j16 / 2;
            }
            return j3 + j17;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean init() {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.extractor = mediaExtractor;
            try {
                mediaExtractor.setDataSource(this.filePath);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.extractor.getTrackCount()) {
                        break;
                    }
                    MediaFormat trackFormat = this.extractor.getTrackFormat(i3);
                    String string = trackFormat.getString("mime");
                    if (string.startsWith("video/")) {
                        this.extractor.selectTrack(i3);
                        trackFormat.setInteger("rotation-degrees", this.mRotation);
                        try {
                            this.decoder = MediaCodec.createDecoderByType(string);
                            if (this.surface.isValid()) {
                                this.decoder.configure(trackFormat, this.surface, (MediaCrypto) null, 0);
                            } else {
                                throw new RuntimeException("surface is not valid.");
                            }
                        } catch (Throwable th5) {
                            if (Thread.interrupted()) {
                                this.logger.e(this.mTag, "Thread is interrupted.", th5);
                            } else {
                                this.decodeListener.onDecodeError(1, new RuntimeException(th5));
                                this.logger.e(this.mTag, "decode configure error", th5);
                            }
                            return false;
                        }
                    } else {
                        i3++;
                    }
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                return false;
            }
        }

        private boolean isCloseSeekTarget(long j3, long j16) {
            if (this.dirtyDecodeConfig.speedType == 5 ? this.lastFrameSampleTimeUs <= this.mSeekTarget : this.lastFrameSampleTimeUs >= this.mSeekTarget) {
                return true;
            }
            long j17 = j16 - j3;
            if (j17 > -100000 && j17 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
                return true;
            }
            return false;
        }

        private void loopInternal(boolean z16) {
            if (!this.inputDone) {
                queueSampleToCodec();
            }
            if (!this.outputDone) {
                dequeueDataFromCodec(z16);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0144, code lost:
        
            if (r3 < r17) goto L63;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean queueSampleToCodec() {
            int i3;
            long j3;
            ArrayList<timeStampPair> arrayList;
            long j16;
            try {
                i3 = this.decoder.dequeueInputBuffer(10000L);
            } catch (IllegalStateException e16) {
                if (this.logger.isEnable()) {
                    this.logger.e(this.mTag, "dequeueInputBuffer =" + e16.getMessage());
                }
                i3 = -1;
            }
            int i16 = i3;
            if (i16 >= 0) {
                ByteBuffer byteBuffer = this.inputBuffers[i16];
                if (this.currentDecodeConfig.speedType == 5) {
                    this.extractor.seekTo(this.lastFrameSampleTimeUs - 1000, 0);
                }
                int readSampleData = this.extractor.readSampleData(byteBuffer, 0);
                long sampleTime = this.extractor.getSampleTime();
                DecodeConfig decodeConfig = this.currentDecodeConfig;
                long j17 = decodeConfig.startTimeMillSecond * 1000;
                long j18 = decodeConfig.endTimeMillSecond * 1000;
                if (this.logger.isEnable() && this.isDebug) {
                    this.logger.d(TAG, "intput sampleTime = " + sampleTime);
                }
                if (sampleTime == this.endFrameSampleTime) {
                    j3 = j18;
                    long j19 = this.currentDecodeConfig.prolongToTime;
                    if (j19 > 0) {
                        if ((this.prolongFrameCount * 33 * 1000) + sampleTime > (j19 - 500) * 1000) {
                            if (this.logger.isEnable() && this.isDebug) {
                                this.logger.e(PKFilter.TAG, "prolongFrameCount=" + this.prolongFrameCount + " finish");
                            }
                            this.decoder.queueInputBuffer(i16, 0, 0, 0L, 4);
                            this.inputDone = true;
                            this.prolongFrameCount = 0;
                        } else {
                            if (this.logger.isEnable() && this.isDebug) {
                                this.logger.e(PKFilter.TAG, "prolongFrameCount=" + this.prolongFrameCount + " and we send the same frame to render");
                            }
                            this.prolongFrameCount = this.prolongFrameCount + 1;
                            this.decoder.queueInputBuffer(i16, 0, readSampleData, (r0 * 33 * 1000) + sampleTime, 0);
                        }
                        return true;
                    }
                } else {
                    j3 = j18;
                }
                if (readSampleData >= 0 && (j3 <= 0 || sampleTime <= j3)) {
                    int i17 = this.currentDecodeConfig.speedType;
                    if (i17 == 5) {
                        if (j17 > 0) {
                            j16 = j17;
                        } else {
                            j16 = 10000;
                        }
                    }
                    long j26 = sampleTime - this.lastFrameSampleTimeUs;
                    this.lastFrameSampleTimeUs = sampleTime;
                    long presentationTime = getPresentationTime(i17, this.lastFramePresentationTimeUs, j26);
                    this.lastFramePresentationTimeUs = presentationTime;
                    this.decoder.queueInputBuffer(i16, 0, readSampleData, presentationTime, 0);
                    this.extractor.advance();
                    timeStampPair timestamppair = new timeStampPair(this.lastFrameSampleTimeUs, this.lastFramePresentationTimeUs);
                    if (this.currentDecodeConfig.speedType == 0 || (arrayList = this.arrTimeStampPairs) == null) {
                        return true;
                    }
                    arrayList.add(timestamppair);
                    if (!this.logger.isEnable() || !this.isDebug) {
                        return true;
                    }
                    this.logger.d(this.mTag, "size : " + this.arrTimeStampPairs.size() + "  add " + this.lastFrameSampleTimeUs);
                    return true;
                }
                if (this.logger.isEnable()) {
                    this.logger.d(this.mTag, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + sampleTime + " endTime=" + j3 + " startTime=" + j17 + " sampleSize=" + readSampleData);
                }
                this.decoder.queueInputBuffer(i16, 0, 0, 0L, 4);
                this.inputDone = true;
                return true;
            }
            if (this.logger.isEnable()) {
                this.logger.w(this.mTag, "queueSampleToCodec inIndex = " + i16);
                return false;
            }
            return false;
        }

        private long seekInLoop(long j3) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.decoder.flush();
            } catch (Exception e16) {
                this.logger.e(TAG, e16);
            }
            this.extractor.seekTo(j3, 0);
            long sampleTime = this.extractor.getSampleTime();
            if (sampleTime == -1) {
                if (this.logger.isEnable()) {
                    this.logger.d(this.mTag, "seekInLoop, getSampleTime return -1");
                }
                if (this.currentDecodeConfig.speedType == 5) {
                    while (sampleTime == -1) {
                        j3 -= 1000;
                        this.extractor.seekTo(j3, 0);
                        sampleTime = this.extractor.getSampleTime();
                    }
                }
            }
            this.decodeListener.onDecodeSeekTo(sampleTime / 1000);
            this.startMs = System.currentTimeMillis();
            this.inputDone = false;
            this.outputDone = false;
            this.lastFrameSampleTimeUs = sampleTime;
            DecodeConfig decodeConfig = this.currentDecodeConfig;
            if (decodeConfig.speedType == 5) {
                this.lastFramePresentationTimeUs = (decodeConfig.endTimeMillSecond * 1000) - sampleTime;
            } else {
                this.lastFramePresentationTimeUs = sampleTime;
            }
            if (this.logger.isEnable()) {
                this.logger.d(this.mTag, "end seekTo timecost=" + (System.currentTimeMillis() - currentTimeMillis) + " seekTargetTimeUs:" + j3 + " realStartTime:" + sampleTime);
            }
            return sampleTime;
        }

        private boolean start() {
            if (this.decoder == null) {
                this.logger.e(this.mTag, "Can't find video info!");
                return false;
            }
            this.decodeListener.onDecodeStart();
            try {
                this.decoder.start();
                try {
                    this.inputBuffers = this.decoder.getInputBuffers();
                    this.outputBuffers = this.decoder.getOutputBuffers();
                    this.info = new MediaCodec.BufferInfo();
                    this.startMs = System.currentTimeMillis();
                    DecodeConfig decodeConfig = this.currentDecodeConfig;
                    if (decodeConfig.speedType == 5) {
                        this.lastFrameSampleTimeUs = decodeConfig.endTimeMillSecond * 1000;
                        return true;
                    }
                    return true;
                } catch (Exception e16) {
                    this.decodeListener.onDecodeError(2, e16);
                    this.logger.e(this.mTag, "decode start error2", e16);
                    return false;
                }
            } catch (Throwable th5) {
                if (Thread.interrupted()) {
                    this.logger.e(this.mTag, "Thread is interrupted.", th5);
                } else {
                    this.decodeListener.onDecodeError(2, new RuntimeException(th5));
                    this.logger.e(this.mTag, "decode start error", th5);
                }
                return false;
            }
        }

        public void clearTimeStamp() {
            ArrayList<timeStampPair> arrayList = this.arrTimeStampPairs;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public long getLastFrameSampleTimeMs() {
            return this.lastFrameSampleTimeUs / 1000;
        }

        public long getProgress() {
            return this.decodeProgressUs;
        }

        public boolean isSeeking() {
            if (this.mSeekTarget >= 0) {
                return true;
            }
            return false;
        }

        public void nextTo(long j3) {
            this.mNextToTaskUs.set(j3 * 1000);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            long currentTimeMillis = System.currentTimeMillis();
            this.currentDecodeConfig.copyFrom(this.dirtyDecodeConfig);
            if (!init()) {
                return;
            }
            if (this.currentDecodeConfig.prolongToTime > 0) {
                this.endFrameSampleTime = getEndFrameSampleTime();
                if (this.logger.isEnable()) {
                    this.logger.d(this.mTag, "getEndFrameSampleTime() = " + this.endFrameSampleTime);
                }
            }
            if (!start()) {
                return;
            }
            if (this.logger.isEnable()) {
                this.logger.d(this.mTag, "decode ready time cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            while (!Thread.interrupted() && !this.interruptedFlag) {
                DecodeConfig decodeConfig = this.dirtyDecodeConfig;
                int i3 = decodeConfig.speedType;
                DecodeConfig decodeConfig2 = this.currentDecodeConfig;
                if (i3 != decodeConfig2.speedType && i3 == 5) {
                    this.lastFrameSampleTimeUs = decodeConfig2.endTimeMillSecond * 1000;
                }
                decodeConfig2.copyFrom(decodeConfig);
                DecodeConfig decodeConfig3 = this.currentDecodeConfig;
                long j3 = decodeConfig3.startTimeMillSecond * 1000;
                long j16 = decodeConfig3.endTimeMillSecond * 1000;
                long j17 = this.seekToTaskUs.get();
                if (j17 >= 0 && j17 >= j3 && j17 <= j16) {
                    seekInLoop(j17);
                    this.mSeekTarget = j17;
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.seekToTaskUs.compareAndSet(j17, -1L);
                long j18 = this.mNextToTaskUs.get();
                if (j18 >= 0) {
                    this.mSeekTarget = j18;
                    this.mNextToTaskUs.compareAndSet(j18, -1L);
                }
                try {
                    loopInternal(true);
                } catch (Throwable th5) {
                    if (Thread.interrupted()) {
                        this.logger.e(this.mTag, "Thread is interrupted.", th5);
                    } else {
                        this.decodeListener.onDecodeError(3, new RuntimeException(th5));
                        this.logger.e(this.mTag, "decode configure error", th5);
                        return;
                    }
                }
                if (this.logger.isEnable() && this.isDebug) {
                    this.logger.d(this.mTag, "decode frame, seekInLoop =" + z16);
                }
                if (this.outputDone) {
                    ArrayList<timeStampPair> arrayList = this.arrTimeStampPairs;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    if (this.logger.isEnable()) {
                        this.logger.d(this.mTag, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                    }
                    DecodeConfig decodeConfig4 = this.currentDecodeConfig;
                    if (decodeConfig4.repeat) {
                        if (decodeConfig4.speedType == 5) {
                            j3 = j16;
                        }
                        seekTo(j3 / 1000);
                        this.decodeListener.onDecodeRepeat();
                        if (this.logger.isEnable()) {
                            this.logger.d(this.mTag, "repeat " + this.pauseFlag.get());
                        }
                    }
                }
                if (this.pauseFlag.get() && this.mSeekTarget < 0 && this.seekToTaskUs.get() < 0) {
                    try {
                        synchronized (this.pauseLock) {
                            if (!this.interruptedFlag) {
                                LockMethodProxy.wait(this.pauseLock);
                            }
                        }
                        this.startMs = System.currentTimeMillis() - (this.info.presentationTimeUs / 1000);
                    } catch (InterruptedException e16) {
                        this.logger.e(this.mTag, "pauseLock lock error, ", e16);
                        this.interruptedFlag = true;
                    }
                }
            }
            try {
                this.decoder.stop();
                this.decoder.release();
                this.extractor.release();
            } catch (Exception e17) {
                this.logger.e(TAG, "decoder stop error " + e17.toString());
            }
            seekFinishNotify();
            if (this.outputDone) {
                this.decodeListener.onDecodeFinish();
            } else {
                this.decodeListener.onDecodeCancel();
            }
        }

        public void seekFinishNotify() {
            if (this.mSeekTarget >= 0) {
                synchronized (this.seekingFlag) {
                    this.seekingFlag.notifyAll();
                }
            }
        }

        public void seekTo(long j3) {
            this.seekToTaskUs.set(j3 * 1000);
        }

        public void setDecodeConfig(DecodeConfig decodeConfig) {
            if (!TextUtils.equals(this.filePath, decodeConfig.inputFilePath)) {
                this.logger.w(TAG, "DecodeRunnable does not support changing the file");
            }
            setSpeedType(decodeConfig.speedType);
            setPlayRange(decodeConfig.startTimeMillSecond, decodeConfig.endTimeMillSecond);
            setRepeat(decodeConfig.repeat);
            setNoSleep(decodeConfig.noSleep);
            setProlongToTime(decodeConfig.prolongToTime);
            setSyncDecode(decodeConfig.syncDecode);
            this.mRotation = decodeConfig.rotation;
        }

        public void setNoSleep(boolean z16) {
            this.dirtyDecodeConfig.noSleep = z16;
        }

        public void setPKManager(PKManager pKManager) {
            this.mPKManager = pKManager;
        }

        public void setPlayRange(long j3, long j16) {
            if (j3 >= 0 && j16 >= 0) {
                if (j16 >= j3) {
                    long j17 = this.videoDurationMs;
                    if (j3 >= j17) {
                        this.logger.e(TAG, "setPlayRange ignore, startTimeMs=" + j3 + ", videoDuration=" + this.videoDurationMs);
                        return;
                    }
                    if (j16 > j17) {
                        j16 = j17;
                    }
                    if (j16 != 0) {
                        j17 = j16;
                    }
                    DecodeConfig decodeConfig = this.dirtyDecodeConfig;
                    if (j3 == decodeConfig.startTimeMillSecond && j17 == decodeConfig.endTimeMillSecond) {
                        this.logger.w(TAG, "segment not changed, setPlayRange ignore, startTimeMs=" + j3 + ", endTimeMs=" + j17);
                        return;
                    }
                    decodeConfig.startTimeMillSecond = j3;
                    decodeConfig.endTimeMillSecond = j17;
                    if (decodeConfig.speedType == 5) {
                        seekTo(j17);
                        return;
                    } else {
                        seekTo(j3);
                        return;
                    }
                }
                throw new IllegalArgumentException("end time should not less than start time");
            }
            throw new IllegalArgumentException("both start time and end time should not less than 0");
        }

        public void setProlongToTime(long j3) {
            this.dirtyDecodeConfig.prolongToTime = j3;
        }

        public void setRepeat(boolean z16) {
            this.dirtyDecodeConfig.repeat = z16;
        }

        public void setSpeedType(int i3) {
            this.dirtyDecodeConfig.speedType = i3;
        }

        public void setSyncDecode(boolean z16) {
            this.dirtyDecodeConfig.syncDecode = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class PlayHandler extends Handler {
        public PlayHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.arg1;
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        HWVideoDecoder.this.handleSeekNext(message.arg2);
                        return;
                    }
                    return;
                }
                HWVideoDecoder.this.handleSeek(message.arg2);
                return;
            }
            HWVideoDecoder.this.handlePlay();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class timeStampPair {
        long orgSampleTime;
        long presentTime;

        timeStampPair(long j3, long j16) {
            this.orgSampleTime = j3;
            this.presentTime = j16;
        }
    }

    private void assureThread() {
        HandlerThread handlerThread = this.mPlayThread;
        if (handlerThread != null && handlerThread.isAlive() && this.mPlayHandler != null) {
            this.logger.d(TAG, "playThread: already start");
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HWVideoDecoder_" + hashCode());
        this.mPlayThread = baseHandlerThread;
        baseHandlerThread.start();
        do {
        } while (!this.mPlayThread.isAlive());
        this.mPlayHandler = new PlayHandler(this.mPlayThread.getLooper());
    }

    public static final float getSpeedRate(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return 1.0f;
                        }
                        return -1.0f;
                    }
                    return 0.25f;
                }
                return 1.5f;
            }
            return 0.5f;
        }
        return 2.0f;
    }

    private void sendMessage(int i3, int i16, Object obj) {
        int i17;
        PlayHandler playHandler = this.mPlayHandler;
        if (playHandler != null) {
            if (i3 == 0) {
                i17 = 1;
            } else {
                i17 = 2;
            }
            playHandler.obtainMessage(i17, i3, i16, obj).sendToTarget();
        }
    }

    private void startDecode(DecodeConfig decodeConfig, Surface surface, HWDecodeListener hWDecodeListener) {
        if (decodeConfig != null && surface != null) {
            this.logger.i(TAG, "startDecode config = " + decodeConfig);
            Thread thread = this.currentDecodeThread;
            if (thread != null) {
                stopDecode();
                try {
                    thread.join();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            DecodeRunnable decodeRunnable = new DecodeRunnable(decodeConfig.inputFilePath, surface, hWDecodeListener, this.mSeekingFlag);
            this.currentDecodeRunnable = decodeRunnable;
            decodeRunnable.setDecodeConfig(decodeConfig);
            this.currentDecodeRunnable.setPKManager(this.mPKManager);
            BaseThread baseThread = new BaseThread(this.currentDecodeRunnable, "HWVideoDecoder-Thread");
            this.currentDecodeThread = baseThread;
            baseThread.start();
            assureThread();
            return;
        }
        throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }

    public void decodeFrame() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null && decodeRunnable.pauseFlag.get()) {
            sendMessage(0, 0, null);
            this.logger.d(TAG, "decodeFrame, " + decodeRunnable.pauseFlag.get());
            return;
        }
        this.logger.w(TAG, "decodeFrame failed, can not find DecodeRunnable");
    }

    public int getLastFrameSampleTimeMs() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            return (int) decodeRunnable.getLastFrameSampleTimeMs();
        }
        return 0;
    }

    public long getProgress() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable == null) {
            return 0L;
        }
        return decodeRunnable.getProgress();
    }

    public void handlePlay() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            synchronized (decodeRunnable.pauseLock) {
                decodeRunnable.pauseLock.notifyAll();
            }
            this.logger.d(TAG, "handlePlay");
        }
    }

    public void handleSeek(long j3) {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            try {
                if (decodeRunnable.isSeeking()) {
                    synchronized (this.mSeekingFlag) {
                        this.mSeekingFlag.wait(1000L);
                    }
                }
                decodeRunnable.seekTo(j3);
                this.logger.d(TAG, "handleSeek " + j3 + " ms");
            } catch (Exception e16) {
                this.logger.e(TAG, "handleSeek " + j3 + " ms", e16);
            }
        }
    }

    public void handleSeekNext(long j3) {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            try {
                if (decodeRunnable.isSeeking()) {
                    synchronized (this.mSeekingFlag) {
                        this.mSeekingFlag.wait(1000L);
                    }
                }
                decodeRunnable.nextTo(j3);
                this.logger.d(TAG, "handleSeekNext " + j3 + " ms");
            } catch (Exception e16) {
                this.logger.e(TAG, "handleSeekNext " + j3 + " ms", e16);
            }
        }
    }

    public void nextTo(long j3) {
        PlayHandler playHandler;
        if (this.currentDecodeRunnable != null && (playHandler = this.mPlayHandler) != null) {
            playHandler.removeMessages(2);
            sendMessage(3, (int) j3, null);
            this.logger.d(TAG, "nextTo " + j3 + " ms");
            return;
        }
        this.logger.w(TAG, "nextTo " + j3 + " ms failed, can not find DecodeRunnable");
    }

    public void pauseDecode() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            decodeRunnable.pauseFlag.compareAndSet(false, true);
            sendMessage(1, 0, null);
            this.logger.d(TAG, "pauseDecode " + decodeRunnable.pauseFlag.get());
            return;
        }
        this.logger.w(TAG, "pauseDecode failed, can not find DecodeRunnable");
    }

    public void resumeDecode() {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            decodeRunnable.clearTimeStamp();
            decodeRunnable.pauseFlag.compareAndSet(true, false);
            sendMessage(0, 0, null);
            this.logger.d(TAG, "resumeDecode " + decodeRunnable.pauseFlag.get());
            return;
        }
        this.logger.w(TAG, "resumeDecode failed, can not find DecodeRunnable");
    }

    public void seekTo(int i3) {
        PlayHandler playHandler;
        if (this.currentDecodeRunnable != null && (playHandler = this.mPlayHandler) != null) {
            playHandler.removeMessages(2);
            sendMessage(2, i3, null);
            this.logger.d(TAG, "seekTo " + i3 + " ms");
            return;
        }
        this.logger.w(TAG, "seekTo " + i3 + " ms failed, can not find DecodeRunnable");
    }

    public void setPKManager(PKManager pKManager) {
        this.mPKManager = pKManager;
    }

    public void setPlayRange(long j3, long j16) {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            this.logger.d(TAG, "setPlayRange [" + j3 + " ms, " + j16 + " ms]");
            decodeRunnable.setPlayRange(j3, j16);
            return;
        }
        this.logger.w(TAG, "setPlayRange failed, can not find DecodeRunnable");
    }

    public void setProlongToTime(long j3) {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            decodeRunnable.setProlongToTime(j3);
        }
    }

    public void setSpeedType(int i3) {
        DecodeRunnable decodeRunnable = this.currentDecodeRunnable;
        if (decodeRunnable != null) {
            decodeRunnable.setSpeedType(i3);
            this.logger.d(TAG, "setSpeedType" + i3);
            return;
        }
        this.logger.w(TAG, "setSpeedType " + i3 + " failed, can not find DecodeRunnable");
    }

    public void stopDecode() {
        PlayHandler playHandler;
        HandlerThread handlerThread = this.mPlayThread;
        if (handlerThread != null && handlerThread.isAlive() && (playHandler = this.mPlayHandler) != null) {
            playHandler.removeMessages(1);
            this.mPlayHandler.removeMessages(2);
            this.mPlayThread.quit();
        }
        Thread thread = this.currentDecodeThread;
        if (thread != null) {
            thread.interrupt();
        }
        this.currentDecodeThread = null;
        this.currentDecodeRunnable = null;
    }

    public void startDecode(DecodeConfig decodeConfig, int i3, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, HWDecodeListener hWDecodeListener) {
        DecodeOutputSurface decodeOutputSurface = new DecodeOutputSurface(i3, onFrameAvailableListener);
        this.decodeOutputSurface = decodeOutputSurface;
        startDecode(decodeConfig, decodeOutputSurface.surface, hWDecodeListener);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class EmptyHWDecodeListener implements HWDecodeListener {
        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeCancel() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFinish() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeRepeat() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeStart() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeSeekTo(long j3) {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeError(int i3, Throwable th5) {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFrame(long j3, long j16) throws InterruptedException {
        }
    }
}
