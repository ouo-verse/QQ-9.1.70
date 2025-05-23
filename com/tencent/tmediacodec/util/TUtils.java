package com.tencent.tmediacodec.util;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TUtils {
    static IPatchRedirector $redirector_ = null;

    @NonNull
    public static final String CSD_0 = "csd-0";

    @NonNull
    public static final String CSD_1 = "csd-1";

    @NonNull
    public static final String CSD_2 = "csd-2";

    @NonNull
    public static final String[] CSD_INDEX_ARRAY;

    @NonNull
    public static final String TAG = "TUtils";
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private static Set<String> sBlackDevices;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CSD_INDEX_ARRAY = new String[]{"csd-0", "csd-1", "csd-2"};
        HashSet hashSet = new HashSet();
        sBlackDevices = hashSet;
        hashSet.add("1601");
        sBlackDevices.add("1713");
        sBlackDevices.add("1714");
        sBlackDevices.add("A10-70F");
        sBlackDevices.add("A10-70L");
        sBlackDevices.add("A1601");
        sBlackDevices.add("A2016a40");
        sBlackDevices.add("A7000-a");
        sBlackDevices.add("A7000plus");
        sBlackDevices.add("A7010a48");
        sBlackDevices.add("A7020a48");
        sBlackDevices.add("AquaPowerM");
        sBlackDevices.add("ASUS_X00AD_2");
        sBlackDevices.add("Aura_Note_2");
        sBlackDevices.add("BLACK-1X");
        sBlackDevices.add("BRAVIA_ATV2");
        sBlackDevices.add("BRAVIA_ATV3_4K");
        sBlackDevices.add("C1");
        sBlackDevices.add("ComioS1");
        sBlackDevices.add("CP8676_I02");
        sBlackDevices.add("CPH1609");
        sBlackDevices.add("CPY83_I00");
        sBlackDevices.add("cv1");
        sBlackDevices.add("cv3");
        sBlackDevices.add("deb");
        sBlackDevices.add("E5643");
        sBlackDevices.add("ELUGA_A3_Pro");
        sBlackDevices.add("ELUGA_Note");
        sBlackDevices.add("ELUGA_Prim");
        sBlackDevices.add("ELUGA_Ray_X");
        sBlackDevices.add("EverStar_S");
        sBlackDevices.add("F3111");
        sBlackDevices.add("F3113");
        sBlackDevices.add("F3116");
        sBlackDevices.add("F3211");
        sBlackDevices.add("F3213");
        sBlackDevices.add("F3215");
        sBlackDevices.add("F3311");
        sBlackDevices.add("flo");
        sBlackDevices.add("fugu");
        sBlackDevices.add("GiONEE_CBL7513");
        sBlackDevices.add("GiONEE_GBL7319");
        sBlackDevices.add("GIONEE_GBL7360");
        sBlackDevices.add("GIONEE_SWW1609");
        sBlackDevices.add("GIONEE_SWW1627");
        sBlackDevices.add("GIONEE_SWW1631");
        sBlackDevices.add("GIONEE_WBL5708");
        sBlackDevices.add("GIONEE_WBL7365");
        sBlackDevices.add("GIONEE_WBL7519");
        sBlackDevices.add("griffin");
        sBlackDevices.add("htc_e56ml_dtul");
        sBlackDevices.add("hwALE-H");
        sBlackDevices.add("HWBLN-H");
        sBlackDevices.add("HWCAM-H");
        sBlackDevices.add("HWVNS-H");
        sBlackDevices.add("HWWAS-H");
        sBlackDevices.add("i9031");
        sBlackDevices.add("iball8735_9806");
        sBlackDevices.add("Infinix-X572");
        sBlackDevices.add("iris60");
        sBlackDevices.add("itel_S41");
        sBlackDevices.add("j2xlteins");
        sBlackDevices.add("JGZ");
        sBlackDevices.add("K50a40");
        sBlackDevices.add("kate");
        sBlackDevices.add("l5460");
        sBlackDevices.add("le_x6");
        sBlackDevices.add("LS-5017");
        sBlackDevices.add("M5c");
        sBlackDevices.add("manning");
        sBlackDevices.add("marino_f");
        sBlackDevices.add("MEIZU_M5");
        sBlackDevices.add("mh");
        sBlackDevices.add("mido");
        sBlackDevices.add("c");
        sBlackDevices.add("namath");
        sBlackDevices.add("nicklaus_f");
        sBlackDevices.add("NX541J");
        sBlackDevices.add("NX573J");
        sBlackDevices.add("OnePlus5T");
        sBlackDevices.add("p212");
        sBlackDevices.add("P681");
        sBlackDevices.add("P85");
        sBlackDevices.add("panell_d");
        sBlackDevices.add("panell_dl");
        sBlackDevices.add("panell_ds");
        sBlackDevices.add("panell_dt");
        sBlackDevices.add("PB2-670M");
        sBlackDevices.add("PGN528");
        sBlackDevices.add("PGN610");
        sBlackDevices.add("PGN611");
        sBlackDevices.add("Phantom6");
        sBlackDevices.add("Pixi4-7_3G");
        sBlackDevices.add("Pixi5-10_4G");
        sBlackDevices.add("PLE");
        sBlackDevices.add("PRO7S");
        sBlackDevices.add("Q350");
        sBlackDevices.add("Q4260");
        sBlackDevices.add("Q427");
        sBlackDevices.add("Q4310");
        sBlackDevices.add("Q5");
        sBlackDevices.add("QM16XE_U");
        sBlackDevices.add("QX1");
        sBlackDevices.add("santoni");
        sBlackDevices.add("Slate_Pro");
        sBlackDevices.add("SVP-DTV15");
        sBlackDevices.add("s905x018");
        sBlackDevices.add("taido_row");
        sBlackDevices.add("TB3-730F");
        sBlackDevices.add("TB3-730X");
        sBlackDevices.add("TB3-850F");
        sBlackDevices.add("TB3-850M");
        sBlackDevices.add("tcl_eu");
        sBlackDevices.add("V1");
        sBlackDevices.add("V23GB");
        sBlackDevices.add("V5");
        sBlackDevices.add("vernee_M5");
        sBlackDevices.add("watson");
        sBlackDevices.add("whyred");
        sBlackDevices.add("woods_f");
        sBlackDevices.add("woods_fn");
        sBlackDevices.add("X3_HK");
        sBlackDevices.add("XE2X");
        sBlackDevices.add("XT1663");
        sBlackDevices.add("Z12_PRO");
        sBlackDevices.add("Z80");
    }

    public TUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                String str = Build.DEVICE;
                if ("dangal".equals(str)) {
                    deviceNeedsSetOutputSurfaceWorkaround = true;
                } else {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 <= 27 && "HWEML".equals(str)) {
                        deviceNeedsSetOutputSurfaceWorkaround = true;
                    } else if (i3 < 27) {
                        if (sBlackDevices.contains(str)) {
                            deviceNeedsSetOutputSurfaceWorkaround = true;
                        }
                        String model = DeviceInfoMonitor.getModel();
                        int hashCode = model.hashCode();
                        if (hashCode != -594534941) {
                            if (hashCode != 2006354) {
                                if (hashCode == 2006367 && model.equals("AFTN")) {
                                    c16 = 1;
                                    if (c16 != 0 || c16 == 1 || c16 == 2) {
                                        deviceNeedsSetOutputSurfaceWorkaround = true;
                                    }
                                }
                                c16 = '\uffff';
                                if (c16 != 0) {
                                }
                                deviceNeedsSetOutputSurfaceWorkaround = true;
                            } else {
                                if (model.equals("AFTA")) {
                                    c16 = 0;
                                    if (c16 != 0) {
                                    }
                                    deviceNeedsSetOutputSurfaceWorkaround = true;
                                }
                                c16 = '\uffff';
                                if (c16 != 0) {
                                }
                                deviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                        } else {
                            if (model.equals("JSN-L21")) {
                                c16 = 2;
                                if (c16 != 0) {
                                }
                                deviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                            c16 = '\uffff';
                            if (c16 != 0) {
                            }
                            deviceNeedsSetOutputSurfaceWorkaround = true;
                        }
                    }
                }
                if (LogUtils.isLogEnable()) {
                    LogUtils.d("TUtils", "deviceNeedsSetOutputSurfaceWorkaround:" + deviceNeedsSetOutputSurfaceWorkaround);
                }
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
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
        return getCodecMaxInputSize(formatWrapper.sampleMimeType, formatWrapper.width, formatWrapper.height, reuseCodecWrapper.secure);
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
                if ("BRAVIA 4K 2015".equals(DeviceInfoMonitor.getModel()) || ("Amazon".equals(Build.MANUFACTURER) && ("KFSOWI".equals(DeviceInfoMonitor.getModel()) || ("AFTS".equals(DeviceInfoMonitor.getModel()) && z16)))) {
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
