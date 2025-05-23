package nm2;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements a {

    /* renamed from: a, reason: collision with root package name */
    private final int f420494a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final e f420495b;

    /* renamed from: d, reason: collision with root package name */
    private final int f420497d;

    /* renamed from: c, reason: collision with root package name */
    private long f420496c = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f420498e = false;

    public f(@NonNull e eVar, int i3, int i16) {
        this.f420495b = eVar;
        this.f420494a = i3;
        this.f420497d = i16;
    }

    @Override // nm2.a
    public List<com.tencent.mobileqq.richmedia.particlesystem.a> a(int i3) {
        if (this.f420498e) {
            return Collections.emptyList();
        }
        if (this.f420496c < this.f420497d) {
            return Collections.emptyList();
        }
        this.f420498e = true;
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < this.f420494a; i16++) {
            arrayList.add(this.f420495b.a(i3));
        }
        return arrayList;
    }

    @Override // nm2.a
    public boolean update(int i3) {
        this.f420496c += i3;
        return !this.f420498e;
    }
}
