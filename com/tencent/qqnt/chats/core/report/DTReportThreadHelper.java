package com.tencent.qqnt.chats.core.report;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/DTReportThreadHelper;", "", "token", "Lkotlin/Function0;", "", "task", "a", "", "delay", "c", "d", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "sReportHandler", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DTReportThreadHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DTReportThreadHelper f354858a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sReportHandler;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f354858a = new DTReportThreadHelper();
        lazy = LazyKt__LazyJVMKt.lazy(DTReportThreadHelper$sReportHandler$2.INSTANCE);
        sReportHandler = lazy;
    }

    DTReportThreadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Handler b() {
        return (Handler) sReportHandler.getValue();
    }

    public final void a(@NotNull Object token, @NotNull Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, token, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), b().getLooper())) {
            task.invoke();
        } else {
            c(token, 1000L, task);
        }
    }

    public final void c(@NotNull Object token, long delay, @NotNull final Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, token, Long.valueOf(delay), task);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(task, "task");
        HandlerCompat.postDelayed(b(), new Runnable() { // from class: com.tencent.qqnt.chats.core.report.DTReportThreadHelper$postDelay$$inlined$postDelayed$1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Function0.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Function0.this.invoke();
                }
            }
        }, token, delay);
    }

    public final void d(@NotNull Object token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, token);
        } else {
            Intrinsics.checkNotNullParameter(token, "token");
            b().removeCallbacksAndMessages(token);
        }
    }
}
