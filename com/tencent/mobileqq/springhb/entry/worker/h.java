package com.tencent.mobileqq.springhb.entry.worker;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.worker.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \t2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/h;", "Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "b", "e", "d", tl.h.F, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "Z", "isNeedRefreshScheduleTask", "()Z", "o", "(Z)V", "f", "getCurIsStudyOrElderMode", "setCurIsStudyOrElderMode", "curIsStudyOrElderMode", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends e.b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d springApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedRefreshScheduleTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean curIsStudyOrElderMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.worker.h$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
        } else {
            this.springApi = springApi;
            springApi.l().c(this);
        }
    }

    private final void k() {
        if (!this.springApi.n().b0()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.worker.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.l(h.this);
                }
            }, 16, null, true);
            return;
        }
        QLog.d("SpringHbUITask", 2, "checkAndReportExpose isDefaultStyle = " + this.springApi.l().e());
        this.springApi.p().o();
        this.springApi.q().F();
        this.springApi.h().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.springApi.n().N();
    }

    private final boolean m() {
        if (!this.springApi.p().i() && !this.springApi.q().x() && this.springApi.k().f289415m == -1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("SpringHbUITask", 2, "onDrawerClose");
        if (this.isNeedRefreshScheduleTask) {
            this.springApi.n().k0();
            this.isNeedRefreshScheduleTask = false;
        }
        k();
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("SpringHbUITask", 2, "onDesktopClosed");
        if (this.isNeedRefreshScheduleTask) {
            this.springApi.n().k0();
            this.isNeedRefreshScheduleTask = false;
        }
        k();
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d("SpringHbUITask", 2, "onMiniAppDesktopOpen");
            this.springApi.n().g0();
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("SpringHbUITask", 2, "onResume isStudyMode = " + this.springApi.t());
        if (!this.springApi.n().V()) {
            QLog.d("SpringHbUITask", 2, "onResume hideNormalActivityPendant");
            this.springApi.p().g(0);
        }
        if (this.springApi.t() != this.curIsStudyOrElderMode) {
            this.isNeedRefreshScheduleTask = true;
            this.curIsStudyOrElderMode = this.springApi.t();
            QLog.d("SpringHbUITask", 1, "onResume: isStudyOrElderMode is Change");
        }
        if (this.curIsStudyOrElderMode && m()) {
            this.springApi.p().g(0);
            this.springApi.h().m();
            this.springApi.q().A();
            return;
        }
        QLog.d("SpringHbUITask", 1, "onResume isNeedRefreshScheduleTask=" + this.isNeedRefreshScheduleTask);
        if (this.isNeedRefreshScheduleTask) {
            this.springApi.n().k0();
            this.isNeedRefreshScheduleTask = false;
        }
        k();
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            QLog.d("SpringHbUITask", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isNeedRefreshScheduleTask = z16;
        }
    }
}
