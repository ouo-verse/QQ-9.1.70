package com.tencent.mobileqq.springhb.main;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/h;", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "", "y", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "f", "j", "i", "e", "", "g", "J", "b", "()J", "loadingTimeOut", tl.h.F, "Z", "mHasRegisteredTimeOutJob", "mIsPageFinished", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mTimeoutJob", "k", "mPageTimeOutJob", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;)V", "l", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends BaseStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long loadingTimeOut;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRegisteredTimeOutJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPageFinished;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mTimeoutJob;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mPageTimeOutJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull BrowserViewModel viewModel) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
            return;
        }
        this.loadingTimeOut = 15000L;
        this.mTimeoutJob = new Runnable() { // from class: com.tencent.mobileqq.springhb.main.f
            @Override // java.lang.Runnable
            public final void run() {
                h.w(h.this);
            }
        };
        this.mPageTimeOutJob = new Runnable() { // from class: com.tencent.mobileqq.springhb.main.g
            @Override // java.lang.Runnable
            public final void run() {
                h.v(h.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    private final void x() {
        QLog.d("LoongCardLoadingStrategy", 1, "onPageTimeOut");
        z(true);
    }

    private final void y() {
        QLog.d("LoongCardLoadingStrategy", 1, "onTimeOut");
        BaseStrategy.s(this, true, false, 2, null);
        o(false);
        if (!this.mIsPageFinished) {
            z(true);
        }
        this.mHasRegisteredTimeOutJob = false;
    }

    private final void z(boolean visible) {
        d().i2(visible);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.loadingTimeOut;
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("LoongCardLoadingStrategy", 1, "h5NotifyLoadFinished");
        super.e();
        c().removeCallbacks(this.mTimeoutJob);
        this.mHasRegisteredTimeOutJob = false;
        BaseStrategy.s(this, true, false, 2, null);
        o(false);
        z(false);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        l();
        q(false);
        p(false);
        n(false);
        if (d().P1()) {
            c().postDelayed(this.mTimeoutJob, b());
            this.mHasRegisteredTimeOutJob = true;
            BaseStrategy.s(this, false, false, 2, null);
            o(true);
            return;
        }
        BaseStrategy.s(this, true, false, 2, null);
        o(false);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.i();
        this.mIsPageFinished = true;
        c().removeCallbacks(this.mPageTimeOutJob);
        z(d().X1());
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.j();
        this.mIsPageFinished = false;
        if (this.mHasRegisteredTimeOutJob) {
            return;
        }
        c().removeCallbacks(this.mPageTimeOutJob);
        c().postDelayed(this.mPageTimeOutJob, b());
    }
}
