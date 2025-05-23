package com.tencent.thumbplayer.core.codec.tmediacodec.util;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TUtils {

    @NonNull
    public static final String CSD_0 = "csd-0";

    @NonNull
    public static final String CSD_1 = "csd-1";

    @NonNull
    public static final String CSD_2 = "csd-2";

    @NonNull
    public static final String[] CSD_INDEX_ARRAY = {"csd-0", "csd-1", "csd-2"};

    @NonNull
    public static final String TAG = "TUtils";
    private static final Set<String> sBlackDevices;
    private static boolean sDeviceNeedsSetOutputSurfaceWorkaround;
    private static boolean sEvaluatedDeviceNeedsSetOutputSurfaceWorkaround;

    static {
        HashSet hashSet = new HashSet();
        sBlackDevices = hashSet;
        hashSet.add("1601");
        hashSet.add("1713");
        hashSet.add("1714");
        hashSet.add("A10-70F");
        hashSet.add("A10-70L");
        hashSet.add("A1601");
        hashSet.add("A2016a40");
        hashSet.add("A7000-a");
        hashSet.add("A7000plus");
        hashSet.add("A7010a48");
        hashSet.add("A7020a48");
        hashSet.add("AquaPowerM");
        hashSet.add("ASUS_X00AD_2");
        hashSet.add("Aura_Note_2");
        hashSet.add("BLACK-1X");
        hashSet.add("BRAVIA_ATV2");
        hashSet.add("BRAVIA_ATV3_4K");
        hashSet.add("C1");
        hashSet.add("ComioS1");
        hashSet.add("CP8676_I02");
        hashSet.add("CPH1609");
        hashSet.add("CPY83_I00");
        hashSet.add("cv1");
        hashSet.add("cv3");
        hashSet.add("deb");
        hashSet.add("E5643");
        hashSet.add("ELUGA_A3_Pro");
        hashSet.add("ELUGA_Note");
        hashSet.add("ELUGA_Prim");
        hashSet.add("ELUGA_Ray_X");
        hashSet.add("EverStar_S");
        hashSet.add("F3111");
        hashSet.add("F3113");
        hashSet.add("F3116");
        hashSet.add("F3211");
        hashSet.add("F3213");
        hashSet.add("F3215");
        hashSet.add("F3311");
        hashSet.add("flo");
        hashSet.add("fugu");
        hashSet.add("GiONEE_CBL7513");
        hashSet.add("GiONEE_GBL7319");
        hashSet.add("GIONEE_GBL7360");
        hashSet.add("GIONEE_SWW1609");
        hashSet.add("GIONEE_SWW1627");
        hashSet.add("GIONEE_SWW1631");
        hashSet.add("GIONEE_WBL5708");
        hashSet.add("GIONEE_WBL7365");
        hashSet.add("GIONEE_WBL7519");
        hashSet.add("griffin");
        hashSet.add("htc_e56ml_dtul");
        hashSet.add("hwALE-H");
        hashSet.add("HWBLN-H");
        hashSet.add("HWCAM-H");
        hashSet.add("HWVNS-H");
        hashSet.add("HWWAS-H");
        hashSet.add("i9031");
        hashSet.add("iball8735_9806");
        hashSet.add("Infinix-X572");
        hashSet.add("iris60");
        hashSet.add("itel_S41");
        hashSet.add("j2xlteins");
        hashSet.add("JGZ");
        hashSet.add("K50a40");
        hashSet.add("kate");
        hashSet.add("l5460");
        hashSet.add("le_x6");
        hashSet.add("LS-5017");
        hashSet.add("M5c");
        hashSet.add("manning");
        hashSet.add("marino_f");
        hashSet.add("MEIZU_M5");
        hashSet.add("mh");
        hashSet.add("mido");
        hashSet.add("c");
        hashSet.add("namath");
        hashSet.add("nicklaus_f");
        hashSet.add("NX541J");
        hashSet.add("NX573J");
        hashSet.add("OnePlus5T");
        hashSet.add("p212");
        hashSet.add("P681");
        hashSet.add("P85");
        hashSet.add("panell_d");
        hashSet.add("panell_dl");
        hashSet.add("panell_ds");
        hashSet.add("panell_dt");
        hashSet.add("PB2-670M");
        hashSet.add("PGN528");
        hashSet.add("PGN610");
        hashSet.add("PGN611");
        hashSet.add("Phantom6");
        hashSet.add("Pixi4-7_3G");
        hashSet.add("Pixi5-10_4G");
        hashSet.add("PLE");
        hashSet.add("PRO7S");
        hashSet.add("Q350");
        hashSet.add("Q4260");
        hashSet.add("Q427");
        hashSet.add("Q4310");
        hashSet.add("Q5");
        hashSet.add("QM16XE_U");
        hashSet.add("QX1");
        hashSet.add("santoni");
        hashSet.add("Slate_Pro");
        hashSet.add("SVP-DTV15");
        hashSet.add("s905x018");
        hashSet.add("taido_row");
        hashSet.add("TB3-730F");
        hashSet.add("TB3-730X");
        hashSet.add("TB3-850F");
        hashSet.add("TB3-850M");
        hashSet.add("tcl_eu");
        hashSet.add("V1");
        hashSet.add("V23GB");
        hashSet.add("V5");
        hashSet.add("vernee_M5");
        hashSet.add("watson");
        hashSet.add("whyred");
        hashSet.add("woods_f");
        hashSet.add("woods_fn");
        hashSet.add("X3_HK");
        hashSet.add("XE2X");
        hashSet.add("XT1663");
        hashSet.add("Z12_PRO");
        hashSet.add("Z80");
    }

    public static int ceilDivide(int i3, int i16) {
        return ((i3 + i16) - 1) / i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean codecNeedsSetOutputSurfaceWorkaround() {
        char c16;
        synchronized (TUtils.class) {
            if (!sEvaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                String str = Build.DEVICE;
                if ("dangal".equals(str)) {
                    sDeviceNeedsSetOutputSurfaceWorkaround = true;
                } else {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 <= 27 && "HWEML".equals(str)) {
                        sDeviceNeedsSetOutputSurfaceWorkaround = true;
                    } else if (i3 < 27) {
                        if (sBlackDevices.contains(str)) {
                            sDeviceNeedsSetOutputSurfaceWorkaround = true;
                        }
                        String deviceName = TPSystemInfo.getDeviceName();
                        int hashCode = deviceName.hashCode();
                        if (hashCode != -594534941) {
                            if (hashCode != 2006354) {
                                if (hashCode == 2006367 && deviceName.equals("AFTN")) {
                                    c16 = 1;
                                    if (c16 != 0 || c16 == 1 || c16 == 2) {
                                        sDeviceNeedsSetOutputSurfaceWorkaround = true;
                                    }
                                }
                                c16 = '\uffff';
                                if (c16 != 0) {
                                }
                                sDeviceNeedsSetOutputSurfaceWorkaround = true;
                            } else {
                                if (deviceName.equals("AFTA")) {
                                    c16 = 0;
                                    if (c16 != 0) {
                                    }
                                    sDeviceNeedsSetOutputSurfaceWorkaround = true;
                                }
                                c16 = '\uffff';
                                if (c16 != 0) {
                                }
                                sDeviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                        } else {
                            if (deviceName.equals("JSN-L21")) {
                                c16 = 2;
                                if (c16 != 0) {
                                }
                                sDeviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                            c16 = '\uffff';
                            if (c16 != 0) {
                            }
                            sDeviceNeedsSetOutputSurfaceWorkaround = true;
                        }
                    }
                }
                if (LogUtils.isLogEnable()) {
                    LogUtils.d("TUtils", "deviceNeedsSetOutputSurfaceWorkaround:" + sDeviceNeedsSetOutputSurfaceWorkaround);
                }
                sEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return sDeviceNeedsSetOutputSurfaceWorkaround;
    }

    @NonNull
    public static String getCodeName(@NonNull MediaCodec mediaCodec) {
        return mediaCodec.getName();
    }

    public static int getCodecMaxInputSize(@NonNull String str, int i3, int i16) {
        return getCodecMaxInputSize(str, i3, i16, false);
    }

    @NonNull
    public static ArrayList<byte[]> getCsdBuffers(@NonNull MediaFormat mediaFormat) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i3 = 0;
        while (true) {
            String[] strArr = CSD_INDEX_ARRAY;
            if (i3 < strArr.length) {
                ByteBuffer byteBuffer = mediaFormat.getByteBuffer(strArr[i3]);
                if (byteBuffer != null) {
                    arrayList.add(byteBuffer.array());
                }
                i3++;
            } else {
                return arrayList;
            }
        }
    }

    public static int getMaxInputSize(@NonNull ReuseCodecWrapper reuseCodecWrapper, @NonNull FormatWrapper formatWrapper) {
        if (formatWrapper.maxInputSize != -1) {
            int i3 = 0;
            for (int i16 = 0; i16 < formatWrapper.initializationData.size(); i16++) {
                i3 += formatWrapper.initializationData.get(i16).length;
            }
            return formatWrapper.maxInputSize + i3;
        }
        return getCodecMaxInputSize(formatWrapper.sampleMimeType, formatWrapper.width, formatWrapper.height, reuseCodecWrapper.mSecure);
    }

    @NonNull
    public static String getSurfaceTextureName(@NonNull Surface surface) {
        try {
            Field field = ReflectUtils.getField(Surface.class, "mName");
            field.setAccessible(true);
            return String.valueOf(field.get(surface));
        } catch (Throwable th5) {
            LogUtils.e("TUtils", "getSurfaceTextureName failed", th5);
            return "";
        }
    }

    public static boolean isAdaptive(@NonNull MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (isAdaptiveV19(codecCapabilities)) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean isSecure(@NonNull MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (isSecureV21(codecCapabilities)) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean isVideo(@NonNull String str) {
        return str.contains("video");
    }

    public static void setCsdBuffers(@NonNull MediaFormat mediaFormat, @NonNull List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap((byte[]) list.get(i3)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x005d. Please report as an issue. */
    public static int getCodecMaxInputSize(@NonNull String str, int i3, int i16, boolean z16) {
        char c16;
        int i17;
        if (i3 == -1 || i16 == -1) {
            return -1;
        }
        str.hashCode();
        int i18 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c16 = 5;
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
            case 2:
            case 4:
                i17 = i3 * i16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            case 1:
            case 5:
                i17 = i3 * i16;
                return (i17 * 3) / (i18 * 2);
            case 3:
                if ("BRAVIA 4K 2015".equals(TPSystemInfo.getDeviceName()) || ("Amazon".equals(TPSystemInfo.getDeviceManufacturer()) && ("KFSOWI".equals(TPSystemInfo.getDeviceName()) || ("AFTS".equals(TPSystemInfo.getDeviceName()) && z16)))) {
                    return -1;
                }
                i17 = ceilDivide(i3, 16) * ceilDivide(i16, 16) * 16 * 16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            default:
                return -1;
        }
    }

    public static boolean isVideo(@NonNull MediaFormat mediaFormat) {
        return isVideo(mediaFormat.getString("mime"));
    }
}
