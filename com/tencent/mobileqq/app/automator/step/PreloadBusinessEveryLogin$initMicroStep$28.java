package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
final class PreloadBusinessEveryLogin$initMicroStep$28 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    public static final PreloadBusinessEveryLogin$initMicroStep$28 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new PreloadBusinessEveryLogin$initMicroStep$28();
        }
    }

    PreloadBusinessEveryLogin$initMicroStep$28() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).onAccountChange();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.e
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadBusinessEveryLogin$initMicroStep$28.c();
                }
            }, 16, null, false);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
