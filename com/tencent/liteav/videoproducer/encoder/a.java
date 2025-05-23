package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Pair;
import android.util.Range;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f119685a = true;

    /* renamed from: b, reason: collision with root package name */
    boolean f119686b = true;

    /* renamed from: c, reason: collision with root package name */
    private final MediaCodec f119687c;

    /* renamed from: d, reason: collision with root package name */
    private final String f119688d;

    /* renamed from: e, reason: collision with root package name */
    private final VideoEncodeParams f119689e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f119690f;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoproducer.encoder.a$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119691a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f119692b;

        static {
            int[] iArr = new int[VideoEncoderDef.EncoderProfile.values().length];
            f119692b = iArr;
            try {
                iArr[VideoEncoderDef.EncoderProfile.PROFILE_MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119692b[VideoEncoderDef.EncoderProfile.PROFILE_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119692b[VideoEncoderDef.EncoderProfile.PROFILE_BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VideoEncoderDef.BitrateMode.values().length];
            f119691a = iArr2;
            try {
                iArr2[VideoEncoderDef.BitrateMode.CBR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119691a[VideoEncoderDef.BitrateMode.VBR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f119691a[VideoEncoderDef.BitrateMode.CQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams, Boolean bool) {
        this.f119687c = mediaCodec;
        this.f119688d = str;
        this.f119689e = videoEncodeParams;
        this.f119690f = bool;
    }

    private boolean a(int i3, MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        Boolean bool;
        if (i3 == 2 && (bool = this.f119690f) != null) {
            return bool.booleanValue();
        }
        return encoderCapabilities.isBitrateModeSupported(i3);
    }

    private MediaCodecInfo.VideoCapabilities b() {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (this.f119687c == null || LiteavSystemInfo.getSystemOSVersionInt() < 21 || (capabilitiesForType = this.f119687c.getCodecInfo().getCapabilitiesForType(this.f119688d)) == null) {
            return null;
        }
        return capabilitiesForType.getVideoCapabilities();
    }

    private static Pair<Integer, Integer> a(MediaFormat mediaFormat) {
        int i3;
        int i16 = 0;
        try {
            i3 = mediaFormat.getInteger("profile");
        } catch (Throwable th5) {
            LiteavLog.i("MediaFormatBuilder", "get profile fail.", th5);
            i3 = 0;
        }
        try {
            i16 = mediaFormat.getInteger("level");
        } catch (Throwable th6) {
            LiteavLog.i("MediaFormatBuilder", "get level fail.", th6);
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    private void b(MediaFormat mediaFormat) {
        if (this.f119689e.mediaCodecDeviceRelatedParams == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f119689e.mediaCodecDeviceRelatedParams.length(); i3++) {
            try {
                JSONObject jSONObject = this.f119689e.mediaCodecDeviceRelatedParams.getJSONObject(i3);
                LiteavLog.i("MediaFormatBuilder", "setDeviceRelatedParams,index=%d,key=%s,value=%d", Integer.valueOf(i3), jSONObject.optString("key"), Integer.valueOf(jSONObject.optInt("value")));
                mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
            } catch (Throwable th5) {
                LiteavLog.e("MediaFormatBuilder", "set mediaCodec device related params failed,index=".concat(String.valueOf(i3)), th5);
            }
        }
    }

    private MediaCodecInfo.VideoCapabilities a(int i3, int i16) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.f119688d, i3, i16)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MediaFormat a() {
        MediaFormat mediaFormat;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        Range<Integer> range;
        Range<Integer> range2;
        Range<Integer> range3;
        Range<Integer> range4;
        int i3;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i16;
        int i17;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        int i18;
        int i19;
        int i26;
        int i27;
        Range<Integer> complexityRange;
        int i28;
        a aVar = this;
        VideoEncodeParams videoEncodeParams = aVar.f119689e;
        int i29 = videoEncodeParams.width;
        if (i29 == 0 || (i28 = videoEncodeParams.height) == 0 || videoEncodeParams.bitrate == 0 || videoEncodeParams.fps == 0 || (mediaFormat = MediaFormat.createVideoFormat(aVar.f119688d, i29, i28)) == null) {
            mediaFormat = null;
        } else {
            mediaFormat.setInteger("bitrate", aVar.f119689e.bitrate * 1024);
            mediaFormat.setInteger("frame-rate", aVar.f119689e.fps);
            mediaFormat.setInteger("color-format", 2130708361);
            VideoEncodeParams videoEncodeParams2 = aVar.f119689e;
            mediaFormat.setInteger("i-frame-interval", videoEncodeParams2.fullIFrame ? 0 : videoEncodeParams2.gop);
        }
        if (mediaFormat == null) {
            return null;
        }
        int codecCount = MediaCodecList.getCodecCount();
        int i36 = 0;
        loop0: while (true) {
            if (i36 >= codecCount) {
                codecCapabilities = null;
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i36);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase(aVar.f119688d)) {
                        codecCapabilities = codecInfoAt.getCapabilitiesForType(aVar.f119688d);
                        break loop0;
                    }
                }
            }
            i36++;
        }
        if (codecCapabilities != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            MediaCodecInfo.EncoderCapabilities encoderCapabilities2 = codecCapabilities.getEncoderCapabilities();
            if (encoderCapabilities2 != null && (complexityRange = encoderCapabilities2.getComplexityRange()) != null) {
                mediaFormat.setInteger("complexity", complexityRange.getUpper().intValue());
            }
            if (aVar.f119686b) {
                VideoEncodeParams videoEncodeParams3 = aVar.f119689e;
                VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams3.encoderProfile;
                if ((!(videoEncodeParams3.codecType == CodecType.H265) || LiteavSystemInfo.getSystemOSVersionInt() < 21) && encoderProfile != null) {
                    int i37 = AnonymousClass1.f119692b[encoderProfile.ordinal()];
                    if (i37 == 1) {
                        i18 = 2;
                    } else if (i37 == 2) {
                        i18 = 8;
                    }
                    if (aVar.f119688d.equals("video/avc")) {
                        i19 = Integer.MIN_VALUE;
                        i26 = Integer.MAX_VALUE;
                    } else {
                        i19 = 256;
                        i26 = 32768;
                    }
                    int i38 = 0;
                    int i39 = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecCapabilities.profileLevels) {
                        int i46 = codecProfileLevel.level;
                        if (i46 >= i19 && (i27 = codecProfileLevel.profile) <= i18 && (i27 > i38 || (i27 == i38 && i46 > i39))) {
                            i39 = Math.min(i46, i26);
                            i38 = i27;
                        }
                    }
                    mediaFormat.setInteger("profile", i38);
                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
                        mediaFormat.setInteger("level", i39);
                    }
                }
                i18 = 1;
                if (aVar.f119688d.equals("video/avc")) {
                }
                int i382 = 0;
                int i392 = 0;
                while (r9 < r4) {
                }
                mediaFormat.setInteger("profile", i382);
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
                }
            }
            if (aVar.f119685a) {
                VideoEncoderDef.BitrateMode bitrateMode = aVar.f119689e.bitrateMode;
                if (bitrateMode != null && (i16 = AnonymousClass1.f119691a[bitrateMode.ordinal()]) != 1) {
                    if (i16 == 2) {
                        i17 = 1;
                    } else if (i16 == 3) {
                        i17 = 0;
                    }
                    encoderCapabilities = codecCapabilities.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (aVar.a(i17, encoderCapabilities)) {
                            mediaFormat.setInteger("bitrate-mode", i17);
                        } else if (aVar.f119689e.fullIFrame) {
                            if (aVar.a(1, encoderCapabilities)) {
                                mediaFormat.setInteger("bitrate-mode", 1);
                            } else if (aVar.a(2, encoderCapabilities)) {
                                mediaFormat.setInteger("bitrate-mode", 2);
                            }
                        } else if (aVar.a(2, encoderCapabilities)) {
                            mediaFormat.setInteger("bitrate-mode", 2);
                        }
                    }
                }
                i17 = 2;
                encoderCapabilities = codecCapabilities.getEncoderCapabilities();
                if (encoderCapabilities != null) {
                }
            }
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            createFromProfileLevel = null;
        } else {
            Pair<Integer, Integer> a16 = a(mediaFormat);
            createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(aVar.f119688d, ((Integer) a16.first).intValue(), ((Integer) a16.second).intValue());
        }
        if (createFromProfileLevel != null) {
            codecCapabilities = createFromProfileLevel;
        }
        VideoEncodeParams videoEncodeParams4 = aVar.f119689e;
        GLConstants.ColorRange colorRange = videoEncodeParams4.colorRange;
        GLConstants.ColorSpace colorSpace = videoEncodeParams4.colorSpace;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24) {
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                mediaFormat.setInteger("color-range", 1);
            } else if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                mediaFormat.setInteger("color-range", 2);
            }
            if (colorSpace == GLConstants.ColorSpace.BT709) {
                mediaFormat.setInteger("color-standard", 1);
            } else if (colorSpace == GLConstants.ColorSpace.BT601) {
                mediaFormat.setInteger("color-standard", 4);
            }
        }
        if (codecCapabilities != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
            int integer = mediaFormat.getInteger("bitrate");
            int intValue = bitrateRange.clamp(Integer.valueOf(integer)).intValue();
            LiteavLog.i("MediaFormatBuilder", "bitrateRange=(%d, %d),bitrate=%d,clampBitrate=%d", bitrateRange.getLower(), bitrateRange.getUpper(), Integer.valueOf(integer), Integer.valueOf(intValue));
            if (integer != intValue) {
                mediaFormat.setInteger("bitrate", intValue);
            }
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            Pair<Integer, Integer> a17 = a(mediaFormat);
            int intValue2 = ((Integer) a17.first).intValue();
            int intValue3 = ((Integer) a17.second).intValue();
            MediaCodecInfo.VideoCapabilities a18 = aVar.a(intValue2, intValue3);
            if (a18 != null) {
                range2 = a18.getSupportedWidths();
                range = a18.getSupportedHeights();
            } else {
                range = null;
                range2 = null;
            }
            MediaCodecInfo.VideoCapabilities b16 = b();
            if (b16 != null) {
                range4 = b16.getSupportedWidths();
                range3 = b16.getSupportedHeights();
            } else {
                range3 = null;
                range4 = null;
            }
            Integer num = Integer.MAX_VALUE;
            Integer num2 = Integer.MAX_VALUE;
            if (range2 != null && range != null) {
                num = range2.getUpper();
                num2 = range.getUpper();
            }
            if (range4 != null && range3 != null) {
                num = Integer.valueOf(Math.min(num.intValue(), range4.getUpper().intValue()));
                num2 = Integer.valueOf(Math.min(num2.intValue(), range3.getUpper().intValue()));
            }
            if (num.intValue() != Integer.MAX_VALUE && num2.intValue() != Integer.MAX_VALUE) {
                int integer2 = mediaFormat.getInteger("width");
                int integer3 = mediaFormat.getInteger("height");
                if ((integer2 > integer3 && num.intValue() < num2.intValue()) || (integer2 < integer3 && num.intValue() > num2.intValue())) {
                    Integer valueOf = Integer.valueOf(num.intValue());
                    num = num2;
                    num2 = valueOf;
                }
                if (num.intValue() < integer2 || num2.intValue() < integer3) {
                    float intValue4 = num.intValue();
                    float f16 = integer2;
                    i3 = intValue3;
                    float f17 = integer3;
                    float min = Math.min(intValue4 / (f16 * 1.0f), num2.intValue() / (f17 * 1.0f));
                    mediaFormat.setInteger("width", (int) (f16 * min));
                    mediaFormat.setInteger("height", (int) (f17 * min));
                    LiteavLog.i("MediaFormatBuilder", "updateMediaFormatToUpperSize:srcWidth=" + integer2 + ", srcHeight=" + integer3 + ", scale: " + min + ", supportedWidthsByProfile= " + range2 + ", supportedHeightsByProfile=" + range + ", supportedWidthsByType=" + range4 + ", supportedHeightsByType=" + range3);
                } else {
                    i3 = intValue3;
                }
            } else {
                i3 = intValue3;
                LiteavLog.w("MediaFormatBuilder", "get supported size failed");
            }
            aVar = this;
            int i47 = i3;
            MediaCodecInfo.VideoCapabilities a19 = aVar.a(intValue2, i47);
            if (a19 != null) {
                Range<Integer> supportedWidths = a19.getSupportedWidths();
                Range<Integer> supportedHeights = a19.getSupportedHeights();
                if (supportedWidths != null && supportedHeights != null) {
                    Integer lower = supportedWidths.getLower();
                    Integer lower2 = supportedHeights.getLower();
                    MediaCodecInfo.VideoCapabilities b17 = b();
                    if (b17 != null) {
                        Range<Integer> supportedWidths2 = b17.getSupportedWidths();
                        Range<Integer> supportedHeights2 = b17.getSupportedHeights();
                        if (supportedWidths2 != null && supportedHeights2 != null) {
                            lower = Integer.valueOf(Math.max(lower.intValue(), supportedWidths2.getLower().intValue()));
                            lower2 = Integer.valueOf(Math.max(lower2.intValue(), supportedHeights2.getLower().intValue()));
                        }
                    }
                    if (lower.intValue() >= 0 && lower2.intValue() >= 0) {
                        int integer4 = mediaFormat.getInteger("width");
                        int integer5 = mediaFormat.getInteger("height");
                        if (lower.intValue() > integer4 || lower2.intValue() > integer5) {
                            float f18 = integer4;
                            float f19 = integer5;
                            float max = Math.max(lower.intValue() / (f18 * 1.0f), lower2.intValue() / (f19 * 1.0f));
                            mediaFormat.setInteger("width", (int) (f18 * max));
                            mediaFormat.setInteger("height", (int) (max * f19));
                            LiteavLog.i("MediaFormatBuilder", "updateMediaFormatToLowerSize:lowerW=%d,lowerH=%d", lower, lower2);
                        }
                    }
                }
            }
            MediaCodecInfo.VideoCapabilities a26 = aVar.a(intValue2, i47);
            if (a26 != null) {
                int widthAlignment = a26.getWidthAlignment();
                int heightAlignment = a26.getHeightAlignment();
                LiteavLog.i("MediaFormatBuilder", "widthAlignment=%d,heightAlignment=%d", Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
                if (widthAlignment >= 2 && heightAlignment >= 2 && widthAlignment % 2 == 0 && heightAlignment % 2 == 0) {
                    int integer6 = mediaFormat.getInteger("width");
                    int integer7 = mediaFormat.getInteger("height");
                    int i48 = (integer6 / widthAlignment) * widthAlignment;
                    int i49 = (integer7 / heightAlignment) * heightAlignment;
                    if (integer6 != i48 || integer7 != i49) {
                        mediaFormat.setInteger("width", i48);
                        mediaFormat.setInteger("height", i49);
                        LiteavLog.i("MediaFormatBuilder", "updateMediaFormatWithAlignment,srcSize=(%d x %d),fixSize=(%d x %d),widthAlignment=%d,heightAlignment=%d", Integer.valueOf(integer6), Integer.valueOf(integer7), Integer.valueOf(i48), Integer.valueOf(i49), Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
                    }
                }
            }
        }
        aVar.b(mediaFormat);
        return mediaFormat;
    }
}
