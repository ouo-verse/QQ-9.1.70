package KQQ;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class QUERYTYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _CELL_V2 = 2;
    public static final int _GPS_CELL_V1 = 0;
    public static final int _GPS_V2 = 1;
    public static final int _WIFI_V2 = 4;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static QUERYTYPE[] f24907d = new QUERYTYPE[4];
    public static final QUERYTYPE GPS_CELL_V1 = new QUERYTYPE(0, 0, "GPS_CELL_V1");
    public static final QUERYTYPE GPS_V2 = new QUERYTYPE(1, 1, "GPS_V2");
    public static final QUERYTYPE CELL_V2 = new QUERYTYPE(2, 2, "CELL_V2");
    public static final QUERYTYPE WIFI_V2 = new QUERYTYPE(3, 4, "WIFI_V2");

    QUERYTYPE(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f24907d[i3] = this;
    }

    public static QUERYTYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            QUERYTYPE[] querytypeArr = f24907d;
            if (i16 >= querytypeArr.length) {
                return null;
            }
            if (querytypeArr[i16].value() == i3) {
                return f24907d[i16];
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

    public static QUERYTYPE convert(String str) {
        int i3 = 0;
        while (true) {
            QUERYTYPE[] querytypeArr = f24907d;
            if (i3 >= querytypeArr.length) {
                return null;
            }
            if (querytypeArr[i3].toString().equals(str)) {
                return f24907d[i3];
            }
            i3++;
        }
    }
}
