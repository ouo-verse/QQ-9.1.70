package SLICE_UPLOAD;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CheckType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _TYPE_MD5 = 0;
    public static final int _TYPE_NONE = 2;
    public static final int _TYPE_SHA1 = 1;
    private String __T;
    private int __value;
    private static CheckType[] __values = new CheckType[3];
    public static final CheckType TYPE_MD5 = new CheckType(0, 0, "TYPE_MD5");
    public static final CheckType TYPE_SHA1 = new CheckType(1, 1, "TYPE_SHA1");
    public static final CheckType TYPE_NONE = new CheckType(2, 2, "TYPE_NONE");

    CheckType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static CheckType convert(int i3) {
        int i16 = 0;
        while (true) {
            CheckType[] checkTypeArr = __values;
            if (i16 >= checkTypeArr.length) {
                return null;
            }
            if (checkTypeArr[i16].value() == i3) {
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

    public static CheckType convert(String str) {
        int i3 = 0;
        while (true) {
            CheckType[] checkTypeArr = __values;
            if (i3 >= checkTypeArr.length) {
                return null;
            }
            if (checkTypeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
