package com.tencent.mobileqq.winkpublish.outbox;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.util.g;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0010J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0007J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/Outbox;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/qcircle/cooperation/config/AccountChangeEvent;", "", "businessType", "", "b", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "params", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "c", "", "g", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "newParams", "", "o", "i", "Lkotlin/Function0;", "resumeFailed", "l", "f", h.F, "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "listener", "d", "e", "j", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class Outbox implements SimpleEventReceiver<AccountChangeEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final Outbox f327227d;

    static {
        Outbox outbox = new Outbox();
        f327227d = outbox;
        SimpleEventBus.getInstance().registerReceiver(outbox);
        ua3.a.d().h();
    }

    Outbox() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(Outbox outbox, int i3, long j3, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.winkpublish.outbox.Outbox$resumeTask$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        outbox.l(i3, j3, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 resumeFailed, long j3) {
        Unit unit;
        Object obj;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(resumeFailed, "$resumeFailed");
        List<BaseTask> tasks = com.tencent.mobileqq.winkpublish.outbox.db.a.c().b();
        Intrinsics.checkNotNullExpressionValue(tasks, "tasks");
        Iterator<T> it = tasks.iterator();
        while (true) {
            unit = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            BaseTask baseTask = (BaseTask) obj;
            boolean z16 = false;
            if (baseTask != null && baseTask.u() == j3) {
                z16 = true;
            }
            if (z16) {
                break;
            }
        }
        BaseTask baseTask2 = (BaseTask) obj;
        if (baseTask2 != null) {
            baseTask2.G();
            d.c(baseTask2.getTaskContext(), "key_user_click_upload_cost");
            TaskContext taskContext = baseTask2.getTaskContext();
            String r16 = baseTask2.getTaskContext().r();
            String valueOf = String.valueOf(baseTask2.getTaskContext().getSeqId());
            if (baseTask2.getTaskContext().A()) {
                str = "1";
            } else {
                str = "0";
            }
            String str3 = str;
            String dtCameraSessionId = baseTask2.getTaskContext().getDtCameraSessionId();
            if (baseTask2.getTaskContext().C()) {
                str2 = "video";
            } else {
                str2 = "image";
            }
            d.d(taskContext, "E_PUBLISH_RESUME_TASK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : dtCameraSessionId, (r33 & 64) != 0 ? "" : str2, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            resumeFailed.invoke();
        }
    }

    public final void d(int businessType, ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e.f327257a.a(businessType).d(listener);
    }

    public final void e(int businessType, ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e.f327257a.a(businessType).b(listener);
    }

    public final List<TaskInfo> g(int businessType) {
        int collectionSizeOrDefault;
        List<BaseTask> e16 = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(businessType).e();
        ArrayList arrayList = new ArrayList();
        for (Object obj : e16) {
            if (((BaseTask) obj).getTaskContext().B()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((BaseTask) it.next()).z());
        }
        return arrayList2;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<AccountChangeEvent>> getEventClass() {
        ArrayList<Class<AccountChangeEvent>> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        return arrayList;
    }

    public final boolean h(int businessType) {
        List<BaseTask> e16 = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(businessType).e();
        if ((e16 instanceof Collection) && e16.isEmpty()) {
            return false;
        }
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            if (((BaseTask) it.next()).E()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_use_new_check_task_list", true);
    }

    public final void j(int businessType, ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e.f327257a.a(businessType).a(listener);
    }

    public final void l(int businessType, final long taskId, final Function0<Unit> resumeFailed) {
        Intrinsics.checkNotNullParameter(resumeFailed, "resumeFailed");
        QLog.i("WinkPublish-upload2-Outbox", 1, "[resumeTask] task id=" + taskId);
        g.c(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.outbox.c
            @Override // java.lang.Runnable
            public final void run() {
                Outbox.n(Function0.this, taskId);
            }
        });
    }

    public final boolean o(long taskId, WinkPublishParams newParams) {
        BaseTask baseTask;
        Intrinsics.checkNotNullParameter(newParams, "newParams");
        QLog.i("WinkPublish-upload2-Outbox", 1, "[updateTask] task id=" + taskId);
        Object obj = null;
        if (i()) {
            Iterator<T> it = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(newParams.getBusinessType()).f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((BaseTask) next).u() == taskId) {
                    obj = next;
                    break;
                }
            }
            baseTask = (BaseTask) obj;
        } else {
            Iterator<T> it5 = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(newParams.getBusinessType()).a().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next2 = it5.next();
                if (((BaseTask) next2).u() == taskId) {
                    obj = next2;
                    break;
                }
            }
            baseTask = (BaseTask) obj;
        }
        if (baseTask != null) {
            baseTask.Q(newParams);
            return true;
        }
        QLog.i("WinkPublish-upload2-Outbox", 1, "[updateTask] no task found");
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.i("WinkPublish-upload2-Outbox", 1, "[onReceiveEvent] event");
        if (event instanceof AccountChangeEvent) {
            b(1);
            b(2);
            b(3);
            ua3.a.d().i();
            ua3.a.d().h();
        }
    }

    private final void b(int businessType) {
        String str;
        QLog.i("WinkPublish-upload2-Outbox", 1, "[cancelBusinessTask] businessType=" + businessType);
        for (BaseTask baseTask : com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(businessType).e()) {
            QLog.i("WinkPublish-upload2-Outbox", 1, "[cancelBusinessTask] taskId=" + baseTask.u());
            baseTask.o();
            TaskContext taskContext = baseTask.getTaskContext();
            String r16 = baseTask.getTaskContext().r();
            String valueOf = String.valueOf(baseTask.getTaskContext().getSeqId());
            String dtCameraSessionId = baseTask.getTaskContext().getDtCameraSessionId();
            if (baseTask.getTaskContext().C()) {
                str = "video";
            } else {
                str = "image";
            }
            d.d(taskContext, "E_ACCOUNT_CHANGE_CANCEL_TASK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : null, (r33 & 32) != 0 ? "" : dtCameraSessionId, (r33 & 64) != 0 ? "" : str, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        }
    }

    public final TaskInfo c(WinkPublishParams params) {
        int i3;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(params, "params");
        TaskContext c16 = TaskContext.Companion.c(TaskContext.INSTANCE, params, null, 2, null);
        BaseTask baseTask = new BaseTask(c16);
        com.tencent.mobileqq.winkpublish.outbox.slot.c cVar = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a;
        cVar.a(c16.b()).i(baseTask);
        QLog.i("WinkPublish-upload2-Outbox", 1, "[addTask] task id=" + baseTask.u() + ", isTrueUpload=" + baseTask.E() + ", traceId=" + params.getTraceId() + ", cameraSessionId=" + c16.getDtCameraSessionId());
        String str4 = "video";
        if (!params.isTruePublish()) {
            i3 = 1;
            str = "WinkPublish-upload2-Outbox";
            String r16 = c16.r();
            String valueOf = String.valueOf(c16.getSeqId());
            if (c16.A()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String dtCameraSessionId = c16.getDtCameraSessionId();
            if (!c16.C()) {
                str4 = "image";
            }
            d.d(c16, "E_PUBLISH_ADD_SLIENCE_TASK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : str2, (r33 & 32) != 0 ? "" : dtCameraSessionId, (r33 & 64) != 0 ? "" : str4, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        } else {
            d.c(c16, "key_user_click_upload_cost");
            String r17 = c16.r();
            String valueOf2 = String.valueOf(c16.getSeqId());
            if (c16.A()) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            String dtCameraSessionId2 = c16.getDtCameraSessionId();
            if (!c16.C()) {
                str4 = "image";
            }
            i3 = 1;
            str = "WinkPublish-upload2-Outbox";
            d.d(c16, "E_PUBLISH_ADD_TASK", r17, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf2, (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : dtCameraSessionId2, (r33 & 64) != 0 ? "" : str4, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        }
        List<BaseTask> allTasks = cVar.a(baseTask.s()).getAllTasks();
        ArrayList<BaseTask> arrayList = new ArrayList();
        for (Object obj : allTasks) {
            if (((((BaseTask) obj).getTaskContext().B() ? 1 : 0) ^ i3) != 0) {
                arrayList.add(obj);
            }
        }
        for (BaseTask baseTask2 : arrayList) {
            QLog.i(str, i3, "[clear] preTask task id=" + baseTask.u());
            baseTask2.r();
        }
        baseTask.G();
        return baseTask.z();
    }

    public final void f(int businessType, long taskId) {
        Object obj;
        String str;
        String str2;
        QLog.i("WinkPublish-upload2-Outbox", 1, "[cancelTask] task id=" + taskId);
        Iterator<T> it = com.tencent.mobileqq.winkpublish.outbox.slot.c.f327281a.a(businessType).e().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((BaseTask) obj).u() == taskId) {
                    break;
                }
            }
        }
        BaseTask baseTask = (BaseTask) obj;
        if (baseTask != null) {
            baseTask.o();
            TaskContext taskContext = baseTask.getTaskContext();
            String r16 = baseTask.getTaskContext().r();
            String valueOf = String.valueOf(baseTask.getTaskContext().getSeqId());
            if (baseTask.getTaskContext().A()) {
                str = "1";
            } else {
                str = "0";
            }
            String str3 = str;
            String dtCameraSessionId = baseTask.getTaskContext().getDtCameraSessionId();
            if (baseTask.getTaskContext().C()) {
                str2 = "video";
            } else {
                str2 = "image";
            }
            d.d(taskContext, "E_PUBLISH_CANCEL_TASK", r16, (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : valueOf, (r33 & 16) != 0 ? "" : str3, (r33 & 32) != 0 ? "" : dtCameraSessionId, (r33 & 64) != 0 ? "" : str2, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        }
    }

    public final void k(int i3, long j3) {
        m(this, i3, j3, null, 4, null);
    }
}
