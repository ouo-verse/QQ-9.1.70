package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.HandlerRecycleThreadPoolExecutor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0006\n !\"#\u000bB\u001f\b\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor;", "Lcom/tencent/mobileqq/app/bd;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "l", "Landroid/os/Handler$Callback;", "callback", "Lcom/tencent/mobileqq/app/bc;", "a", "b", "", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "threadName", "I", "getPriority", "()I", "priority", "Ljava/util/concurrent/ThreadPoolExecutor;", "c", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "d", "atFrontPriorityIndex", "e", "normalPriorityIndex", "<init>", "(Ljava/lang/String;I)V", "f", "HandlerSingleThreadMessageRunnable", "HandlerSingleThreadRunnable", "MessageRunnable", "PriorityTask", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class HandlerRecycleThreadPoolExecutor implements bd {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static final HandlerThread f194724g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String threadName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int priority;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThreadPoolExecutor executor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int atFrontPriorityIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int normalPriorityIndex;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "d", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "getQqHandlerImpl", "()Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "qqHandlerImpl", "", "e", "Z", "isAtFrontOfQueueRunnable", "()Z", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "f", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "()Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "setJob", "(Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;)V", "job", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$HandlerSingleThreadRunnable;", "singleThreadRunnable", "<init>", "(Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$HandlerSingleThreadRunnable;Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;Z)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static class MessageRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b qqHandlerImpl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isAtFrontOfQueueRunnable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private PriorityTask job;

        public MessageRunnable(@NotNull HandlerSingleThreadRunnable singleThreadRunnable, @NotNull b qqHandlerImpl, boolean z16) {
            Intrinsics.checkNotNullParameter(singleThreadRunnable, "singleThreadRunnable");
            Intrinsics.checkNotNullParameter(qqHandlerImpl, "qqHandlerImpl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, singleThreadRunnable, qqHandlerImpl, Boolean.valueOf(z16));
                return;
            }
            this.qqHandlerImpl = qqHandlerImpl;
            this.isAtFrontOfQueueRunnable = z16;
            this.job = new PriorityTask(512, singleThreadRunnable, false);
        }

        @Nullable
        public final PriorityTask e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PriorityTask) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.job;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            PriorityTask priorityTask = this.job;
            if (priorityTask != null) {
                priorityTask.i(this.isAtFrontOfQueueRunnable ? this.qqHandlerImpl.o().j() : this.qqHandlerImpl.o().l());
            }
            this.qqHandlerImpl.o().executor.execute(this.job);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "Lcom/tencent/mobileqq/app/Job;", "", "d", "I", tl.h.F, "()I", "i", "(I)V", "priorityTask", "", "key", "Ljava/lang/Runnable;", "job", "", "canAutoRetrieve", "<init>", "(Ljava/lang/Object;Ljava/lang/Runnable;Z)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class PriorityTask extends Job {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int priorityTask;

        public PriorityTask(@Nullable Object obj, @Nullable Runnable runnable, boolean z16) {
            super(obj, runnable, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, runnable, Boolean.valueOf(z16));
            }
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.priorityTask;
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.priorityTask = i3;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$a;", "", "", "CAFE", "Ljava/lang/String;", "", "DEFAULT_KEEP_ALIVE", "I", "MESSAGE_AT_FRONT_OF_QUEUE", "TAG", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "handlerThread", "Landroid/os/HandlerThread;", "<init>", "()V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.HandlerRecycleThreadPoolExecutor$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010.\u001a\u00020*\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\u001a\u0010$\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J*\u0010$\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b,\u0010-R\u0019\u00102\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00104R+\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010807068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b:\u0010;R+\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010=07068\u0006\u00a2\u0006\f\n\u0004\b%\u00109\u001a\u0004\b>\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "Lcom/tencent/mobileqq/app/bc;", "Landroid/os/Handler$Callback;", "Ljava/lang/Runnable;", "runnable", "", "delayMs", "", ReportConstant.COSTREPORT_PREFIX, "", "isAtFrontOfQueueRunnable", "Landroid/os/Message;", "k", Method.POST, "p", "postDelayed", "", "what", "sendEmptyMessage", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "message", tl.h.F, "r", "", "obj", "a", "g", "e", "c", "f", "d", "removeMessages", "removeAll", "removeCallbacksAndMessages", "j", "obtainMessage", "i", "arg1", "arg2", "msg", "handleMessage", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor;", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor;", "o", "()Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor;", "singleThreadPoolExecute", "Landroid/os/Handler$Callback;", "l", "()Landroid/os/Handler$Callback;", "callback", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;", "Ljava/util/concurrent/ConcurrentHashMap;", DomainData.DOMAIN_NAME, "()Ljava/util/concurrent/ConcurrentHashMap;", "runnableConcurrentHashMap", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgConcurrentHashMap", "<init>", "(Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor;Landroid/os/Handler$Callback;)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements bc, Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HandlerRecycleThreadPoolExecutor singleThreadPoolExecute;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Handler.Callback callback;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler handler;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConcurrentHashMap<Runnable, ConcurrentLinkedQueue<MessageRunnable>> runnableConcurrentHashMap;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<PriorityTask>> msgConcurrentHashMap;

        public b(@NotNull HandlerRecycleThreadPoolExecutor singleThreadPoolExecute, @Nullable Handler.Callback callback) {
            Intrinsics.checkNotNullParameter(singleThreadPoolExecute, "singleThreadPoolExecute");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) singleThreadPoolExecute, (Object) callback);
                return;
            }
            this.singleThreadPoolExecute = singleThreadPoolExecute;
            this.callback = callback;
            this.handler = new Handler(HandlerRecycleThreadPoolExecutor.f194724g.getLooper(), this);
            this.runnableConcurrentHashMap = new ConcurrentHashMap<>();
            this.msgConcurrentHashMap = new ConcurrentHashMap<>();
        }

        private final Message k(Runnable runnable, boolean isAtFrontOfQueueRunnable) {
            HandlerSingleThreadRunnable handlerSingleThreadRunnable = new HandlerSingleThreadRunnable(runnable, this, null, 4, null);
            MessageRunnable messageRunnable = new MessageRunnable(handlerSingleThreadRunnable, this, isAtFrontOfQueueRunnable);
            handlerSingleThreadRunnable.a(messageRunnable);
            Message message = Message.obtain(this.handler, messageRunnable);
            if (this.runnableConcurrentHashMap.contains(runnable)) {
                ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue = this.runnableConcurrentHashMap.get(runnable);
                if (concurrentLinkedQueue != null) {
                    concurrentLinkedQueue.add(messageRunnable);
                }
            } else {
                ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue2 = new ConcurrentLinkedQueue<>();
                concurrentLinkedQueue2.add(messageRunnable);
                this.runnableConcurrentHashMap.put(runnable, concurrentLinkedQueue2);
            }
            Intrinsics.checkNotNullExpressionValue(message, "message");
            return message;
        }

        private final void s(Runnable runnable, long delayMs) {
            this.handler.sendMessageDelayed(k(runnable, false), delayMs);
        }

        @Override // com.tencent.mobileqq.app.bc
        public void a(int what, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, what, obj);
            } else {
                g(what, obj, 0L);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void b(int what, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Integer.valueOf(what), Long.valueOf(delayMs));
            } else {
                r(what, delayMs);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public boolean c(int what) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, what)).booleanValue();
            }
            if (this.handler.hasMessages(what)) {
                return true;
            }
            if (this.msgConcurrentHashMap.get(Integer.valueOf(what)) != null) {
                ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue = this.msgConcurrentHashMap.get(Integer.valueOf(what));
                if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.bc
        public void d(@NotNull Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) runnable);
                return;
            }
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue = this.runnableConcurrentHashMap.get(runnable);
            if (concurrentLinkedQueue != null) {
                for (MessageRunnable messageRunnable : concurrentLinkedQueue) {
                    if (messageRunnable != null) {
                        this.handler.removeCallbacks(messageRunnable);
                        this.singleThreadPoolExecute.executor.remove(messageRunnable.e());
                    }
                }
            }
            this.runnableConcurrentHashMap.remove(runnable);
        }

        @Override // com.tencent.mobileqq.app.bc
        public void e(@NotNull Message message, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, message, Long.valueOf(delayMs));
            } else {
                Intrinsics.checkNotNullParameter(message, "message");
                this.handler.sendMessageDelayed(message, delayMs);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void f(@NotNull Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) runnable);
                return;
            }
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue = this.runnableConcurrentHashMap.get(runnable);
            if (concurrentLinkedQueue != null) {
                for (MessageRunnable messageRunnable : concurrentLinkedQueue) {
                    if (messageRunnable != null) {
                        this.handler.removeCallbacks(messageRunnable);
                        this.singleThreadPoolExecute.executor.remove(messageRunnable.e());
                    }
                }
            }
            this.runnableConcurrentHashMap.remove(runnable);
        }

        @Override // com.tencent.mobileqq.app.bc
        public void g(int what, @Nullable Object obj, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Integer.valueOf(what), obj, Long.valueOf(delayMs));
            } else {
                this.handler.sendMessageDelayed(Message.obtain(this.handler, what, obj), delayMs);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void h(@NotNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) message);
            } else {
                Intrinsics.checkNotNullParameter(message, "message");
                this.handler.sendMessageDelayed(message, 0L);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) msg2)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Message newMsg = Message.obtain(msg2);
            Intrinsics.checkNotNullExpressionValue(newMsg, "newMsg");
            HandlerSingleThreadMessageRunnable handlerSingleThreadMessageRunnable = new HandlerSingleThreadMessageRunnable(newMsg, this, null, 4, null);
            PriorityTask priorityTask = new PriorityTask(512, handlerSingleThreadMessageRunnable, false);
            handlerSingleThreadMessageRunnable.a(priorityTask);
            priorityTask.i(newMsg.arg1 == 999 ? this.singleThreadPoolExecute.j() : this.singleThreadPoolExecute.l());
            if (this.msgConcurrentHashMap.contains(Integer.valueOf(newMsg.what))) {
                ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue = this.msgConcurrentHashMap.get(Integer.valueOf(newMsg.what));
                if (concurrentLinkedQueue != null) {
                    concurrentLinkedQueue.add(priorityTask);
                }
            } else {
                ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue2 = new ConcurrentLinkedQueue<>();
                concurrentLinkedQueue2.add(priorityTask);
                this.msgConcurrentHashMap.put(Integer.valueOf(newMsg.what), concurrentLinkedQueue2);
            }
            this.singleThreadPoolExecute.executor.execute(priorityTask);
            return false;
        }

        @Override // com.tencent.mobileqq.app.bc
        @NotNull
        public Message i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (Message) iPatchRedirector.redirect((short) 29, (Object) this);
            }
            Message obtainMessage = this.handler.obtainMessage();
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage()");
            return obtainMessage;
        }

        @Override // com.tencent.mobileqq.app.bc
        public boolean j() {
            List split$default;
            boolean equals$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
            }
            String curThreadName = Thread.currentThread().getName();
            Intrinsics.checkNotNullExpressionValue(curThreadName, "curThreadName");
            split$default = StringsKt__StringsKt.split$default((CharSequence) curThreadName, new String[]{"cafe"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                equals$default = StringsKt__StringsJVMKt.equals$default(this.singleThreadPoolExecute.k(), (String) it.next(), false, 2, null);
                if (equals$default) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public final Handler.Callback l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Handler.Callback) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.callback;
        }

        @NotNull
        public final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<PriorityTask>> m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.msgConcurrentHashMap;
        }

        @NotNull
        public final ConcurrentHashMap<Runnable, ConcurrentLinkedQueue<MessageRunnable>> n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.runnableConcurrentHashMap;
        }

        @NotNull
        public final HandlerRecycleThreadPoolExecutor o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HandlerRecycleThreadPoolExecutor) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.singleThreadPoolExecute;
        }

        @Override // com.tencent.mobileqq.app.bc
        @NotNull
        public Message obtainMessage(int what, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (Message) iPatchRedirector.redirect((short) 28, (Object) this, what, obj);
            }
            Message obtainMessage = this.handler.obtainMessage(what, obj);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(what, obj)");
            return obtainMessage;
        }

        public void p(@NotNull Runnable runnable, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, runnable, Long.valueOf(delayMs));
            } else {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                s(runnable, delayMs);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void post(@NotNull Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable);
            } else {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                p(runnable, 0L);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void postDelayed(@NotNull Runnable runnable, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, runnable, Long.valueOf(delayMs));
            } else {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                p(runnable, delayMs);
            }
        }

        public void q(int what) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, what);
            } else {
                r(what, 0L);
            }
        }

        public void r(int what, long delayMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Integer.valueOf(what), Long.valueOf(delayMs));
            } else {
                g(what, null, delayMs);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void removeAll() {
            PriorityTask priorityTask;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this);
                return;
            }
            this.handler.removeCallbacksAndMessages(null);
            Iterator<Map.Entry<Integer, ConcurrentLinkedQueue<PriorityTask>>> it = this.msgConcurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<T> it5 = it.next().getValue().iterator();
                while (it5.hasNext()) {
                    this.singleThreadPoolExecute.executor.remove((PriorityTask) it5.next());
                }
            }
            Iterator<Map.Entry<Runnable, ConcurrentLinkedQueue<MessageRunnable>>> it6 = this.runnableConcurrentHashMap.entrySet().iterator();
            while (it6.hasNext()) {
                for (MessageRunnable messageRunnable : it6.next().getValue()) {
                    ThreadPoolExecutor threadPoolExecutor = this.singleThreadPoolExecute.executor;
                    if (messageRunnable != null) {
                        priorityTask = messageRunnable.e();
                    } else {
                        priorityTask = null;
                    }
                    threadPoolExecutor.remove(priorityTask);
                }
            }
            this.msgConcurrentHashMap.clear();
            this.runnableConcurrentHashMap.clear();
        }

        @Override // com.tencent.mobileqq.app.bc
        public void removeCallbacksAndMessages(@Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, obj);
            } else if (obj == null) {
                removeAll();
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        public void removeMessages(int what) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, what);
                return;
            }
            this.handler.removeMessages(what);
            ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue = this.msgConcurrentHashMap.get(Integer.valueOf(what));
            if (concurrentLinkedQueue != null) {
                Iterator<T> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    this.singleThreadPoolExecute.executor.remove((PriorityTask) it.next());
                }
            }
            this.msgConcurrentHashMap.remove(Integer.valueOf(what));
        }

        @Override // com.tencent.mobileqq.app.bc
        public void sendEmptyMessage(int what) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, what);
            } else {
                q(what);
            }
        }

        @Override // com.tencent.mobileqq.app.bc
        @NotNull
        public Message obtainMessage(int what) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (Message) iPatchRedirector.redirect((short) 30, (Object) this, what);
            }
            Message obtainMessage = this.handler.obtainMessage(what);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(what)");
            return obtainMessage;
        }

        @Override // com.tencent.mobileqq.app.bc
        @NotNull
        public Message obtainMessage(int what, int arg1, int arg2, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (Message) iPatchRedirector.redirect((short) 31, this, Integer.valueOf(what), Integer.valueOf(arg1), Integer.valueOf(arg2), obj);
            }
            Message obtainMessage = this.handler.obtainMessage(what, arg1, arg2, obj);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(what, arg1, arg2, obj)");
            return obtainMessage;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("HandlerSingleThreadPoolExecutor", -8);
        newFreeHandlerThread.start();
        f194724g = newFreeHandlerThread;
    }

    @JvmOverloads
    public HandlerRecycleThreadPoolExecutor() {
        this(null, 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(PriorityTask priorityTask, PriorityTask priorityTask2) {
        return priorityTask.h() - priorityTask2.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        int i3 = this.atFrontPriorityIndex;
        this.atFrontPriorityIndex = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l() {
        int i3 = this.normalPriorityIndex;
        this.normalPriorityIndex = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (this.executor.getQueue().size() == 0) {
            this.atFrontPriorityIndex = 1;
            this.normalPriorityIndex = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
    }

    @Override // com.tencent.mobileqq.app.bd
    @NotNull
    public bc a(@Nullable Handler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (bc) iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        }
        return new b(this, callback);
    }

    @Override // com.tencent.mobileqq.app.bd
    @NotNull
    public bc b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (bc) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return a(null);
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.threadName;
    }

    @JvmOverloads
    public HandlerRecycleThreadPoolExecutor(@Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.threadName = str;
        this.priority = i3;
        ThreadPoolParams threadPoolParams = new ThreadPoolParams();
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(11, new Comparator() { // from class: com.tencent.mobileqq.app.aw
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d16;
                d16 = HandlerRecycleThreadPoolExecutor.d((HandlerRecycleThreadPoolExecutor.PriorityTask) obj, (HandlerRecycleThreadPoolExecutor.PriorityTask) obj2);
                return d16;
            }
        });
        threadPoolParams.poolThreadName = "cafe" + str + "cafe";
        threadPoolParams.corePoolsize = 1;
        threadPoolParams.maxPooolSize = 1;
        threadPoolParams.priority = i3;
        threadPoolParams.queue = priorityBlockingQueue;
        threadPoolParams.keepAliveTime = 30;
        Executor newFreeThreadPool = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
        Intrinsics.checkNotNull(newFreeThreadPool, "null cannot be cast to non-null type java.util.concurrent.ThreadPoolExecutor");
        this.executor = (ThreadPoolExecutor) newFreeThreadPool;
        this.atFrontPriorityIndex = 1;
        this.normalPriorityIndex = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$HandlerSingleThreadMessageRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Landroid/os/Message;", "d", "Landroid/os/Message;", "realMessage", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "e", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "qqHandlerImpl", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "f", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "getJob", "()Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;", "a", "(Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;)V", "job", "<init>", "(Landroid/os/Message;Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$PriorityTask;)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class HandlerSingleThreadMessageRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Message realMessage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b qqHandlerImpl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private PriorityTask job;

        public HandlerSingleThreadMessageRunnable(@NotNull Message realMessage, @NotNull b qqHandlerImpl, @Nullable PriorityTask priorityTask) {
            Intrinsics.checkNotNullParameter(realMessage, "realMessage");
            Intrinsics.checkNotNullParameter(qqHandlerImpl, "qqHandlerImpl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, realMessage, qqHandlerImpl, priorityTask);
                return;
            }
            this.realMessage = realMessage;
            this.qqHandlerImpl = qqHandlerImpl;
            this.job = priorityTask;
        }

        public final void a(@Nullable PriorityTask priorityTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) priorityTask);
            } else {
                this.job = priorityTask;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue = this.qqHandlerImpl.m().get(Integer.valueOf(this.realMessage.what));
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.remove(this.job);
            }
            ConcurrentLinkedQueue<PriorityTask> concurrentLinkedQueue2 = this.qqHandlerImpl.m().get(Integer.valueOf(this.realMessage.what));
            boolean z16 = false;
            if (concurrentLinkedQueue2 != null && concurrentLinkedQueue2.size() == 0) {
                z16 = true;
            }
            if (z16) {
                this.qqHandlerImpl.m().remove(Integer.valueOf(this.realMessage.what));
            }
            if (this.qqHandlerImpl.l() != null) {
                this.qqHandlerImpl.l().handleMessage(this.realMessage);
            }
            this.realMessage.recycle();
            this.qqHandlerImpl.o().m();
        }

        public /* synthetic */ HandlerSingleThreadMessageRunnable(Message message, b bVar, PriorityTask priorityTask, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(message, bVar, (i3 & 4) != 0 ? null : priorityTask);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, message, bVar, priorityTask, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$HandlerSingleThreadRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "d", "Ljava/lang/Runnable;", "getRealRunnable", "()Ljava/lang/Runnable;", "realRunnable", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "e", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;", "qqHandlerImpl", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;", "f", "Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;", "getMessageRunnable", "()Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;", "a", "(Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;)V", "messageRunnable", "<init>", "(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$b;Lcom/tencent/mobileqq/app/HandlerRecycleThreadPoolExecutor$MessageRunnable;)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class HandlerSingleThreadRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable realRunnable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b qqHandlerImpl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MessageRunnable messageRunnable;

        public HandlerSingleThreadRunnable(@NotNull Runnable realRunnable, @NotNull b qqHandlerImpl, @Nullable MessageRunnable messageRunnable) {
            Intrinsics.checkNotNullParameter(realRunnable, "realRunnable");
            Intrinsics.checkNotNullParameter(qqHandlerImpl, "qqHandlerImpl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, realRunnable, qqHandlerImpl, messageRunnable);
                return;
            }
            this.realRunnable = realRunnable;
            this.qqHandlerImpl = qqHandlerImpl;
            this.messageRunnable = messageRunnable;
        }

        public final void a(@Nullable MessageRunnable messageRunnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRunnable);
            } else {
                this.messageRunnable = messageRunnable;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue = this.qqHandlerImpl.n().get(this.realRunnable);
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.remove(this.messageRunnable);
            }
            ConcurrentLinkedQueue<MessageRunnable> concurrentLinkedQueue2 = this.qqHandlerImpl.n().get(this.realRunnable);
            boolean z16 = false;
            if (concurrentLinkedQueue2 != null && concurrentLinkedQueue2.size() == 0) {
                z16 = true;
            }
            if (z16) {
                this.qqHandlerImpl.n().remove(this.realRunnable);
            }
            this.realRunnable.run();
            this.qqHandlerImpl.o().m();
        }

        public /* synthetic */ HandlerSingleThreadRunnable(Runnable runnable, b bVar, MessageRunnable messageRunnable, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(runnable, bVar, (i3 & 4) != 0 ? null : messageRunnable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, runnable, bVar, messageRunnable, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    public /* synthetic */ HandlerRecycleThreadPoolExecutor(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "HandlerSingleThreadPoolExecutor" : str, (i16 & 2) != 0 ? 5 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
