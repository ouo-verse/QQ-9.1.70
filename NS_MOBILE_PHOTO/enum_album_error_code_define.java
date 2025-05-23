package NS_MOBILE_PHOTO;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class enum_album_error_code_define implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static enum_album_error_code_define[] __values = new enum_album_error_code_define[1];
    public static final int _enum_album_not_exist = -11529;
    public static final enum_album_error_code_define enum_album_not_exist = new enum_album_error_code_define(0, _enum_album_not_exist, "enum_album_not_exist");
    private String __T;
    private int __value;

    enum_album_error_code_define(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static enum_album_error_code_define convert(int i3) {
        int i16 = 0;
        while (true) {
            enum_album_error_code_define[] enum_album_error_code_defineVarArr = __values;
            if (i16 >= enum_album_error_code_defineVarArr.length) {
                return null;
            }
            if (enum_album_error_code_defineVarArr[i16].value() == i3) {
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

    public static enum_album_error_code_define convert(String str) {
        int i3 = 0;
        while (true) {
            enum_album_error_code_define[] enum_album_error_code_defineVarArr = __values;
            if (i3 >= enum_album_error_code_defineVarArr.length) {
                return null;
            }
            if (enum_album_error_code_defineVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
