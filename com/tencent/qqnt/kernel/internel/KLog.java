package com.tencent.qqnt.kernel.internel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J;\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u0001H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ9\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ9\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\r\u0010\fJ9\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000e\u0010\fJ9\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\fJ9\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/internel/KLog;", "", "", "subTag", "", "seq", "", "msg", "j", "(Ljava/lang/String;Ljava/lang/Integer;[Ljava/lang/Object;)Ljava/lang/String;", "", h.F, "(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Integer;)V", "d", "k", "f", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCurSeq", "()Ljava/util/concurrent/atomic/AtomicInteger;", "curSeq", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KLog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final KLog f359087a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger curSeq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f359087a = new KLog();
            curSeq = new AtomicInteger(0);
        }
    }

    KLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(KLog kLog, String str, Object[] objArr, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        kLog.b(str, objArr, num);
    }

    public static /* synthetic */ void e(KLog kLog, String str, Object[] objArr, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        kLog.d(str, objArr, num);
    }

    public static /* synthetic */ void g(KLog kLog, String str, Object[] objArr, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        kLog.f(str, objArr, num);
    }

    public static /* synthetic */ void i(KLog kLog, String str, Object[] objArr, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        kLog.h(str, objArr, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(String subTag, Integer seq, Object... msg2) {
        int incrementAndGet;
        String joinToString$default;
        if (seq != null) {
            incrementAndGet = seq.intValue();
        } else {
            incrementAndGet = curSeq.incrementAndGet();
        }
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(msg2, (CharSequence) null, "[" + subTag + "]seq(" + incrementAndGet + ")---- ", (CharSequence) null, 0, (CharSequence) null, KLog$joinLogString$1.INSTANCE, 29, (Object) null);
        return joinToString$default;
    }

    public final void b(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, subTag, msg2, seq);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("NTKernel", 2, f359087a.j(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }

    public final void d(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, subTag, msg2, seq);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isDevelopLevel()) {
            QLog.d("NTKernel", 4, f359087a.j(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }

    public final void f(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, subTag, msg2, seq);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("NTKernel", 1, f359087a.j(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }

    public final void h(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, subTag, msg2, seq);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("NTKernel", 1, f359087a.j(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }

    public final void k(@Nullable String subTag, @NotNull Object[] msg2, @Nullable Integer seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, subTag, msg2, seq);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.w("NTKernel", 1, f359087a.j(subTag, seq, Arrays.copyOf(msg2, msg2.length)));
        }
    }
}
