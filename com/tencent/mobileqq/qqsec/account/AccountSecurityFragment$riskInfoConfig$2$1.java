package com.tencent.mobileqq.qqsec.account;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class AccountSecurityFragment$riskInfoConfig$2$1 extends Lambda implements Function1<Bundle, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AccountSecurityFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountSecurityFragment$riskInfoConfig$2$1(AccountSecurityFragment accountSecurityFragment) {
        super(1);
        this.this$0 = accountSecurityFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) accountSecurityFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r1 = r1.riskInfoView;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(AccountSecurityFragment this$0, boolean z16, String strRiskTipsText) {
        AccountRiskInfoView accountRiskInfoView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(strRiskTipsText, "$strRiskTipsText");
        if (this$0.getActivity() != null && accountRiskInfoView != null) {
            accountRiskInfoView.o(z16, strRiskTipsText);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
        invoke2(bundle);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        final boolean z16 = bundle.getBoolean("bSafe");
        final String string = bundle.getString("TipText");
        if (string == null) {
            string = "";
        }
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final AccountSecurityFragment accountSecurityFragment = this.this$0;
        uIHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqsec.account.o
            @Override // java.lang.Runnable
            public final void run() {
                AccountSecurityFragment$riskInfoConfig$2$1.b(AccountSecurityFragment.this, z16, string);
            }
        }, 2000L);
    }
}
