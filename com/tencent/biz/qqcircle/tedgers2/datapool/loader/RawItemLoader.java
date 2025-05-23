package com.tencent.biz.qqcircle.tedgers2.datapool.loader;

import android.os.Handler;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolConfig;
import ec0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RawItemLoader extends a {

    /* renamed from: j, reason: collision with root package name */
    private final gc0.c f92499j;

    public RawItemLoader(dc0.b bVar, DataPoolConfig dataPoolConfig, Handler handler, d dVar) {
        super(bVar, dataPoolConfig, handler, dVar);
        this.f92499j = new gc0.c(bVar, dataPoolConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final boolean z16, final List<QFSEdgeItem> list) {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.RawItemLoader.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                RawItemLoader rawItemLoader = RawItemLoader.this;
                boolean z17 = false;
                rawItemLoader.f92507f = false;
                dc0.c cVar = ((dc0.a) rawItemLoader).f393528b;
                String h16 = RawItemLoader.this.h();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[handleRequestRawItemRsp]  | success = ");
                sb5.append(z16);
                sb5.append(" | result.size = ");
                List list2 = list;
                if (list2 != null) {
                    i3 = list2.size();
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                cVar.a(h16, sb5.toString());
                if (!z16) {
                    ((dc0.a) RawItemLoader.this).f393528b.f(RawItemLoader.this.h(), 8, "fail for request raw item");
                    return;
                }
                List list3 = list;
                if (list3 != null && list3.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((QFSEdgeItem) it.next()).setTimeStamp(System.currentTimeMillis());
                    }
                } else {
                    ((dc0.a) RawItemLoader.this).f393528b.f(RawItemLoader.this.h(), 8, "result is empty");
                    z17 = true;
                }
                RawItemLoader.this.f92499j.b(list);
                ((dc0.a) RawItemLoader.this).f393528b.a(RawItemLoader.this.h(), "[handleRequestRawItemRsp] after add,  | mRawItemPool.getAllData().size() = " + RawItemLoader.this.f92499j.d().size());
                RawItemLoader.this.n();
                RawItemLoader.this.o(z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        List<QFSEdgeItem> b16;
        this.f393528b.a(h(), "[restart]");
        ec0.a c16 = c();
        if (c16 != null && (b16 = c16.b(0)) != null) {
            this.f393528b.a(h(), "[restart] data size:" + b16);
            this.f92499j.b(b16);
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        m();
        ArrayList arrayList = new ArrayList(this.f92499j.d());
        this.f393528b.a(h(), "[stop] allData size = " + arrayList.size());
        this.f92499j.f();
        ec0.a c16 = c();
        if (c16 != null) {
            c16.f(arrayList, 0);
        }
    }

    public void D(List<QFSEdgeItem> list) {
        int i3;
        this.f92499j.h(list);
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[removeRawItemList]  | removeList.size = ");
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(" | mRawItemPool.getAllData().size() = ");
        sb5.append(this.f92499j.d().size());
        cVar.a(h16, sb5.toString());
    }

    public void E() {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.e
            @Override // java.lang.Runnable
            public final void run() {
                RawItemLoader.this.B();
            }
        });
    }

    public void F() {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.f
            @Override // java.lang.Runnable
            public final void run() {
                RawItemLoader.this.C();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected void f() {
        DataPoolConfig dataPoolConfig;
        if (b() != null && c() != null && (dataPoolConfig = this.f92504c) != null) {
            if (this.f92507f) {
                this.f393528b.a(h(), "[doStartLoadData]  already requesting... , return");
                return;
            }
            final int min = Math.min(dataPoolConfig.f92466c - this.f92499j.d().size(), this.f92504c.f92471h);
            this.f393528b.a(h(), "[doStartLoadData]  | mDataPoolConfig.mItemIndexPoolUpperLimit = " + this.f92504c.f92466c + " | mRawItemPool.getAllData().size = " + this.f92499j.d().size() + " | mDataPoolConfig.mItemIndexRequestNum = " + this.f92504c.f92471h + " | needNum = " + min);
            this.f393528b.a(h(), "[doStartLoadData]  | request......");
            this.f92507f = true;
            a(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.RawItemLoader.1

                /* compiled from: P */
                /* renamed from: com.tencent.biz.qqcircle.tedgers2.datapool.loader.RawItemLoader$1$a */
                /* loaded from: classes5.dex */
                class a implements a.InterfaceC10228a {
                    a() {
                    }

                    @Override // ec0.a.InterfaceC10228a
                    public void a(boolean z16, List<QFSEdgeItem> list, Map<String, String> map) {
                        RawItemLoader.this.A(z16, list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (RawItemLoader.this.b() != null && RawItemLoader.this.c() != null) {
                        RawItemLoader.this.c().a(min, RawItemLoader.this.f92504c.f92473j, new a());
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected gc0.a g() {
        return this.f92499j;
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected String h() {
        return "DP-RawItemLoader";
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected int i() {
        return 2;
    }

    public List<QFSEdgeItem> z(int i3) {
        int i16;
        List<QFSEdgeItem> e16 = this.f92499j.e(i3);
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getRawItemList]  | needSize = ");
        sb5.append(i3);
        sb5.append(" | resultList.size = ");
        if (e16 != null) {
            i16 = e16.size();
        } else {
            i16 = 0;
        }
        sb5.append(i16);
        cVar.a(h16, sb5.toString());
        return e16;
    }
}
