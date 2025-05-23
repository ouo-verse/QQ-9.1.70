package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/soload/api/IFlowControlService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reqHippyFlowControl", "", "url", "", "ls", "Lcom/tencent/mobileqq/soload/api/IFlowControlService$OnFlowControlListener;", "reqSoFlowControl", "OnFlowControlListener", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IFlowControlService extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/soload/api/IFlowControlService$OnFlowControlListener;", "", "onLimited", "", "code", "", "nextTime", "", "onSuccess", "Companion", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public interface OnFlowControlListener {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int LIMIT_CODE_IN_NOT_ALLOW_REQ_FLOW_TIME = -1001;
        public static final int LIMIT_CODE_SERVICE = -1000;
        public static final int PASS_CODE_LOGIC_EXCEPTION = 1002;
        public static final int PASS_CODE_SERVICE_ERROR = 1001;
        public static final int PASS_CODE_SERVICE_SUCCESS = 1000;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/soload/api/IFlowControlService$OnFlowControlListener$Companion;", "", "()V", "LIMIT_CODE_IN_NOT_ALLOW_REQ_FLOW_TIME", "", "LIMIT_CODE_SERVICE", "PASS_CODE_LOGIC_EXCEPTION", "PASS_CODE_SERVICE_ERROR", "PASS_CODE_SERVICE_SUCCESS", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;
            static IPatchRedirector $redirector_ = null;
            public static final int LIMIT_CODE_IN_NOT_ALLOW_REQ_FLOW_TIME = -1001;
            public static final int LIMIT_CODE_SERVICE = -1000;
            public static final int PASS_CODE_LOGIC_EXCEPTION = 1002;
            public static final int PASS_CODE_SERVICE_ERROR = 1001;
            public static final int PASS_CODE_SERVICE_SUCCESS = 1000;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33573);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    $$INSTANCE = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33575), (Class<?>) OnFlowControlListener.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.$$INSTANCE;
            }
        }

        void onLimited(int code, long nextTime);

        void onSuccess(int code);
    }

    void reqHippyFlowControl(@Nullable String url, @Nullable OnFlowControlListener ls5);

    void reqSoFlowControl(@Nullable String url, @Nullable OnFlowControlListener ls5);
}
