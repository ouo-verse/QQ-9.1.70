package com.tencent.mobileqq.zplan.utils.stack;

import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import k74.i;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xk3.UEActivityRecorder;
import xk3.a;
import yk3.b;
import yk3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/UEActivityManagerService;", "Lxk3/a;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Ljava/util/LinkedList;", "Lxk3/c;", "stackCopy", "", "doFinishingCheck", "", "needRemoveItem", "removeItemInProcessSet", "deadProcess", "clearAllTaskOfProcess", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "activityName", "", "hashCode", "processName", OperateCustomButton.OPERATE_CREATE, "finish", "key", "destroy", "isTopEngineActivity", "getActiveSceneCounter", "mEngineActivityStack", "Ljava/util/LinkedList;", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "mProcessStackMap", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UEActivityManagerService implements a, ZPlanEngineStatusUpdateListener {
    private static final String TAG = "UEActivityManagerService_";
    private final LinkedList<UEActivityRecorder> mEngineActivityStack = new LinkedList<>();
    private final HashMap<String, HashSet<UEActivityRecorder>> mProcessStackMap = new HashMap<>();

    public UEActivityManagerService() {
        ZPlanServiceHelper.I.E0(this);
    }

    private final synchronized void clearAllTaskOfProcess(@ProcessName String deadProcess) {
        HashSet<UEActivityRecorder> remove = this.mProcessStackMap.remove(deadProcess);
        QLog.d(TAG, 4, "clearAllTaskOfProcess deadProcess:" + deadProcess + ", needRemoveItem:" + remove);
        if (remove == null || remove.isEmpty()) {
            return;
        }
        Iterator<UEActivityRecorder> it = remove.iterator();
        while (it.hasNext()) {
            this.mEngineActivityStack.remove(it.next());
        }
    }

    private final void doFinishingCheck(LinkedList<UEActivityRecorder> stackCopy) {
        QLog.d(TAG, 4, "doFinishingCheck size:" + stackCopy.size());
        Iterator<UEActivityRecorder> it = stackCopy.iterator();
        while (it.hasNext()) {
            UEActivityRecorder next = it.next();
            QLog.d(TAG, 4, "doFinishingCheck ueActivity:" + next);
            String key = next.getKey();
            String process = next.getProcess();
            if (Intrinsics.areEqual(process, "main")) {
                QLog.d(TAG, 4, "doFinishingCheck-main ueActivity:" + next + " , checkResult:" + ((b) i.INSTANCE.a(b.class)).finishCheck(key));
            } else if (Intrinsics.areEqual(process, "zplan")) {
                try {
                    QLog.d(TAG, 4, "doFinishingCheck-zplan ueActivity:" + next + " , checkResult:" + ((c) i.INSTANCE.a(c.class)).finishCheck(key));
                } catch (Exception e16) {
                    QLog.w(TAG, 4, "doFinishingCheck-zplan failed", e16);
                }
            }
        }
    }

    private final void removeItemInProcessSet(String needRemoveItem) {
        Object obj;
        for (Map.Entry<String, HashSet<UEActivityRecorder>> entry : this.mProcessStackMap.entrySet()) {
            HashSet<UEActivityRecorder> value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((UEActivityRecorder) obj).getKey(), needRemoveItem)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            UEActivityRecorder uEActivityRecorder = (UEActivityRecorder) obj;
            if (uEActivityRecorder != null) {
                entry.getValue().remove(uEActivityRecorder);
            }
        }
    }

    @Override // xk3.a
    public synchronized void create(String activityName, int hashCode, @ProcessName String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(processName, "processName");
        String a16 = xk3.b.f448110a.a(activityName, hashCode);
        UEActivityRecorder uEActivityRecorder = new UEActivityRecorder(a16, processName);
        this.mEngineActivityStack.add(uEActivityRecorder);
        HashSet<UEActivityRecorder> hashSet = this.mProcessStackMap.get(processName);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(uEActivityRecorder);
        this.mProcessStackMap.put(processName, hashSet);
        QLog.d(TAG, 4, "create key:" + a16 + ", after add:" + this.mEngineActivityStack);
        HashMap<String, HashSet<UEActivityRecorder>> hashMap = this.mProcessStackMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("create after add mProcessStackMap:");
        sb5.append(hashMap);
        QLog.d(TAG, 4, sb5.toString());
    }

    @Override // xk3.a
    public synchronized void destroy(String activityName, int hashCode) {
        Object obj;
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        String a16 = xk3.b.f448110a.a(activityName, hashCode);
        Iterator<T> it = this.mEngineActivityStack.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((UEActivityRecorder) obj).getKey(), a16)) {
                    break;
                }
            }
        }
        UEActivityRecorder uEActivityRecorder = (UEActivityRecorder) obj;
        if (uEActivityRecorder == null) {
            return;
        }
        this.mEngineActivityStack.remove(uEActivityRecorder);
        removeItemInProcessSet(a16);
        QLog.d(TAG, 4, "destroy key:" + a16 + ", after remove:" + this.mEngineActivityStack);
        QLog.d(TAG, 4, "destroy key:" + a16 + ", after remove mProcessStackMap:" + this.mProcessStackMap);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.c(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    public synchronized void finish(String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        finish(xk3.b.f448110a.a(activityName, hashCode));
    }

    @Override // xk3.a
    public int getActiveSceneCounter() {
        return this.mEngineActivityStack.size();
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // xk3.a
    public boolean isTopEngineActivity(String activityName, int hashCode) {
        LinkedList<UEActivityRecorder> linkedList;
        LinkedList linkedList2;
        UEActivityRecorder uEActivityRecorder;
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        synchronized (UEActivityManagerService.class) {
            linkedList = new LinkedList<>(this.mEngineActivityStack);
        }
        doFinishingCheck(linkedList);
        String a16 = xk3.b.f448110a.a(activityName, hashCode);
        synchronized (UEActivityManagerService.class) {
            linkedList2 = new LinkedList(this.mEngineActivityStack);
        }
        try {
            uEActivityRecorder = (UEActivityRecorder) linkedList2.getLast();
        } catch (NoSuchElementException unused) {
            uEActivityRecorder = null;
        }
        boolean z16 = uEActivityRecorder == null || Intrinsics.areEqual(uEActivityRecorder.getKey(), a16);
        QLog.d(TAG, 4, "isTopEngineActivity[" + z16 + "] key:" + a16 + ", mEngineActivityStack:" + this.mEngineActivityStack + ", mProcessStackMap:" + this.mProcessStackMap);
        return z16;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        QLog.d(TAG, 4, "serviceConnected connect:" + connect);
        if (connect) {
            return;
        }
        clearAllTaskOfProcess("zplan");
    }

    @Override // xk3.a
    public synchronized void finish(String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<T> it = this.mEngineActivityStack.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((UEActivityRecorder) obj).getKey(), key)) {
                    break;
                }
            }
        }
        UEActivityRecorder uEActivityRecorder = (UEActivityRecorder) obj;
        if (uEActivityRecorder == null) {
            return;
        }
        this.mEngineActivityStack.remove(uEActivityRecorder);
        removeItemInProcessSet(key);
        QLog.d(TAG, 4, "finish key:" + key + ", after remove:" + this.mEngineActivityStack);
        QLog.d(TAG, 4, "finish key:" + key + ", after remove mProcessStackMap:" + this.mProcessStackMap);
    }
}
