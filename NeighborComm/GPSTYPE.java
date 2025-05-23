package NeighborComm;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class GPSTYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _GPS_MARS = 1;
    public static final int _GPS_MARS_VIRTUAL = 4;
    public static final int _GPS_WGS84 = 0;
    public static final int _GPS_WGS84_VIRTUAL = 3;
    public static final int _GPS_WGS_REAL = 2;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static GPSTYPE[] f25075d = new GPSTYPE[5];
    public static final GPSTYPE GPS_WGS84 = new GPSTYPE(0, 0, "GPS_WGS84");
    public static final GPSTYPE GPS_MARS = new GPSTYPE(1, 1, "GPS_MARS");
    public static final GPSTYPE GPS_WGS_REAL = new GPSTYPE(2, 2, "GPS_WGS_REAL");
    public static final GPSTYPE GPS_WGS84_VIRTUAL = new GPSTYPE(3, 3, "GPS_WGS84_VIRTUAL");
    public static final GPSTYPE GPS_MARS_VIRTUAL = new GPSTYPE(4, 4, "GPS_MARS_VIRTUAL");

    GPSTYPE(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25075d[i3] = this;
    }

    public static GPSTYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            GPSTYPE[] gpstypeArr = f25075d;
            if (i16 >= gpstypeArr.length) {
                return null;
            }
            if (gpstypeArr[i16].value() == i3) {
                return f25075d[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static GPSTYPE convert(String str) {
        int i3 = 0;
        while (true) {
            GPSTYPE[] gpstypeArr = f25075d;
            if (i3 >= gpstypeArr.length) {
                return null;
            }
            if (gpstypeArr[i3].toString().equals(str)) {
                return f25075d[i3];
            }
            i3++;
        }
    }
}
