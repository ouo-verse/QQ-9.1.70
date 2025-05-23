package NS_MOBILE_EXTRA;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tail_opmask implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _ENUM_FOR_ALL = 1;
    public static final int _ENUM_FOR_TIP = 3;
    public static final int _ENUM_FOR_VIP = 2;
    private String __T;
    private int __value;
    private static tail_opmask[] __values = new tail_opmask[3];
    public static final tail_opmask ENUM_FOR_ALL = new tail_opmask(0, 1, "ENUM_FOR_ALL");
    public static final tail_opmask ENUM_FOR_VIP = new tail_opmask(1, 2, "ENUM_FOR_VIP");
    public static final tail_opmask ENUM_FOR_TIP = new tail_opmask(2, 3, "ENUM_FOR_TIP");

    tail_opmask(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static tail_opmask convert(int i3) {
        int i16 = 0;
        while (true) {
            tail_opmask[] tail_opmaskVarArr = __values;
            if (i16 >= tail_opmaskVarArr.length) {
                return null;
            }
            if (tail_opmaskVarArr[i16].value() == i3) {
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

    public static tail_opmask convert(String str) {
        int i3 = 0;
        while (true) {
            tail_opmask[] tail_opmaskVarArr = __values;
            if (i3 >= tail_opmaskVarArr.length) {
                return null;
            }
            if (tail_opmaskVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
