package com.tencent.ad.tangram.system;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdTelephonyManager {
    public static final long NETWORK_CLASS_BITMASK_2G = 32843;
    public static final long NETWORK_CLASS_BITMASK_3G = 93108;
    public static final long NETWORK_CLASS_BITMASK_4G = 397312;
    public static final long NETWORK_CLASS_BITMASK_5G = 524288;
    public static final long NETWORK_STANDARDS_FAMILY_BITMASK_3GPP = 906119;
    public static final long NETWORK_STANDARDS_FAMILY_BITMASK_3GPP2 = 10360;
    public static final long NETWORK_TYPE_BITMASK_1xRTT = 64;
    public static final long NETWORK_TYPE_BITMASK_CDMA = 8;
    public static final long NETWORK_TYPE_BITMASK_EDGE = 2;
    public static final long NETWORK_TYPE_BITMASK_EHRPD = 8192;
    public static final long NETWORK_TYPE_BITMASK_EVDO_0 = 16;
    public static final long NETWORK_TYPE_BITMASK_EVDO_A = 32;
    public static final long NETWORK_TYPE_BITMASK_EVDO_B = 2048;
    public static final long NETWORK_TYPE_BITMASK_GPRS = 1;
    public static final long NETWORK_TYPE_BITMASK_GSM = 32768;
    public static final long NETWORK_TYPE_BITMASK_HSDPA = 128;
    public static final long NETWORK_TYPE_BITMASK_HSPA = 512;
    public static final long NETWORK_TYPE_BITMASK_HSPAP = 16384;
    public static final long NETWORK_TYPE_BITMASK_HSUPA = 256;
    public static final long NETWORK_TYPE_BITMASK_IWLAN = 131072;
    public static final long NETWORK_TYPE_BITMASK_LTE = 4096;
    public static final long NETWORK_TYPE_BITMASK_LTE_CA = 262144;
    public static final long NETWORK_TYPE_BITMASK_NR = 524288;
    public static final long NETWORK_TYPE_BITMASK_TD_SCDMA = 65536;
    public static final long NETWORK_TYPE_BITMASK_UMTS = 4;
    public static final long NETWORK_TYPE_BITMASK_UNKNOWN = 0;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_NR = 20;

    public static long getBitMaskForNetworkType(int i3) {
        switch (i3) {
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 4L;
            case 4:
                return 8L;
            case 5:
                return 16L;
            case 6:
                return 32L;
            case 7:
                return 64L;
            case 8:
                return 128L;
            case 9:
                return 256L;
            case 10:
                return 512L;
            case 11:
            case 18:
            default:
                return 0L;
            case 12:
                return 2048L;
            case 13:
                return 4096L;
            case 14:
                return 8192L;
            case 15:
                return 16384L;
            case 16:
                return 32768L;
            case 17:
                return 65536L;
            case 19:
                return 262144L;
            case 20:
                return 524288L;
        }
    }
}
