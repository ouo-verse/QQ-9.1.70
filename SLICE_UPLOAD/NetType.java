package SLICE_UPLOAD;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NetType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _NET_2G = 2;
    public static final int _NET_3G = 3;
    public static final int _NET_4G = 4;
    public static final int _NET_ETHERNET = 5;
    public static final int _NET_UNKOWN = 0;
    public static final int _NET_WIFI = 1;
    private String __T;
    private int __value;
    private static NetType[] __values = new NetType[6];
    public static final NetType NET_UNKOWN = new NetType(0, 0, "NET_UNKOWN");
    public static final NetType NET_WIFI = new NetType(1, 1, "NET_WIFI");
    public static final NetType NET_2G = new NetType(2, 2, "NET_2G");
    public static final NetType NET_3G = new NetType(3, 3, "NET_3G");
    public static final NetType NET_4G = new NetType(4, 4, "NET_4G");
    public static final NetType NET_ETHERNET = new NetType(5, 5, "NET_ETHERNET");

    NetType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static NetType convert(int i3) {
        int i16 = 0;
        while (true) {
            NetType[] netTypeArr = __values;
            if (i16 >= netTypeArr.length) {
                return null;
            }
            if (netTypeArr[i16].value() == i3) {
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

    public static NetType convert(String str) {
        int i3 = 0;
        while (true) {
            NetType[] netTypeArr = __values;
            if (i3 >= netTypeArr.length) {
                return null;
            }
            if (netTypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
