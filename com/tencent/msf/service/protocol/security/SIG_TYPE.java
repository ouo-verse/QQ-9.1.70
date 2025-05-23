package com.tencent.msf.service.protocol.security;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* loaded from: classes21.dex */
public final class SIG_TYPE implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_ = null;
    public static final SIG_TYPE SIG_TYPE_A2;
    public static final SIG_TYPE SIG_TYPE_A3;
    public static final SIG_TYPE SIG_TYPE_A8;
    public static final SIG_TYPE SIG_TYPE_AccessToken;
    public static final SIG_TYPE SIG_TYPE_AccessTokenSecret;
    public static final SIG_TYPE SIG_TYPE_D2;
    public static final SIG_TYPE SIG_TYPE_D2_KEY;
    public static final SIG_TYPE SIG_TYPE_D3;
    public static final SIG_TYPE SIG_TYPE_D3_KA1;
    public static final SIG_TYPE SIG_TYPE_MiniA2;
    public static final SIG_TYPE SIG_TYPE_OpenID;
    public static final SIG_TYPE SIG_TYPE_OpenKey;
    public static final SIG_TYPE SIG_TYPE_Qzone_accesstoken;
    public static final SIG_TYPE SIG_TYPE_Qzone_ckey;
    public static final SIG_TYPE SIG_TYPE_Qzone_openid;
    public static final SIG_TYPE SIG_TYPE_SESSIONKEY;
    public static final SIG_TYPE SIG_TYPE_SKey;
    public static final SIG_TYPE SIG_TYPE_STwxWeb;
    public static final SIG_TYPE SIG_TYPE_SuperKey;
    public static final SIG_TYPE SIG_TYPE_TenpaySessionKey;
    public static final SIG_TYPE SIG_TYPE_ocid;
    public static final SIG_TYPE SIG_TYPE_vkey;
    public static final int _SIG_TYPE_A2 = 0;
    public static final int _SIG_TYPE_A3 = 2;
    public static final int _SIG_TYPE_A8 = 3;
    public static final int _SIG_TYPE_AccessToken = 5;
    public static final int _SIG_TYPE_AccessTokenSecret = 6;
    public static final int _SIG_TYPE_D2 = 18;
    public static final int _SIG_TYPE_D2_KEY = 20;
    public static final int _SIG_TYPE_D3 = 12;
    public static final int _SIG_TYPE_D3_KA1 = 13;
    public static final int _SIG_TYPE_MiniA2 = 1;
    public static final int _SIG_TYPE_OpenID = 16;
    public static final int _SIG_TYPE_OpenKey = 17;
    public static final int _SIG_TYPE_Qzone_accesstoken = 9;
    public static final int _SIG_TYPE_Qzone_ckey = 10;
    public static final int _SIG_TYPE_Qzone_openid = 11;
    public static final int _SIG_TYPE_SESSIONKEY = 4;
    public static final int _SIG_TYPE_SKey = 19;
    public static final int _SIG_TYPE_STwxWeb = 8;
    public static final int _SIG_TYPE_SuperKey = 21;
    public static final int _SIG_TYPE_TenpaySessionKey = 7;
    public static final int _SIG_TYPE_ocid = 15;
    public static final int _SIG_TYPE_vkey = 14;
    private static SIG_TYPE[] __values;
    private String __T;
    private int __value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        $assertionsDisabled = true;
        __values = new SIG_TYPE[20];
        SIG_TYPE_A2 = new SIG_TYPE(0, 0, "SIG_TYPE_A2");
        SIG_TYPE_MiniA2 = new SIG_TYPE(1, 1, "SIG_TYPE_MiniA2");
        SIG_TYPE_A3 = new SIG_TYPE(2, 2, "SIG_TYPE_A3");
        SIG_TYPE_A8 = new SIG_TYPE(3, 3, "SIG_TYPE_A8");
        SIG_TYPE_SESSIONKEY = new SIG_TYPE(4, 4, "SIG_TYPE_SESSIONKEY");
        SIG_TYPE_AccessToken = new SIG_TYPE(5, 5, "SIG_TYPE_AccessToken");
        SIG_TYPE_AccessTokenSecret = new SIG_TYPE(6, 6, "SIG_TYPE_AccessTokenSecret");
        SIG_TYPE_TenpaySessionKey = new SIG_TYPE(7, 7, "SIG_TYPE_TenpaySessionKey");
        SIG_TYPE_STwxWeb = new SIG_TYPE(8, 8, "SIG_TYPE_STwxWeb");
        SIG_TYPE_Qzone_accesstoken = new SIG_TYPE(9, 9, "SIG_TYPE_Qzone_accesstoken");
        SIG_TYPE_Qzone_ckey = new SIG_TYPE(10, 10, "SIG_TYPE_Qzone_ckey");
        SIG_TYPE_Qzone_openid = new SIG_TYPE(11, 11, "SIG_TYPE_Qzone_openid");
        SIG_TYPE_D3 = new SIG_TYPE(12, 12, "SIG_TYPE_D3");
        SIG_TYPE_D3_KA1 = new SIG_TYPE(13, 13, "SIG_TYPE_D3_KA1");
        SIG_TYPE_vkey = new SIG_TYPE(14, 14, "SIG_TYPE_vkey");
        SIG_TYPE_ocid = new SIG_TYPE(15, 15, "SIG_TYPE_ocid");
        SIG_TYPE_OpenID = new SIG_TYPE(16, 16, "SIG_TYPE_OpenID");
        SIG_TYPE_OpenKey = new SIG_TYPE(17, 17, "SIG_TYPE_OpenKey");
        SIG_TYPE_D2 = new SIG_TYPE(18, 18, "SIG_TYPE_D2");
        SIG_TYPE_SKey = new SIG_TYPE(19, 19, "SIG_TYPE_SKey");
        SIG_TYPE_D2_KEY = new SIG_TYPE(20, 20, "SIG_TYPE_D2_KEY");
        SIG_TYPE_SuperKey = new SIG_TYPE(21, 21, "SIG_TYPE_SuperKey");
    }

    SIG_TYPE(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static SIG_TYPE convert(int i3) {
        int i16 = 0;
        while (true) {
            SIG_TYPE[] sig_typeArr = __values;
            if (i16 < sig_typeArr.length) {
                if (sig_typeArr[i16].value() == i3) {
                    return __values[i16];
                }
                i16++;
            } else {
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.__T;
    }

    public int value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.__value;
    }

    public static SIG_TYPE convert(String str) {
        int i3 = 0;
        while (true) {
            SIG_TYPE[] sig_typeArr = __values;
            if (i3 < sig_typeArr.length) {
                if (sig_typeArr[i3].toString().equals(str)) {
                    return __values[i3];
                }
                i3++;
            } else {
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }
}
