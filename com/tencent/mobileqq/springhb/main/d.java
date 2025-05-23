package com.tencent.mobileqq.springhb.main;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/d;", "Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "", "t", "f", "i", "e", tl.h.F, "", "g", "J", "b", "()J", "loadingTimeOut", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class d extends BaseStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long loadingTimeOut;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull BrowserViewModel viewModel) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
        } else {
            this.loadingTimeOut = 15000L;
        }
    }

    private final void t() {
        MobileQQ.sMobileQQ.sendBroadcast(new Intent(SpringHbJsPlugin.ACTION_SPRING_GAME_LOADING_CANCEL));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.e();
        BaseStrategy.s(this, true, false, 2, null);
        t();
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.f();
        BaseStrategy.s(this, false, false, 2, null);
        q(false);
        p(false);
        n(false);
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.h();
            t();
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseStrategy
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
