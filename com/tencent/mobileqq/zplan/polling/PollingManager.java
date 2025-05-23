package com.tencent.mobileqq.zplan.polling;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zplan.polling.task.TaskIdEnum;
import com.tencent.mobileqq.zplan.polling.task.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.Thread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/polling/PollingManager;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/zplan/polling/task/a;", "task", "", "intervalTime", "", "d", "f", "", "executeImmediately", "b", "Lcom/tencent/mobileqq/zplan/polling/task/TaskIdEnum;", "g", "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/mobileqq/zplan/polling/PollingHandlerThread;", "Lcom/tencent/mobileqq/zplan/polling/PollingHandlerThread;", "pollingHandler", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "dispatchHandler", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PollingManager implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy<PollingManager> f334925h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PollingHandlerThread pollingHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Handler dispatchHandler;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/polling/PollingManager$a;", "", "Lcom/tencent/mobileqq/zplan/polling/PollingManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/polling/PollingManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.polling.PollingManager$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PollingManager a() {
            return (PollingManager) PollingManager.f334925h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<PollingManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PollingManager>() { // from class: com.tencent.mobileqq.zplan.polling.PollingManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PollingManager invoke() {
                return new PollingManager(null);
            }
        });
        f334925h = lazy;
    }

    public /* synthetic */ PollingManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void d(a task, long intervalTime) {
        Message message = new Message();
        message.what = task.getTaskId().ordinal();
        message.obj = task;
        Handler handler = this.dispatchHandler;
        if (handler != null) {
            handler.sendMessageDelayed(message, intervalTime);
        }
    }

    private final void f() {
        if (this.dispatchHandler != null) {
            return;
        }
        if (this.pollingHandler.getState() != Thread.State.RUNNABLE) {
            this.pollingHandler.start();
            QLog.d("PollingManager", 1, "start thread");
        }
        Looper looper = this.pollingHandler.getLooper();
        Handler handler = looper != null ? new Handler(looper, this) : null;
        this.dispatchHandler = handler;
        QLog.d("PollingManager", 1, "dispatch Handler " + handler);
    }

    public final void b(a task, boolean executeImmediately) {
        Intrinsics.checkNotNullParameter(task, "task");
        f();
        Handler handler = this.dispatchHandler;
        boolean z16 = false;
        if (handler != null && handler.hasMessages(task.getTaskId().ordinal())) {
            z16 = true;
        }
        if (z16) {
            QLog.d("PollingManager", 1, "added task before " + task.getTaskId().ordinal());
            return;
        }
        if (task.a() <= 0) {
            QLog.e("PollingManager", 1, "illegal intervalTime " + task.a());
            return;
        }
        long a16 = executeImmediately ? 0L : task.a();
        d(task, a16);
        QLog.i("PollingManager", 1, "addPollingTask :: task == " + task.getTaskId().name() + " , interval == " + a16);
    }

    public final void g(TaskIdEnum task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Handler handler = this.dispatchHandler;
        if (handler != null) {
            handler.removeMessages(task.ordinal());
        }
        QLog.i("PollingManager", 1, "removePollIngTask :: task == " + task.name());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        if (!(obj instanceof a)) {
            QLog.e("PollingManager", 1, "obj must be IPollingTask " + msg2);
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.polling.task.IPollingTask");
        a aVar = (a) obj;
        aVar.b();
        if (aVar.c()) {
            g(aVar.getTaskId());
        } else {
            e(this, aVar, 0L, 2, null);
        }
        return true;
    }

    PollingManager() {
        this.pollingHandler = new PollingHandlerThread();
    }

    static /* synthetic */ void e(PollingManager pollingManager, a aVar, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = aVar.a();
        }
        pollingManager.d(aVar, j3);
    }

    public static /* synthetic */ void c(PollingManager pollingManager, a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        pollingManager.b(aVar, z16);
    }
}
