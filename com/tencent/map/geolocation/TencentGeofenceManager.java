package com.tencent.map.geolocation;

import android.app.PendingIntent;
import android.content.Context;
import c.t.m.g.o0;
import c.t.m.g.u1;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentGeofenceManager {

    /* renamed from: a, reason: collision with root package name */
    public u1 f147565a;

    public TencentGeofenceManager(Context context) {
        o0.a(context.getApplicationContext());
        this.f147565a = new u1(context);
    }

    public void addFence(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        this.f147565a.a(tencentGeofence, pendingIntent);
    }

    public void destroy() {
        this.f147565a.d();
    }

    public void removeAllFences() {
        this.f147565a.h();
    }

    public void removeFence(TencentGeofence tencentGeofence) {
        this.f147565a.a(tencentGeofence);
    }

    public void removeFence(String str) {
        this.f147565a.c(str);
    }
}
