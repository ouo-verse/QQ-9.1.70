package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.gf;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class by implements gf.a {

    /* renamed from: a, reason: collision with root package name */
    public static final double f147964a = 1.0d;

    /* renamed from: d, reason: collision with root package name */
    private static final gi f147965d = new gi(1.0d);

    /* renamed from: b, reason: collision with root package name */
    fw f147966b;

    /* renamed from: c, reason: collision with root package name */
    double f147967c;

    public by(LatLng latLng, double d16) {
        this.f147966b = f147965d.d(latLng);
        if (d16 >= 0.0d) {
            this.f147967c = d16;
        } else {
            this.f147967c = 1.0d;
        }
    }

    private LatLng b() {
        return f147965d.b(this.f147966b);
    }

    private double c() {
        return this.f147967c;
    }

    @Override // com.tencent.mapsdk.internal.gf.a
    public final fw a() {
        return this.f147966b;
    }

    private void a(LatLng latLng) {
        this.f147966b = f147965d.d(latLng);
    }

    private void a(double d16) {
        if (d16 >= 0.0d) {
            this.f147967c = d16;
        } else {
            this.f147967c = 1.0d;
        }
    }

    public by(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
