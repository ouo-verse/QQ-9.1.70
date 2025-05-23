package com.tencent.msf.service.protocol.security;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class CMD_ID implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_ = null;
    public static final CMD_ID CMD_ID_AUTH;
    public static final CMD_ID CMD_ID_AUTH_AND_GET_KEY;
    public static final CMD_ID CMD_ID_AUTH_MAIL;
    public static final CMD_ID CMD_ID_AUTH_MSF_ACCOUNT_LOGIN;
    public static final CMD_ID CMD_ID_AUTH_WLOGIN;
    public static final CMD_ID CMD_ID_AUTH_WLOGIN_AND_GET_KEY;
    public static final CMD_ID CMD_ID_CUSTOM_SIG;
    public static final CMD_ID CMD_ID_EMAIL_EXCHANGE_UIN;
    public static final CMD_ID CMD_ID_FETCH_VPIC_CODE;
    public static final CMD_ID CMD_ID_GET_SERVER_TIME;
    public static final CMD_ID CMD_ID_LOGGED_STAT_CUSTOM_SIG;
    public static final CMD_ID CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID;
    public static final CMD_ID CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN;
    public static final CMD_ID CMD_ID_NAME_EXCHANGE_UIN;
    public static final CMD_ID CMD_ID_REFETCH_SID;
    public static final CMD_ID CMD_ID_REFRESH_VPIC;
    public static final CMD_ID CMD_ID_REGISTQQ;
    public static final CMD_ID CMD_ID_SYNC;
    public static final CMD_ID CMD_ID_TOKEN_REQUEST;
    public static final CMD_ID CMD_ID_VERIFY_KEY;
    public static final CMD_ID CMD_ID_VERIFY_PIC;
    public static final CMD_ID CMD_ID_WB_EXCHANGE_UIN;
    public static final int _CMD_ID_AUTH = 0;
    public static final int _CMD_ID_AUTH_AND_GET_KEY = 12;
    public static final int _CMD_ID_AUTH_MAIL = 5;
    public static final int _CMD_ID_AUTH_MSF_ACCOUNT_LOGIN = 21;
    public static final int _CMD_ID_AUTH_WLOGIN = 14;
    public static final int _CMD_ID_AUTH_WLOGIN_AND_GET_KEY = 18;
    public static final int _CMD_ID_CUSTOM_SIG = 7;
    public static final int _CMD_ID_EMAIL_EXCHANGE_UIN = 10;
    public static final int _CMD_ID_FETCH_VPIC_CODE = 11;
    public static final int _CMD_ID_GET_SERVER_TIME = 15;
    public static final int _CMD_ID_LOGGED_STAT_CUSTOM_SIG = 9;
    public static final int _CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID = 20;
    public static final int _CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN = 19;
    public static final int _CMD_ID_NAME_EXCHANGE_UIN = 13;
    public static final int _CMD_ID_REFETCH_SID = 6;
    public static final int _CMD_ID_REFRESH_VPIC = 2;
    public static final int _CMD_ID_REGISTQQ = 17;
    public static final int _CMD_ID_SYNC = 4;
    public static final int _CMD_ID_TOKEN_REQUEST = 16;
    public static final int _CMD_ID_VERIFY_KEY = 3;
    public static final int _CMD_ID_VERIFY_PIC = 1;
    public static final int _CMD_ID_WB_EXCHANGE_UIN = 8;
    private static CMD_ID[] __values;
    private String __T;
    private int __value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27063);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        $assertionsDisabled = true;
        __values = new CMD_ID[22];
        CMD_ID_AUTH = new CMD_ID(0, 0, "CMD_ID_AUTH");
        CMD_ID_VERIFY_PIC = new CMD_ID(1, 1, "CMD_ID_VERIFY_PIC");
        CMD_ID_REFRESH_VPIC = new CMD_ID(2, 2, "CMD_ID_REFRESH_VPIC");
        CMD_ID_VERIFY_KEY = new CMD_ID(3, 3, "CMD_ID_VERIFY_KEY");
        CMD_ID_SYNC = new CMD_ID(4, 4, "CMD_ID_SYNC");
        CMD_ID_AUTH_MAIL = new CMD_ID(5, 5, "CMD_ID_AUTH_MAIL");
        CMD_ID_REFETCH_SID = new CMD_ID(6, 6, "CMD_ID_REFETCH_SID");
        CMD_ID_CUSTOM_SIG = new CMD_ID(7, 7, "CMD_ID_CUSTOM_SIG");
        CMD_ID_WB_EXCHANGE_UIN = new CMD_ID(8, 8, "CMD_ID_WB_EXCHANGE_UIN");
        CMD_ID_LOGGED_STAT_CUSTOM_SIG = new CMD_ID(9, 9, "CMD_ID_LOGGED_STAT_CUSTOM_SIG");
        CMD_ID_EMAIL_EXCHANGE_UIN = new CMD_ID(10, 10, "CMD_ID_EMAIL_EXCHANGE_UIN");
        CMD_ID_FETCH_VPIC_CODE = new CMD_ID(11, 11, "CMD_ID_FETCH_VPIC_CODE");
        CMD_ID_AUTH_AND_GET_KEY = new CMD_ID(12, 12, "CMD_ID_AUTH_AND_GET_KEY");
        CMD_ID_NAME_EXCHANGE_UIN = new CMD_ID(13, 13, "CMD_ID_NAME_EXCHANGE_UIN");
        CMD_ID_AUTH_WLOGIN = new CMD_ID(14, 14, "CMD_ID_AUTH_WLOGIN");
        CMD_ID_GET_SERVER_TIME = new CMD_ID(15, 15, "CMD_ID_GET_SERVER_TIME");
        CMD_ID_TOKEN_REQUEST = new CMD_ID(16, 16, "CMD_ID_TOKEN_REQUEST");
        CMD_ID_REGISTQQ = new CMD_ID(17, 17, "CMD_ID_REGISTQQ");
        CMD_ID_AUTH_WLOGIN_AND_GET_KEY = new CMD_ID(18, 18, "CMD_ID_AUTH_WLOGIN_AND_GET_KEY");
        CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN = new CMD_ID(19, 19, "CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN");
        CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID = new CMD_ID(20, 20, "CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID");
        CMD_ID_AUTH_MSF_ACCOUNT_LOGIN = new CMD_ID(21, 21, "CMD_ID_AUTH_MSF_ACCOUNT_LOGIN");
    }

    CMD_ID(int i3, int i16, String str) {
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

    public static CMD_ID convert(int i3) {
        int i16 = 0;
        while (true) {
            CMD_ID[] cmd_idArr = __values;
            if (i16 < cmd_idArr.length) {
                if (cmd_idArr[i16].value() == i3) {
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

    public static CMD_ID convert(String str) {
        int i3 = 0;
        while (true) {
            CMD_ID[] cmd_idArr = __values;
            if (i3 < cmd_idArr.length) {
                if (cmd_idArr[i3].toString().equals(str)) {
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
