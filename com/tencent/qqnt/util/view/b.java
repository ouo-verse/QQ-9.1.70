package com.tencent.qqnt.util.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/util/view/b;", "", "", "dp", "b", "", "a", "c", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f362999a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f362999a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(float dp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Float.valueOf(dp5))).intValue();
        }
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return (int) (f16 * dp5);
    }

    public final int b(int dp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, dp5)).intValue();
        }
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return (int) (f16 * dp5);
    }

    public final float c(float dp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, this, Float.valueOf(dp5))).floatValue();
        }
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 3.0f;
        }
        return f16 * dp5;
    }
}
