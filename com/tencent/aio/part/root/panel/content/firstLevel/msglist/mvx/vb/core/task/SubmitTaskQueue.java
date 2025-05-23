package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB'\u0012\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0002H\u0007R$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR/\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/SubmitTaskQueue;", "", "", "d", "c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/a;", "task", "b", "e", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "a", "Ljava/util/HashSet;", "runningTaskSet", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "pendingQueue", "Lkotlin/Function2;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function2;", "getSubmitAction", "()Lkotlin/jvm/functions/Function2;", "submitAction", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class SubmitTaskQueue {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashSet<a> runningTaskSet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<a> pendingQueue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<a, Function0<Unit>, Unit> submitAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/SubmitTaskQueue$a;", "", "", "RUNNING_LIMIT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.SubmitTaskQueue$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubmitTaskQueue(@NotNull Function2<? super a, ? super Function0<Unit>, Unit> submitAction) {
        Intrinsics.checkNotNullParameter(submitAction, "submitAction");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) submitAction);
            return;
        }
        this.submitAction = submitAction;
        this.runningTaskSet = new HashSet<>();
        this.pendingQueue = new LinkedList<>();
    }

    @MainThread
    private final void c() {
        Object obj;
        Iterator<T> it = this.runningTaskSet.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((a) obj).a()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("SubmitTaskQueue", "execTask but current running task is immediately");
                return;
            }
            return;
        }
        a peek = this.pendingQueue.peek();
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("SubmitTaskQueue", "execTask: taskSetSize: " + this.runningTaskSet.size());
        }
        if ((this.runningTaskSet.size() < 3 || (peek != null && peek.a())) && peek != null) {
            this.pendingQueue.pop();
            this.runningTaskSet.add(peek);
            this.submitAction.invoke(peek, new Function0<Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.SubmitTaskQueue$execTask$$inlined$let$lambda$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitTaskQueue.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        SubmitTaskQueue.this.d();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void d() {
        this.runningTaskSet.clear();
        if (!this.pendingQueue.isEmpty()) {
            c();
        }
    }

    @MainThread
    public final void b(@NotNull a task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.pendingQueue.isEmpty()) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("SubmitTaskQueue", "pendingQueue is Empty");
            }
            this.pendingQueue.add(task);
        } else {
            int i3 = 0;
            while ((!this.pendingQueue.isEmpty()) && !this.pendingQueue.peek().a()) {
                this.pendingQueue.pop();
                i3++;
            }
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("SubmitTaskQueue", "addTask and delete " + i3 + " task");
            }
            this.pendingQueue.add(task);
        }
        c();
    }

    @MainThread
    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.pendingQueue.clear();
            this.runningTaskSet.clear();
        }
    }
}
