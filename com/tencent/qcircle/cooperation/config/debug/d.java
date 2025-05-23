package com.tencent.qcircle.cooperation.config.debug;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public int f342444b;

    /* renamed from: c, reason: collision with root package name */
    public List<b> f342445c;

    public d() {
        ArrayList arrayList = new ArrayList();
        this.f342445c = arrayList;
        l(arrayList);
        k();
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        if (this.f342445c.size() > 2) {
            return 9999;
        }
        return -9999;
    }

    protected abstract void g(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int h();

    public int i() {
        return this.f342444b;
    }

    public List<b> j() {
        return this.f342445c;
    }

    protected abstract void k();

    protected abstract void l(List<b> list);

    public boolean m() {
        List<b> list = this.f342445c;
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public boolean n() {
        if (!m() && this.f342445c.get(this.f342444b).b() == 1) {
            return true;
        }
        return false;
    }

    public void o(int i3) {
        for (b bVar : this.f342445c) {
            if (bVar != null && bVar.b() == i3) {
                p(this.f342445c.indexOf(bVar));
                return;
            }
        }
    }

    public void p(int i3) {
        this.f342444b = i3;
        g(i3);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
    }
}
