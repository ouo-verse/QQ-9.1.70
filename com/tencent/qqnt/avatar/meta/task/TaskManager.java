package com.tencent.qqnt.avatar.meta.task;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.avatar.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001\u0015BK\u0012\u0006\u0010;\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010&\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\r0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "Lwv3/a;", "Lcom/tencent/qqnt/avatar/meta/task/RunnableTask;", "runnableTask", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/avatar/meta/task/a;", "task", "t", "w", "v", "(Lcom/tencent/qqnt/avatar/meta/task/RunnableTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "", "key", "r", "", "forceRefresh", "o", ReportConstant.COSTREPORT_PREFIX, "b", "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mScope", "", "I", "mConcurrentCount", "", "c", "J", "mTimeOut", "d", "mMaxWaitingCount", "e", "mMaxRunningCount", "f", "Z", "mUseThreadPool", "Lkotlin/collections/ArrayDeque;", "g", "Lkotlin/collections/ArrayDeque;", "mWaitingQueue", "", h.F, "Ljava/util/List;", "mRunningQueue", "", "i", "Ljava/util/Set;", "mPendingSet", "", "Lkotlinx/coroutines/Job;", "j", "Ljava/util/Map;", "mJobMap", "k", "Ljava/lang/String;", "TAG", "tag", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;IJIIZ)V", "l", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TaskManager implements wv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope mScope;

    /* renamed from: b, reason: from kotlin metadata */
    private final int mConcurrentCount;

    /* renamed from: c, reason: from kotlin metadata */
    private long mTimeOut;

    /* renamed from: d, reason: from kotlin metadata */
    private int mMaxWaitingCount;

    /* renamed from: e, reason: from kotlin metadata */
    private int mMaxRunningCount;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean mUseThreadPool;

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    private final ArrayDeque<RunnableTask> mWaitingQueue;

    /* renamed from: h */
    @NotNull
    private final List<RunnableTask> mRunningQueue;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final Set<String> mPendingSet;

    /* renamed from: j, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Job> mJobMap;

    /* renamed from: k, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/task/TaskManager$a;", "", "", "DEFAULT_CONCURRENT_COUNT", "I", "MAX_RUNNING_COUNT", "MAX_WAITING_COUNT", "", "TIME_OUT", "J", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.task.TaskManager$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40532);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TaskManager(@NotNull String tag, @NotNull CoroutineScope mScope, int i3, long j3, int i16, int i17, boolean z16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mScope, "mScope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tag, mScope, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        this.mScope = mScope;
        this.mConcurrentCount = i3;
        this.mTimeOut = j3;
        this.mMaxWaitingCount = i16;
        this.mMaxRunningCount = i17;
        this.mUseThreadPool = z16;
        this.mWaitingQueue = new ArrayDeque<>();
        this.mRunningQueue = new ArrayList();
        this.mPendingSet = new LinkedHashSet();
        this.mJobMap = new LinkedHashMap();
        this.TAG = "TaskManager_" + tag;
    }

    public static /* synthetic */ void p(TaskManager taskManager, a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        taskManager.o(aVar, z16);
    }

    public final void q(RunnableTask runnableTask) {
        if (this.mWaitingQueue.size() >= this.mMaxWaitingCount) {
            this.mWaitingQueue.removeFirst().e(new b(false, null));
        }
        this.mWaitingQueue.add(runnableTask);
    }

    public final void r(String key) {
        try {
            Job job = this.mJobMap.get(key);
            if (job != null) {
                JobKt__JobKt.cancel$default(job, "cancelJob " + key, null, 2, null);
            }
            d.f352991a.a(this.TAG, new Function0<String>(key) { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$cancelJob$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $key;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "cancelJob " + this.$key;
                }
            });
        } catch (CancellationException e16) {
            d.f352991a.a(this.TAG, new Function0<String>(e16) { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$cancelJob$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellationException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "CancellationException:" + this.$e;
                }
            });
        }
    }

    public final RunnableTask t(a task) {
        Object obj;
        Iterator<T> it = this.mRunningQueue.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RunnableTask) obj).c(), task.a())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RunnableTask runnableTask = (RunnableTask) obj;
        if (runnableTask == null) {
            return null;
        }
        d.f352991a.b(this.TAG, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$findRunningTask$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "findRunningTask " + a.this.a();
            }
        });
        return runnableTask;
    }

    public final void u(RunnableTask runnableTask) {
        this.mRunningQueue.remove(runnableTask);
        this.mJobMap.remove(runnableTask.c());
        this.mPendingSet.remove(runnableTask.c());
        w();
        d.f352991a.b(this.TAG, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$removeFromRunningQueue$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableTask.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "removeFromRunningQueue :" + RunnableTask.this.c();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v(RunnableTask runnableTask, Continuation<? super Unit> continuation) {
        TaskManager$startTask$1 taskManager$startTask$1;
        Object coroutine_suspended;
        int i3;
        TaskManager taskManager;
        if (continuation instanceof TaskManager$startTask$1) {
            taskManager$startTask$1 = (TaskManager$startTask$1) continuation;
            int i16 = taskManager$startTask$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                taskManager$startTask$1.label = i16 - Integer.MIN_VALUE;
                Object obj = taskManager$startTask$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = taskManager$startTask$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        runnableTask = (RunnableTask) taskManager$startTask$1.L$1;
                        taskManager = (TaskManager) taskManager$startTask$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    long j3 = this.mTimeOut;
                    TaskManager$startTask$result$1 taskManager$startTask$result$1 = new TaskManager$startTask$result$1(this, runnableTask, null);
                    taskManager$startTask$1.L$0 = this;
                    taskManager$startTask$1.L$1 = runnableTask;
                    taskManager$startTask$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(j3, taskManager$startTask$result$1, taskManager$startTask$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    taskManager = this;
                }
                BuildersKt__Builders_commonKt.launch$default(taskManager.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$startTask$2((b) obj, taskManager, runnableTask, null), 2, null);
                return Unit.INSTANCE;
            }
        }
        taskManager$startTask$1 = new TaskManager$startTask$1(this, continuation);
        Object obj2 = taskManager$startTask$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = taskManager$startTask$1.label;
        if (i3 == 0) {
        }
        BuildersKt__Builders_commonKt.launch$default(taskManager.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$startTask$2((b) obj2, taskManager, runnableTask, null), 2, null);
        return Unit.INSTANCE;
    }

    public final void w() {
        RunnableTask removeLastOrNull;
        CoroutineContext coroutineContext;
        Job launch$default;
        d dVar = d.f352991a;
        dVar.b(this.TAG, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$submitRunnableTask$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int i3;
                List list;
                Set set;
                ArrayDeque arrayDeque;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                i3 = TaskManager.this.mConcurrentCount;
                list = TaskManager.this.mRunningQueue;
                int size = list.size();
                set = TaskManager.this.mPendingSet;
                int size2 = set.size();
                arrayDeque = TaskManager.this.mWaitingQueue;
                return "mConcurrentCount " + i3 + " mRunningQueue.size " + size + " ,mPendingCount " + size2 + " ,mWaitingQueue.size " + arrayDeque.size();
            }
        });
        Ref.IntRef intRef = new Ref.IntRef();
        int size = (this.mConcurrentCount - this.mRunningQueue.size()) + this.mPendingSet.size();
        intRef.element = size;
        if (size <= 0) {
            return;
        }
        dVar.b(this.TAG, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$submitRunnableTask$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Ref.IntRef.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "submitRunnableTask " + Ref.IntRef.this.element;
            }
        });
        while (true) {
            int i3 = intRef.element;
            intRef.element = i3 - 1;
            if (i3 <= 0 || this.mRunningQueue.size() >= this.mMaxRunningCount || (removeLastOrNull = this.mWaitingQueue.removeLastOrNull()) == null) {
                return;
            }
            this.mRunningQueue.add(removeLastOrNull);
            if (this.mUseThreadPool) {
                coroutineContext = ThreadPoolManager.f352976a.b();
            } else {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            }
            CoroutineContext coroutineContext2 = coroutineContext;
            Map<String, Job> map = this.mJobMap;
            String c16 = removeLastOrNull.c();
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.mScope, coroutineContext2, null, new TaskManager$submitRunnableTask$3(this, removeLastOrNull, null), 2, null);
            map.put(c16, launch$default);
        }
    }

    @Override // wv3.a
    public void a(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            BuildersKt__Builders_commonKt.launch$default(this.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$onResume$1(this, key, null), 2, null);
        }
    }

    @Override // wv3.a
    public void b(@Nullable RunnableTask runnableTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnableTask);
        } else if (runnableTask != null) {
            BuildersKt__Builders_commonKt.launch$default(this.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$onPending$1(runnableTask, this, null), 2, null);
        }
    }

    public final void o(@NotNull a task, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, task, Boolean.valueOf(forceRefresh));
        } else {
            Intrinsics.checkNotNullParameter(task, "task");
            BuildersKt__Builders_commonKt.launch$default(this.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$addTask$1(this, task, forceRefresh, null), 2, null);
        }
    }

    public final void s(@NotNull a task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
        } else {
            Intrinsics.checkNotNullParameter(task, "task");
            BuildersKt__Builders_commonKt.launch$default(this.mScope, ThreadPoolManager.f352976a.a(), null, new TaskManager$cancelTask$1(this, task, null), 2, null);
        }
    }

    public /* synthetic */ TaskManager(String str, CoroutineScope coroutineScope, int i3, long j3, int i16, int i17, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i18 & 2) != 0 ? GlobalScope.INSTANCE : coroutineScope, (i18 & 4) != 0 ? 1 : i3, (i18 & 8) != 0 ? 20000L : j3, (i18 & 16) != 0 ? 200 : i16, (i18 & 32) != 0 ? 20 : i17, (i18 & 64) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, coroutineScope, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
