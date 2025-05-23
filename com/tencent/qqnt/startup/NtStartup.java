package com.tencent.qqnt.startup;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.startup.execption.StartupException;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u0000 '2\u00020\u0001:\u0002\b\u0005B!\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/startup/NtStartup;", "", "Lcom/tencent/qqnt/startup/task/NtTask;", "task", "", "b", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/startup/e;", "Lcom/tencent/qqnt/startup/e;", "taskConfig", "Lcom/tencent/qqnt/startup/d;", "Lcom/tencent/qqnt/startup/d;", "startupListener", "", "d", "Ljava/util/List;", "mTaskList", "Lcom/tencent/qqnt/startup/NtStartupDispatcher;", "e", "Lcom/tencent/qqnt/startup/NtStartupDispatcher;", "mTaskDispatcher", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "mRemainTaskCount", "Ljava/util/concurrent/CountDownLatch;", "g", "Ljava/util/concurrent/CountDownLatch;", "mAllTasksLatch", "", h.F, "J", "mLaunchTime", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/startup/e;Lcom/tencent/qqnt/startup/d;)V", "i", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class NtStartup {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e taskConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d startupListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<NtTask> mTaskList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NtStartupDispatcher mTaskDispatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AtomicInteger mRemainTaskCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch mAllTasksLatch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mLaunchTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/startup/NtStartup$a;", "", "Lcom/tencent/qqnt/startup/e;", DownloadInfo.spKey_Config, "c", "Lcom/tencent/qqnt/startup/d;", "listener", "a", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/startup/NtStartup;", "b", "Lcom/tencent/qqnt/startup/e;", "mTaskConfig", "Lcom/tencent/qqnt/startup/d;", "mStartupListener", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private e mTaskConfig;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private d mStartupListener;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final a a(@Nullable d listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            }
            this.mStartupListener = listener;
            return this;
        }

        @NotNull
        public final NtStartup b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NtStartup) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.mTaskConfig != null) {
                e eVar = this.mTaskConfig;
                Intrinsics.checkNotNull(eVar);
                return new NtStartup(context, eVar, this.mStartupListener);
            }
            throw new StartupException("Need to set taskConfig before build!");
        }

        @NotNull
        public final a c(@NotNull e config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            }
            Intrinsics.checkNotNullParameter(config, "config");
            this.mTaskConfig = config;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/startup/NtStartup$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.startup.NtStartup$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtStartup(@NotNull Context context, @NotNull e taskConfig, @Nullable d dVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, taskConfig, dVar);
            return;
        }
        this.context = context;
        this.taskConfig = taskConfig;
        this.startupListener = dVar;
        this.mTaskList = new ArrayList();
        this.mTaskDispatcher = new NtStartupDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(NtTask task) {
        CountDownLatch countDownLatch;
        if (task.blockUntilFinish() && (countDownLatch = this.mAllTasksLatch) != null) {
            countDownLatch.countDown();
        }
        List<NtTask> childNodes$nt_startup_kit_release = task.getChildNodes$nt_startup_kit_release();
        if (childNodes$nt_startup_kit_release != null) {
            Iterator<T> it = childNodes$nt_startup_kit_release.iterator();
            while (it.hasNext()) {
                ((NtTask) it.next()).onNotify();
            }
        }
        AtomicInteger atomicInteger = this.mRemainTaskCount;
        boolean z16 = false;
        if (atomicInteger != null && atomicInteger.decrementAndGet() == 0) {
            z16 = true;
        }
        if (z16) {
            com.tencent.qqnt.startup.utils.a.a("[NtStartup]", "finish!!! [" + this.taskConfig.a().b() + "] allTasks:" + this.mTaskList.size() + ", totalCost:" + (System.currentTimeMillis() - this.mLaunchTime));
            d dVar = this.startupListener;
            if (dVar != null) {
                dVar.onTasksComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        List listOf;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.qqnt.startup.utils.a.a("[NtStartup]", "start!!! [" + this.taskConfig.a().b() + "]");
        this.mLaunchTime = System.currentTimeMillis();
        List<com.tencent.qqnt.startup.parse.b> c16 = this.taskConfig.a().c();
        ArrayList<NtTask> arrayList = new ArrayList();
        for (com.tencent.qqnt.startup.parse.b bVar : c16) {
            NtTask createTask = this.taskConfig.b().createTask(bVar.c());
            ArrayList<String> dependencies = createTask.getDependencies();
            List<com.tencent.qqnt.startup.parse.b> b16 = bVar.b();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                arrayList2.add(((com.tencent.qqnt.startup.parse.b) it.next()).c());
            }
            dependencies.addAll(arrayList2);
            arrayList.add(createTask);
        }
        ArrayList arrayList3 = new ArrayList();
        for (NtTask ntTask : arrayList) {
            if (!(ntTask instanceof com.tencent.qqnt.startup.task.a)) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(ntTask);
            } else {
                ArrayList<String> dependencies2 = ntTask.getDependencies();
                com.tencent.qqnt.startup.task.a aVar = (com.tencent.qqnt.startup.task.a) ntTask;
                List<NtTask> a16 = aVar.a();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = a16.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(((NtTask) it5.next()).getTaskId());
                }
                dependencies2.addAll(arrayList4);
                listOf = CollectionsKt___CollectionsKt.plus((Collection<? extends NtTask>) ((Collection<? extends Object>) aVar.a()), ntTask);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, listOf);
        }
        this.mTaskList.addAll(arrayList3);
        List<NtTask> list = this.mTaskList;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : list) {
            if (((NtTask) obj).blockUntilFinish()) {
                arrayList5.add(obj);
            }
        }
        int size = arrayList5.size();
        if (size > 0) {
            this.mAllTasksLatch = new CountDownLatch(size);
        }
        List<NtTask> f16 = com.tencent.qqnt.startup.utils.c.f362283a.f(this.mTaskList);
        this.mRemainTaskCount = new AtomicInteger(f16.size());
        Iterator<T> it6 = f16.iterator();
        while (it6.hasNext()) {
            this.mTaskDispatcher.b(this.context, (NtTask) it6.next(), new Function1<NtTask, Unit>() { // from class: com.tencent.qqnt.startup.NtStartup$start$4$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtStartup.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NtTask ntTask2) {
                    invoke2(ntTask2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull NtTask it7) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it7);
                    } else {
                        Intrinsics.checkNotNullParameter(it7, "it");
                        NtStartup.this.b(it7);
                    }
                }
            });
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            CountDownLatch countDownLatch = this.mAllTasksLatch;
            if (countDownLatch != null) {
                countDownLatch.await();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.qqnt.startup.utils.a.a("[NtStartup]", "end block!!! [" + this.taskConfig.a().b() + "] blockTasks:" + size + ", waitCost:" + (currentTimeMillis2 - currentTimeMillis) + ", totalCost:" + (currentTimeMillis2 - this.mLaunchTime));
        } catch (Exception e16) {
            com.tencent.qqnt.startup.utils.a.f362281a.b("[NtStartup]", "", e16);
        }
    }
}
