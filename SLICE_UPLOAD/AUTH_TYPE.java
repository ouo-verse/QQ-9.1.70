package SLICE_UPLOAD;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class AUTH_TYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _LOGIN_TYPE_A2 = 2;
    public static final int _LOGIN_TYPE_BIZ = 7;
    public static final int _LOGIN_TYPE_ENC_A2 = 1;
    public static final int _LOGIN_TYPE_OPENID = 5;
    public static final int _LOGIN_TYPE_OPENID_OTHER = 8;
    public static final int _LOGIN_TYPE_PSKEY = 4;
    public static final int _LOGIN_TYPE_SKEY = 3;
    public static final int _LOGIN_TYPE_THEMEALBUM_XCX_TICKET = 6;
    private String __T;
    private int __value;
    private static AUTH_TYPE[] __values = new AUTH_TYPE[8];
    public static final AUTH_TYPE LOGIN_TYPE_ENC_A2 = new AUTH_TYPE(0, 1, "LOGIN_TYPE_ENC_A2");
    public static final AUTH_TYPE LOGIN_TYPE_A2 = new AUTH_TYPE(1, 2, "LOGIN_TYPE_A2");
    public static final AUTH_TYPE LOGIN_TYPE_SKEY = new AUTH_TYPE(2, 3, "LOGIN_TYPE_SKEY");
    public static final AUTH_TYPE LOGIN_TYPE_PSKEY = new AUTH_TYPE(3, 4, "LOGIN_TYPE_PSKEY");
    public static final AUTH_TYPE LOGIN_TYPE_OPENID = new AUTH_TYPE(4, 5, "LOGIN_TYPE_OPENID");
    public static final AUTH_TYPE LOGIN_TYPE_THEMEALBUM_XCX_TICKET = new AUTH_TYPE(5, 6, "LOGIN_TYPE_THEMEALBUM_XCX_TICKET");
    public static final AUTH_TYPE LOGIN_TYPE_BIZ = new AUTH_TYPE(6, 7, "LOGIN_TYPE_BIZ");
    public static final AUTH_TYPE LOGIN_TYPE_OPENID_OTHER = new AUTH_TYPE(7, 8, "LOGIN_TYPE_OPENID_OTHER");

    AUTH_TYPE(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static AUTH_TYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            AUTH_TYPE[] auth_typeArr = __values;
            if (i16 >= auth_typeArr.length) {
                return null;
            }
            if (auth_typeArr[i16].value() == i3) {
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

    public static AUTH_TYPE convert(String str) {
        int i3 = 0;
        while (true) {
            AUTH_TYPE[] auth_typeArr = __values;
            if (i3 >= auth_typeArr.length) {
                return null;
            }
            if (auth_typeArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
