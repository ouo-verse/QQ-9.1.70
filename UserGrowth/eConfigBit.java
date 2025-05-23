package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eConfigBit implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eGetAuth = 4;
    public static final int _eGetCallInBg = 8;
    public static final int _eSetAuth = 2;
    public static final int _eShowConfirmWindow = 1;
    private String __T;
    private int __value;
    private static eConfigBit[] __values = new eConfigBit[4];
    public static final eConfigBit eShowConfirmWindow = new eConfigBit(0, 1, "eShowConfirmWindow");
    public static final eConfigBit eSetAuth = new eConfigBit(1, 2, "eSetAuth");
    public static final eConfigBit eGetAuth = new eConfigBit(2, 4, "eGetAuth");
    public static final eConfigBit eGetCallInBg = new eConfigBit(3, 8, "eGetCallInBg");

    eConfigBit(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eConfigBit convert(int i3) {
        int i16 = 0;
        while (true) {
            eConfigBit[] econfigbitArr = __values;
            if (i16 >= econfigbitArr.length) {
                return null;
            }
            if (econfigbitArr[i16].value() == i3) {
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

    public static eConfigBit convert(String str) {
        int i3 = 0;
        while (true) {
            eConfigBit[] econfigbitArr = __values;
            if (i3 >= econfigbitArr.length) {
                return null;
            }
            if (econfigbitArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
