package com.tencent.qqnt.inner;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R&\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00160\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/inner/k;", "", "", "c", "Lkotlin/Function0;", "task", "d", "e", "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "", "Z", "waiting", "", "Lcom/tencent/qqnt/inner/TroopSequentialTask;", "Ljava/util/List;", "waitingTask", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runWaitingTask", "<init>", "(Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean waiting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Function0<Unit>> waitingTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runWaitingTask;

    public k(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag);
            return;
        }
        this.tag = tag;
        this.handler = new Handler(ThreadManagerV2.getSubThreadLooper());
        this.waitingTask = new ArrayList();
        this.runWaitingTask = new Runnable() { // from class: com.tencent.qqnt.inner.i
            @Override // java.lang.Runnable
            public final void run() {
                k.f(k.this);
            }
        };
    }

    private final void c() {
        synchronized (this) {
            if (!this.waiting && (!this.waitingTask.isEmpty())) {
                this.waiting = true;
                this.handler.post(this.runWaitingTask);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(k this$0) {
        Object removeFirst;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0) {
            if (!this$0.waitingTask.isEmpty()) {
                removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(this$0.waitingTask);
                final Function0 function0 = (Function0) removeFirst;
                bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.g(Function0.this);
                    }
                });
            } else {
                this$0.waiting = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 firstTask) {
        Intrinsics.checkNotNullParameter(firstTask, "$firstTask");
        firstTask.invoke();
    }

    public final void d(@NotNull Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "execute: task.hashCode=" + task.hashCode());
        }
        synchronized (this) {
            this.waitingTask.add(task);
            c();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "finishTask: ");
        }
        synchronized (this) {
            this.waiting = false;
            c();
            Unit unit = Unit.INSTANCE;
        }
    }
}
