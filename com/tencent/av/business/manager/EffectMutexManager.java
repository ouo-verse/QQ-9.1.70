package com.tencent.av.business.manager;

import android.util.SparseArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectMutexManager extends com.tencent.av.business.manager.a {

    /* renamed from: h, reason: collision with root package name */
    private volatile SparseArray<a> f73311h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void d(int i3, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EffectMutexManager(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f73311h = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return false;
    }

    public void m(final int i3, final String str) {
        if (QLog.isDevelopLevel()) {
            QLog.w("EffectMutexManager", 1, "notifyMutex, fromMuteKey[" + i3 + "], data[" + str + "]");
        }
        this.f73316e.runOnUiThread(new Runnable() { // from class: com.tencent.av.business.manager.EffectMutexManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i16 = 0; i16 < EffectMutexManager.this.f73311h.size(); i16++) {
                    a aVar = (a) EffectMutexManager.this.f73311h.valueAt(i16);
                    if (aVar != null) {
                        int keyAt = EffectMutexManager.this.f73311h.keyAt(i16);
                        int i17 = i3;
                        if (keyAt != i17) {
                            aVar.d(i17, str);
                        }
                    }
                }
            }
        });
    }

    public void n(int i3, a aVar) {
        if (aVar == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("EffectMutexManager", 1, "registerMutexItem, key[" + i3 + "]");
        }
        this.f73311h.remove(i3);
        this.f73311h.put(i3, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
    }
}
