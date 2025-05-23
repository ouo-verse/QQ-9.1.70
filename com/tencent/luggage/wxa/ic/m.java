package com.tencent.luggage.wxa.ic;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f129940a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseIntArray f129941b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static m f129942a = new m();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    public static m a() {
        return b.f129942a;
    }

    public void b(l lVar, c cVar) {
        int componentId = lVar.getComponentId();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d, listener:%d", Integer.valueOf(componentId), Integer.valueOf(cVar.hashCode()));
        synchronized (this) {
            List list = (List) this.f129940a.get(componentId);
            if (list == null) {
                return;
            }
            list.remove(cVar);
            if (list.isEmpty()) {
                this.f129940a.remove(componentId);
            }
        }
    }

    public m() {
        this.f129940a = new SparseArray();
        this.f129941b = new SparseIntArray();
    }

    public void a(l lVar, c cVar) {
        int componentId = lVar.getComponentId();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d, listener:%d", Integer.valueOf(componentId), Integer.valueOf(cVar.hashCode()));
        synchronized (this) {
            List list = (List) this.f129940a.get(componentId);
            if (list == null) {
                list = new ArrayList();
                this.f129940a.put(componentId, list);
            }
            list.add(cVar);
            a(componentId, list);
        }
    }

    public void b(l lVar) {
        int indexOfKey;
        int componentId = lVar.getComponentId();
        synchronized (this) {
            indexOfKey = this.f129940a.indexOfKey(componentId);
            if (indexOfKey >= 0) {
                this.f129940a.removeAt(indexOfKey);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(componentId);
        objArr[1] = Boolean.valueOf(indexOfKey < 0);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeAllListeners, service:%d, already removed:%b", objArr);
    }

    public void a(l lVar) {
        int componentId = lVar.getComponentId();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", Integer.valueOf(componentId));
        synchronized (this) {
            List list = (List) this.f129940a.get(componentId);
            if (list == null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
                this.f129941b.put(componentId, 1);
            } else {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    ((c) list.get(i3)).a();
                }
            }
        }
    }

    public final void a(int i3, List list) {
        if (this.f129941b.size() <= 0) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", Integer.valueOf(i3));
        if (this.f129941b.indexOfKey(i3) < 0) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
            return;
        }
        this.f129941b.delete(i3);
        for (int i16 = 0; i16 < list.size(); i16++) {
            ((c) list.get(i16)).a();
        }
    }
}
