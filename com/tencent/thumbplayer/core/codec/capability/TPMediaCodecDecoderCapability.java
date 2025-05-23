package com.tencent.thumbplayer.core.codec.capability;

import android.content.Context;
import androidx.collection.SparseArrayCompat;
import com.tencent.thumbplayer.core.codec.capability.TPMediaDecoderInfo;
import com.tencent.thumbplayer.core.codec.common.TPMimeTypes;
import com.tencent.thumbplayer.core.utils.TPApplicationContext;
import com.tencent.thumbplayer.core.utils.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.utils.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPThreadPool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPMediaCodecDecoderCapability {
    public static final int AV1_PROFILE_MAIN10_HDR10 = 4096;
    public static final int AV1_PROFILE_MAIN10_HDR10_PLUS = 8192;
    public static final float DEFAULT_FRAMERATE = 30.0f;
    public static final int HEVC_PROFILE_MAIN10_HDR10 = 4096;
    public static final int HEVC_PROFILE_MAIN10_HDR10_PLUS = 8192;
    public static final int PROFILE_DEFAULT = 0;
    private static final String TAG = "TPMediaCodecDecoderCapability";
    public static final int TP_DECODER_CAP_NOT_SUPPORT = 0;
    public static final int TP_DECODER_CAP_SUPPORT = 1;
    public static final int TP_DECODER_FEATURE_ADAPTIVE_PLAYBACK = 0;
    public static final int TP_DECODER_FEATURE_ROTATION = 1;
    private static SparseArrayCompat<HashMap<String, Integer>> sHdrCodecMimeTypeProfileMap = new SparseArrayCompat<>();
    private static Context sContext = TPApplicationContext.getContext();
    private static boolean sIsInitDone = false;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("video/hevc", 4096);
        hashMap.put("video/av01", 4096);
        sHdrCodecMimeTypeProfileMap.put(0, hashMap);
        sHdrCodecMimeTypeProfileMap.put(4, hashMap);
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        hashMap2.put("video/hevc", 8192);
        hashMap2.put("video/av01", 8192);
        sHdrCodecMimeTypeProfileMap.put(1, hashMap2);
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        hashMap3.put("video/dolby-vision", 0);
        sHdrCodecMimeTypeProfileMap.put(2, hashMap3);
    }

    static /* synthetic */ Context access$000() {
        return getAppContext();
    }

    private static Context getAppContext() {
        if (sContext == null) {
            sContext = TPApplicationContext.getContext();
        }
        return sContext;
    }

    @TPMethodCalledByNative
    public static int getAudioDecoderCapability(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInWhiteList(str)) {
            return 1;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInBlackList(str)) {
            return 0;
        }
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(getAppContext())) {
            if (tPMediaDecoderInfo.isAudio() && str.equals(tPMediaDecoderInfo.getDecoderMimeType())) {
                return 1;
            }
        }
        if (!TPMediaCodecCapabilityForWanosFromSystemProperty.isWanosAudioType(str) || !TPMediaCodecCapabilityForWanosFromSystemProperty.isWanosAudioDecodeSupported()) {
            return 0;
        }
        return 1;
    }

    @TPMethodCalledByNative
    public static int getAudioDecoderCapabilityWithParams(TPMediaCodecAudioDecoderQueryParams tPMediaCodecAudioDecoderQueryParams) {
        if (tPMediaCodecAudioDecoderQueryParams == null) {
            return 0;
        }
        String mimeType = tPMediaCodecAudioDecoderQueryParams.getMimeType();
        if (mimeType.isEmpty()) {
            return 0;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInWhiteList(mimeType)) {
            return 1;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInBlackList(mimeType)) {
            return 0;
        }
        if (isWithinMaxAudioDecoderCapability(tPMediaCodecAudioDecoderQueryParams)) {
            return 1;
        }
        if (!TPMediaCodecCapabilityForWanosFromSystemProperty.isWanosAudioType(mimeType) || !TPMediaCodecCapabilityForWanosFromSystemProperty.isWanosAudioDecodeSupported()) {
            return 0;
        }
        return 1;
    }

    private static int getAudioFormat(String str, int i3) {
        if ("audio/vnd.dts".equals(str)) {
            if (i3 == 20) {
                return 7;
            }
            if (i3 == 50 || i3 == 60) {
                return 8;
            }
        } else {
            if ("audio/ac3".equals(str)) {
                return 5;
            }
            if ("audio/eac3".equals(str)) {
                return 6;
            }
        }
        return 1;
    }

    @TPMethodCalledByNative
    public static int getAudioPassThroughCapability(String str, int i3, int i16) {
        if ("audio/vnd.dts".equals(str) || "audio/ac3".equals(str) || "audio/eac3".equals(str)) {
            return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(getAudioFormat(str, i3), i16) ? 1 : 0;
        }
        return 0;
    }

    @TPMethodCalledByNative
    public static int getDecoderHdrCapability(int i3) {
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInHdrMediaCodecWhiteList(i3)) {
            return 1;
        }
        if (!sHdrCodecMimeTypeProfileMap.containsKey(i3)) {
            return 0;
        }
        for (Map.Entry<String, Integer> entry : sHdrCodecMimeTypeProfileMap.get(i3).entrySet()) {
            if (getVideoDecoderCapability(entry.getKey(), entry.getValue().intValue()) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static float getMaxSupportedFrameRates(String str, int i3, int i16) {
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(getAppContext())) {
            if (tPMediaDecoderInfo.isVideo() && str.equals(tPMediaDecoderInfo.getDecoderMimeType())) {
                int decoderMaxWidth = tPMediaDecoderInfo.getDecoderMaxWidth();
                int decoderLumaHeight = tPMediaDecoderInfo.getDecoderLumaHeight();
                float decoderMaxFrameRateForMaxLuma = tPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma();
                float decoderMaxFrameRate = tPMediaDecoderInfo.getDecoderMaxFrameRate();
                if (isBeyondMaxWidthOrMaxHeight(tPMediaDecoderInfo, i3, i16)) {
                    return 0.0f;
                }
                return Math.min(decoderMaxFrameRate, Math.max(1.0f, decoderMaxFrameRateForMaxLuma * ((int) (((decoderMaxWidth * decoderLumaHeight) * 1) / Math.max((i3 * i16) * 1, 1L)))));
            }
        }
        return 0.0f;
    }

    @TPMethodCalledByNative
    public static int getMaxSupportedInstances(String str) {
        if (str.isEmpty()) {
            return getMaxSupportedInstances();
        }
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(getAppContext())) {
            if (str.equals(tPMediaDecoderInfo.getDecoderMimeType())) {
                return Math.min(tPMediaDecoderInfo.getMaxSupportedInstances(), getMaxSupportedInstances());
            }
        }
        return getMaxSupportedInstances();
    }

    @TPMethodCalledByNative
    public static int getVideoDecoderCapability(String str, int i3, int i16, float f16) {
        if (str.isEmpty()) {
            return 0;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInWhiteList(str)) {
            return 1;
        }
        return (!TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInBlackList(str) && f16 <= getMaxSupportedFrameRates(str, i3, i16)) ? 1 : 0;
    }

    private static boolean isBeyondMaxWidthOrMaxHeight(TPMediaDecoderInfo tPMediaDecoderInfo, int i3, int i16) {
        int i17;
        int decoderMaxWidth = tPMediaDecoderInfo.getDecoderMaxWidth();
        int decoderMaxHeight = tPMediaDecoderInfo.getDecoderMaxHeight();
        int decoderLumaWidth = tPMediaDecoderInfo.getDecoderLumaWidth();
        int decoderLumaHeight = tPMediaDecoderInfo.getDecoderLumaHeight();
        if ((i3 <= i16 || (i3 <= decoderMaxWidth && i16 <= decoderLumaHeight)) && (i3 >= i16 || (i3 <= decoderLumaWidth && i16 <= decoderMaxHeight))) {
            return false;
        }
        if (i3 > i16) {
            i17 = decoderLumaHeight * decoderMaxWidth;
        } else {
            i17 = decoderLumaWidth * decoderMaxHeight;
        }
        if (decoderMaxWidth >= i3 && decoderMaxHeight >= i16 && i17 >= i3 * i16) {
            TPNativeLog.printLog(2, TAG, "isBeyondMaxWidthOrMaxHeight width:" + i3 + " height:" + i16 + " beyond maxLumaWidth or maxLumaHeight, but not limit maxLumaSamples, do support! maxWidth:" + decoderMaxWidth + " maxHeight:" + decoderMaxHeight + " maxLumaSamples:" + i17);
            return false;
        }
        TPNativeLog.printLog(0, TAG, "isBeyondMaxWidthOrMaxHeight width:" + i3 + " height:" + i16 + " do not support! maxWidth:" + decoderMaxWidth + " maxHeight:" + decoderMaxHeight);
        return true;
    }

    @TPMethodCalledByNative
    public static boolean isFeatureSupported(int i3) {
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    private static boolean isWithinMaxAudioDecoderCapability(TPMediaCodecAudioDecoderQueryParams tPMediaCodecAudioDecoderQueryParams) {
        if (tPMediaCodecAudioDecoderQueryParams.getMimeType() != null && tPMediaCodecAudioDecoderQueryParams.getMimeType().equals(TPMimeTypes.AUDIO_AVS_3DA)) {
            return false;
        }
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(getAppContext())) {
            if (tPMediaDecoderInfo.isAudio() && tPMediaCodecAudioDecoderQueryParams.getMimeType().equals(tPMediaDecoderInfo.getDecoderMimeType())) {
                if (Integer.bitCount(tPMediaCodecAudioDecoderQueryParams.getChannelLayout()) * tPMediaCodecAudioDecoderQueryParams.getSampleRate() <= tPMediaDecoderInfo.getMaxAudioSampleRate() * tPMediaDecoderInfo.getMaxAudioChannels()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized void preloadMediaCodecInfo() {
        synchronized (TPMediaCodecDecoderCapability.class) {
            if (sIsInitDone) {
                TPNativeLog.printLog(2, TAG, "decoder capability already init,return directly!");
                return;
            }
            TPNativeLog.printLog(2, TAG, "init MediaCodec decoder capability start");
            TPThreadPool.getInstance().obtainThreadExecutor().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.codec.capability.TPMediaCodecDecoderCapability.1
                @Override // java.lang.Runnable
                public void run() {
                    TPMediaDecoderInfoMgr.initMediaDecoderInfos(TPMediaCodecDecoderCapability.access$000());
                    TPNativeLog.printLog(2, TPMediaCodecDecoderCapability.TAG, "new thread getTPMediaDecoderInfos done");
                }
            });
            sIsInitDone = true;
        }
    }

    private static int getVideoDecoderCapability(String str, int i3) {
        if (str.isEmpty()) {
            return 0;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInWhiteList(str)) {
            return 1;
        }
        if (TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInBlackList(str)) {
            return 0;
        }
        for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderInfoMgr.getTPMediaDecoderInfos(getAppContext())) {
            if (tPMediaDecoderInfo.isVideo() && str.equals(tPMediaDecoderInfo.getDecoderMimeType())) {
                if (i3 == 0) {
                    return 1;
                }
                for (TPMediaDecoderInfo.DecoderProfileLevel decoderProfileLevel : tPMediaDecoderInfo.getProfileLevels()) {
                    if (decoderProfileLevel.profile == i3) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    @TPMethodCalledByNative
    public static int getMaxSupportedInstances() {
        return TPMediaCodecDeviceBlackWhiteList.isCurrentDeviceInMultiInstancesBlackList() ? 1 : Integer.MAX_VALUE;
    }
}
