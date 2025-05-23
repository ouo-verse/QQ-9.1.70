package UserGrowth;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eBlockStyle implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eBlockMiddle = 2;
    public static final int _eBlockTop = 1;
    private String __T;
    private int __value;
    private static eBlockStyle[] __values = new eBlockStyle[2];
    public static final eBlockStyle eBlockTop = new eBlockStyle(0, 1, "eBlockTop");
    public static final eBlockStyle eBlockMiddle = new eBlockStyle(1, 2, "eBlockMiddle");

    eBlockStyle(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eBlockStyle convert(int i3) {
        int i16 = 0;
        while (true) {
            eBlockStyle[] eblockstyleArr = __values;
            if (i16 >= eblockstyleArr.length) {
                return null;
            }
            if (eblockstyleArr[i16].value() == i3) {
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

    public static eBlockStyle convert(String str) {
        int i3 = 0;
        while (true) {
            eBlockStyle[] eblockstyleArr = __values;
            if (i3 >= eblockstyleArr.length) {
                return null;
            }
            if (eblockstyleArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
