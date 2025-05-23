package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cn extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388418a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388420c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388422e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388424g;

    /* renamed from: b, reason: collision with root package name */
    private int f388419b = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f388421d = false;

    /* renamed from: f, reason: collision with root package name */
    private int f388423f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f388425h = false;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f388426i = Collections.emptyList();

    /* renamed from: j, reason: collision with root package name */
    private int f388427j = -1;

    public static cn n(byte[] bArr) {
        return (cn) new cn().c(bArr);
    }

    public static cn r(ac acVar) {
        return new cn().b(acVar);
    }

    public boolean A() {
        return this.f388424g;
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388427j < 0) {
            i();
        }
        return this.f388427j;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (p()) {
            cVar.M(1, u());
        }
        if (v()) {
            cVar.y(2, t());
        }
        if (x()) {
            cVar.t(3, w());
        }
        if (A()) {
            cVar.y(4, z());
        }
        Iterator<String> it = o().iterator();
        while (it.hasNext()) {
            cVar.x(5, it.next());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3;
        int i16 = 0;
        if (p()) {
            i3 = c.H(1, u()) + 0;
        } else {
            i3 = 0;
        }
        if (v()) {
            i3 += c.h(2, t());
        }
        if (x()) {
            i3 += c.c(3, w());
        }
        if (A()) {
            i3 += c.h(4, z());
        }
        Iterator<String> it = o().iterator();
        while (it.hasNext()) {
            i16 += c.l(it.next());
        }
        int size = i3 + i16 + (o().size() * 1);
        this.f388427j = size;
        return size;
    }

    public cn j(int i3) {
        this.f388418a = true;
        this.f388419b = i3;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public cn b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 8) {
                    if (b16 != 16) {
                        if (b16 != 24) {
                            if (b16 != 32) {
                                if (b16 != 42) {
                                    if (!g(acVar, b16)) {
                                        return this;
                                    }
                                } else {
                                    l(acVar.h());
                                }
                            } else {
                                s(acVar.l());
                            }
                        } else {
                            q(acVar.p());
                        }
                    } else {
                        m(acVar.l());
                    }
                } else {
                    j(acVar.u());
                }
            } else {
                return this;
            }
        }
    }

    public cn l(String str) {
        str.getClass();
        if (this.f388426i.isEmpty()) {
            this.f388426i = new ArrayList();
        }
        this.f388426i.add(str);
        return this;
    }

    public cn m(boolean z16) {
        this.f388420c = true;
        this.f388421d = z16;
        return this;
    }

    public List<String> o() {
        return this.f388426i;
    }

    public boolean p() {
        return this.f388418a;
    }

    public cn q(int i3) {
        this.f388422e = true;
        this.f388423f = i3;
        return this;
    }

    public cn s(boolean z16) {
        this.f388424g = true;
        this.f388425h = z16;
        return this;
    }

    public boolean t() {
        return this.f388421d;
    }

    public int u() {
        return this.f388419b;
    }

    public boolean v() {
        return this.f388420c;
    }

    public int w() {
        return this.f388423f;
    }

    public boolean x() {
        return this.f388422e;
    }

    public int y() {
        return this.f388426i.size();
    }

    public boolean z() {
        return this.f388425h;
    }
}
