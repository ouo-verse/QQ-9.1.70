package QQService;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserIdentityType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _UserIdentityType_Merchant = 1;
    public static final int _UserIdentityType_Nomal = 0;
    public static final int _UserIdentityType_Official = 2;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static UserIdentityType[] f25089d = new UserIdentityType[3];
    public static final UserIdentityType UserIdentityType_Nomal = new UserIdentityType(0, 0, "UserIdentityType_Nomal");
    public static final UserIdentityType UserIdentityType_Merchant = new UserIdentityType(1, 1, "UserIdentityType_Merchant");
    public static final UserIdentityType UserIdentityType_Official = new UserIdentityType(2, 2, "UserIdentityType_Official");

    UserIdentityType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25089d[i3] = this;
    }

    public static UserIdentityType convert(int i3) {
        int i16 = 0;
        while (true) {
            UserIdentityType[] userIdentityTypeArr = f25089d;
            if (i16 >= userIdentityTypeArr.length) {
                return null;
            }
            if (userIdentityTypeArr[i16].value() == i3) {
                return f25089d[i16];
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

    public static UserIdentityType convert(String str) {
        int i3 = 0;
        while (true) {
            UserIdentityType[] userIdentityTypeArr = f25089d;
            if (i3 >= userIdentityTypeArr.length) {
                return null;
            }
            if (userIdentityTypeArr[i3].toString().equals(str)) {
                return f25089d[i3];
            }
            i3++;
        }
    }
}
