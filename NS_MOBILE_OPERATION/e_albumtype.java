package NS_MOBILE_OPERATION;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e_albumtype implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _ENUM_ALBUM_TYPE_MOBILE = 1;
    public static final int _ENUM_ALBUM_TYPE_SECRET_TIETU = 7;
    public static final int _ENUM_ALBUM_TYPE_TIETU = 2;
    private String __T;
    private int __value;
    private static e_albumtype[] __values = new e_albumtype[3];
    public static final e_albumtype ENUM_ALBUM_TYPE_MOBILE = new e_albumtype(0, 1, "ENUM_ALBUM_TYPE_MOBILE");
    public static final e_albumtype ENUM_ALBUM_TYPE_TIETU = new e_albumtype(1, 2, "ENUM_ALBUM_TYPE_TIETU");
    public static final e_albumtype ENUM_ALBUM_TYPE_SECRET_TIETU = new e_albumtype(2, 7, "ENUM_ALBUM_TYPE_SECRET_TIETU");

    e_albumtype(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static e_albumtype convert(int i3) {
        int i16 = 0;
        while (true) {
            e_albumtype[] e_albumtypeVarArr = __values;
            if (i16 >= e_albumtypeVarArr.length) {
                return null;
            }
            if (e_albumtypeVarArr[i16].value() == i3) {
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

    public static e_albumtype convert(String str) {
        int i3 = 0;
        while (true) {
            e_albumtype[] e_albumtypeVarArr = __values;
            if (i3 >= e_albumtypeVarArr.length) {
                return null;
            }
            if (e_albumtypeVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
