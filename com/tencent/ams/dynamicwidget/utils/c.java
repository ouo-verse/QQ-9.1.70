package com.tencent.ams.dynamicwidget.utils;

import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ams/dynamicwidget/utils/c;", "", "Ljava/lang/Runnable;", "task", "", "a", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final c f70219a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f70219a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public final void a(@NotNull Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkParameterIsNotNull(task, "task");
        WorkThreadManager workThreadManager = WorkThreadManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(workThreadManager, "WorkThreadManager.getInstance()");
        workThreadManager.getImmediateThreadPool().execute(task);
    }
}
