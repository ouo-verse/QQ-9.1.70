package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ql implements fd {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<fd> f149878a = new ArrayList<>();

    public final synchronized void a(fd fdVar) {
        if (fdVar != null) {
            if (!this.f149878a.contains(fdVar)) {
                this.f149878a.add(fdVar);
            }
        }
    }

    public final synchronized void b(fd fdVar) {
        this.f149878a.remove(fdVar);
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean c(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).c(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean d(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).d(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean e(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).e(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean f(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).f(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean g(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).g(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean h(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).h(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean i(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).i(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean j(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).j(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean k(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).k(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean b(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).b(f16, f17)) {
                return true;
            }
        }
        LogUtil.b("notify onSingleTap");
        for (int size2 = this.f149878a.size() - 1; size2 >= 0; size2--) {
            this.f149878a.get(size2).a();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean a(float f16, float f17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).a(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean c() {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).c()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean d() {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final void a() {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            this.f149878a.get(size).a();
        }
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean a(float f16) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).a(f16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean b() {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).b()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean a(PointF pointF, PointF pointF2, float f16) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).a(pointF, pointF2, f16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean b(float f16) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).b(f16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final synchronized boolean a(PointF pointF, PointF pointF2, double d16, double d17) {
        for (int size = this.f149878a.size() - 1; size >= 0; size--) {
            if (this.f149878a.get(size).a(pointF, pointF2, d16, d17)) {
                return true;
            }
        }
        return false;
    }
}
