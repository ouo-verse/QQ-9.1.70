package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.Utils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CodecHelper {

    @Nullable
    static MediaCodecList CODEC_LIST = new MediaCodecList(0);
    private static final int DEFAULT_HEIGHT = 720;
    private static final int DEFAULT_WIDTH = 1280;
    private static final String TAG = "CodecHelper";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int ceilTo(float f16, float f17) {
        return (int) (Math.floor(f16 / f17) * f17);
    }

    @RequiresApi(api = 21)
    public static boolean checkAudioOutSupported(int i3, int i16, int i17, String str) {
        boolean z16;
        boolean z17;
        List<MediaCodecInfo> encoderCodecInfo = encoderCodecInfo(str);
        if (encoderCodecInfo.size() > 0) {
            Iterator<MediaCodecInfo> it = encoderCodecInfo.iterator();
            while (it.hasNext()) {
                MediaCodecInfo.AudioCapabilities audioCapabilities = it.next().getCapabilitiesForType(str).getAudioCapabilities();
                boolean contains = audioCapabilities.getBitrateRange().contains((Range<Integer>) Integer.valueOf(i3));
                if (audioCapabilities.getMaxInputChannelCount() >= i16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
                int length = supportedSampleRateRanges.length;
                int i18 = 0;
                while (true) {
                    if (i18 < length) {
                        if (supportedSampleRateRanges[i18].contains((Range<Integer>) Integer.valueOf(i17))) {
                            z17 = true;
                            break;
                        }
                        i18++;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (contains && z16 && z17) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 21)
    public static boolean checkVideoOutSupported(int i3, int i16, int i17, int i18, String str) {
        List<MediaCodecInfo> encoderCodecInfo = encoderCodecInfo(str);
        if (encoderCodecInfo.size() > 0) {
            Iterator<MediaCodecInfo> it = encoderCodecInfo.iterator();
            while (it.hasNext()) {
                MediaCodecInfo.VideoCapabilities videoCapabilities = it.next().getCapabilitiesForType(str).getVideoCapabilities();
                boolean contains = videoCapabilities.getBitrateRange().contains((Range<Integer>) Integer.valueOf(i18));
                boolean contains2 = videoCapabilities.getSupportedFrameRates().contains((Range<Integer>) Integer.valueOf(i17));
                boolean isSizeSupported = videoCapabilities.isSizeSupported(i3, i16);
                if (contains && contains2 && isSizeSupported) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int clampHeight(MediaCodecInfo mediaCodecInfo, String str, int i3) {
        if (mediaCodecInfo == null) {
            return i3;
        }
        return mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getSupportedHeights().clamp(Integer.valueOf(i3)).intValue();
    }

    public static int clampWidth(MediaCodecInfo mediaCodecInfo, String str, int i3) {
        if (mediaCodecInfo == null) {
            return i3;
        }
        return mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getSupportedWidths().clamp(Integer.valueOf(i3)).intValue();
    }

    public static double correctSupportFps(CGSize cGSize, float f16, String str, MediaCodec mediaCodec) {
        MediaCodecList mediaCodecList;
        MediaCodecInfo.VideoCapabilities findVideoCapabilitiesByName;
        String codecName = getCodecName(mediaCodec);
        if (codecName == null || (mediaCodecList = CODEC_LIST) == null || (findVideoCapabilitiesByName = findVideoCapabilitiesByName(codecName, str, mediaCodecList)) == null) {
            return -1.0d;
        }
        return new EncodeFormatFixHelper(codecName, findVideoCapabilitiesByName).fixFrameRate(cGSize, f16);
    }

    @NonNull
    public static CGSize correctSupportSize(CGSize cGSize, String str) {
        return correctSupportSize(cGSize, str, true);
    }

    @Nullable
    public static CGSize correctSupportSizeByCodecName(CGSize cGSize, String str, MediaCodec mediaCodec) {
        MediaCodecList mediaCodecList;
        MediaCodecInfo.VideoCapabilities findVideoCapabilitiesByName;
        String codecName = getCodecName(mediaCodec);
        if (codecName == null || (mediaCodecList = CODEC_LIST) == null || (findVideoCapabilitiesByName = findVideoCapabilitiesByName(codecName, str, mediaCodecList)) == null) {
            return null;
        }
        return new EncodeFormatFixHelper(codecName, findVideoCapabilitiesByName).fixSize(cGSize);
    }

    private static List<MediaCodecInfo> decoderCodecInfo(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    if (supportedTypes[i16].equals(str)) {
                        arrayList.add(codecInfoAt);
                        break;
                    }
                    i16++;
                }
            }
        }
        return arrayList;
    }

    private static List<MediaCodecInfo> encoderCodecInfo(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    if (supportedTypes[i16].equals(str)) {
                        arrayList.add(codecInfoAt);
                        break;
                    }
                    i16++;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @RequiresApi(api = 21)
    public static String findDecoderForFormat(MediaFormat mediaFormat) {
        MediaCodecList mediaCodecList = CODEC_LIST;
        if (mediaCodecList == null) {
            return null;
        }
        return mediaCodecList.findDecoderForFormat(mediaFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @RequiresApi(api = 21)
    public static String findEncoderForFormat(MediaFormat mediaFormat) {
        MediaCodecList mediaCodecList = CODEC_LIST;
        if (mediaCodecList == null) {
            return null;
        }
        return mediaCodecList.findEncoderForFormat(mediaFormat);
    }

    @Nullable
    @RequiresApi(api = 21)
    public static MediaCodecInfo findHardwareCodecInfo(MediaFormat mediaFormat) {
        MediaCodecList mediaCodecList = CODEC_LIST;
        if (mediaCodecList == null) {
            return null;
        }
        String findDecoderForFormat = mediaCodecList.findDecoderForFormat(mediaFormat);
        return findHardwareCodecInfo(isHardwareByName(findDecoderForFormat) ? findDecoderForFormat : null, mediaFormat.getString("mime"));
    }

    @RequiresApi(api = 21)
    public static List<MediaCodecInfo.VideoCapabilities> findHardwareVideoCapabilities() {
        return findHardwareVideoCapabilities("video/avc");
    }

    @RequiresApi(api = 21)
    public static MediaCodecInfo.VideoCapabilities findVideoCapabilitiesByName(@NonNull String str, String str2, MediaCodecList mediaCodecList) {
        for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
            if (str.equals(mediaCodecInfo.getName())) {
                return mediaCodecInfo.getCapabilitiesForType(str2).getVideoCapabilities();
            }
        }
        return null;
    }

    public static Integer getBlockHeight(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        return (Integer) Utils.getDeclaredFieldValue(Integer.class, videoCapabilities, "mBlockHeight", 16);
    }

    public static int getBlockWidth(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        return ((Integer) Utils.getDeclaredFieldValue(Integer.class, videoCapabilities, "mBlockWidth", 16)).intValue();
    }

    @RequiresApi(api = 21)
    public static long getCodecMaxDecodeBlockCountPerSecond() throws Throwable {
        Iterator<MediaCodecInfo.VideoCapabilities> it = findHardwareVideoCapabilities().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 = Math.max(j3, getCodecMaxDecodeBlockCountPerSecond(it.next(), 1280.0f, 720.0f));
        }
        return j3;
    }

    @Nullable
    public static String getCodecName(@Nullable MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return null;
        }
        try {
            return mediaCodec.getName();
        } catch (Throwable th5) {
            Logger.e(TAG, "correctSupportSizeByCodecName: ", th5);
            return null;
        }
    }

    private static int getHeightAlignment(MediaCodecInfo mediaCodecInfo, String str) {
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getHeightAlignment();
        }
        return 16;
    }

    public static long getVideoDecodeBlockCountPerSecond(MediaFormat mediaFormat, MediaCodecInfo.VideoCapabilities videoCapabilities) {
        int blockWidth = getBlockWidth(videoCapabilities);
        int intValue = getBlockHeight(videoCapabilities).intValue();
        return (long) ((((mediaFormat.getInteger("frame-rate") * 1.0d) * mediaFormat.getInteger("width")) * mediaFormat.getInteger("height")) / (blockWidth * intValue));
    }

    private static int getWidthAlignment(MediaCodecInfo mediaCodecInfo, String str) {
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getWidthAlignment();
        }
        return 16;
    }

    public static boolean isHardwareByName(String str) {
        if (!str.contains("google") && !str.contains("android")) {
            return true;
        }
        return false;
    }

    private static boolean isSupported(MediaCodecInfo mediaCodecInfo, String str, int i3, int i16) {
        if (mediaCodecInfo != null && mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().isSizeSupported(i3, i16)) {
            return true;
        }
        return false;
    }

    public static boolean isVideoCodec(MediaCodecInfo mediaCodecInfo) {
        for (String str : mediaCodecInfo.getSupportedTypes()) {
            if (str.startsWith("video")) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchCodecInfo(@Nullable String str, MediaCodecInfo mediaCodecInfo, String str2) {
        if (str != null) {
            return str.equals(mediaCodecInfo.getName());
        }
        if (Utils.arrayContains(mediaCodecInfo.getSupportedTypes(), str2) && isHardwareByName(mediaCodecInfo.getName())) {
            return true;
        }
        return false;
    }

    public static float queryMaxHardwareVideoDecodeInstanceCount(String str) throws Throwable {
        return queryMaxHardwareVideoDecodeInstanceCount(ExtractorUtils.getFirstVideoFormat(str));
    }

    public static double queryMaxHardwareVideoEncodeInstanceCount(String str, float f16, float f17, float f18) throws Throwable {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo findHardwareCodecInfo = findHardwareCodecInfo(str);
        if (findHardwareCodecInfo == null || (videoCapabilities = findHardwareCodecInfo.getCapabilitiesForType(str).getVideoCapabilities()) == null) {
            return 0.0d;
        }
        return (getCodecMaxDecodeBlockCountPerSecond(videoCapabilities, 1280.0f, 720.0f) * 1.0d) / ((long) ((((f16 * 1.0d) * f17) * f18) / (getBlockWidth(videoCapabilities) * getBlockHeight(videoCapabilities).intValue())));
    }

    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    public static void selectProfileAndLevel(MediaFormat mediaFormat, String str) {
        int i3;
        int i16;
        MediaCodecInfo selectCodec = selectCodec(str);
        if (selectCodec != null) {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = selectCodec.getCapabilitiesForType(str);
            int i17 = -1;
            if (capabilitiesForType.profileLevels != null) {
                int i18 = 0;
                i3 = -1;
                while (true) {
                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (i18 >= codecProfileLevelArr.length) {
                        break;
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i18];
                    int i19 = codecProfileLevel.profile;
                    if (i19 <= 8) {
                        if (i19 > i17) {
                            i3 = codecProfileLevel.level;
                            i17 = i19;
                        } else if (i19 == i17 && (i16 = codecProfileLevel.level) > i3) {
                            i3 = i16;
                        }
                    }
                    i18++;
                }
            } else {
                i3 = -1;
            }
            if (i17 == 8) {
                mediaFormat.setInteger("profile", i17);
                mediaFormat.setInteger("level", i3);
                Logger.i(TAG, String.format("selectProfileAndLevel: 0x%x, 0x%x", Integer.valueOf(i17), Integer.valueOf(i3)));
            }
        }
    }

    @NonNull
    public static CGSize correctSupportSize(CGSize cGSize, String str, boolean z16) {
        int i3 = (int) cGSize.width;
        int i16 = (int) cGSize.height;
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i17 = 0; i17 < codecCount && mediaCodecInfo == null; i17++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i17);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                boolean z17 = false;
                for (int i18 = 0; i18 < supportedTypes.length && !z17; i18++) {
                    if (supportedTypes[i18].equals(str)) {
                        z17 = true;
                    }
                }
                if (z17) {
                    mediaCodecInfo = codecInfoAt;
                }
            }
        }
        int widthAlignment = getWidthAlignment(mediaCodecInfo, str);
        int heightAlignment = getHeightAlignment(mediaCodecInfo, str);
        float f16 = i3;
        float f17 = widthAlignment;
        int ceilTo = ceilTo(f16 * 1.0f, f17);
        float f18 = i16;
        float f19 = heightAlignment;
        int ceilTo2 = ceilTo(f18 * 1.0f, f19);
        String str2 = TAG;
        Logger.d(str2, "correctSupportSize 1: target = [" + ceilTo + ", " + ceilTo2 + "]");
        int clampWidth = clampWidth(mediaCodecInfo, str, i3);
        if (ceilTo > clampWidth) {
            ceilTo2 = (int) (ceilTo2 * ((clampWidth * 1.0f) / ceilTo));
            ceilTo = clampWidth;
        }
        Logger.d(str2, "correctSupportSize 2: target = [" + ceilTo + ", " + ceilTo2 + "]");
        int clampHeight = clampHeight(mediaCodecInfo, str, i16);
        if (ceilTo2 > clampHeight) {
            ceilTo = (int) (ceilTo * ((clampHeight * 1.0f) / ceilTo2));
            ceilTo2 = clampHeight;
        }
        int ceilTo3 = ceilTo(ceilTo * 1.0f, f17);
        int ceilTo4 = ceilTo(ceilTo2 * 1.0f, f19);
        Logger.d(str2, "correctSupportSize 3: target = [" + ceilTo3 + ", " + ceilTo4 + "]");
        if (!isSupported(mediaCodecInfo, str, ceilTo3, ceilTo4) && z16) {
            int ceilTo5 = ceilTo(f16, 16.0f);
            ceilTo4 = ceilTo(f18, 16.0f);
            ceilTo3 = ceilTo5;
        }
        Logger.i(str2, "correctSupportSize return: target = [" + ceilTo3 + ", " + ceilTo4 + "]");
        return new CGSize(ceilTo3, ceilTo4);
    }

    @RequiresApi(api = 21)
    public static List<MediaCodecInfo.VideoCapabilities> findHardwareVideoCapabilities(String str) {
        if (CODEC_LIST == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : CODEC_LIST.getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder() && isHardwareByName(mediaCodecInfo.getName()) && Utils.arrayContains(mediaCodecInfo.getSupportedTypes(), str)) {
                arrayList.add(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities());
            }
        }
        return arrayList;
    }

    public static float queryMaxHardwareVideoDecodeInstanceCount(MediaFormat mediaFormat) throws Throwable {
        MediaCodecInfo.VideoCapabilities findHardwareVideoCapabilities = findHardwareVideoCapabilities(mediaFormat);
        if (findHardwareVideoCapabilities == null) {
            return 0.0f;
        }
        return (((float) getCodecMaxDecodeBlockCountPerSecond(findHardwareVideoCapabilities, mediaFormat.getInteger("width"), mediaFormat.getInteger("height"))) * 1.0f) / ((float) getVideoDecodeBlockCountPerSecond(mediaFormat, findHardwareVideoCapabilities));
    }

    @RequiresApi(api = 21)
    public static long getCodecMaxDecodeBlockCountPerSecond(MediaCodecInfo.VideoCapabilities videoCapabilities, float f16, float f17) throws Throwable {
        Range<Double> supportedFrameRatesFor = videoCapabilities.getSupportedFrameRatesFor((int) f16, (int) f17);
        if (supportedFrameRatesFor != null) {
            return (long) (((supportedFrameRatesFor.getUpper().doubleValue() * f16) * f17) / (getBlockWidth(videoCapabilities) * getBlockHeight(videoCapabilities).intValue()));
        }
        return getCodecMaxDecodeBlockCountPerSecond(videoCapabilities);
    }

    @Nullable
    @RequiresApi(api = 21)
    public static MediaCodecInfo findHardwareCodecInfo(String str) {
        return findHardwareCodecInfo(null, str);
    }

    @Nullable
    @RequiresApi(api = 21)
    public static MediaCodecInfo findHardwareCodecInfo(String str, String str2) {
        MediaCodecList mediaCodecList = CODEC_LIST;
        if (mediaCodecList == null) {
            return null;
        }
        for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
            if (matchCodecInfo(str, mediaCodecInfo, str2)) {
                return mediaCodecInfo;
            }
        }
        return null;
    }

    @RequiresApi(api = 21)
    public static MediaCodecInfo.VideoCapabilities findHardwareVideoCapabilities(MediaFormat mediaFormat) {
        MediaCodecInfo findHardwareCodecInfo = findHardwareCodecInfo(mediaFormat);
        if (findHardwareCodecInfo == null) {
            return null;
        }
        return findHardwareCodecInfo.getCapabilitiesForType(mediaFormat.getString("mime")).getVideoCapabilities();
    }

    @RequiresApi(api = 21)
    public static long getCodecMaxDecodeBlockCountPerSecond(MediaCodecInfo.VideoCapabilities videoCapabilities) throws NoSuchFieldException, IllegalAccessException {
        Object declaredFieldValue = Utils.getDeclaredFieldValue(videoCapabilities, "mBlocksPerSecondRange");
        if (declaredFieldValue instanceof Range) {
            return ((Long) ((Range) declaredFieldValue).getUpper()).longValue();
        }
        return 0L;
    }
}
