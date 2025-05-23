package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
final class PreloadBusinessEveryLogin$initMicroStep$25 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    public static final PreloadBusinessEveryLogin$initMicroStep$25 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new PreloadBusinessEveryLogin$initMicroStep$25();
        }
    }

    PreloadBusinessEveryLogin$initMicroStep$25() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        QLog.i(QQUtils.f307225a, 1, "excute addLongShortcut");
        QQUtils.a();
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
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.b
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadBusinessEveryLogin$initMicroStep$25.c();
                }
            }, 16, null, false);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
