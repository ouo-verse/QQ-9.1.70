package com.tencent.mobileqq.springhb.main;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/e;", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "", "f", "e", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends BaseStrategy {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull BrowserViewModel viewModel) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.e();
        BaseStrategy.s(this, true, false, 2, null);
        q(false);
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
        p(false);
        n(false);
    }
}
