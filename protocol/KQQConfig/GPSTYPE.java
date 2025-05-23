package protocol.KQQConfig;

import java.io.Serializable;

/* loaded from: classes29.dex */
public final class GPSTYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _GPS_MARS = 1;
    public static final int _GPS_WGS84 = 0;
    public static final int _GPS_WGS_REAL = 2;
    private String __T;
    private int __value;
    private static GPSTYPE[] __values = new GPSTYPE[3];
    public static final GPSTYPE GPS_WGS84 = new GPSTYPE(0, 0, "GPS_WGS84");
    public static final GPSTYPE GPS_MARS = new GPSTYPE(1, 1, "GPS_MARS");
    public static final GPSTYPE GPS_WGS_REAL = new GPSTYPE(2, 2, "GPS_WGS_REAL");

    GPSTYPE(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static GPSTYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            GPSTYPE[] gpstypeArr = __values;
            if (i16 >= gpstypeArr.length) {
                return null;
            }
            if (gpstypeArr[i16].value() == i3) {
                return __values[i16];
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
            GPSTYPE[] gpstypeArr = __values;
            if (i3 >= gpstypeArr.length) {
                return null;
            }
            if (gpstypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
