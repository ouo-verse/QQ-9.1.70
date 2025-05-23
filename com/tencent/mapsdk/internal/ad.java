package com.tencent.mapsdk.internal;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    public aj f147714a;

    public ad(aj ajVar) {
        this.f147714a = ajVar;
    }

    private void a() {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            ajVar.a();
            this.f147714a = null;
        }
    }

    private Location b() {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            return ajVar.e();
        }
        return null;
    }

    private void c() {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            ajVar.b();
        }
    }

    private void d() {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            ajVar.c();
        }
    }

    private boolean e() {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            return ajVar.d();
        }
        return false;
    }

    private void a(LocationSource locationSource) {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            ajVar.a(locationSource);
        }
    }

    private void a(MyLocationStyle myLocationStyle) {
        aj ajVar = this.f147714a;
        if (ajVar != null) {
            ajVar.a(myLocationStyle);
        }
    }
}
