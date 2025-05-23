package com.tencent.mobileqq.springhb.main;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/i;", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "", "f", "k", "e", "", "g", "Z", "showJumpBtn", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends BaseStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean showJumpBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull BrowserViewModel viewModel, boolean z16) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewModel, Boolean.valueOf(z16));
        } else {
            this.showJumpBtn = z16;
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.e();
        n(this.showJumpBtn);
        BaseStrategy.s(this, true, false, 2, null);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.f();
        q(true);
        BaseStrategy.s(this, false, false, 2, null);
        p(true);
        n(false);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.k();
        BaseStrategy.s(this, true, false, 2, null);
        q(false);
    }
}
