package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes3.dex */
public class NativeCodec extends NativeCodecBase implements IMediaCodecCallback {
    static IPatchRedirector $redirector_ = null;
    public static final String AVCPPS = "csd-1";
    public static final String AVCSPS = "csd-0";
    public static final String BOTTOM = "crop-bottom";
    public static final String HEVCVPSSPSPPS = "csd-0";
    public static final String LEFT = "crop-left";
    public static final String RIGHT = "crop-right";
    public static final String SLICEHEIGHT = "slice-height";
    public static final String STRIDE = "stride";
    public static final String TOP = "crop-top";
    public static boolean printLog;
    private int mBitRate;
    private boolean mCallHwCodcFuncTimeout;
    private AndroidCodecBase mCodec;
    private int mCodecType;
    private final AtomicBoolean mCodersExit;
    private int mColorFormat;
    private final boolean mDebugDelay;
    private Map<Long, Long> mDebugDelayMap;
    private Map<Integer, Long> mDebugDelayMap2;
    private Map<Long, Integer> mDebugIndexMap;
    private MediaFormat mFormat;
    private int mFrameInterval;
    private int mFrameRate;
    private int mHeight;
    private int mHwDetectMode;
    private boolean mHwEncodeTimeOpt;
    private int mImageMode;
    private boolean mIsDecoder;
    private long mLastEncFrameTime;
    private String mMime;
    private AndroidCodecStatus mNativeCodecStatus;
    private long mNativeContext;
    private final List<InputBufferData> mPendingInputBuffers;
    private int mQP;
    private int mRCMode;
    public final String mTag;
    private long mTimeStamp;
    private int mTotalCodecInFrameNum;
    private int mTotalCodecOutFrameNum;
    private int mTryAgainLaterCount;
    private int mTryAgainLaterCount2;
    private int mUseAdaptiveDecode;
    private int mWidth;
    private int setBitRatePending;
    private boolean setIFramePending;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            printLog = false;
        }
    }

    public NativeCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTimeStamp = 0L;
        this.mLastEncFrameTime = 0L;
        this.mTryAgainLaterCount = 0;
        this.mTryAgainLaterCount2 = 0;
        this.mFormat = null;
        this.mWidth = 320;
        this.mHeight = 240;
        this.mCodecType = 3;
        this.mHwDetectMode = 0;
        this.mCallHwCodcFuncTimeout = false;
        this.mHwEncodeTimeOpt = false;
        this.mNativeCodecStatus = AndroidCodecStatus.OK;
        this.mFrameRate = 20;
        this.mFrameInterval = 40000;
        this.mRCMode = 2;
        this.mTotalCodecInFrameNum = 0;
        this.mTotalCodecOutFrameNum = 0;
        this.mPendingInputBuffers = new ArrayList();
        this.mCodersExit = new AtomicBoolean(false);
        this.mDebugDelay = false;
        this.mDebugDelayMap = null;
        this.mDebugDelayMap2 = null;
        this.mDebugIndexMap = null;
        this.setBitRatePending = 0;
        this.setIFramePending = false;
        this.mImageMode = 0;
        this.mUseAdaptiveDecode = 0;
        this.mNativeContext = 0L;
        this.mTag = "NativeCodec_" + AVCoreLog.genDebugSeq();
    }

    public static boolean canLog() {
        if (!AVCoreLog.isDevelopLevel() && (!AVCoreLog.isColorLevel() || !printLog)) {
            return false;
        }
        return true;
    }

    private void createDecCodec() {
        boolean z16;
        MediaCodecInfo findPortableDecCodecBelowV29;
        this.mCodec = AndroidCodecAdapterProxy.getInstance().createDecCodec(this.mTag);
        boolean isSupportHWDecLowLatency = AndroidCodecAdapterProxy.getInstance().isSupportHWDecLowLatency();
        boolean z17 = true;
        if (Build.VERSION.SDK_INT >= 29) {
            z16 = true;
        } else {
            z16 = false;
        }
        String cpuModel = AVCoreSystemInfo.getCpuModel();
        if (cpuModel != null && cpuModel.contains("IncSM8350")) {
            z17 = false;
        }
        if (this.mIsDecoder) {
            long currentTimeMillis = System.currentTimeMillis();
            if (isSupportHWDecLowLatency && z16 && z17) {
                findPortableDecCodecBelowV29 = findPortableDecCodecAboveV29();
            } else {
                findPortableDecCodecBelowV29 = findPortableDecCodecBelowV29();
            }
            if (findPortableDecCodecBelowV29 == null) {
                return;
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "findPortableDecCodec codeName:=" + findPortableDecCodecBelowV29.getName() + ", costTimes:= " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (!this.mCodec.init(this.mMime, this.mFormat, findPortableDecCodecBelowV29.getName(), this.mCallHwCodcFuncTimeout, this)) {
                this.mCodec = null;
            }
        }
    }

    private void createEncCodec() {
        int i3;
        boolean z16;
        if (this.mCodec == null) {
            try {
                List<MediaCodecInfo> endoderInfos = AndroidCodecBase.getEndoderInfos(this.mMime);
                this.mColorFormat = 21;
                boolean z17 = false;
                int i16 = 0;
                while (true) {
                    if (i16 < endoderInfos.size()) {
                        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i16), this.mMime);
                        if (codecCapabilities != null) {
                            if (ArrayUtils.contains(codecCapabilities.colorFormats, 21)) {
                                this.mColorFormat = 21;
                                break;
                            } else if (ArrayUtils.contains(codecCapabilities.colorFormats, 19)) {
                                this.mColorFormat = 19;
                                break;
                            }
                        }
                        i16++;
                    } else {
                        i16 = 0;
                        break;
                    }
                }
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
                createVideoFormat.setInteger("color-format", this.mColorFormat);
                createVideoFormat.setInteger("frame-rate", this.mFrameRate);
                createVideoFormat.setInteger("bitrate", this.mBitRate);
                int i17 = this.mFrameRate;
                if (i17 * 30 > 255) {
                    i3 = 255 / i17;
                } else {
                    i3 = 30;
                }
                AVCoreLog.e(this.mTag, "KEY_I_FRAME_INTERVAL =" + i3 + ", mFrameRate = " + this.mFrameRate);
                createVideoFormat.setInteger("i-frame-interval", i3);
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i16), this.mMime);
                if (codecCapabilities2 != null) {
                    if (this.mMime.contains("video/avc")) {
                        int i18 = 0;
                        while (true) {
                            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities2.profileLevels;
                            if (i18 >= codecProfileLevelArr.length) {
                                break;
                            }
                            int i19 = codecProfileLevelArr[i18].profile;
                            int i26 = 512;
                            if (i19 != 1) {
                                if (i19 == 8 && 5 == this.mCodecType) {
                                    createVideoFormat.setInteger("profile", 8);
                                    int i27 = codecCapabilities2.profileLevels[i18].level;
                                    if (512 < i27) {
                                        i26 = i27;
                                    }
                                    createVideoFormat.setInteger("level", i26);
                                }
                            } else {
                                createVideoFormat.setInteger("profile", 1);
                                int i28 = codecCapabilities2.profileLevels[i18].level;
                                if (512 < i28) {
                                    i26 = i28;
                                }
                                createVideoFormat.setInteger("level", i26);
                            }
                            i18++;
                        }
                    }
                    if (this.mMime.contains("video/hevc")) {
                        int i29 = 0;
                        while (true) {
                            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr2 = codecCapabilities2.profileLevels;
                            if (i29 >= codecProfileLevelArr2.length) {
                                break;
                            }
                            if (codecProfileLevelArr2[i29].profile == 1) {
                                createVideoFormat.setInteger("profile", 1);
                                int i36 = codecCapabilities2.profileLevels[i29].level;
                                if (16384 >= i36) {
                                    i36 = 16384;
                                }
                                String cpuModel = AVCoreSystemInfo.getCpuModel();
                                if (cpuModel != null && (cpuModel.equalsIgnoreCase("QualcommTechnologies,IncMSM8953") || cpuModel.equalsIgnoreCase("QualcommTechnologies,Inc625"))) {
                                    createVideoFormat.setInteger("level", 16384);
                                } else if (cpuModel != null && (cpuModel.equalsIgnoreCase("MT6833V/ZA") || cpuModel.equalsIgnoreCase("MT6833V/PNZA") || cpuModel.equalsIgnoreCase("MT6833") || cpuModel.equalsIgnoreCase("MT6833P"))) {
                                    createVideoFormat.setInteger("level", 1024);
                                } else {
                                    createVideoFormat.setInteger("level", i36);
                                }
                            }
                            i29++;
                        }
                    }
                    this.mFormat = createVideoFormat;
                    int i37 = this.mFrameRate;
                    if (i37 > 0) {
                        this.mFrameInterval = 1000000 / i37;
                    } else {
                        this.mFrameInterval = 40000;
                    }
                    int i38 = Build.VERSION.SDK_INT;
                    MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities2.getEncoderCapabilities();
                    if (encoderCapabilities != null && encoderCapabilities.isBitrateModeSupported(2)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i38 >= 29 && i38 <= 30) {
                        z17 = true;
                    }
                    boolean isSupportHWEncCBR = AndroidCodecAdapterProxy.getInstance().isSupportHWEncCBR();
                    if (z17 && isSupportHWEncCBR && z16) {
                        createVideoFormat.setInteger("bitrate-mode", 2);
                    }
                    if (i38 > 30 && this.mRCMode == 2 && z16) {
                        createVideoFormat.setInteger("bitrate-mode", 2);
                    }
                    this.mCodec = AndroidCodecAdapterProxy.getInstance().createEncCodec(this.mTag);
                    AVCoreLog.e(this.mTag, "createEncCodec format: " + createVideoFormat + ", codec name: " + endoderInfos.get(i16).getName() + ", CBR: " + z16);
                    this.mCodec.init(this.mMime, this.mFormat, endoderInfos.get(i16).getName(), this.mCallHwCodcFuncTimeout, this);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                AVCoreLog.e(this.mTag, "Exception at CreateCodec!!!!");
                this.mCodec = null;
                this.mNativeCodecStatus = AndroidCodecStatus.ErrorCreateEncCodecException;
            }
        }
    }

    private boolean dequeueLastFrame(int i3) {
        boolean z16;
        boolean z17;
        ByteBuffer byteBuffer;
        AndroidCodecBase androidCodecBase = this.mCodec;
        if (androidCodecBase == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTag, "dequeueLastFrame err!! mCodec is null");
            }
            return false;
        }
        try {
            BufferData inputBuffer = androidCodecBase.getInputBuffer();
            int i16 = 0;
            while (inputBuffer == null) {
                i16++;
                if (this.mIsDecoder) {
                    dequeueOutFrameMore(3000000L);
                }
                inputBuffer = this.mCodec.getInputBuffer();
                if (inputBuffer != null) {
                    break;
                }
                if (i16 > 8) {
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.e(this.mTag, "dequeueLastFrame not available, try count=" + i16);
                    }
                    return false;
                }
            }
            inputBuffer.buffer = null;
            this.mCodec.queueInputBuffer(inputBuffer.index, 0, 0L, 4);
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 >= 10) {
                    break;
                }
                i17++;
                BufferData dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer();
                if (dequeueOutputBuffer != null && dequeueOutputBuffer.index >= 0) {
                    if (!dequeueOutputBuffer.success) {
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTag, "dequeueLastFrame output.success is false");
                        }
                    } else {
                        MediaFormat mediaFormat = dequeueOutputBuffer.format;
                        if (mediaFormat != null && (byteBuffer = dequeueOutputBuffer.buffer) != null) {
                            if (this.mIsDecoder) {
                                setFrame(byteBuffer, dequeueOutputBuffer.info.size, mediaFormat);
                            } else {
                                MediaCodec.BufferInfo bufferInfo = dequeueOutputBuffer.info;
                                readOutputStream(byteBuffer, bufferInfo.presentationTimeUs, bufferInfo.offset, bufferInfo.size, bufferInfo.flags);
                            }
                            this.mCodec.releaseOutputBuffer(dequeueOutputBuffer.index);
                            if ((dequeueOutputBuffer.info.flags & 4) != 0) {
                                if (AVCoreLog.isLogColorOrGary()) {
                                    AVCoreLog.e(this.mTag, "dequeueLastFrame reach eof getFrame: " + i18 + ", lastFrameCount: " + i3 + ", loopCount:" + i17);
                                }
                            } else {
                                i18++;
                            }
                        }
                        if (AVCoreLog.isLogColorOrGary()) {
                            String str = this.mTag;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("dequeueLastFrame err! output.format == null: ");
                            if (dequeueOutputBuffer.format == null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            sb5.append(z16);
                            sb5.append(", output.buffer == null: ");
                            if (dequeueOutputBuffer.buffer == null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            sb5.append(z17);
                            AVCoreLog.e(str, sb5.toString());
                        }
                        this.mCodec.releaseOutputBuffer(dequeueOutputBuffer.index);
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTag, "dequeueLastFrame CodecException!!", e16);
            }
            return false;
        }
    }

    private boolean dequeueOutFrameMore(long j3) {
        int i3;
        ByteBuffer byteBuffer;
        boolean z16;
        long j16 = 0;
        while (j16 < j3) {
            long nanoTime = System.nanoTime();
            BufferData dequeueDecoderOutputBuffer = this.mCodec.dequeueDecoderOutputBuffer(3000L);
            j16 += System.nanoTime() - nanoTime;
            if (dequeueDecoderOutputBuffer != null && (i3 = dequeueDecoderOutputBuffer.index) != -1 && i3 >= 0) {
                if (!dequeueDecoderOutputBuffer.success) {
                    AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer failed with exception");
                } else {
                    MediaFormat mediaFormat = dequeueDecoderOutputBuffer.format;
                    if (mediaFormat != null && (byteBuffer = dequeueDecoderOutputBuffer.buffer) != null) {
                        boolean z17 = true;
                        if (this.mIsDecoder) {
                            setFrame(byteBuffer, dequeueDecoderOutputBuffer.info.size, mediaFormat);
                        } else {
                            if (dequeueDecoderOutputBuffer.info.flags == 1) {
                                AVCoreLog.e(this.mTag, "dequeueOutFrameMore err flags = 1");
                            }
                            if (dequeueDecoderOutputBuffer.info.flags == 2) {
                                this.mCodec.releaseOutputBuffer(dequeueDecoderOutputBuffer.index);
                                ByteBuffer byteBuffer2 = dequeueDecoderOutputBuffer.buffer;
                                MediaCodec.BufferInfo bufferInfo = dequeueDecoderOutputBuffer.info;
                                readOutputStream(byteBuffer2, bufferInfo.presentationTimeUs, bufferInfo.offset, bufferInfo.size, bufferInfo.flags);
                                BufferData dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer();
                                if (dequeueOutputBuffer != null) {
                                    int i16 = dequeueOutputBuffer.index;
                                    if (i16 == -1) {
                                        this.mTryAgainLaterCount2++;
                                        if (AVCoreLog.isColorLevel()) {
                                            AVCoreLog.e(this.mTag, "dequeueOutFrameMore, re-dequeue dequeueOutputBuffer, try again later,count =" + this.mTryAgainLaterCount2);
                                        }
                                        if (this.mTryAgainLaterCount2 < 16) {
                                            return true;
                                        }
                                        AVCoreLog.e(this.mTag, "dequeueOutFrameMore, re-dequeue dequeueOutputBuffer >= 16 times");
                                        return false;
                                    }
                                    this.mTryAgainLaterCount2 = 0;
                                    if (!dequeueOutputBuffer.success) {
                                        AVCoreLog.e(this.mTag, "dequeueOutFrameMore, re-dequeue onDoCodec err!");
                                        return false;
                                    }
                                    if (dequeueOutputBuffer.format == null || dequeueOutputBuffer.buffer == null) {
                                        this.mCodec.releaseOutputBuffer(i16);
                                        String str = this.mTag;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("dequeueOutFrameMore err! output.format == null: ");
                                        if (dequeueOutputBuffer.format == null) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        sb5.append(z16);
                                        sb5.append(", output.buffer == null: ");
                                        if (dequeueOutputBuffer.buffer != null) {
                                            z17 = false;
                                        }
                                        sb5.append(z17);
                                        AVCoreLog.e(str, sb5.toString());
                                        return false;
                                    }
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue success");
                                }
                                dequeueDecoderOutputBuffer = dequeueOutputBuffer;
                            }
                            ByteBuffer byteBuffer3 = dequeueDecoderOutputBuffer.buffer;
                            MediaCodec.BufferInfo bufferInfo2 = dequeueDecoderOutputBuffer.info;
                            readOutputStream(byteBuffer3, bufferInfo2.presentationTimeUs, bufferInfo2.offset, bufferInfo2.size, bufferInfo2.flags);
                            this.mTotalCodecOutFrameNum++;
                        }
                        this.mCodec.releaseOutputBuffer(dequeueDecoderOutputBuffer.index);
                        return true;
                    }
                    AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer error");
                    this.mCodec.releaseOutputBuffer(dequeueDecoderOutputBuffer.index);
                }
            }
        }
        return false;
    }

    private MediaCodecInfo filterI420OrNV21Format(List<MediaCodecInfo> list, boolean z16) {
        MediaCodecInfo mediaCodecInfo = null;
        if (list.size() == 0) {
            AVCoreLog.e(this.mTag, "filterI420OrNV21Format fail, list.size\u4e3a0");
            return null;
        }
        if (z16) {
            mediaCodecInfo = list.get(0);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(list.get(i3), this.mMime);
            if (codecCapabilities != null) {
                if (ArrayUtils.contains(codecCapabilities.colorFormats, 19)) {
                    MediaCodecInfo mediaCodecInfo2 = list.get(i3);
                    this.mFormat.setInteger("color-format", 19);
                    return mediaCodecInfo2;
                }
                if (ArrayUtils.contains(codecCapabilities.colorFormats, 21)) {
                    MediaCodecInfo mediaCodecInfo3 = list.get(i3);
                    this.mFormat.setInteger("color-format", 21);
                    return mediaCodecInfo3;
                }
            }
        }
        return mediaCodecInfo;
    }

    private MediaCodecInfo findPortableDecCodecAboveV29() {
        AVCoreLog.e(this.mTag, "findPortableDecCodecNewApi");
        MediaCodecInfo filterI420OrNV21Format = filterI420OrNV21Format(MediaCodecHelper.getMediaCodecDecoderV29(this.mMime, -1), false);
        if (filterI420OrNV21Format == null) {
            return findPortableDecCodecBelowV29();
        }
        return filterI420OrNV21Format;
    }

    private MediaCodecInfo findPortableDecCodecBelowV29() {
        AVCoreLog.e(this.mTag, "findPortableDecCodecBelowV29");
        return filterI420OrNV21Format(AndroidCodecBase.getDecoderInfos(this.mMime), true);
    }

    private static int getIntValues(String str, String str2, boolean z16, boolean z17) {
        int intValuesImp = NativeCodecBase.getIntValuesImp("NativeCodec", str, str2, z16, z17);
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e("NativeCodec", "getIntValues, mime[" + str + "], isDecoder[" + z16 + "], key[" + str2 + "], value[" + intValuesImp + "]");
        }
        return intValuesImp;
    }

    private int getNativeCodecStatus() {
        AndroidCodecStatus androidCodecStatus = this.mNativeCodecStatus;
        AndroidCodecStatus androidCodecStatus2 = AndroidCodecStatus.OK;
        if (androidCodecStatus != androidCodecStatus2) {
            return androidCodecStatus.getValue();
        }
        AndroidCodecBase androidCodecBase = this.mCodec;
        if (androidCodecBase != null) {
            AndroidCodecStatus androidCodecStatus3 = androidCodecBase.getAndroidCodecStatus();
            if (androidCodecStatus3 != androidCodecStatus2) {
                return androidCodecStatus3.getValue();
            }
            return androidCodecStatus2.getValue();
        }
        return AndroidCodecBase.callGetCodecCountStatus().getValue();
    }

    public static native int getVersion();

    private static boolean onAttach(String str, long j3, boolean z16, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        NativeCodec nativeCodec = new NativeCodec(str, j3, map, z16);
        AVCoreLog.e(nativeCodec.mTag, "onAttach, mime[" + str + "], instance[" + j3 + "], isDecoder[" + z16 + "]");
        AVCoreLog.print(nativeCodec.mTag, (Map) map, true);
        if (nativeCodec.mCodec == null) {
            AVCoreLog.e(nativeCodec.mTag, "onAttach, fail");
            return false;
        }
        nativeCodec.attachCodec(nativeCodec);
        nativeCodec.mTimeStamp = 0L;
        nativeCodec.mTryAgainLaterCount = 0;
        nativeCodec.mLastEncFrameTime = 0L;
        nativeCodec.mTotalCodecOutFrameNum = 0;
        nativeCodec.mTotalCodecInFrameNum = 0;
        boolean start = nativeCodec.mCodec.start();
        AVCoreLog.e(nativeCodec.mTag, "HW TEST onAttach, cost[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
        return start;
    }

    private boolean onCalcDelay(int i3) {
        return true;
    }

    private static void onDetach(Object obj) {
        if (obj instanceof NativeCodec) {
            NativeCodec nativeCodec = (NativeCodec) obj;
            nativeCodec.detachCodec();
            nativeCodec.mTryAgainLaterCount = 0;
            nativeCodec.mTimeStamp = 0L;
            nativeCodec.mFormat = null;
            nativeCodec.mLastEncFrameTime = 0L;
            nativeCodec.mTotalCodecOutFrameNum = 0;
            nativeCodec.mTotalCodecInFrameNum = 0;
            synchronized (nativeCodec.mPendingInputBuffers) {
                nativeCodec.mCodersExit.set(true);
                nativeCodec.mPendingInputBuffers.clear();
                AndroidCodecBase androidCodecBase = nativeCodec.mCodec;
                if (androidCodecBase != null) {
                    try {
                        if (androidCodecBase.checkCallHwCodecFuncTimeOut()) {
                            nativeCodec.mCodec = null;
                        } else {
                            nativeCodec.mCodec.stop();
                            nativeCodec.mCodec.release();
                        }
                    } catch (Exception unused) {
                    }
                    nativeCodec.mCodec = null;
                }
                AVCoreLog.e(nativeCodec.mTag, "onDetach");
            }
            return;
        }
        AVCoreLog.e("NativeCodec", "onDetach, nativeCodec[" + obj + "]");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0134 A[Catch: Exception -> 0x031a, TryCatch #1 {Exception -> 0x031a, blocks: (B:20:0x008c, B:25:0x0098, B:27:0x00a6, B:29:0x00ac, B:33:0x00b8, B:159:0x00d1, B:41:0x00d5, B:43:0x00d9, B:46:0x00ec, B:48:0x00f5, B:51:0x0119, B:54:0x011e, B:57:0x0134, B:59:0x013b, B:61:0x0146, B:62:0x0162, B:65:0x0168, B:67:0x017b, B:72:0x016c, B:74:0x0178, B:76:0x0181, B:78:0x0187, B:80:0x0190, B:83:0x019a, B:86:0x01a0, B:88:0x01a4, B:89:0x02a5, B:92:0x02b2, B:94:0x02b6, B:96:0x02bd, B:98:0x02c1, B:100:0x02d1, B:101:0x01b6, B:103:0x01bc, B:104:0x01c4, B:106:0x01cb, B:108:0x01f6, B:110:0x01fa, B:112:0x0205, B:113:0x021e, B:115:0x0222, B:118:0x022d, B:120:0x0234, B:122:0x023e, B:124:0x0242, B:126:0x0246, B:129:0x025e, B:132:0x026c, B:136:0x0278, B:138:0x027e, B:139:0x0286, B:141:0x02a0, B:142:0x02e9, B:145:0x0301, B:148:0x030d, B:156:0x012b, B:157:0x00e1), top: B:19:0x008c, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean onDoCodec(int i3, int i16) {
        int writeInputData2;
        BufferData dequeueDecoderOutputBuffer;
        AndroidCodecBase androidCodecBase = this.mCodec;
        if (androidCodecBase == null) {
            AVCoreLog.e(this.mTag, "onDoCodec err!! mCodec is null");
            return false;
        }
        if (androidCodecBase.checkCallHwCodecFuncTimeOut()) {
            AVCoreLog.e(this.mTag, "onDoCodec err!! mCodec checkCallHwCodecFuncTimeOut");
            return false;
        }
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.e(this.mTag, "onDoCodec,frameIndex[" + i16 + "], flag[" + i3 + "], mTryAgainLaterCount[" + this.mTryAgainLaterCount + "]");
        }
        if (this.mTryAgainLaterCount >= 10 && i3 == 0) {
            AVCoreLog.e(this.mTag, "onDoCodec err!! restCodec mTryAgainLaterCount: " + this.mTryAgainLaterCount + ", flag: " + i3);
            resetCodec();
            if (this.mCodec == null) {
                return false;
            }
        }
        try {
            BufferData inputBuffer = this.mCodec.getInputBuffer();
            int i17 = 0;
            while (inputBuffer == null) {
                try {
                    LockMethodProxy.sleep(50L);
                    inputBuffer = this.mCodec.getInputBuffer();
                    i17++;
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                if (inputBuffer != null) {
                    break;
                }
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.e(this.mTag, "onDoCodec not available");
                }
                if (i17 > 8) {
                    AVCoreLog.e(this.mTag, "onDoCodec not available, try count=" + i17);
                    return false;
                }
                continue;
            }
            if (this.mIsDecoder) {
                writeInputData2 = writeInputData(inputBuffer.buffer, false);
            } else {
                writeInputData2 = writeInputData2(inputBuffer.buffer, this.mColorFormat, false);
            }
            int i18 = writeInputData2;
            if (i18 < 0) {
                AVCoreLog.e(this.mTag, "writeInputData, SampleSize < 0");
                return false;
            }
            long j3 = this.mLastEncFrameTime + this.mFrameInterval;
            this.mLastEncFrameTime = j3;
            this.mCodec.queueInputBuffer(inputBuffer.index, i18, j3, 0);
            boolean z16 = true;
            this.mTotalCodecInFrameNum++;
            long nanoTime = System.nanoTime();
            boolean z17 = this.mIsDecoder;
            if (!z17 && (z17 || !this.mHwEncodeTimeOpt)) {
                dequeueDecoderOutputBuffer = this.mCodec.dequeueOutputBuffer();
                long j16 = r4;
                if (dequeueDecoderOutputBuffer != null) {
                    int i19 = dequeueDecoderOutputBuffer.index;
                    if (i19 == -1) {
                        this.mTryAgainLaterCount++;
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTag, "onDoCodec, try again, count[" + this.mTryAgainLaterCount + "]");
                        }
                        boolean z18 = this.mIsDecoder;
                        if ((!z18 && (z18 || !this.mHwEncodeTimeOpt)) || !dequeueOutFrameMore(j16 - (System.nanoTime() - nanoTime))) {
                            return this.mTryAgainLaterCount < 16;
                        }
                        this.mTryAgainLaterCount = 0;
                        return true;
                    }
                    this.mTryAgainLaterCount = 0;
                    if (!dequeueDecoderOutputBuffer.success) {
                        AVCoreLog.e(this.mTag, "onDoCodec err!");
                        return false;
                    }
                    if (dequeueDecoderOutputBuffer.format != null && dequeueDecoderOutputBuffer.buffer != null) {
                        if (this.mIsDecoder) {
                            calcDelay(true, dequeueDecoderOutputBuffer.info);
                            setFrame(dequeueDecoderOutputBuffer.buffer, dequeueDecoderOutputBuffer.info.size, dequeueDecoderOutputBuffer.format);
                        } else {
                            if (dequeueDecoderOutputBuffer.info.flags == 1) {
                                AVCoreLog.e(this.mTag, "onDoCodec err flags = 1");
                            }
                            if (dequeueDecoderOutputBuffer.info.flags == 2) {
                                this.mCodec.releaseOutputBuffer(dequeueDecoderOutputBuffer.index);
                                ByteBuffer byteBuffer = dequeueDecoderOutputBuffer.buffer;
                                MediaCodec.BufferInfo bufferInfo = dequeueDecoderOutputBuffer.info;
                                readOutputStream(byteBuffer, bufferInfo.presentationTimeUs, bufferInfo.offset, bufferInfo.size, bufferInfo.flags);
                                dequeueDecoderOutputBuffer = this.mCodec.dequeueOutputBuffer();
                                if (dequeueDecoderOutputBuffer != null) {
                                    int i26 = dequeueDecoderOutputBuffer.index;
                                    if (i26 == -1) {
                                        this.mTryAgainLaterCount2++;
                                        if (AVCoreLog.isColorLevel()) {
                                            AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue dequeueOutputBuffer, try again later,count =" + this.mTryAgainLaterCount2);
                                        }
                                        if (this.mTryAgainLaterCount2 < 16) {
                                            return true;
                                        }
                                        AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue dequeueOutputBuffer >= 16 times");
                                        return false;
                                    }
                                    this.mTryAgainLaterCount2 = 0;
                                    if (!dequeueDecoderOutputBuffer.success) {
                                        AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue onDoCodec err!");
                                        return false;
                                    }
                                    if (dequeueDecoderOutputBuffer.format == null || dequeueDecoderOutputBuffer.buffer == null) {
                                        this.mCodec.releaseOutputBuffer(i26);
                                        String str = this.mTag;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("onDoCodec err! output.format == null: ");
                                        sb5.append(dequeueDecoderOutputBuffer.format == null);
                                        sb5.append(", output.buffer == null: ");
                                        if (dequeueDecoderOutputBuffer.buffer != null) {
                                            z16 = false;
                                        }
                                        sb5.append(z16);
                                        AVCoreLog.e(str, sb5.toString());
                                        return false;
                                    }
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue success");
                                }
                            }
                            calcDelay(true, dequeueDecoderOutputBuffer.info);
                            ByteBuffer byteBuffer2 = dequeueDecoderOutputBuffer.buffer;
                            MediaCodec.BufferInfo bufferInfo2 = dequeueDecoderOutputBuffer.info;
                            readOutputStream(byteBuffer2, bufferInfo2.presentationTimeUs, bufferInfo2.offset, bufferInfo2.size, bufferInfo2.flags);
                            if (this.mHwEncodeTimeOpt) {
                                this.mTotalCodecOutFrameNum++;
                            }
                        }
                        this.mCodec.releaseOutputBuffer(dequeueDecoderOutputBuffer.index);
                        boolean z19 = this.mIsDecoder;
                        if ((z19 || (!z19 && this.mHwEncodeTimeOpt)) && this.mTotalCodecInFrameNum - this.mTotalCodecOutFrameNum > 0 && this.mImageMode != 1) {
                            boolean dequeueOutFrameMore = dequeueOutFrameMore(j16 - (System.nanoTime() - nanoTime));
                            if (AVCoreLog.isLogColorOrGary()) {
                                AVCoreLog.e(this.mTag, "dequeue one store Frame status: " + dequeueOutFrameMore);
                            }
                        }
                    }
                    this.mCodec.releaseOutputBuffer(i19);
                    String str2 = this.mTag;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("onDoCodec err! output.format == null: ");
                    sb6.append(dequeueDecoderOutputBuffer.format == null);
                    sb6.append(", output.buffer == null: ");
                    if (dequeueDecoderOutputBuffer.buffer != null) {
                        z16 = false;
                    }
                    sb6.append(z16);
                    AVCoreLog.e(str2, sb6.toString());
                    return false;
                }
                return true;
            }
            r4 = i16 < 4 ? 45000000L : 33000000L;
            dequeueDecoderOutputBuffer = this.mCodec.dequeueDecoderOutputBuffer(r4);
            long j162 = r4;
            if (dequeueDecoderOutputBuffer != null) {
            }
            return true;
        } catch (Exception e17) {
            AVCoreLog.e(this.mTag, "onDoCodec Exception!", e17);
            this.mNativeCodecStatus = AndroidCodecStatus.ErrorOnDoCodecFrame;
            return false;
        }
    }

    private int onDoCodecAsync(int i3, int i16) {
        int writeInputData2;
        if (!NativeCodecBase.sUseAsyncAPI) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "NOT in async mode.");
            }
            return -1;
        }
        synchronized (this.mPendingInputBuffers) {
            if (this.mCodersExit.get()) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(this.mTag, "hardware coders exit, return.");
                }
                return 2;
            }
            if (this.mPendingInputBuffers.size() <= 0) {
                return 2;
            }
            if (canLog()) {
                AVCoreLog.e(this.mTag, "InputData pendingInputBuffers exist, size:" + this.mPendingInputBuffers.size());
            }
            InputBufferData inputBufferData = this.mPendingInputBuffers.get(0);
            if (inputBufferData == null) {
                return 2;
            }
            ByteBuffer byteBuffer = inputBufferData.buffer;
            if (byteBuffer == null) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(this.mTag, "inputbuffer null, return");
                }
                return -1;
            }
            if (inputBufferData.processing) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(this.mTag, "curr buffer is being processed by other thread, return");
                }
                return 2;
            }
            if (this.mIsDecoder) {
                writeInputData2 = writeInputData(byteBuffer, false);
            } else {
                writeInputData2 = writeInputData2(byteBuffer, this.mColorFormat, false);
            }
            int i17 = writeInputData2;
            if (canLog()) {
                AVCoreLog.e(this.mTag, "onDoCodecAsync, sampleSize[" + i17 + "]");
            }
            if (i17 > 0) {
                this.mLastEncFrameTime += this.mFrameInterval;
                this.mPendingInputBuffers.remove(0);
                this.mCodec.queueInputBuffer(inputBufferData.index, i17, this.mLastEncFrameTime, 0);
                return 1;
            }
            if (i17 != 0 && i17 != -1) {
                return -1;
            }
            return 0;
        }
    }

    public static native boolean putByteArray2ByteBuffer(ByteBuffer byteBuffer, int i3, byte[] bArr, int i16, int i17, int i18, int i19);

    private void resetCodec() {
        if (this.mCodec != null) {
            try {
                synchronized (this.mPendingInputBuffers) {
                    this.mCodersExit.set(true);
                    this.mPendingInputBuffers.clear();
                    this.mCodec.stop();
                    this.mCodec.release();
                    this.mCodec = null;
                }
            } catch (Exception unused) {
                this.mCodec = null;
                this.mNativeCodecStatus = AndroidCodecStatus.ErrorResetCodecException;
            }
        }
        try {
            if (this.mIsDecoder) {
                createDecCodec();
            } else {
                createEncCodec();
            }
            this.mTimeStamp = 0L;
            this.mLastEncFrameTime = 0L;
            this.mCodec.start();
            this.mCodersExit.set(false);
        } catch (Exception unused2) {
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "resetCodec");
        }
    }

    public static native void setDeviceInfo(String str);

    private boolean setFrame(ByteBuffer byteBuffer, int i3, MediaFormat mediaFormat) {
        int i16;
        int i17;
        String str;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        int integer3 = mediaFormat.getInteger(LEFT);
        int integer4 = mediaFormat.getInteger(RIGHT);
        int integer5 = mediaFormat.getInteger(TOP);
        int integer6 = mediaFormat.getInteger(BOTTOM);
        int integer7 = mediaFormat.getInteger(STRIDE);
        int integer8 = mediaFormat.getInteger(SLICEHEIGHT);
        int integer9 = mediaFormat.getInteger("color-format");
        int max = Math.max(integer8, integer2);
        int max2 = Math.max(integer7, integer);
        if (integer9 == 2130706688) {
            i16 = max - (integer5 / 2);
            str = SLICEHEIGHT;
            integer5 = 0;
            i17 = 0;
        } else {
            i16 = max;
            i17 = integer3;
            str = SLICEHEIGHT;
        }
        int max3 = Math.max(max2, integer);
        if ((2141391876 == integer9 || 2130706433 == integer9 || 2130706944 == integer9) && integer2 < i16) {
            i18 = i16;
        } else {
            i18 = integer2;
        }
        if (i17 + integer4 + integer5 + integer6 == 0) {
            i26 = integer5;
            i36 = 0;
            i28 = integer2 - 1;
            i19 = i16;
            i29 = integer - 1;
            i27 = 0;
        } else {
            i19 = i16;
            int i37 = (integer4 - i17) + 1;
            i26 = integer5;
            int i38 = (integer6 - integer5) + 1;
            if (max3 < i37) {
                max3 = i37;
            }
            if (i18 < i38) {
                i18 = i38;
            }
            i27 = i17;
            i28 = integer6;
            i29 = integer4;
            i36 = i26;
        }
        int i39 = max3;
        int i46 = i18;
        if (i39 > 0 && i46 > 0 && i29 > 0 && i28 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i47 = (i28 - i36) + 1;
            int i48 = i19;
            int i49 = i17;
            String str2 = str;
            int readOutputDataEx = readOutputDataEx(byteBuffer, i3, i39, i46, i27, i36, (i29 - i27) + 1, i47, integer9);
            this.mTotalCodecOutFrameNum++;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (canLog()) {
                AVCoreLog.e(this.mTag, "setFrame, size[" + i3 + "], width[" + integer + "], height[" + integer2 + "], crop_left[" + mediaFormat.getInteger(LEFT) + "->" + i49 + "], crop_right[" + integer4 + "], crop_top[" + mediaFormat.getInteger(TOP) + "->" + i26 + "], crop_bottom[" + integer6 + "], stride[" + mediaFormat.getInteger(STRIDE) + "->" + max2 + "], slice_height[" + mediaFormat.getInteger(str2) + "->" + i48 + "], picWidth[" + i39 + "], picHeight[" + i46 + "], colorFormat[0x" + Integer.toHexString(integer9).toUpperCase() + "], cost[" + elapsedRealtime2 + "]");
            }
            if (readOutputDataEx <= 0) {
                return false;
            }
            return true;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "setFrame, error, size[" + i3 + "], colorFormat[0x" + Integer.toHexString(integer9).toUpperCase() + "]");
        }
        return false;
    }

    private void setParameters(String str, int i3) {
        if (this.mCodec == null || str == null) {
            return;
        }
        if (str.equalsIgnoreCase("frame-rate")) {
            if (i3 > 0) {
                this.mFrameRate = i3;
                this.mFrameInterval = 1000000 / i3;
                resetCodec();
                AVCoreLog.e(this.mTag, "HWENC setParameters mFrameRate =" + this.mFrameRate);
            } else {
                return;
            }
        }
        if (this.mCodec == null) {
            return;
        }
        if (str.equalsIgnoreCase("i-frame-interval")) {
            AVCoreLog.e(this.mTag, "HWENC setParameters i-frame-interval: " + i3 + ", frameRate: " + this.mFrameRate);
            int i16 = this.mFrameRate;
            if (i3 * i16 > 255) {
                i3 = 255 / i16;
                AVCoreLog.e(this.mTag, "HWENC setParameters i-frame-interval changed: " + i3);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt(str, i3);
        this.mCodec.setParameters(bundle);
    }

    public native boolean attachCodec(Object obj);

    public native void detachCodec();

    @Override // com.tencent.avcore.jni.codec.IMediaCodecCallback
    public void onError(MediaCodec mediaCodec, Exception exc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mediaCodec, (Object) exc);
            return;
        }
        if (this.mCodersExit.get()) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "codec exit, return onError");
            }
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "onError", exc);
        }
    }

    @Override // com.tencent.avcore.jni.codec.IMediaCodecCallback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaCodec, i3);
            return;
        }
        ByteBuffer inputBuffer = this.mCodec.getInputBuffer(i3);
        if (inputBuffer == null) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "getInputBuffer null, index:" + i3);
                return;
            }
            return;
        }
        try {
            synchronized (this.mPendingInputBuffers) {
                if (this.mCodersExit.get()) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.e(this.mTag, "codec exit, return onInputBufferAvailable");
                    }
                    synchronized (this.mPendingInputBuffers) {
                        try {
                            this.mPendingInputBuffers.get(0).processing = false;
                        } catch (Exception unused) {
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
                            }
                        }
                    }
                    return;
                }
                this.mPendingInputBuffers.add(new InputBufferData(inputBuffer, i3));
                this.mPendingInputBuffers.get(0).processing = true;
                try {
                    if (canLog()) {
                        AVCoreLog.e(this.mTag, "call writeInputData2 in callback, mIsDecoder[" + this.mIsDecoder + "]");
                    }
                    if (this.mIsDecoder) {
                        i17 = writeInputData(this.mPendingInputBuffers.get(0).buffer, true);
                    } else {
                        i17 = writeInputData2(this.mPendingInputBuffers.get(0).buffer, this.mColorFormat, true);
                    }
                } catch (Exception unused2) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.e(this.mTag, "input buffers cleared by other thread when writeInputData");
                    }
                    i17 = 0;
                }
                if (i17 > 0) {
                    try {
                        if (canLog()) {
                            AVCoreLog.e(this.mTag, "writeInputData, SampleSize:" + i17);
                        }
                        this.mLastEncFrameTime += this.mFrameInterval;
                        try {
                            this.mCodec.queueInputBuffer(this.mPendingInputBuffers.get(0).index, i17, this.mLastEncFrameTime, 0);
                        } catch (Exception unused3) {
                            if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.e(this.mTag, "input buffers cleared by other thread when queueInputBuffer");
                            }
                        }
                    } catch (Throwable th5) {
                        i16 = i17;
                        th = th5;
                        synchronized (this.mPendingInputBuffers) {
                            try {
                                this.mPendingInputBuffers.get(0).processing = false;
                                if (i16 > 0) {
                                    this.mPendingInputBuffers.remove(0);
                                }
                            } catch (Exception unused4) {
                                if (AVCoreLog.isColorLevel()) {
                                    AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
                                }
                            }
                        }
                        throw th;
                    }
                }
                synchronized (this.mPendingInputBuffers) {
                    try {
                        this.mPendingInputBuffers.get(0).processing = false;
                        if (i17 > 0) {
                            this.mPendingInputBuffers.remove(0);
                        }
                    } catch (Exception unused5) {
                        if (AVCoreLog.isColorLevel()) {
                            AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            i16 = 0;
        }
    }

    @Override // com.tencent.avcore.jni.codec.IMediaCodecCallback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, mediaCodec, Integer.valueOf(i3), bufferInfo);
            return;
        }
        if (this.mCodersExit.get()) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "codec exit, return onOutputBufferAvailable");
                return;
            }
            return;
        }
        ByteBuffer outputBuffer = this.mCodec.getOutputBuffer(i3);
        if (outputBuffer != null && bufferInfo != null) {
            if (this.mIsDecoder) {
                MediaFormat outputFormat = this.mCodec.getOutputFormat(i3);
                if (outputFormat != null) {
                    calcDelay(false, bufferInfo);
                    setFrame(outputBuffer, bufferInfo.size, outputFormat);
                } else if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e(this.mTag, "getOutputFormat null");
                }
            } else {
                calcDelay(false, bufferInfo);
                readOutputStream(outputBuffer, bufferInfo.presentationTimeUs, bufferInfo.offset, bufferInfo.size, bufferInfo.flags);
            }
            this.mCodec.releaseOutputBuffer(i3);
        }
    }

    @Override // com.tencent.avcore.jni.codec.IMediaCodecCallback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) mediaCodec, (Object) mediaFormat);
            return;
        }
        if (this.mCodersExit.get()) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(this.mTag, "codec exit, return onOutputFormatChanged");
            }
        } else if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "onOutputFormatChanged");
        }
    }

    public native int readOutputData(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36);

    public native int readOutputDataEx(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    public native int readOutputStream(ByteBuffer byteBuffer, long j3, int i3, int i16, int i17);

    public native int setAVCParams(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    void setParams_impl() {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "setParams_impl");
        }
        if (this.setIFramePending) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodecConstants.FORCE_I_FRAME, 1);
            this.setIFramePending = false;
            int i3 = this.setBitRatePending;
            if (i3 > 0) {
                bundle.putInt("bitrate", i3);
            }
            this.mCodec.setParameters(bundle);
            this.setBitRatePending = 0;
        }
        if (this.setBitRatePending > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("bitrate", this.setBitRatePending);
            if (this.setIFramePending) {
                bundle2.putInt(MediaCodecConstants.FORCE_I_FRAME, 1);
            }
            this.mCodec.setParameters(bundle2);
            this.setBitRatePending = 0;
            this.setIFramePending = false;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mTag;
    }

    public native int writeInputData(ByteBuffer byteBuffer, boolean z16);

    public native int writeInputData2(ByteBuffer byteBuffer, int i3, boolean z16);

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    public NativeCodec(String str, long j3, Map<String, Object> map, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), map, Boolean.valueOf(z16));
            return;
        }
        this.mTimeStamp = 0L;
        this.mLastEncFrameTime = 0L;
        this.mTryAgainLaterCount = 0;
        this.mTryAgainLaterCount2 = 0;
        this.mFormat = null;
        this.mWidth = 320;
        this.mHeight = 240;
        this.mCodecType = 3;
        this.mHwDetectMode = 0;
        this.mCallHwCodcFuncTimeout = false;
        this.mHwEncodeTimeOpt = false;
        this.mNativeCodecStatus = AndroidCodecStatus.OK;
        this.mFrameRate = 20;
        this.mFrameInterval = 40000;
        this.mRCMode = 2;
        this.mTotalCodecInFrameNum = 0;
        this.mTotalCodecOutFrameNum = 0;
        this.mPendingInputBuffers = new ArrayList();
        this.mCodersExit = new AtomicBoolean(false);
        this.mDebugDelay = false;
        this.mDebugDelayMap = null;
        this.mDebugDelayMap2 = null;
        this.mDebugIndexMap = null;
        this.setBitRatePending = 0;
        this.setIFramePending = false;
        this.mImageMode = 0;
        this.mUseAdaptiveDecode = 0;
        this.mNativeContext = 0L;
        this.mIsDecoder = z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("NativeCodec_");
        sb5.append(NativeCodecBase.sUseAsyncAPI ? "Async_" : "Sync_");
        sb5.append(this.mIsDecoder ? "DEC" : "ENC");
        sb5.append("_i");
        sb5.append(j3);
        sb5.append("_");
        sb5.append(AVCoreLog.genDebugSeq());
        String sb6 = sb5.toString();
        this.mTag = sb6;
        this.mMime = str;
        this.mNativeContext = j3;
        this.mWidth = ((Integer) map.get("width")).intValue();
        this.mHeight = ((Integer) map.get("height")).intValue();
        if (AVCoreLog.isDebugVersion() || AVCoreLog.isGrayVersion()) {
            this.mHwDetectMode = ((Integer) map.get("hw-detect-mode")).intValue();
        }
        if (map.containsKey("call_hwcodec_func_timeout")) {
            this.mCallHwCodcFuncTimeout = ((Integer) map.get("call_hwcodec_func_timeout")).intValue() == 1;
        } else {
            this.mCallHwCodcFuncTimeout = false;
        }
        if (map.containsKey("hw_encode_time_opt")) {
            this.mHwEncodeTimeOpt = ((Integer) map.get("hw_encode_time_opt")).intValue() == 1;
        } else {
            this.mHwEncodeTimeOpt = false;
        }
        AVCoreLog.e(sb6, "NativeCodec, w[" + this.mWidth + "], h[" + this.mHeight + "], isDecoder[" + this.mIsDecoder + "], mMime[" + this.mMime + "], hwDetectMode[" + this.mHwDetectMode + "], call_hwcodec_func_timeout[" + this.mCallHwCodcFuncTimeout + "], hw_encode_time_opt[" + this.mHwEncodeTimeOpt + "]");
        if (this.mIsDecoder) {
            try {
                this.mImageMode = ((Integer) map.get("hw-decode-image")).intValue();
                AVCoreLog.e(sb6, "hw-decode-image mode: " + this.mImageMode);
                this.mUseAdaptiveDecode = ((Integer) map.get("adaptive-decode")).intValue();
                AVCoreLog.e(sb6, "adaptive-decode: " + this.mUseAdaptiveDecode);
                int i3 = this.mWidth;
                int i16 = this.mHeight;
                this.mFormat = MediaFormat.createVideoFormat(str, i3, i16);
                if (str.contains("video/avc")) {
                    this.mFormat.setInteger("max-input-size", i3 * i16);
                    this.mFormat.setInteger("color-format", 21);
                    this.mFormat.setInteger("frame-rate", 25);
                    ByteBuffer byteBuffer = (ByteBuffer) map.get("csd-0");
                    ByteBuffer byteBuffer2 = (ByteBuffer) map.get("csd-1");
                    this.mFormat.setByteBuffer("csd-0", byteBuffer);
                    this.mFormat.setByteBuffer("csd-1", byteBuffer2);
                }
                if (str.contains("video/hevc")) {
                    this.mFormat.setInteger("max-input-size", i3 * i16);
                    this.mFormat.setInteger("color-format", 21);
                    this.mFormat.setInteger("frame-rate", 25);
                    this.mFormat.setByteBuffer("csd-0", (ByteBuffer) map.get("csd-0"));
                }
                createDecCodec();
                return;
            } catch (Exception unused) {
                this.mCodec = null;
                this.mNativeCodecStatus = AndroidCodecStatus.ErrorCreateDecCodecException;
                return;
            }
        }
        try {
            this.mBitRate = ((Integer) map.get("bitrate")).intValue();
            this.mFrameRate = ((Integer) map.get("frame-rate")).intValue();
            this.mRCMode = ((Integer) map.get("hw-enc-rc-mode")).intValue();
            this.mQP = ((Integer) map.get("hw-cqp-qp")).intValue();
            this.mCodecType = 3;
            createEncCodec();
        } catch (Exception e16) {
            this.mCodec = null;
            this.mNativeCodecStatus = AndroidCodecStatus.ErrorCreateEncCodecException;
            AVCoreLog.e(this.mTag, "NativeCodec, createEncCodec Exception", e16);
        }
    }

    void calcDelay(boolean z16, MediaCodec.BufferInfo bufferInfo) {
    }
}
