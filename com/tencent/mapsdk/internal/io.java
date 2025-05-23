package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.in;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class io extends in {

    /* renamed from: i, reason: collision with root package name */
    protected boolean f148807i;

    /* renamed from: j, reason: collision with root package name */
    protected List<in> f148808j;

    public io(boolean z16) {
        this.f148808j = null;
        this.f148807i = z16;
        this.f148808j = new ArrayList();
    }

    public final void a(in inVar) {
        if (inVar == null) {
            return;
        }
        this.f148808j.add(inVar);
    }

    public final void c() {
        List<in> list = this.f148808j;
        if (list == null) {
            return;
        }
        list.clear();
    }

    @Override // com.tencent.mapsdk.internal.in
    public final void a(long j3) {
        int size;
        super.a(j3);
        List<in> list = this.f148808j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            in inVar = this.f148808j.get(i3);
            if (inVar != null) {
                inVar.a(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        int size;
        List<in> list = this.f148808j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            in inVar = this.f148808j.get(i3);
            if (inVar != null) {
                if (this.f148807i) {
                    inVar.a(f16, interpolator);
                } else {
                    inVar.a(f16, inVar.f148804f);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.in
    public final boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        List<in> list;
        int size;
        boolean a16 = super.a(geoPoint, geoPoint2);
        if (!a16 || (list = this.f148808j) == null || (size = list.size()) == 0) {
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            in inVar = this.f148808j.get(i3);
            if (inVar != null) {
                a16 = a16 && inVar.a(geoPoint, geoPoint2);
            }
        }
        return a16;
    }

    @Override // com.tencent.mapsdk.internal.in
    public final void a(in.b bVar) {
        int size;
        super.a(bVar);
        List<in> list = this.f148808j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            in inVar = this.f148808j.get(i3);
            if (inVar != null) {
                inVar.a(bVar);
            }
        }
    }
}
