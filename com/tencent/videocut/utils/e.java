package com.tencent.videocut.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/utils/e;", "", "", "dpValue", "", "a", "pxValue", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f384236a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384236a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final int a(float dpValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, this, Float.valueOf(dpValue))).intValue();
        }
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) ((dpValue * system.getDisplayMetrics().density) + 0.5f);
    }

    public final float b(float pxValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(pxValue))).floatValue();
        }
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return pxValue / system.getDisplayMetrics().density;
    }
}
