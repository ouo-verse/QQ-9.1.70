package com.tencent.av.opengl.effects;

import android.util.SparseArray;
import com.tencent.av.opengl.effects.c;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected SparseArray<String> f73970a;

    /* renamed from: b, reason: collision with root package name */
    protected LinkedHashMap<String, c.a> f73971b;

    public LinkedHashMap<String, c.a> a() {
        return this.f73971b;
    }

    public int b(String str) {
        c.a aVar = this.f73971b.get(str);
        if (aVar != null) {
            return aVar.f73969e;
        }
        return 0;
    }

    public SparseArray<String> c() {
        return this.f73970a;
    }

    public abstract String d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    public abstract void g(String str);

    public boolean h(String str, int i3) {
        c.a aVar = this.f73971b.get(str);
        if (aVar != null && aVar.f73969e != i3) {
            aVar.f73969e = i3;
            return true;
        }
        return false;
    }
}
