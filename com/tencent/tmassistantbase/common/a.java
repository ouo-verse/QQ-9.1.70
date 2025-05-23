package com.tencent.tmassistantbase.common;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum a {
    UN_DETECT,
    WIFI,
    CMWAP,
    CMNET,
    UNIWAP,
    UNINET,
    WAP3G,
    NET3G,
    CTWAP,
    CTNET,
    UNKNOWN,
    UNKNOW_WAP,
    NO_NETWORK,
    WAP4G,
    NET4G;

    /* compiled from: P */
    /* renamed from: com.tencent.tmassistantbase.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    static /* synthetic */ class C9993a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f380421a;

        static {
            int[] iArr = new int[a.values().length];
            f380421a = iArr;
            try {
                iArr[a.UN_DETECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f380421a[a.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f380421a[a.CMWAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f380421a[a.CMNET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f380421a[a.UNIWAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f380421a[a.UNINET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f380421a[a.WAP3G.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f380421a[a.NET3G.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f380421a[a.CTWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f380421a[a.CTNET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f380421a[a.UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f380421a[a.UNKNOW_WAP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f380421a[a.NO_NETWORK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f380421a[a.WAP4G.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f380421a[a.NET4G.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public byte a() {
        switch (C9993a.f380421a[ordinal()]) {
            case 1:
                return (byte) 0;
            case 2:
                return (byte) 1;
            case 3:
                return (byte) 2;
            case 4:
                return (byte) 3;
            case 5:
                return (byte) 4;
            case 6:
                return (byte) 5;
            case 7:
                return (byte) 6;
            case 8:
                return (byte) 7;
            case 9:
                return (byte) 8;
            case 10:
                return (byte) 9;
            case 11:
            default:
                return (byte) 10;
            case 12:
                return (byte) 11;
            case 13:
                return (byte) 12;
            case 14:
                return (byte) 13;
            case 15:
                return RegisterType.DOUBLE_LO;
        }
    }
}
