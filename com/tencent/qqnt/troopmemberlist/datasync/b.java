package com.tencent.qqnt.troopmemberlist.datasync;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H$J\b\u0010\u0006\u001a\u00020\u0003H$J\u000f\u0010\u0007\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0003J\u0014\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/datasync/b;", "T", "", "", "e", "b", "c", "d", "()Ljava/lang/Object;", "g", "Lcom/tencent/qqnt/troopmemberlist/datasync/d;", "callback", h.F, "", "a", "I", "getPartCount", "()I", "setPartCount", "(I)V", "partCount", "Lcom/tencent/qqnt/troopmemberlist/datasync/d;", "dataReadyCallback", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile int partCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile d<T> dataReadyCallback;

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.partCount = i3;
        }
    }

    private final void e() {
        b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.datasync.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(b.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d<T> dVar = this$0.dataReadyCallback;
        if (dVar != 0) {
            dVar.a(this$0.d());
        }
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract T d();

    public final synchronized void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c();
        this.partCount--;
        if (this.partCount == 0) {
            e();
        }
    }

    public final void h(@NotNull d<T> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dataReadyCallback = callback;
        }
    }
}
