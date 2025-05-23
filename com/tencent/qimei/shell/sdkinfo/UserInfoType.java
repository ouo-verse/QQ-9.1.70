package com.tencent.qimei.shell.sdkinfo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class UserInfoType {
    static IPatchRedirector $redirector_;
    public static final UserInfoType MAX_TYPE_SIZE;
    public static final UserInfoType TYPE_APP_KEY;
    public static final UserInfoType TYPE_APP_VERSION;
    public static final UserInfoType TYPE_CHANNEL_ID;
    public static final UserInfoType TYPE_MODEL;
    public static final UserInfoType TYPE_NET_WORK_TYPE;
    public static final UserInfoType TYPE_OS_VERSION;
    public static final UserInfoType TYPE_OZ;
    public static final UserInfoType TYPE_PRE_AUDIT_STATE;
    public static final UserInfoType TYPE_Q16;
    public static final UserInfoType TYPE_Q36;
    public static final UserInfoType TYPE_SDK_VERSION;
    public static final UserInfoType TYPE_USER_ID_PARAM;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserInfoType[] f343374a;
    private int value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UserInfoType userInfoType = new UserInfoType("TYPE_APP_KEY", 0, 0);
        TYPE_APP_KEY = userInfoType;
        UserInfoType userInfoType2 = new UserInfoType("TYPE_NET_WORK_TYPE", 1, 1);
        TYPE_NET_WORK_TYPE = userInfoType2;
        UserInfoType userInfoType3 = new UserInfoType("TYPE_SDK_VERSION", 2, 2);
        TYPE_SDK_VERSION = userInfoType3;
        UserInfoType userInfoType4 = new UserInfoType("TYPE_APP_VERSION", 3, 3);
        TYPE_APP_VERSION = userInfoType4;
        UserInfoType userInfoType5 = new UserInfoType("TYPE_CHANNEL_ID", 4, 4);
        TYPE_CHANNEL_ID = userInfoType5;
        UserInfoType userInfoType6 = new UserInfoType("TYPE_USER_ID_PARAM", 5, 5);
        TYPE_USER_ID_PARAM = userInfoType6;
        UserInfoType userInfoType7 = new UserInfoType("TYPE_OS_VERSION", 6, 6);
        TYPE_OS_VERSION = userInfoType7;
        UserInfoType userInfoType8 = new UserInfoType("TYPE_Q16", 7, 7);
        TYPE_Q16 = userInfoType8;
        UserInfoType userInfoType9 = new UserInfoType("TYPE_Q36", 8, 8);
        TYPE_Q36 = userInfoType9;
        UserInfoType userInfoType10 = new UserInfoType("TYPE_MODEL", 9, 9);
        TYPE_MODEL = userInfoType10;
        UserInfoType userInfoType11 = new UserInfoType("TYPE_PRE_AUDIT_STATE", 10, 10);
        TYPE_PRE_AUDIT_STATE = userInfoType11;
        UserInfoType userInfoType12 = new UserInfoType("TYPE_OZ", 11, 11);
        TYPE_OZ = userInfoType12;
        UserInfoType userInfoType13 = new UserInfoType("MAX_TYPE_SIZE", 12, 12);
        MAX_TYPE_SIZE = userInfoType13;
        f343374a = new UserInfoType[]{userInfoType, userInfoType2, userInfoType3, userInfoType4, userInfoType5, userInfoType6, userInfoType7, userInfoType8, userInfoType9, userInfoType10, userInfoType11, userInfoType12, userInfoType13};
    }

    public UserInfoType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static UserInfoType valueOf(String str) {
        return (UserInfoType) Enum.valueOf(UserInfoType.class, str);
    }

    public static UserInfoType[] values() {
        return (UserInfoType[]) f343374a.clone();
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return String.valueOf(this.value);
    }
}
