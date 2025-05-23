package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVUserInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int MIC_AUTH_NONE = 2;
    public static final int MIC_AUTH_OFF = 1;
    public static final int MIC_AUTH_ON = 0;
    public String account;
    public int accountType;
    public String commonTipsInfo;
    public String extBusinessInfo;
    public int extInfoType;
    public int micAuthByAdmin;
    public int netLevel;
    public String openId;
    public int pstnStatus;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AccountType {
        public static final int PSTN = 1;
        public static final int QQ = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface PstnStatus {
        public static final int ACCEPT = 3;
        public static final int CALLING = 1;
        public static final int CLOSED = 6;
        public static final int MISSED = 5;
        public static final int REFUSE = 4;
        public static final int RINGING = 2;
        public static final int UNKNOWN = 0;
    }

    public AVUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.account = "";
        this.openId = null;
        this.accountType = 0;
        this.pstnStatus = 0;
        this.micAuthByAdmin = 2;
        this.extInfoType = 0;
        this.extBusinessInfo = "";
        this.netLevel = 1;
        this.commonTipsInfo = "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AVUserInfo{account=" + this.account + ", openId=[" + this.openId + "], accountType=" + this.accountType + ", pstnStatus=" + this.pstnStatus + ", micAuthByAdmin=" + this.micAuthByAdmin + ", extInfoType=" + this.extInfoType + ", extBusinessInfo=" + this.extBusinessInfo + ", netLevel=" + this.netLevel + ", commonTipsInfo=" + this.commonTipsInfo + '}';
    }
}
