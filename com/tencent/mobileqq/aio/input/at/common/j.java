package com.tencent.mobileqq.aio.input.at.common;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0005\u001a\u00020\u0004H \u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H \u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H \u00a2\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H \u00a2\u0006\u0004\b\r\u0010\nJ\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u000f\u0010\u0016\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/j;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "", "", "f", "()Z", "isHalfDisplayMode", "", tl.h.F, "(Z)V", "g", "isMultiSelectMode", "i", "Landroid/content/Context;", "c", "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "b", "Lcom/tencent/mobileqq/aio/input/at/common/e;", "d", "e", "()Lcom/tencent/mobileqq/aio/input/at/common/c;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class j<T extends c> {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public abstract View a();

    @NotNull
    public abstract a<T> b();

    @NotNull
    public abstract Context c();

    @NotNull
    public abstract e d();

    @NotNull
    public abstract T e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract void h(boolean isHalfDisplayMode);

    public abstract void i(boolean isMultiSelectMode);
}
