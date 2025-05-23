package com.qzone.publish.business.publishqueue.common;

import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qzonehub.api.IQzoneStateStoreApi;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010.\u001a\u00020\u000e\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\bH\u0002J0\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010)\u001a\u00020(2\u0006\u0010#\u001a\u00020\tJ\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010#\u001a\u00020\tR\u0017\u0010.\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020$018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00102R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00102R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00106\u00a8\u0006:"}, d2 = {"Lcom/qzone/publish/business/publishqueue/common/f;", "", "Lcom/qzone/publish/business/task/IQueueTask;", "task", "", "b", "", "clearAll", "", "", "newHasRunningTaskMap", "w", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "i", h.F, "key", "", "countMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "y", "o", "spaceId", DomainData.DOMAIN_NAME, "l", "u", StateEvent.ProcessResult.SUCCEED, "c", "p", "v", "t", "r", ReportConstant.COSTREPORT_PREFIX, "caseId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "j", "d", "", "e", "g", "I", "getBusinessType", "()I", "businessType", "Ljava/util/concurrent/CopyOnWriteArrayList;", "allTaskList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "allTaskListMap", "allHasRunningTaskMap", "Lcom/qzone/publish/business/publishqueue/e;", "Lcom/qzone/publish/business/publishqueue/e;", "cacheManager", "<init>", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int businessType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<IQueueTask> allTaskList = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<IQueueTask>> allTaskListMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Boolean> allHasRunningTaskMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.qzone.publish.business.publishqueue.e cacheManager = new com.qzone.publish.business.publishqueue.e();

    public f(int i3) {
        this.businessType = i3;
    }

    private final void b(IQueueTask task) {
        CopyOnWriteArrayList<IQueueTask> putIfAbsent;
        ConcurrentHashMap<String, CopyOnWriteArrayList<IQueueTask>> concurrentHashMap = this.allTaskListMap;
        String caseId = task.getCaseId();
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = concurrentHashMap.get(caseId);
        if (copyOnWriteArrayList == null && (putIfAbsent = concurrentHashMap.putIfAbsent(caseId, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = putIfAbsent;
        }
        copyOnWriteArrayList.add(task);
    }

    private final Map<String, Integer> h() {
        int state;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (IQueueTask iQueueTask : this.allTaskList) {
            if (iQueueTask != null && ((state = iQueueTask.getState()) == 1 || state == 4)) {
                if (System.currentTimeMillis() - iQueueTask.getTime() < 1800000) {
                    String caseId = iQueueTask.getCaseId();
                    Intrinsics.checkNotNullExpressionValue(caseId, "it.caseId");
                    m(caseId, linkedHashMap);
                } else {
                    iQueueTask.setState(2);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r3.getState() != 4) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x000b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int i() {
        boolean z16;
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            IQueueTask iQueueTask = (IQueueTask) obj;
            if (iQueueTask != null && iQueueTask.isVideoTask()) {
                z16 = true;
                if (iQueueTask.getState() != 1) {
                }
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return arrayList.size();
    }

    private final boolean k() {
        Collection<Boolean> values = this.allHasRunningTaskMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "allHasRunningTaskMap.values");
        Collection<Boolean> collection = values;
        if (collection.isEmpty()) {
            return false;
        }
        for (Boolean it : collection) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private final Map<String, Integer> m(String key, Map<String, Integer> countMap) {
        Integer num = countMap.get(key);
        countMap.put(key, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        return countMap;
    }

    private final void q(IQueueTask task) {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskListMap.get(task.getCaseId());
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(task);
        }
    }

    private final void w(boolean clearAll, Map<String, Boolean> newHasRunningTaskMap) {
        RFWLog.d("CommonTaskManager", RFWLog.USR, "syncHasRunningTaskMap, clearAll:" + clearAll + ", newHasRunningTaskMap:" + newHasRunningTaskMap);
        if (clearAll) {
            this.allHasRunningTaskMap.clear();
        }
        if (newHasRunningTaskMap != null) {
            for (Map.Entry<String, Boolean> entry : newHasRunningTaskMap.entrySet()) {
                this.allHasRunningTaskMap.put(entry.getKey(), entry.getValue());
            }
        }
        ((IQzoneStateStoreApi) QRoute.api(IQzoneStateStoreApi.class)).syncRunningTaskState(k());
    }

    public final long e(String caseId) {
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskListMap.get(caseId);
        long j3 = 0;
        if (copyOnWriteArrayList != null) {
            long j16 = 0;
            for (IQueueTask iQueueTask : copyOnWriteArrayList) {
                if (iQueueTask != null && iQueueTask.getState() != 3) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(iQueueTask.getLeaveSize(), 0L);
                    j16 += coerceAtLeast;
                }
            }
            j3 = j16;
        }
        RFWLog.d("CommonTaskManager", RFWLog.USR, "getAllLeaveSizeBySpaceId, size:" + j3);
        return j3;
    }

    public final CopyOnWriteArrayList<IQueueTask> f(String caseId) {
        CopyOnWriteArrayList<IQueueTask> putIfAbsent;
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        ConcurrentHashMap<String, CopyOnWriteArrayList<IQueueTask>> concurrentHashMap = this.allTaskListMap;
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = concurrentHashMap.get(caseId);
        if (copyOnWriteArrayList == null && (putIfAbsent = concurrentHashMap.putIfAbsent(caseId, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = putIfAbsent;
        }
        Object clone = copyOnWriteArrayList.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.concurrent.CopyOnWriteArrayList<com.qzone.publish.business.task.IQueueTask>");
        return (CopyOnWriteArrayList) clone;
    }

    public final CopyOnWriteArrayList<IQueueTask> g(String caseId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList2 = this.allTaskListMap.get(caseId);
        if (copyOnWriteArrayList2 != null) {
            for (IQueueTask iQueueTask : copyOnWriteArrayList2) {
                if (iQueueTask != null && iQueueTask.getState() == 2) {
                    copyOnWriteArrayList.add(iQueueTask);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public final boolean j(String caseId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskListMap.get(caseId);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (((IQueueTask) it.next()).getState() == 6) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Boolean bool = this.allHasRunningTaskMap.get(spaceId);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void n(String spaceId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskListMap.get(spaceId);
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            RFWLog.i("CommonTaskManager", RFWLog.USR, "pauseAllTasksBySpaceId, spaceId:" + spaceId);
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                o((IQueueTask) it.next());
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(spaceId, Boolean.FALSE));
            x(this, false, mapOf, 1, null);
            return;
        }
        RFWLog.w("CommonTaskManager", RFWLog.USR, "pauseAllTasksBySpaceId, taskList is null or empty, spaceId:" + spaceId);
    }

    public final void r() {
        RFWLog.i("CommonTaskManager", RFWLog.USR, "resetAllTask ");
        for (IQueueTask iQueueTask : this.allTaskList) {
            if (iQueueTask != null && !iQueueTask.cancel()) {
                iQueueTask.clear();
            }
        }
        this.allTaskList.clear();
        this.allTaskListMap.clear();
    }

    public final void s(String spaceId) {
        Set set;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        ArrayList arrayList = new ArrayList();
        for (IQueueTask iQueueTask : this.allTaskList) {
            if (iQueueTask != null && Intrinsics.areEqual(iQueueTask.getCaseId(), spaceId)) {
                arrayList.add(iQueueTask);
                if (!iQueueTask.cancel()) {
                    iQueueTask.clear();
                }
            }
        }
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.allTaskList;
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        copyOnWriteArrayList.removeAll(set);
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList2 = this.allTaskListMap.get(spaceId);
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
    }

    public final boolean t() {
        ArrayList<IQueueTask> arrayList;
        if (!this.allTaskList.isEmpty()) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "restore, allTaskList is not empty ");
            return false;
        }
        try {
            arrayList = this.cacheManager.e(this.businessType);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
            arrayList = null;
        }
        if (arrayList != null) {
            for (IQueueTask iQueueTask : arrayList) {
                if (iQueueTask != null) {
                    iQueueTask.onRestore();
                    RFWLog.i("CommonTaskManager", RFWLog.USR, "restore,  caseId:" + iQueueTask.getCaseId() + ", taskId:" + iQueueTask.getTaskId());
                    this.allTaskList.add(iQueueTask);
                    b(iQueueTask);
                }
            }
        }
        return this.allTaskList.size() > 0;
    }

    public final boolean a(IQueueTask task) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "addTask, task is null ");
            return false;
        }
        if (this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "addTask, task is already exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "addTask, taskId: " + task.getTaskId());
        this.allTaskList.add(task);
        b(task);
        this.cacheManager.f(task);
        return true;
    }

    public final boolean c(IQueueTask task, boolean succeed) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "completeTask, task is null ");
            return false;
        }
        if (!this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "completeTask, task is not exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "completeTask, taskId:" + task.getTaskId() + ", succeed:" + succeed + ", code=" + task.getResultCode() + ", task=" + task);
        if (succeed) {
            task.setState(3);
            this.allTaskList.remove(task);
            q(task);
            this.cacheManager.d(task);
            return true;
        }
        task.setState(2);
        this.cacheManager.g(task);
        a9.b.f25722a.a(task);
        return true;
    }

    public final boolean o(IQueueTask task) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "pauseTask, task is null ");
            return false;
        }
        if (!this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "pauseTask, task is not exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "pauseTask, taskId: " + task.getTaskId());
        task.cancel();
        task.setState(2);
        y(task);
        return true;
    }

    public final boolean p(IQueueTask task) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "removeTask, task is null ");
            return false;
        }
        if (!this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "removeTask, task is not exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "removeTask, taskId:" + task.getTaskId());
        task.setState(5);
        task.onRemove();
        this.allTaskList.remove(task);
        q(task);
        this.cacheManager.d(task);
        return true;
    }

    public final boolean u(IQueueTask task) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "resumeTask, task is null ");
            return false;
        }
        if (!this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "resumeTask, task is not exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "resumeTask, taskId:" + task.getTaskId() + ", state:" + task.getState());
        int state = task.getState();
        if (state != 2 && state != 5) {
            return true;
        }
        task.onResume();
        if (NetworkState.isNetSupport()) {
            task.setState(0);
        } else {
            task.setState(6);
        }
        y(task);
        return true;
    }

    public final boolean y(IQueueTask task) {
        if (task == null) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "updateTask, task is null ");
            return false;
        }
        if (!this.allTaskList.contains(task)) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "updateTask, task is not exists, taskId: " + task.getTaskId());
            return false;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "updateTask, taskId: " + task.getTaskId());
        this.cacheManager.g(task);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean v() {
        int[] intArray;
        int sum;
        boolean z16;
        int mapCapacity;
        Map<String, Integer> mutableMap;
        int mapCapacity2;
        Map<String, Integer> h16 = h();
        int i3 = 1;
        boolean z17 = false;
        RFWLog.d("CommonTaskManager", RFWLog.USR, "runTask, runningTaskCountMap:" + h16);
        if (!NetworkState.isNetSupport()) {
            RFWLog.w("CommonTaskManager", RFWLog.USR, "runTask, net not support ");
            mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(h16.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity2);
            Iterator<T> it = h16.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), Boolean.valueOf(((Number) entry.getValue()).intValue() > 0));
            }
            w(true, linkedHashMap);
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_MAX_PARALLEL_TASK_COUNT, 5);
        ArrayList arrayList = new ArrayList(h16.size());
        Iterator<Map.Entry<String, Integer>> it5 = h16.entrySet().iterator();
        while (it5.hasNext()) {
            arrayList.add(Integer.valueOf(it5.next().getValue().intValue()));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        sum = ArraysKt___ArraysKt.sum(intArray);
        RFWLog.d("CommonTaskManager", RFWLog.USR, "runTask, runningTaskCount:" + sum + ", maxParallelTaskCount:" + config);
        if (sum >= config) {
            return false;
        }
        Iterator<T> it6 = this.allTaskList.iterator();
        boolean z18 = false;
        while (true) {
            if (!it6.hasNext()) {
                z16 = z17;
                break;
            }
            IQueueTask iQueueTask = (IQueueTask) it6.next();
            if (iQueueTask != 0) {
                int state = iQueueTask.getState();
                if (state != 0 && state != 6) {
                    RFWLog.i("CommonTaskManager", RFWLog.USR, "runTask, repeat, state not allowed run, state:" + iQueueTask.getState() + ", taskId:" + iQueueTask.getTaskId());
                    z16 = z17;
                } else {
                    int i16 = i();
                    int i17 = RFWLog.USR;
                    Object[] objArr = new Object[i3];
                    objArr[0] = "runTask, repeat, runningVideoTaskCount:" + i16 + ", taskId:" + iQueueTask.getTaskId();
                    RFWLog.d("CommonTaskManager", i17, objArr);
                    if (iQueueTask.isVideoTask() && i16 > 0) {
                        RFWLog.d("CommonTaskManager", RFWLog.USR, "runTask, repeat, running video task over limit, taskId:" + iQueueTask.getTaskId());
                        z16 = false;
                    } else {
                        sum++;
                        z16 = false;
                        RFWLog.d("CommonTaskManager", RFWLog.USR, "runTask, repeat, taskId:" + iQueueTask.getTaskId() + ", runningTaskCount:" + sum);
                        String caseId = iQueueTask.getCaseId();
                        Intrinsics.checkNotNullExpressionValue(caseId, "it.caseId");
                        mutableMap = MapsKt__MapsKt.toMutableMap(h16);
                        h16 = m(caseId, mutableMap);
                        iQueueTask.setState(1);
                        QZoneBusinessLooper.getInstance().runTask((QZoneTask) iQueueTask);
                        z18 = true;
                    }
                }
                if (sum == config) {
                    break;
                }
            } else {
                z16 = z17;
            }
            z17 = z16;
            i3 = 1;
        }
        RFWLog.i("CommonTaskManager", RFWLog.USR, "runTask, over ");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(h16.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        Iterator<T> it7 = h16.entrySet().iterator();
        while (it7.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it7.next();
            linkedHashMap2.put(entry2.getKey(), Boolean.valueOf(((Number) entry2.getValue()).intValue() > 0 ? true : z16));
        }
        w(true, linkedHashMap2);
        return z18;
    }

    public final boolean d(IQueueTask task) {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList;
        if (task == null || (copyOnWriteArrayList = this.allTaskListMap.get(task.getCaseId())) == null) {
            return false;
        }
        return copyOnWriteArrayList.contains(task);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void x(f fVar, boolean z16, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            map = null;
        }
        fVar.w(z16, map);
    }
}
