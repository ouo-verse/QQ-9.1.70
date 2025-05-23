package com.tencent.qqnt.startup.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/startup/utils/a;", "", "", "tag", "msg", "", "a", "", ReportConstant.COSTREPORT_TRANS, "c", "d", "b", "", "Z", "QLogEnable", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362281a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean QLogEnable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362281a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLogEnable) {
            QLog.d(tag, 1, msg2);
        } else {
            Log.d(tag, msg2);
        }
    }

    @JvmStatic
    public static final void c(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(tr5, "tr");
        if (QLogEnable) {
            QLog.e(tag, 1, msg2, tr5);
        } else {
            Log.e(tag, msg2, tr5);
        }
    }

    public final void b(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tag, msg2, tr5);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(tr5, "tr");
        if (QLogEnable) {
            QLog.d(tag, 1, msg2, tr5);
        } else {
            Log.d(tag, msg2, tr5);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLogEnable = true;
        }
    }
}
