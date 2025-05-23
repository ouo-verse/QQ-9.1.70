package Sound;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Format implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _kAmr = 1;
    public static final int _kMp3 = 2;
    private String __T;
    private int __value;
    private static Format[] __values = new Format[2];
    public static final Format kAmr = new Format(0, 1, "kAmr");
    public static final Format kMp3 = new Format(1, 2, "kMp3");

    Format(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static Format convert(int i3) {
        int i16 = 0;
        while (true) {
            Format[] formatArr = __values;
            if (i16 >= formatArr.length) {
                return null;
            }
            if (formatArr[i16].value() == i3) {
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

    public static Format convert(String str) {
        int i3 = 0;
        while (true) {
            Format[] formatArr = __values;
            if (i3 >= formatArr.length) {
                return null;
            }
            if (formatArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
