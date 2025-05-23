package com.tencent.av.opengl.effects;

import android.util.SparseArray;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    protected static SparseArray<String> f73961d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f73962a = false;

    /* renamed from: b, reason: collision with root package name */
    protected LinkedHashMap<String, a> f73963b;

    /* renamed from: c, reason: collision with root package name */
    private final d f73964c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f73965a;

        /* renamed from: b, reason: collision with root package name */
        final BeautyRealConfig.TYPE f73966b;

        /* renamed from: c, reason: collision with root package name */
        final int f73967c;

        /* renamed from: d, reason: collision with root package name */
        final int f73968d;

        /* renamed from: e, reason: collision with root package name */
        public int f73969e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(BeautyRealConfig.TYPE type, int i3, int i16, int i17) {
            this.f73966b = type;
            this.f73965a = i3;
            this.f73969e = i16;
            this.f73967c = i16;
            this.f73968d = i17;
        }
    }

    public c() {
        d eVar;
        if (com.tencent.av.ui.f.d()) {
            eVar = new f();
        } else {
            eVar = new e();
        }
        this.f73964c = eVar;
        h();
        g();
        f73961d = eVar.c();
        this.f73963b = eVar.a();
    }

    public static String d(int i3) {
        return f73961d.get(i3);
    }

    public void a() {
        Iterator<Map.Entry<String, a>> it = this.f73963b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                int i3 = value.f73969e;
                int i16 = value.f73968d;
                if (i3 != i16) {
                    value.f73969e = i16;
                    this.f73962a = true;
                }
            }
        }
    }

    public int b(String str) {
        return this.f73964c.b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(List<a> list) {
        if (list == null) {
            return;
        }
        Iterator<Map.Entry<String, a>> it = this.f73963b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                list.add(value);
            }
        }
    }

    public int e(String str) {
        a aVar = this.f73963b.get(str);
        if (aVar != null) {
            return aVar.f73968d;
        }
        return 0;
    }

    public String f() {
        return this.f73964c.d();
    }

    void g() {
        this.f73964c.e();
    }

    void h() {
        this.f73964c.f();
    }

    public boolean i() {
        return this.f73962a;
    }

    public boolean j() {
        Iterator<Map.Entry<String, a>> it = this.f73963b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null && value.f73969e != value.f73968d) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        this.f73962a = false;
    }

    public void l(String str) {
        this.f73964c.g(str);
    }

    public void m() {
        Iterator<Map.Entry<String, a>> it = this.f73963b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                int i3 = value.f73969e;
                int i16 = value.f73967c;
                if (i3 != i16) {
                    value.f73969e = i16;
                    this.f73962a = true;
                }
            }
        }
    }

    public void n(String str, int i3) {
        if (this.f73964c.h(str, i3)) {
            this.f73962a = true;
        }
    }

    public void o(c cVar) {
        if (cVar == null) {
            return;
        }
        for (String str : cVar.f73963b.keySet()) {
            a aVar = this.f73963b.get(str);
            if (aVar != null) {
                aVar.f73969e = cVar.b(str);
            }
        }
    }
}
