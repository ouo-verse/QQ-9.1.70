package com.tencent.mobileqq.register.prettyaccount;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/register/prettyaccount/c;", "", "Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountABTestExp;", "abTestExp", "", "e", "", "tValue", IProfileCardConst.KEY_FROM_TYPE, "r4", "", "a", "d", "c", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f280545a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f280546a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27175);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PrettyAccountABTestExp.values().length];
            try {
                iArr[PrettyAccountABTestExp.EXP_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrettyAccountABTestExp.EXP_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f280546a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f280545a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String tValue, int fromType, String r46) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            ReportController.o(peekAppRuntime, "dc00898", "", "", tValue, tValue, fromType, 0, "", "", r46, "");
        } else {
            ReportController.r(peekAppRuntime, "dc00898", "", "", tValue, tValue, fromType, 0, "", "", r46, "");
        }
    }

    static /* synthetic */ void b(c cVar, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = o.c();
            Intrinsics.checkNotNullExpressionValue(str2, "getQimei36()");
        }
        cVar.a(str, i3, str2);
    }

    private final int e(PrettyAccountABTestExp abTestExp) {
        int i3 = a.f280546a[abTestExp.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        return 0;
    }

    public final void c(@NotNull PrettyAccountABTestExp abTestExp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) abTestExp);
            return;
        }
        Intrinsics.checkNotNullParameter(abTestExp, "abTestExp");
        QLog.d("PrettyAccountRegister", 4, "reportClick " + abTestExp);
        if (abTestExp == PrettyAccountABTestExp.EXP_1 || abTestExp == PrettyAccountABTestExp.EXP_2) {
            b(this, "0X800C686", e(abTestExp), null, 4, null);
        }
    }

    public final void d(@NotNull PrettyAccountABTestExp abTestExp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) abTestExp);
            return;
        }
        Intrinsics.checkNotNullParameter(abTestExp, "abTestExp");
        QLog.d("PrettyAccountRegister", 4, "reportShow " + abTestExp);
        if (abTestExp == PrettyAccountABTestExp.EXP_1 || abTestExp == PrettyAccountABTestExp.EXP_2) {
            b(this, "0X800C685", e(abTestExp), null, 4, null);
        }
    }
}
