package com.tencent.mobileqq.qcoroutine.framework.impl;

import android.os.Message;
import com.tencent.mobileqq.qcoroutine.api.c;
import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.QHandler;
import com.tencent.mobileqq.qcoroutine.framework.QTaskPool;
import com.tencent.mobileqq.qcoroutine.framework.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JF\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0002\b\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/impl/a;", "", "Lcom/tencent/mobileqq/qcoroutine/api/g;", "runnable", "", "e", "a", "", "nameAndGroupId", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/qcoroutine/api/c;", "Landroid/os/Message;", "Lkotlin/ParameterName;", "name", "msg", "Lkotlin/ExtensionFunctionType;", "handleMessage", "c", "d", "b", "Lkotlinx/coroutines/CoroutineScope;", "f", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f261834a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f261834a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void a(@NotNull g runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        QTaskPool e16 = d.f261833c.e(runnable.e());
        if (e16 != null) {
            e16.a(runnable);
        }
    }

    public void b(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) type);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            d.f261833c.a(type);
        }
    }

    @NotNull
    public c c(@NotNull String nameAndGroupId, @NotNull i type, @NotNull Function2<? super c, ? super Message, Unit> handleMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, this, nameAndGroupId, type, handleMessage);
        }
        Intrinsics.checkNotNullParameter(nameAndGroupId, "nameAndGroupId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(handleMessage, "handleMessage");
        return new QHandler(nameAndGroupId, type, handleMessage);
    }

    public void d(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) type);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            d.f261833c.b(type);
        }
    }

    public void e(@NotNull g runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        QTaskPool e16 = d.f261833c.e(runnable.e());
        if (e16 != null) {
            e16.c(runnable);
        }
    }

    @Nullable
    public CoroutineScope f(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 8, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        QTaskPool e16 = d.f261833c.e(type);
        if (e16 != null) {
            return e16.i();
        }
        return null;
    }
}
