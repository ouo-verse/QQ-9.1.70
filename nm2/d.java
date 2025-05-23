package nm2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private final e f420463a;

    /* renamed from: b, reason: collision with root package name */
    private final float f420464b;

    /* renamed from: c, reason: collision with root package name */
    private final int f420465c;

    /* renamed from: d, reason: collision with root package name */
    private int f420466d = 0;

    /* renamed from: e, reason: collision with root package name */
    private float f420467e = 0.0f;

    public d(e eVar, float f16, int i3) {
        this.f420463a = eVar;
        this.f420464b = f16;
        this.f420465c = i3;
    }

    @Override // nm2.a
    public List<com.tencent.mobileqq.richmedia.particlesystem.a> a(int i3) {
        if (!b()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            float f16 = this.f420467e;
            if (f16 > 1.0f) {
                this.f420467e = f16 - 1.0f;
                arrayList.add(this.f420463a.a(i3));
            } else {
                return arrayList;
            }
        }
    }

    boolean b() {
        if (this.f420466d < this.f420465c) {
            return true;
        }
        return false;
    }

    @Override // nm2.a
    public boolean update(int i3) {
        this.f420466d += i3;
        this.f420467e += (i3 * this.f420464b) / 1000.0f;
        return b();
    }
}
