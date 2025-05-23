package com.tencent.upload.network.session;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmdownloader.a;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadSession {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface RequestListener {
        void onRequestError(IActionRequest iActionRequest, Const.UploadRetCode uploadRetCode, IUploadSession iUploadSession);

        void onRequestSended(IActionRequest iActionRequest);

        void onRequestSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder);

        void onRequestTimeout(IActionRequest iActionRequest, IUploadSession iUploadSession);

        void onResponse(IActionRequest iActionRequest, UploadResponse uploadResponse);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SessionState {
        private static final /* synthetic */ SessionState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SessionState CONNECTING;
        public static final SessionState ESTABLISHED;
        public static final SessionState NO_CONNECT;
        private int code;
        private String desc;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11648);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            SessionState sessionState = new SessionState("NO_CONNECT", 0, 0, "NoConnect");
            NO_CONNECT = sessionState;
            SessionState sessionState2 = new SessionState(a.CONNTECTSTATE_CONNECTING, 1, 1, "Connecting");
            CONNECTING = sessionState2;
            SessionState sessionState3 = new SessionState("ESTABLISHED", 2, 3, "Establish");
            ESTABLISHED = sessionState3;
            $VALUES = new SessionState[]{sessionState, sessionState2, sessionState3};
        }

        SessionState(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                this.code = i16;
                this.desc = str2;
            }
        }

        public static SessionState valueOf(String str) {
            return (SessionState) Enum.valueOf(SessionState.class, str);
        }

        public static SessionState[] values() {
            return (SessionState[]) $VALUES.clone();
        }

        public int getCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.code;
        }

        public String getDesc() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.desc;
        }

        @Override // java.lang.Enum
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "[" + this.code + "," + this.desc + "]";
        }
    }

    void cancel(int i3);

    void close();

    String getBaseSessionReportString();

    String getConnectedIp();

    String getSessionId();

    SessionState getState();

    UploadRoute getUploadRoute();

    boolean isExpired();

    boolean isIdle();

    boolean open(UploadRoute uploadRoute);

    boolean open(UploadRoute uploadRoute, int i3);

    boolean send(IActionRequest iActionRequest, TaskTypeConfig taskTypeConfig, RequestListener requestListener);

    void setBusy(boolean z16);
}
