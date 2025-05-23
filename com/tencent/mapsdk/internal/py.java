package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.px;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class py implements fj, AoiLayer.OnAoiLayerLoadListener {

    /* renamed from: b, reason: collision with root package name */
    public final ne f149722b;

    /* renamed from: c, reason: collision with root package name */
    public TencentMap.OnMapPoiClickListener f149723c;

    /* renamed from: a, reason: collision with root package name */
    public final List<pw> f149721a = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, AoiLayer.OnAoiLayerLoadListener> f149724d = new HashMap();

    public py(ne neVar) {
        this.f149722b = neVar;
    }

    private ne b() {
        return this.f149722b;
    }

    private void c() {
        this.f149723c = null;
        this.f149721a.clear();
        this.f149724d.clear();
    }

    @Override // com.tencent.mapsdk.internal.fj
    public final void a(gc gcVar) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener
    public final void onAoiLayerLoaded(boolean z16, AoiLayer aoiLayer) {
        if (aoiLayer != null && this.f149722b != null) {
            AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener = this.f149724d.get(aoiLayer.getId());
            if (onAoiLayerLoadListener != null) {
                onAoiLayerLoadListener.onAoiLayerLoaded(z16, aoiLayer);
            }
            if (z16) {
                this.f149722b.f147918e.g().f148592a++;
            }
        }
    }

    private bp a() {
        return this.f149722b;
    }

    private AoiLayer a(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        pw pwVar;
        Iterator<pw> it = this.f149721a.iterator();
        while (true) {
            if (!it.hasNext()) {
                pwVar = null;
                break;
            }
            pwVar = it.next();
            if (pwVar.getId() != null && pwVar.getId().equals(str)) {
                break;
            }
        }
        if (pwVar == null) {
            pwVar = new pw(this, str, aoiLayerOptions, this);
            this.f149721a.add(pwVar);
            if (onAoiLayerLoadListener != null) {
                this.f149724d.put(str, onAoiLayerLoadListener);
            }
        }
        pwVar.a(aoiLayerOptions);
        return pwVar;
    }

    private void a(pw pwVar) {
        this.f149721a.remove(pwVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r4 = com.tencent.mapsdk.internal.pw.a(r0.getId(), r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(TappedElement tappedElement) {
        SubPoi subPoi;
        px.d dVar;
        List<px.d> list;
        if (this.f149723c != null && tappedElement != null && tappedElement.type == 4) {
            long j3 = tappedElement.itemId;
            Iterator<pw> it = this.f149721a.iterator();
            while (true) {
                subPoi = null;
                r4 = null;
                r4 = null;
                r4 = null;
                px.d dVar2 = null;
                if (!it.hasNext()) {
                    break;
                }
                pw next = it.next();
                px pxVar = next.f149671b;
                if (pxVar != null && (dVar = pxVar.f149690a) != null && (list = dVar.f149708j) != null) {
                    Iterator<px.d> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        px.d next2 = it5.next();
                        if (((oc) next.f149670a.f149722b.f149400m.a(oc.class, next2.f149699a)) != null && r7.a() == j3) {
                            dVar2 = next2;
                            break;
                        }
                    }
                }
            }
            if (subPoi != null) {
                this.f149723c.onClicked(subPoi);
                return true;
            }
        }
        return false;
    }

    private void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        this.f149723c = onMapPoiClickListener;
    }
}
