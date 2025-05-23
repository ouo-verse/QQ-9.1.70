package com.tencent.biz.qqcircle.tedgers2.datapool;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends dc0.a {

    /* renamed from: c, reason: collision with root package name */
    private DataPoolConfig f92487c;

    /* renamed from: d, reason: collision with root package name */
    private volatile DataPoolLoaderManager f92488d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f92489e;

    public a(dc0.b bVar) {
        super(bVar);
        this.f92489e = false;
    }

    private void f() {
        if (this.f92488d == null) {
            synchronized (a.class) {
                if (this.f92488d == null) {
                    this.f92488d = new DataPoolLoaderManager(b(), this.f92487c);
                    this.f393528b.e("DP-DataPoolImp", "[initLoaderManager]  | mDataPoolConfig = " + this.f92487c.toString());
                }
            }
        }
    }

    private boolean g() {
        if (this.f92487c == null) {
            this.f393528b.b("DP-DataPoolImp", 8, "[initLoaderManager]  mDataPoolConfig == null");
            return false;
        }
        return true;
    }

    public void d() {
        this.f393528b.e("DP-DataPoolImp", "[clearPool]");
        if (!g()) {
            return;
        }
        f();
        this.f92488d.p();
        this.f92489e = false;
    }

    public List<QFSEdgeItem> e(int i3) {
        this.f393528b.e("DP-DataPoolImp", "[getItemList]  | maxCount = " + i3);
        if (!g()) {
            return null;
        }
        f();
        return this.f92488d.q(i3, -1L);
    }

    public void h(List<QFSEdgeItem> list) {
        int size;
        dc0.c cVar = this.f393528b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[removeItemList]  | list.size = ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        cVar.e("DP-DataPoolImp", sb5.toString());
        if (!g()) {
            return;
        }
        f();
        this.f92488d.x(list);
    }

    public void i() {
        this.f393528b.e("DP-DataPoolImp", "[restart]");
        this.f92489e = true;
        if (!g()) {
            return;
        }
        f();
        this.f92488d.y();
    }

    public void j(DataPoolConfig dataPoolConfig) {
        String dataPoolConfig2;
        this.f92487c = dataPoolConfig;
        dc0.c cVar = this.f393528b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[setPoolConfig] | config = ");
        if (dataPoolConfig == null) {
            dataPoolConfig2 = "null";
        } else {
            dataPoolConfig2 = dataPoolConfig.toString();
        }
        sb5.append(dataPoolConfig2);
        cVar.e("DP-DataPoolImp", sb5.toString());
    }

    public void k() {
        this.f393528b.e("DP-DataPoolImp", "[startLoadData]");
        this.f92489e = true;
        if (!g()) {
            return;
        }
        f();
        if (this.f92487c.f92464a) {
            this.f92488d.z();
        }
    }

    public void l() {
        this.f393528b.e("DP-DataPoolImp", "[stop]");
        this.f92489e = false;
        if (!g()) {
            return;
        }
        f();
        this.f92488d.A();
    }
}
