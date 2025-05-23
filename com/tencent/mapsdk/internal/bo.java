package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class bo implements TencentMapComponent.Component {

    /* renamed from: a, reason: collision with root package name */
    final Map<bp, Boolean> f147907a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private bp f147908b;

    private int e() {
        return this.f147907a.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
    }

    public final void b_() {
        c_();
        if (this.f147907a.size() <= 0) {
            this.f147908b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bp bpVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void d(bp bpVar) {
        if (bpVar != null) {
            this.f147907a.remove(bpVar);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component
    /* renamed from: n_, reason: merged with bridge method [inline-methods] */
    public final synchronized bp getMapContext() {
        return this.f147908b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(bp bpVar) {
        if (bpVar != null) {
            this.f147907a.put(bpVar, Boolean.TRUE);
        }
        a(bpVar, null);
    }

    public final Context c() {
        bp mapContext = getMapContext();
        if (mapContext != null) {
            return mapContext.getContext();
        }
        return null;
    }

    public synchronized void a(bp bpVar, Bundle bundle) {
        if (this.f147907a.size() == 0) {
            return;
        }
        this.f147908b = bpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(bp bpVar) {
    }
}
