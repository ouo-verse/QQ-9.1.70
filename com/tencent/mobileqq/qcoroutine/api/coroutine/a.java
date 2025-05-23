package com.tencent.mobileqq.qcoroutine.api.coroutine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "T", "Lcom/tencent/mobileqq/qcoroutine/framework/b;", "Lkotlinx/coroutines/Deferred;", "o", "Lkotlinx/coroutines/Job;", "_job", "", "j", "f", "Lkotlinx/coroutines/Deferred;", "p", "()Lkotlinx/coroutines/Deferred;", "setDeferred", "(Lkotlinx/coroutines/Deferred;)V", "deferred", "", "excuteTime", "<init>", "(J)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class a<T> extends com.tencent.mobileqq.qcoroutine.framework.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Deferred<? extends T> deferred;

    public a(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.qcoroutine.framework.b
    public void j(@NotNull Job _job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) _job);
            return;
        }
        Intrinsics.checkNotNullParameter(_job, "_job");
        super.j(_job);
        if (_job instanceof Deferred) {
            this.deferred = (Deferred) _job;
        }
    }

    @Nullable
    public Deferred<T> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Deferred) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.deferred;
    }

    @Nullable
    public final Deferred<T> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Deferred) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.deferred;
    }
}
