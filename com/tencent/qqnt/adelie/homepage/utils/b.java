package com.tencent.qqnt.adelie.homepage.utils;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/adelie/homepage/utils/b;", "", "Ljava/lang/Runnable;", "job", "", "f", "e", "b", "Lkotlin/Function0;", "block", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f348409a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f348409a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    public final void b(@NotNull Runnable job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) job);
            return;
        }
        Intrinsics.checkNotNullParameter(job, "job");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            job.run();
        } else {
            f(job);
        }
    }

    public final void c(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            b(new Runnable() { // from class: com.tencent.qqnt.adelie.homepage.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(Function0.this);
                }
            });
        }
    }

    public final void e(@NotNull Runnable job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) job);
        } else {
            Intrinsics.checkNotNullParameter(job, "job");
            ThreadManagerV2.excute(job, 16, null, false);
        }
    }

    public final void f(@NotNull Runnable job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) job);
        } else {
            Intrinsics.checkNotNullParameter(job, "job");
            ThreadManagerV2.getUIHandlerV2().post(job);
        }
    }
}
