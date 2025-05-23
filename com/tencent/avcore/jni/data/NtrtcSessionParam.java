package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcSessionParam {
    static IPatchRedirector $redirector_;
    public NtrtcSessionBaseParam base;
    public NtrtcSessionExtParam ext;
    public NtrtcTempChatParam tempChat;

    /* loaded from: classes3.dex */
    public static class NtrtcSessionBaseParam {
        static IPatchRedirector $redirector_;
        public int businessType;
        public int inviteScene;
        public String peerUid;
        public int relationType;

        public NtrtcSessionBaseParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.peerUid = "";
            this.businessType = 0;
            this.relationType = 1;
            this.inviteScene = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class NtrtcSessionExtParam {
        static IPatchRedirector $redirector_;
        public String interestingChatBuf;
        public int subServiceType;
        public String traceId;

        public NtrtcSessionExtParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.subServiceType = 0;
            this.interestingChatBuf = "";
            this.traceId = "";
        }
    }

    /* loaded from: classes3.dex */
    public static class NtrtcTempChatParam {
        static IPatchRedirector $redirector_;
        public String dcReportBuf;
        public byte[] sign;
        public int tempChatType;
        public long tempId;
        public long tempUin;

        public NtrtcTempChatParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.tempChatType = 0;
            this.tempId = 0L;
            this.tempUin = 0L;
            this.sign = null;
            this.dcReportBuf = "";
        }
    }

    public NtrtcSessionParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.base = new NtrtcSessionBaseParam();
        this.ext = new NtrtcSessionExtParam();
        this.tempChat = new NtrtcTempChatParam();
    }
}
