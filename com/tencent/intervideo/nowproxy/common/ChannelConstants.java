package com.tencent.intervideo.nowproxy.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ChannelConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_RET_CODE = "retcode";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class CSRetCode {
        static IPatchRedirector $redirector_ = null;
        public static final int CS_RET_FAIL = 10001;
        public static final int CS_RET_SUCCESS = 0;
        public static final int CS_RET_TIMEOUT = 10002;

        public CSRetCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class CmdInner {
        static IPatchRedirector $redirector_ = null;
        public static final int CMD_RSP = 1;
        public static final int CMD_TIMEOUT = 2;

        public CmdInner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class MainCmd {
        static IPatchRedirector $redirector_ = null;
        public static final int CMD_ACCOUNT = 3;
        public static final int CMD_CS = 1;
        public static final int CMD_PUSH = 2;
        public static final int CMD_SHARE = 4;

        public MainCmd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class Plugin2SdkMsg {
        static IPatchRedirector $redirector_ = null;
        public static final String ACTION_NO_LOGIN = "action.now.nologin";

        public Plugin2SdkMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class Sdk2PluginMsg {
        static IPatchRedirector $redirector_ = null;
        public static final String ACTION_LOGIN = "action.now.set.logindata";
        public static final String ACTION_LOGOUT = "action.now.logout";

        public Sdk2PluginMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class SdkInner {
        static IPatchRedirector $redirector_ = null;
        public static final String ACTION_JSBRIDGE = "action.now.jscall";
        public static final String ACTION_LOGINDATA_INVALID = "action.now.logindata.invalid";
        public static final String ACTION_LOGINDATA_READY = "action.now.logindata.ready";

        public SdkInner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChannelConstants.this);
            }
        }
    }

    public ChannelConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
