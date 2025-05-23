package com.tencent.biz.webviewplugin;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class v implements com.tencent.biz.common.offline.a {
    public String C;
    public String D;
    public String E;
    public int F;

    /* renamed from: e, reason: collision with root package name */
    private int f97642e;

    /* renamed from: h, reason: collision with root package name */
    public String f97644h;

    /* renamed from: i, reason: collision with root package name */
    public String f97645i;

    /* renamed from: m, reason: collision with root package name */
    public String f97646m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<com.tencent.biz.common.util.f> f97641d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f97643f = 0;

    public v(String str) {
        this.f97644h = str;
    }

    public void a(com.tencent.biz.common.util.f fVar) {
        if (!this.f97641d.contains(fVar)) {
            this.f97641d.add(fVar);
        }
    }

    public int b() {
        return this.f97641d.size();
    }

    public int c() {
        return this.f97643f;
    }

    public void c0() {
        Iterator<com.tencent.biz.common.util.f> it = this.f97641d.iterator();
        while (it.hasNext()) {
            it.next().c0();
        }
    }

    public int d() {
        return this.f97642e;
    }

    public void e(com.tencent.biz.common.util.f fVar) {
        this.f97641d.remove(fVar);
    }

    public void f(int i3) {
        this.f97642e = i3;
    }

    @Override // com.tencent.biz.common.offline.a
    public void loaded(String str, int i3) {
        Iterator<com.tencent.biz.common.util.f> it = this.f97641d.iterator();
        while (it.hasNext()) {
            it.next().loaded(str, i3);
        }
    }

    @Override // com.tencent.biz.common.offline.a
    public void progress(int i3) {
        this.f97643f = i3;
        Iterator<com.tencent.biz.common.util.f> it = this.f97641d.iterator();
        while (it.hasNext()) {
            it.next().progress(i3);
        }
    }
}
