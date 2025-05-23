package com.tencent.kuikly.core.render.android.scheduler;

import android.os.Handler;
import android.os.Looper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.codegenmeta.utils.Constants;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010N\u001a\u00020L\u0012\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rj\u0004\u0018\u0001`O\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\u0004J,\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000eJ\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000eJ\u001c\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ\u0006\u0010 \u001a\u00020\u0004R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"RH\u0010+\u001a4\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00108\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00118\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105R$\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000e0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010C\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010DR\u0016\u0010F\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00105R\"\u0010J\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u00105\u001a\u0004\bG\u00107\"\u0004\bH\u0010IR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010MR\"\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rj\u0004\u0018\u0001`O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010-\u00a8\u0006S"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "Lcom/tencent/kuikly/core/render/android/scheduler/a;", "Lcom/tencent/kuikly/core/render/android/scheduler/c;", "task", "", h.F, HippyTKDListViewAdapter.X, "", Constants.Raft.TASKS, "t", "r", "", "delayMs", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "a", "l", "", "isUpdateViewTree", "u", "i", "Lcom/tencent/kuikly/core/render/android/f;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/kuikly/core/render/android/exception/a;", "y", "sync", "freezePerformTasks", "p", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Ljava/util/List;", "mainThreadTasksOnContextQueue", "b", "mainThreadTasks", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "c", "Lkotlin/jvm/functions/Function2;", "needSyncMainQueueTasksBlock", "d", "Lkotlin/jvm/functions/Function0;", "getMainThreadTaskWaitToSyncBlock", "()Lkotlin/jvm/functions/Function0;", "setMainThreadTaskWaitToSyncBlock", "(Lkotlin/jvm/functions/Function0;)V", "mainThreadTaskWaitToSyncBlock", "<set-?>", "e", "Z", "k", "()Z", "isPerformingMainQueueTask", "Landroid/os/Handler;", "f", "Lkotlin/Lazy;", "j", "()Landroid/os/Handler;", "uiHandler", "g", "viewDidLoad", "viewDidLoadMainThreadTasks", "Lcom/tencent/kuikly/core/render/android/f;", "viewTreeUpdateListener", "Lcom/tencent/kuikly/core/render/android/exception/a;", "exceptionListener", "isMarkViewDidLoad", "getLazyAfterFirstScreenUITasks", "w", "(Z)V", "lazyAfterFirstScreenUITasks", "afterFirstScreenLazyUITasks", "Lcom/tencent/kuikly/core/render/android/g;", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lcom/tencent/kuikly/core/render/android/scheduler/PreRunKuiklyRenderCoreTask;", "preRunKuiklyRenderCoreUITask", "<init>", "(Lcom/tencent/kuikly/core/render/android/g;Lkotlin/jvm/functions/Function0;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderCoreUIScheduler implements a {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<c> mainThreadTasksOnContextQueue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<c> mainThreadTasks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Boolean, ? super Boolean, Unit> needSyncMainQueueTasksBlock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> mainThreadTaskWaitToSyncBlock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPerformingMainQueueTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean viewDidLoad;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<Function0<Unit>> viewDidLoadMainThreadTasks;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private f viewTreeUpdateListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.exception.a exceptionListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isMarkViewDidLoad;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean lazyAfterFirstScreenUITasks;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<c> afterFirstScreenLazyUITasks;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final KuiklyContextParams contextParams;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> preRunKuiklyRenderCoreUITask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler$a;", "", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KuiklyRenderCoreUIScheduler(@NotNull KuiklyContextParams contextParams, @Nullable Function0<Unit> function0) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        this.contextParams = contextParams;
        this.preRunKuiklyRenderCoreUITask = function0;
        this.mainThreadTasks = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.uiHandler = lazy;
        this.viewDidLoadMainThreadTasks = new ArrayList();
        this.afterFirstScreenLazyUITasks = new ArrayList();
    }

    private final void h(final c task) {
        f fVar;
        KuiklyRenderThreadManager.f118203b.a(this.contextParams);
        if (this.contextParams.d()) {
            j().post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$addTaskToMainQueue$1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.a();
                }
            });
            return;
        }
        List list = this.mainThreadTasksOnContextQueue;
        if (list == null) {
            list = new ArrayList();
            this.mainThreadTasksOnContextQueue = list;
        }
        list.add(task);
        if (task.getIsUpdateViewTree() && (fVar = this.viewTreeUpdateListener) != null) {
            fVar.c();
        }
        x();
    }

    private final Handler j() {
        return (Handler) this.uiHandler.getValue();
    }

    public static /* synthetic */ void q(KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        kuiklyRenderCoreUIScheduler.p(z16, z17);
    }

    private final void r() {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$performViewDidLoadTasksIfNeed$block$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List list2;
                List list3;
                list = KuiklyRenderCoreUIScheduler.this.viewDidLoadMainThreadTasks;
                list2 = CollectionsKt___CollectionsKt.toList(list);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                list3 = KuiklyRenderCoreUIScheduler.this.viewDidLoadMainThreadTasks;
                list3.clear();
            }
        };
        if (this.isMarkViewDidLoad) {
            function0.invoke();
        } else {
            o(false, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$performViewDidLoadTasksIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0.this.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List<c> tasks) {
        f fVar;
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        if (tasks != null) {
            try {
            } catch (Exception e16) {
                com.tencent.kuikly.core.render.android.exception.a aVar = this.exceptionListener;
                if (aVar != null) {
                    aVar.b(e16, ErrorReason.UPDATE_VIEW_TREE);
                }
            }
            if (this.viewDidLoad && this.lazyAfterFirstScreenUITasks) {
                this.afterFirstScreenLazyUITasks.addAll(tasks);
                w.f392617a.c("runMainQueueTasks", "lazy task: " + this.afterFirstScreenLazyUITasks.size());
                return;
            }
            this.isPerformingMainQueueTask = true;
            for (c cVar : tasks) {
                cVar.a();
                if (cVar.getIsUpdateViewTree() && (fVar = this.viewTreeUpdateListener) != null) {
                    fVar.b();
                }
            }
            this.isPerformingMainQueueTask = false;
            this.isPerformingMainQueueTask = false;
            if (!this.viewDidLoad) {
                w.f392617a.c("runMainQueueTasks", "first screen tasks: " + Integer.valueOf(tasks.size()));
                this.viewDidLoad = true;
                r();
            }
        }
    }

    public static /* synthetic */ void v(KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler, long j3, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        kuiklyRenderCoreUIScheduler.u(j3, z16, function0);
    }

    private final void x() {
        if (this.needSyncMainQueueTasksBlock != null) {
            return;
        }
        this.needSyncMainQueueTasksBlock = new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$setNeedSyncMainQueueTasks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
            
                r3 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16, final boolean z17) {
                Function0 function0;
                final List list;
                List list2;
                List emptyList;
                function0 = KuiklyRenderCoreUIScheduler.this.preRunKuiklyRenderCoreUITask;
                if (function0 != null) {
                }
                list = KuiklyRenderCoreUIScheduler.this.mainThreadTasksOnContextQueue;
                KuiklyRenderCoreUIScheduler.this.mainThreadTasksOnContextQueue = null;
                synchronized (KuiklyRenderCoreUIScheduler.this) {
                    if (!z17) {
                        list2 = KuiklyRenderCoreUIScheduler.this.mainThreadTasks;
                        if (list == null || emptyList == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        list2.addAll(emptyList);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                KuiklyRenderCoreUIScheduler.this.o(z16, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$setNeedSyncMainQueueTasks$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        List list3;
                        List list4;
                        List list5;
                        if (!z17) {
                            synchronized (KuiklyRenderCoreUIScheduler.this) {
                                list4 = KuiklyRenderCoreUIScheduler.this.mainThreadTasks;
                                list3 = CollectionsKt___CollectionsKt.toList(list4);
                                list5 = KuiklyRenderCoreUIScheduler.this.mainThreadTasks;
                                list5.clear();
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } else {
                            list3 = list;
                        }
                        KuiklyRenderCoreUIScheduler.this.t(list3);
                    }
                });
            }
        };
        KuiklyRenderThreadManager.f118203b.g(this.contextParams, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$setNeedSyncMainQueueTasks$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                KuiklyRenderCoreUIScheduler.q(KuiklyRenderCoreUIScheduler.this, false, false, 2, null);
            }
        });
    }

    @Override // com.tencent.kuikly.core.render.android.scheduler.a
    public void a(long delayMs, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        u(delayMs, false, task);
    }

    public void i() {
        j().removeCallbacksAndMessages(null);
        this.exceptionListener = null;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsPerformingMainQueueTask() {
        return this.isPerformingMainQueueTask;
    }

    public final void l() {
        this.isMarkViewDidLoad = true;
    }

    public final void m() {
        if (this.afterFirstScreenLazyUITasks.isEmpty()) {
            this.lazyAfterFirstScreenUITasks = false;
            return;
        }
        w.f392617a.c("performAfterFirstScreenUITasks", "run lazy task: " + this.afterFirstScreenLazyUITasks.size());
        this.lazyAfterFirstScreenUITasks = false;
        t(this.afterFirstScreenLazyUITasks);
        this.afterFirstScreenLazyUITasks = new ArrayList();
    }

    public final void n() {
        Function0<Unit> function0 = this.mainThreadTaskWaitToSyncBlock;
        if (function0 != null) {
            if (function0 != null) {
                function0.invoke();
            }
            this.mainThreadTaskWaitToSyncBlock = null;
        }
    }

    public final void o(boolean sync, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (sync) {
            if (com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
                task.invoke();
                return;
            } else {
                this.mainThreadTaskWaitToSyncBlock = task;
                j().post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$performOnMainQueueWithTask$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KuiklyRenderCoreUIScheduler.this.n();
                    }
                });
                return;
            }
        }
        j().post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler$performOnMainQueueWithTask$2
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
    }

    public final void p(boolean sync, boolean freezePerformTasks) {
        KuiklyRenderThreadManager.f118203b.a(this.contextParams);
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this.needSyncMainQueueTasksBlock;
        if (function2 != null) {
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(sync), Boolean.valueOf(freezePerformTasks));
            }
            this.needSyncMainQueueTasksBlock = null;
        }
    }

    public final void s(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        if (!this.viewDidLoad && !this.isMarkViewDidLoad) {
            this.viewDidLoadMainThreadTasks.add(task);
        } else {
            task.invoke();
        }
    }

    public final void u(long delayMs, boolean isUpdateViewTree, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        h(new c(task, isUpdateViewTree));
    }

    public final void w(boolean z16) {
        this.lazyAfterFirstScreenUITasks = z16;
    }

    public final void y(@Nullable com.tencent.kuikly.core.render.android.exception.a listener) {
        this.exceptionListener = listener;
    }

    public final void z(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.viewTreeUpdateListener = listener;
    }
}
