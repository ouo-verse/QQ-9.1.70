package com.tencent.gdt.tangram.net.qzone.embedded.msf;

import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import dm0.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import wl0.a;
import wl0.c;
import wl0.d;
import wl0.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AdMSFSessionManager extends Observable implements d, IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private int f108429d = -1;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, a> f108430e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, WeakReference<e>> f108431f = new HashMap();

    static /* synthetic */ int E(AdMSFSessionManager adMSFSessionManager) {
        int i3 = adMSFSessionManager.f108429d + 1;
        adMSFSessionManager.f108429d = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e O(int i3) {
        WeakReference<e> weakReference;
        Map<Integer, WeakReference<e>> map = this.f108431f;
        if (map == null || (weakReference = map.get(Integer.valueOf(i3))) == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a P(int i3) {
        Map<Integer, a> map = this.f108430e;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3) {
        Map<Integer, WeakReference<e>> map = this.f108431f;
        if (map == null) {
            return;
        }
        map.remove(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i3) {
        Map<Integer, a> map = this.f108430e;
        if (map == null) {
            return;
        }
        map.remove(Integer.valueOf(i3));
    }

    @Override // wl0.d
    public void s(final a aVar, final WeakReference<e> weakReference) {
        final WeakReference weakReference2 = new WeakReference(this);
        b.b(new Runnable() { // from class: com.tencent.gdt.tangram.net.qzone.embedded.msf.AdMSFSessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AdMSFSessionManager.N(aVar) || weakReference2.get() == null) {
                    return;
                }
                AdMSFSessionManager.E(AdMSFSessionManager.this);
                AdMSFSessionManager adMSFSessionManager = AdMSFSessionManager.this;
                adMSFSessionManager.M(adMSFSessionManager.f108429d, aVar);
                AdMSFSessionManager adMSFSessionManager2 = AdMSFSessionManager.this;
                adMSFSessionManager2.L(adMSFSessionManager2.f108429d, weakReference);
                a aVar2 = aVar;
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new AdQZoneRequest(aVar2.f445785a, (JceStruct) aVar2.f445786b.f445788a), null, (IQZoneServiceListener) weakReference2.get(), AdMSFSessionManager.this.f108429d));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i3, WeakReference<e> weakReference) {
        Map<Integer, WeakReference<e>> map;
        if (weakReference == null || (map = this.f108431f) == null) {
            return;
        }
        map.put(Integer.valueOf(i3), weakReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3, a aVar) {
        Map<Integer, a> map;
        if (aVar == null || (map = this.f108430e) == null) {
            return;
        }
        map.put(Integer.valueOf(i3), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N(a aVar) {
        wl0.b bVar;
        Object obj;
        return (aVar == null || (bVar = aVar.f445786b) == null || (obj = bVar.f445788a) == null || !(obj instanceof JceStruct)) ? false : true;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            return;
        }
        final int i3 = qZoneTask.mType;
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        final JceStruct jceStruct = qZoneRequest == null ? null : qZoneRequest.rsp;
        b.b(new Runnable() { // from class: com.tencent.gdt.tangram.net.qzone.embedded.msf.AdMSFSessionManager.2
            @Override // java.lang.Runnable
            public void run() {
                a P = AdMSFSessionManager.this.P(i3);
                AdMSFSessionManager.this.R(i3);
                if (jceStruct != null && P != null) {
                    c cVar = new c();
                    P.f445787c = cVar;
                    cVar.f445789a = jceStruct;
                }
                e O = AdMSFSessionManager.this.O(i3);
                if (O != null) {
                    O.a(P);
                    AdMSFSessionManager.this.Q(i3);
                }
            }
        });
    }
}
