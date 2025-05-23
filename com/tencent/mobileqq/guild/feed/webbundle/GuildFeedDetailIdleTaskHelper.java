package com.tencent.mobileqq.guild.feed.webbundle;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailIdleTaskHelper;", "", "Lcom/tencent/mobileqq/guild/feed/webbundle/u;", ISchemeApi.KEY_ENABLE_NEW_TASK, "", "i", "f", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "l", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "idleTasks", "b", "Z", "isIdleHandlerInQueue", "Landroid/os/MessageQueue$IdleHandler;", "c", "Landroid/os/MessageQueue$IdleHandler;", "idleHandler", "<init>", "()V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailIdleTaskHelper {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildFeedDetailIdleTaskHelper> f224070e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<u> idleTasks;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isIdleHandlerInQueue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MessageQueue.IdleHandler idleHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailIdleTaskHelper$a;", "", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailIdleTaskHelper;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/feed/webbundle/GuildFeedDetailIdleTaskHelper;", "sInstance", "", "RESULT_CONTINUE", "I", "RESULT_DONE_OK", "RESULT_DONE_UNNECESSARY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildFeedDetailIdleTaskHelper b() {
            return (GuildFeedDetailIdleTaskHelper) GuildFeedDetailIdleTaskHelper.f224070e.getValue();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedDetailIdleTaskHelper a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildFeedDetailIdleTaskHelper> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildFeedDetailIdleTaskHelper>() { // from class: com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedDetailIdleTaskHelper invoke() {
                return new GuildFeedDetailIdleTaskHelper(null);
            }
        });
        f224070e = lazy;
    }

    public /* synthetic */ GuildFeedDetailIdleTaskHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final GuildFeedDetailIdleTaskHelper this$0, final u newTask) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newTask, "$newTask");
        new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailIdleTaskHelper.h(GuildFeedDetailIdleTaskHelper.this, newTask);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildFeedDetailIdleTaskHelper this$0, u newTask) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newTask, "$newTask");
        this$0.i(newTask);
    }

    private final void i(u newTask) {
        CopyOnWriteArrayList<u> copyOnWriteArrayList = this.idleTasks;
        boolean z16 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((u) it.next()).getTaskId(), newTask.getTaskId())) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedDetailIdleTaskHelper", 2, "doAddIdleTask " + newTask.getTaskId() + ", isExist " + z16);
                return;
            }
            return;
        }
        this.idleTasks.add(newTask);
        if (!this.isIdleHandlerInQueue) {
            this.isIdleHandlerInQueue = true;
            Looper.myQueue().addIdleHandler(this.idleHandler);
        }
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedDetailIdleTaskHelper j() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(GuildFeedDetailIdleTaskHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (u uVar : this$0.idleTasks) {
            if (uVar.run() != 2) {
                this$0.idleTasks.remove(uVar);
            }
        }
        boolean z16 = !this$0.idleTasks.isEmpty();
        this$0.isIdleHandlerInQueue = z16;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final void f(@NotNull final u newTask) {
        Intrinsics.checkNotNullParameter(newTask, "newTask");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            i(newTask);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.webbundle.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedDetailIdleTaskHelper.g(GuildFeedDetailIdleTaskHelper.this, newTask);
                }
            });
        }
    }

    public final boolean l(@NotNull final String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        if (Build.VERSION.SDK_INT >= 24) {
            CopyOnWriteArrayList<u> copyOnWriteArrayList = this.idleTasks;
            final Function1<u, Boolean> function1 = new Function1<u, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper$removeIdleTask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(u uVar) {
                    return Boolean.valueOf(Intrinsics.areEqual(uVar.getTaskId(), taskId));
                }
            };
            copyOnWriteArrayList.removeIf(new Predicate() { // from class: com.tencent.mobileqq.guild.feed.webbundle.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean m3;
                    m3 = GuildFeedDetailIdleTaskHelper.m(Function1.this, obj);
                    return m3;
                }
            });
            return false;
        }
        u uVar = null;
        for (u uVar2 : this.idleTasks) {
            if (Intrinsics.areEqual(uVar2.getTaskId(), taskId)) {
                uVar = uVar2;
            }
        }
        if (uVar != null) {
            this.idleTasks.remove(uVar);
            return false;
        }
        return false;
    }

    GuildFeedDetailIdleTaskHelper() {
        this.idleTasks = new CopyOnWriteArrayList<>();
        this.idleHandler = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.guild.feed.webbundle.b
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean k3;
                k3 = GuildFeedDetailIdleTaskHelper.k(GuildFeedDetailIdleTaskHelper.this);
                return k3;
            }
        };
    }
}
