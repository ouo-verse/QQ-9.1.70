package com.tencent.mobileqq.winkpublish.outbox;

import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/a;", "Lcom/tencent/mobileqq/winkpublish/outbox/b;", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "listener", "", "d", "b", "a", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "c", "", "Ljava/lang/ref/WeakReference;", "Ljava/util/List;", "listeners", "", "", "Ljava/util/Map;", "listenersMap", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<WeakReference<ITaskListener>> listeners = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, ITaskListener> listenersMap = new LinkedHashMap();

    @Override // com.tencent.mobileqq.winkpublish.outbox.b
    public void a(ITaskListener listener) {
        ITaskListener iTaskListener;
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Iterator<WeakReference<ITaskListener>> it = this.listeners.iterator();
            while (it.hasNext()) {
                WeakReference<ITaskListener> next = it.next();
                if (next != null && ((iTaskListener = next.get()) == null || Intrinsics.areEqual(iTaskListener.asBinder(), listener.asBinder()))) {
                    it.remove();
                }
            }
            Map<Integer, ITaskListener> map = this.listenersMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, ITaskListener> entry : map.entrySet()) {
                if (listener.asBinder().hashCode() == entry.getKey().intValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it5 = linkedHashMap.entrySet().iterator();
            while (it5.hasNext()) {
                this.listenersMap.remove(((Map.Entry) it5.next()).getKey());
            }
        } catch (Exception e16) {
            QLog.w("WinkPublish-upload2-TaskListeners", 1, "[removeListener] ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-TaskListeners", 2, "[removeListener] size=" + this.listeners.size() + ", map size=" + this.listenersMap.size());
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.b
    public void b(ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            int hashCode = listener.asBinder().hashCode();
            if (this.listenersMap.containsKey(Integer.valueOf(hashCode))) {
                QLog.d("WinkPublish-upload2-TaskListeners", 1, "[addListener2] already in added");
                return;
            }
            this.listenersMap.put(Integer.valueOf(hashCode), listener);
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-upload2-TaskListeners", 2, "[addListener] size=" + this.listeners.size() + ", map size=" + this.listenersMap.size());
            }
        } catch (Exception e16) {
            QLog.w("WinkPublish-upload2-TaskListeners", 1, "[addListener2] ", e16);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.b
    public void c(TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        try {
            Iterator<WeakReference<ITaskListener>> it = this.listeners.iterator();
            while (it.hasNext()) {
                ITaskListener iTaskListener = it.next().get();
                if (iTaskListener == null) {
                    it.remove();
                } else {
                    iTaskListener.onTaskChange(taskInfo);
                }
            }
            Iterator<Map.Entry<Integer, ITaskListener>> it5 = this.listenersMap.entrySet().iterator();
            while (it5.hasNext()) {
                try {
                    it5.next().getValue().onTaskChange(taskInfo);
                } catch (Exception e16) {
                    QLog.w("WinkPublish-upload2-TaskListeners", 1, "[notifyChange] taskId:" + taskInfo.getTaskId(), e16);
                }
            }
        } catch (Exception e17) {
            QLog.w("WinkPublish-upload2-TaskListeners", 1, "[notifyChange]  taskId:" + taskInfo.getTaskId(), e17);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        com.tencent.qphone.base.util.QLog.d("WinkPublish-upload2-TaskListeners", 2, "[addListener] listener already in list");
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.winkpublish.outbox.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(ITaskListener listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<WeakReference<ITaskListener>> it = this.listeners.iterator();
        while (true) {
            z16 = true;
            try {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<ITaskListener> next = it.next();
                if (next != null) {
                    ITaskListener iTaskListener = next.get();
                    if (iTaskListener == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WinkPublish-upload2-TaskListeners", 2, "[addListener] listener has been recycled");
                        }
                        it.remove();
                    } else if (Intrinsics.areEqual(iTaskListener, listener)) {
                        break;
                    }
                }
            } catch (Exception e16) {
                QLog.w("WinkPublish-upload2-TaskListeners", 1, "[addListener] ", e16);
            }
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-upload2-TaskListeners", 2, "[addListener] add to list");
            }
            this.listeners.add(new WeakReference<>(listener));
        }
        if (QLog.isColorLevel()) {
            return;
        }
        QLog.d("WinkPublish-upload2-TaskListeners", 2, "[addListener] size=" + this.listeners.size() + ", map size=" + this.listenersMap.size());
        return;
        z16 = false;
        if (!z16) {
        }
        if (QLog.isColorLevel()) {
        }
    }
}
