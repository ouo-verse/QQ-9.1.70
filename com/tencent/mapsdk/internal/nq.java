package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.nh;
import com.tencent.mapsdk.internal.ns;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nq extends nh<nr> {

    /* renamed from: i, reason: collision with root package name */
    private final HashMap<Long, LatLngBounds> f149469i;

    public nq(tk tkVar) {
        super(tkVar);
        this.f149469i = new HashMap<>();
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = this.f149469i.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f149469i.get(it.next()));
        }
        this.f149455a.a(arrayList);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final /* synthetic */ ng<nr> a(nr nrVar) {
        return new ns(this, nrVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c() {
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void d(ng<nr> ngVar) {
        tk tkVar = this.f149455a;
        tkVar.a(new tk.AnonymousClass82(ngVar.e_(), ngVar.f149454d));
        if (!ngVar.f149454d.f149470a.isBuildingHidden() || ngVar.f149454d.f149470a.getLatLngBounds() == null) {
            return;
        }
        this.f149469i.put(Long.valueOf(ngVar.e_()), ngVar.f149454d.f149470a.getLatLngBounds());
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e(ng<nr> ngVar) {
        this.f149455a.c(ngVar.e_());
        this.f149469i.remove(Long.valueOf(ngVar.e_()));
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void f(ng<nr> ngVar) {
        ((ns) ngVar).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.nh
    public synchronized ns b(@NonNull nr nrVar) {
        return (ns) super.b((nq) nrVar);
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void c(ng<nr> ngVar) {
        tk tkVar = this.f149455a;
        ngVar.a(((Long) tkVar.a((CallbackRunnable<tk.AnonymousClass81>) new tk.AnonymousClass81(ngVar.f149454d), (tk.AnonymousClass81) 0L)).longValue());
        if (!ngVar.f149454d.f149470a.isBuildingHidden() || ngVar.f149454d.f149470a.getLatLngBounds() == null) {
            return;
        }
        this.f149469i.put(Long.valueOf(ngVar.e_()), ngVar.f149454d.f149470a.getLatLngBounds());
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private ng<nr> a2(nr nrVar) {
        return new ns(this, nrVar);
    }

    public final List<CommonParamsModelClass.AnimationInfo> b(long j3) {
        tk tkVar = this.f149455a;
        int intValue = ((Integer) tkVar.b((CallbackRunnable<tk.AnonymousClass85>) new tk.AnonymousClass85(j3), (tk.AnonymousClass85) 0)).intValue();
        if (intValue <= 0) {
            return null;
        }
        tk tkVar2 = this.f149455a;
        float[] fArr = (float[]) tkVar2.b((CallbackRunnable<tk.AnonymousClass86>) new tk.AnonymousClass86(j3), (tk.AnonymousClass86) new float[0]);
        tk tkVar3 = this.f149455a;
        String[] strArr = (String[]) tkVar3.b((CallbackRunnable<tk.AnonymousClass87>) new tk.AnonymousClass87(j3), (tk.AnonymousClass87) new String[0]);
        if (fArr == null || strArr == null || fArr.length != strArr.length || fArr.length != intValue) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < intValue; i3++) {
            arrayList.add(new CommonParamsModelClass.AnimationInfo(i3, strArr[i3], fArr[i3]));
        }
        return arrayList;
    }

    public final void e(long j3) {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).e_() == j3) {
                tk tkVar = this.f149455a;
                tkVar.a(new tk.AnonymousClass93(j3));
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final boolean f() {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).isClickEnabled()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j3, String str, String str2) {
        Pair<VectorOverlay, TencentMap.IClickedObject> pair = new Pair<>(null, null);
        if (j3 > 0) {
            Iterator it = this.f149456b.entrySet().iterator();
            while (it.hasNext()) {
                ns nsVar = (ns) ((Map.Entry) it.next()).getValue();
                if (nsVar.e_() == j3) {
                    nh.a aVar = new nh.a(latLng, str, str2);
                    kp.a(new ns.AnonymousClass1(aVar));
                    return new Pair<>(nsVar, aVar);
                }
            }
        }
        return pair;
    }

    @Override // com.tencent.mapsdk.internal.nh
    public final void e() {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = this.f149469i.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f149469i.get(it.next()));
        }
        this.f149455a.a(arrayList);
        if (this.f149455a.y()) {
            this.f149455a.f150520j.f149412y = true;
        }
    }

    public final void a(long j3, int i3, float f16, boolean z16) {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).e_() == j3) {
                tk tkVar = this.f149455a;
                tkVar.a(new tk.AnonymousClass83(j3, i3, f16, z16));
            }
        }
    }

    public final void a(long j3) {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).e_() == j3) {
                tk tkVar = this.f149455a;
                tkVar.a(new tk.AnonymousClass84(j3));
            }
        }
    }

    public final int d(long j3) {
        tk tkVar = this.f149455a;
        return Math.max(((Integer) tkVar.b((CallbackRunnable<tk.AnonymousClass89>) new tk.AnonymousClass89(j3), (tk.AnonymousClass89) 0)).intValue(), 0);
    }

    public final void a(long j3, int i3) {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).e_() == j3) {
                tk tkVar = this.f149455a;
                tkVar.a(new tk.AnonymousClass91(j3, i3));
            }
        }
    }

    public final List<CommonParamsModelClass.MaterialVariantInfo> c(long j3) {
        tk tkVar = this.f149455a;
        tk.AnonymousClass88 anonymousClass88 = new tk.AnonymousClass88(j3);
        String[] strArr = (String[]) tkVar.b((CallbackRunnable<tk.AnonymousClass88>) anonymousClass88, (tk.AnonymousClass88) new String[0]);
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                CommonParamsModelClass.MaterialVariantInfo materialVariantInfo = new CommonParamsModelClass.MaterialVariantInfo();
                materialVariantInfo.variantName = str;
                arrayList.add(materialVariantInfo);
            }
        }
        return arrayList;
    }

    public final void a(long j3, float f16, float f17, float f18) {
        Iterator it = this.f149456b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ns) ((Map.Entry) it.next()).getValue()).e_() == j3) {
                tk tkVar = this.f149455a;
                tkVar.a(new tk.AnonymousClass92(j3, f16, f17, f18));
            }
        }
    }

    private nq h() {
        return this;
    }
}
