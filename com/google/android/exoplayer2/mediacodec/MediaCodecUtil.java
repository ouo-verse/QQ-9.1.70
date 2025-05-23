package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes2.dex */
public final class MediaCodecUtil {
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final String MTK_RAW_DECODER_NAME = "OMX.MTK.AUDIO.DECODER.RAW";
    private static final String TAG = "MediaCodecUtil";
    private static final String GOOGLE_RAW_DECODER_NAME = "OMX.google.raw.decoder";
    private static final MediaCodecInfo PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance(GOOGLE_RAW_DECODER_NAME);
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CodecKey {
        public final String mimeType;
        public final boolean secure;

        public CodecKey(String str, boolean z16) {
            this.mimeType = str;
            this.secure = z16;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3;
            String str = this.mimeType;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode + 31) * 31;
            if (this.secure) {
                i3 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
            } else {
                i3 = 1237;
            }
            return i16 + i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DecoderQueryException extends Exception {
        DecoderQueryException(Throwable th5) {
            super("Failed to query underlying media codecs", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i3);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        MediaCodecListCompatV16() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i3) {
            return MediaCodecList.getCodecInfoAt(i3);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes2.dex */
    public static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z16) {
            this.codecKind = z16 ? 1 : 0;
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i3) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i3];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    MediaCodecUtil() {
    }

    private static void applySoftDecoderSelection(List<MediaCodecInfo> list) {
        for (int i3 = 1; i3 < list.size(); i3++) {
            if (!isSoftwareCodec(list.get(i3).name)) {
                list.remove(i3);
            }
        }
    }

    private static void applyWorkarounds(List<MediaCodecInfo> list) {
        if (Util.SDK_INT < 26) {
            if (list.size() > 1 && MTK_RAW_DECODER_NAME.equals(list.get(0).name)) {
                for (int i3 = 1; i3 < list.size(); i3++) {
                    MediaCodecInfo mediaCodecInfo = list.get(i3);
                    if (GOOGLE_RAW_DECODER_NAME.equals(mediaCodecInfo.name)) {
                        list.remove(i3);
                        list.add(0, mediaCodecInfo);
                        return;
                    }
                }
            }
        }
    }

    private static int avcLevelToMaxFrameSize(int i3) {
        if (i3 == 1 || i3 == 2) {
            return 25344;
        }
        switch (i3) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        if (Util.SDK_INT <= 22) {
            String str2 = Util.MODEL;
            if ((str2.equals("ODROID-XU3") || str2.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf2;
            } else {
                Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(AVC_PROFILE_NUMBER_TO_CONST.get(num.intValue()));
            if (valueOf3 == null) {
                Log.w(TAG, "Unknown AVC profile: " + num);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(AVC_LEVEL_NUMBER_TO_CONST.get(valueOf.intValue()));
            if (valueOf4 == null) {
                Log.w(TAG, "Unknown AVC level: " + valueOf);
                return null;
            }
            return new Pair<>(valueOf3, valueOf4);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (r3.equals(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CODEC_ID_AVC1) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> getCodecProfileAndLevel(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        char c16 = 0;
        String str2 = split[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3006243:
                break;
            case 3006244:
                if (str2.equals(CODEC_ID_AVC2)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3199032:
                if (str2.equals(CODEC_ID_HEV1)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3214780:
                if (str2.equals(CODEC_ID_HVC1)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return getAvcProfileAndLevel(str, split);
            case 2:
            case 3:
                return getHevcProfileAndLevel(str, split);
            default:
                return null;
        }
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z16, boolean z17) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z16, z17);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z16, boolean z17) throws DecoderQueryException {
        MediaCodecListCompat mediaCodecListCompatV16;
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z16);
            HashMap<CodecKey, List<MediaCodecInfo>> hashMap = decoderInfosCache;
            List<MediaCodecInfo> list = hashMap.get(codecKey);
            if (list != null) {
                return list;
            }
            int i3 = Util.SDK_INT;
            if (i3 >= 21) {
                mediaCodecListCompatV16 = new MediaCodecListCompatV21(z16);
            } else {
                mediaCodecListCompatV16 = new MediaCodecListCompatV16();
            }
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV16, str);
            if (z16 && decoderInfosInternal.isEmpty() && 21 <= i3 && i3 <= 23) {
                mediaCodecListCompatV16 = new MediaCodecListCompatV16();
                decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV16, str);
                if (!decoderInfosInternal.isEmpty()) {
                    Log.w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            if ("audio/eac3-joc".equals(str)) {
                decoderInfosInternal.addAll(getDecoderInfosInternal(new CodecKey("audio/eac3", codecKey.secure), mediaCodecListCompatV16, str));
            }
            applyWorkarounds(decoderInfosInternal);
            if (z17) {
                applySoftDecoderSelection(decoderInfosInternal);
            }
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
            hashMap.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat, String str) throws DecoderQueryException {
        int i3;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
            String str2 = codecKey.mimeType;
            int codecCount = mediaCodecListCompat.getCodecCount();
            boolean secureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
            int i16 = 0;
            while (i16 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i16);
                String name = codecInfoAt.getName();
                if (isCodecUsableDecoder(codecInfoAt, name, secureDecodersExplicit, str)) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i17 = 0;
                    while (i17 < length) {
                        String str3 = supportedTypes[i17];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str3);
                                boolean isSecurePlaybackSupported = mediaCodecListCompat2.isSecurePlaybackSupported(str2, capabilitiesForType);
                                boolean codecNeedsDisableAdaptationWorkaround = codecNeedsDisableAdaptationWorkaround(name);
                                if (secureDecodersExplicit) {
                                    i3 = codecCount;
                                    try {
                                        if (codecKey.secure != isSecurePlaybackSupported) {
                                        }
                                        arrayList.add(MediaCodecInfo.newInstance(name, str2, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, false));
                                    } catch (Exception e16) {
                                        e = e16;
                                        if (Util.SDK_INT <= 23 && !arrayList.isEmpty()) {
                                            Log.e(TAG, "Skipping codec " + name + " (failed to query capabilities)");
                                            i17++;
                                            mediaCodecListCompat2 = mediaCodecListCompat;
                                            codecCount = i3;
                                        } else {
                                            Log.e(TAG, "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e;
                                        }
                                    }
                                } else {
                                    i3 = codecCount;
                                }
                                if (!secureDecodersExplicit && !codecKey.secure) {
                                    arrayList.add(MediaCodecInfo.newInstance(name, str2, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, false));
                                } else if (!secureDecodersExplicit && isSecurePlaybackSupported) {
                                    arrayList.add(MediaCodecInfo.newInstance(name + ".secure", str2, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, true));
                                    return arrayList;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                i3 = codecCount;
                            }
                        } else {
                            i3 = codecCount;
                        }
                        i17++;
                        mediaCodecListCompat2 = mediaCodecListCompat;
                        codecCount = i3;
                    }
                }
                i16++;
                mediaCodecListCompat2 = mediaCodecListCompat;
                codecCount = codecCount;
            }
            return arrayList;
        } catch (Exception e18) {
            throw new DecoderQueryException(e18);
        }
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        int i3;
        if (strArr.length < 4) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i3 = 1;
        } else if ("2".equals(group)) {
            i3 = 2;
        } else {
            Log.w(TAG, "Unknown HEVC profile string: " + group);
            return null;
        }
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
        if (num == null) {
            Log.w(TAG, "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        return new Pair<>(Integer.valueOf(i3), num);
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() {
        return PASSTHROUGH_DECODER_INFO;
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z16, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z16 && str.endsWith(".secure"))) {
            return false;
        }
        int i3 = Util.SDK_INT;
        if (i3 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i3 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i3 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i3 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && Util.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || str6.equals("SC-05G") || str6.equals("marinelteatt") || str6.equals("404SC") || str6.equals("SC-04G") || str6.equals("SCV31")) {
                return false;
            }
        }
        if (i3 <= 19 && "OMX.SEC.vp8.dec".equals(str) && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i3 <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean isSoftwareCodec(String str) {
        if (!str.toLowerCase().startsWith("omx.google.") && str.toLowerCase().startsWith("omx.")) {
            return false;
        }
        return true;
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        int i3;
        if (maxH264DecodableFrameSize == -1) {
            int i16 = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i17 = 0;
                while (i16 < length) {
                    i17 = Math.max(avcLevelToMaxFrameSize(profileLevels[i16].level), i17);
                    i16++;
                }
                if (Util.SDK_INT >= 21) {
                    i3 = 345600;
                } else {
                    i3 = 172800;
                }
                i16 = Math.max(i17, i3);
            }
            maxH264DecodableFrameSize = i16;
        }
        return maxH264DecodableFrameSize;
    }

    public static void warmDecoderInfoCache(String str, boolean z16) {
        try {
            getDecoderInfos(str, z16, false);
        } catch (DecoderQueryException e16) {
            Log.e(TAG, "Codec warming failed", e16);
        }
    }
}
