package com.tencent.mobileqq.activity.home.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/home/util/f;", "", "", "e", "Ljava/lang/Runnable;", "r", "b", "", "concurrentCount", "Lkotlin/Function0;", "onDoneTasks", "c", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "a", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "taskQueue", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentLinkedQueue<Runnable> taskQueue;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.taskQueue = new ConcurrentLinkedQueue<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(f this$0, AtomicInteger count, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(count, "$count");
        this$0.e();
        if (count.decrementAndGet() == 0 && function0 != null) {
            function0.invoke();
        }
    }

    private final void e() {
        while (true) {
            Runnable poll = this.taskQueue.poll();
            if (poll == null) {
                return;
            } else {
                poll.run();
            }
        }
    }

    public final void b(@NotNull Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) r16);
        } else {
            Intrinsics.checkNotNullParameter(r16, "r");
            this.taskQueue.add(r16);
        }
    }

    public final void c(int concurrentCount, @Nullable final Function0<Unit> onDoneTasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, concurrentCount, (Object) onDoneTasks);
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(concurrentCount);
        for (int i3 = 0; i3 < concurrentCount; i3++) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.d(f.this, atomicInteger, onDoneTasks);
                }
            }, 16, null, false);
        }
    }
}
