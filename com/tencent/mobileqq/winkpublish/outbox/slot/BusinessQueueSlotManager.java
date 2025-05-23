package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0016R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0013j\b\u0012\u0004\u0012\u00020\n`\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020)8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/BusinessQueueSlotManager;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "j", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/WaitingQueueSlot;", "b", "g", "d", h.F, "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "getAllTasks", "e", "a", "f", "task", "", "i", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getTaskList", "()Ljava/util/ArrayList;", "taskList", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/IdleQueueSlot;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/IdleQueueSlot;", HippyPagerPageChangeListener.IDLE, "o", "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/WaitingQueueSlot;", "waiting", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/RunningQueueSlot;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/RunningQueueSlot;", "running", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/CancelledQueueSlot;", "k", "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/CancelledQueueSlot;", "cancelled", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/FinishedQueueSlot;", "l", "()Lcom/tencent/mobileqq/winkpublish/outbox/slot/FinishedQueueSlot;", IXWebBroadcastListener.STAGE_FINISHED, "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BusinessQueueSlotManager implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<BaseTask> taskList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy idle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy waiting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy running;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy cancelled;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy finished;

    public BusinessQueueSlotManager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IdleQueueSlot>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BusinessQueueSlotManager$idle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IdleQueueSlot invoke() {
                return new IdleQueueSlot();
            }
        });
        this.idle = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WaitingQueueSlot>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BusinessQueueSlotManager$waiting$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WaitingQueueSlot invoke() {
                return new WaitingQueueSlot();
            }
        });
        this.waiting = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RunningQueueSlot>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BusinessQueueSlotManager$running$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RunningQueueSlot invoke() {
                return new RunningQueueSlot();
            }
        });
        this.running = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CancelledQueueSlot>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BusinessQueueSlotManager$cancelled$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CancelledQueueSlot invoke() {
                return new CancelledQueueSlot();
            }
        });
        this.cancelled = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FinishedQueueSlot>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BusinessQueueSlotManager$finished$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FinishedQueueSlot invoke() {
                return new FinishedQueueSlot();
            }
        });
        this.finished = lazy5;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public List<BaseTask> a() {
        List plus;
        List<BaseTask> plus2;
        plus = CollectionsKt___CollectionsKt.plus((Collection) m().j(), (Iterable) o().k());
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) n().k());
        return plus2;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public WaitingQueueSlot b() {
        return o();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public void c(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.taskList.remove(task);
        QLog.i("BusinessQueueSlotManager", 1, "removeTask... id:" + task.u() + "  size:" + this.taskList.size());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public a d() {
        return k();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public List<BaseTask> e() {
        List<BaseTask> plus;
        plus = CollectionsKt___CollectionsKt.plus((Collection) o().k(), (Iterable) n().k());
        return plus;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public List<BaseTask> f() {
        ArrayList<BaseTask> arrayList = this.taskList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            BaseTask baseTask = (BaseTask) obj;
            boolean z16 = true;
            if (baseTask.x() != -1000 && baseTask.x() != 0 && baseTask.x() != 1) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public a g() {
        return n();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public List<BaseTask> getAllTasks() {
        List plus;
        List plus2;
        List plus3;
        List<BaseTask> plus4;
        plus = CollectionsKt___CollectionsKt.plus((Collection) m().j(), (Iterable) o().k());
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) n().k());
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) k().k());
        plus4 = CollectionsKt___CollectionsKt.plus((Collection) plus3, (Iterable) l().i());
        return plus4;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public a h() {
        return l();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public void i(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.taskList.contains(task)) {
            return;
        }
        this.taskList.add(task);
        QLog.i("BusinessQueueSlotManager", 1, "addTask... id:" + task.u() + " size:" + this.taskList.size());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.b
    public a j() {
        return m();
    }

    public final CancelledQueueSlot k() {
        return (CancelledQueueSlot) this.cancelled.getValue();
    }

    public final FinishedQueueSlot l() {
        return (FinishedQueueSlot) this.finished.getValue();
    }

    public final IdleQueueSlot m() {
        return (IdleQueueSlot) this.idle.getValue();
    }

    public final RunningQueueSlot n() {
        return (RunningQueueSlot) this.running.getValue();
    }

    public final WaitingQueueSlot o() {
        return (WaitingQueueSlot) this.waiting.getValue();
    }
}
