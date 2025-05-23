package com.tencent.biz.qqcircle.tedgers2.datapool.loader;

import android.os.Handler;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolConfig;
import ec0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DetailItemLoader extends a {

    /* renamed from: j, reason: collision with root package name */
    private final gc0.b f92493j;

    public DetailItemLoader(dc0.b bVar, DataPoolConfig dataPoolConfig, Handler handler, d dVar) {
        super(bVar, dataPoolConfig, handler, dVar);
        this.f92493j = new gc0.b(bVar, dataPoolConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final boolean z16, final List<QFSEdgeItem> list, final List<QFSEdgeItem> list2) {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.DetailItemLoader.2
            @Override // java.lang.Runnable
            public void run() {
                int size;
                List list3;
                DetailItemLoader detailItemLoader = DetailItemLoader.this;
                boolean z17 = false;
                detailItemLoader.f92507f = false;
                dc0.c cVar = ((dc0.a) detailItemLoader).f393528b;
                String h16 = DetailItemLoader.this.h();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[handleRequestDetailItemRsp]  | success = ");
                sb5.append(z16);
                sb5.append(" | result.size = ");
                List list4 = list;
                if (list4 == null) {
                    size = 0;
                } else {
                    size = list4.size();
                }
                sb5.append(size);
                cVar.a(h16, sb5.toString());
                if (z16 && (list3 = list) != null) {
                    if (list3 != null && list3.size() > 0) {
                        HashMap hashMap = new HashMap();
                        for (QFSEdgeItem qFSEdgeItem : list2) {
                            hashMap.put(qFSEdgeItem.getItemID(), qFSEdgeItem);
                        }
                        for (QFSEdgeItem qFSEdgeItem2 : list) {
                            if (hashMap.containsKey(qFSEdgeItem2.getItemID())) {
                                qFSEdgeItem2.setTimeStamp(((QFSEdgeItem) hashMap.get(qFSEdgeItem2.getItemID())).getTimeStamp());
                            } else {
                                qFSEdgeItem2.setTimeStamp(System.currentTimeMillis());
                            }
                        }
                        DetailItemLoader.this.f92493j.b(list);
                        ((dc0.a) DetailItemLoader.this).f393528b.a(DetailItemLoader.this.h(), "[handleRequestDetailItemRsp] after add | getAllData().size() = " + DetailItemLoader.this.f92493j.d().size());
                        DetailItemLoader.this.f92506e.b(list);
                    } else {
                        ((dc0.a) DetailItemLoader.this).f393528b.f(DetailItemLoader.this.h(), 8, "result is empty");
                        z17 = true;
                    }
                    DetailItemLoader.this.n();
                    DetailItemLoader.this.o(z17);
                    return;
                }
                ((dc0.a) DetailItemLoader.this).f393528b.f(DetailItemLoader.this.h(), 8, "fail for request detail item");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        List<QFSEdgeItem> b16;
        this.f393528b.a(h(), "[restart]");
        ec0.a c16 = c();
        if (c16 != null && (b16 = c16.b(1)) != null) {
            this.f393528b.a(h(), "[restart] data size:" + b16);
            this.f92493j.b(b16);
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        m();
        ArrayList arrayList = new ArrayList(this.f92493j.d());
        this.f393528b.a(h(), "[stop] allData size = " + arrayList.size());
        this.f92493j.f();
        c().f(arrayList, 1);
    }

    public void B(List<QFSEdgeItem> list, int i3) {
        int size;
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[insertItemList]  | position = ");
        sb5.append(i3);
        sb5.append(" | itemList.size = ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        cVar.a(h16, sb5.toString());
        this.f92493j.c(list, i3);
    }

    public void E(List<QFSEdgeItem> list) {
        int size;
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pushbackItemList]  | itemList.size = ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        cVar.a(h16, sb5.toString());
        this.f92493j.b(list);
    }

    public void F(List<QFSEdgeItem> list) {
        int size;
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[removeItemList]  | list.size = ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        cVar.a(h16, sb5.toString());
        this.f92493j.h(list);
        o(false);
    }

    public void G() {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.c
            @Override // java.lang.Runnable
            public final void run() {
                DetailItemLoader.this.C();
            }
        });
    }

    public void H() {
        this.f92505d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.b
            @Override // java.lang.Runnable
            public final void run() {
                DetailItemLoader.this.D();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected void f() {
        DataPoolConfig dataPoolConfig;
        int size;
        if (b() != null && c() != null && (dataPoolConfig = this.f92504c) != null && this.f92506e != null) {
            if (this.f92507f) {
                this.f393528b.a(h(), "[doStartLoadData]  already requesting... , return");
                return;
            }
            int min = Math.min(dataPoolConfig.f92468e - this.f92493j.d().size(), this.f92504c.f92472i);
            final List<QFSEdgeItem> a16 = this.f92506e.a(min);
            dc0.c cVar = this.f393528b;
            String h16 = h();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[doStartLoadData]  | mDataPoolConfig.mItemDetailPoolUpperLimit = ");
            sb5.append(this.f92504c.f92468e);
            sb5.append(" | mDetailItemPool.getAllData().size = ");
            sb5.append(this.f92493j.d().size());
            sb5.append(" | mDataPoolConfig.mItemDetailRequestNum = ");
            sb5.append(this.f92504c.f92472i);
            sb5.append(" | getRawList.size = ");
            if (a16 == null) {
                size = 0;
            } else {
                size = a16.size();
            }
            sb5.append(size);
            sb5.append(" | needNum = ");
            sb5.append(min);
            cVar.a(h16, sb5.toString());
            if (a16 != null && a16.size() != 0) {
                this.f393528b.a(h(), "[doStartLoadData]  | request......");
                this.f92507f = true;
                a(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.loader.DetailItemLoader.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.biz.qqcircle.tedgers2.datapool.loader.DetailItemLoader$1$a */
                    /* loaded from: classes5.dex */
                    class a implements a.InterfaceC10228a {
                        a() {
                        }

                        @Override // ec0.a.InterfaceC10228a
                        public void a(boolean z16, List<QFSEdgeItem> list, Map<String, String> map) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            DetailItemLoader.this.A(z16, list, a16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (DetailItemLoader.this.b() != null && DetailItemLoader.this.c() != null) {
                            DetailItemLoader.this.c().e(a16, new a());
                        }
                    }
                });
                return;
            }
            this.f393528b.a(h(), "[doStartLoadData]  not raw data, no request");
        }
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected gc0.a g() {
        return this.f92493j;
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected String h() {
        return "DP-DetailItemLoader";
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.a
    protected int i() {
        return 3;
    }

    public List<QFSEdgeItem> z(int i3, long j3) {
        int size;
        List<QFSEdgeItem> j16 = this.f92493j.j(i3, j3);
        dc0.c cVar = this.f393528b;
        String h16 = h();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getItemList]  | maxCount = ");
        sb5.append(i3);
        sb5.append(" | duration = ");
        sb5.append(j3);
        sb5.append(" | resultList.size = ");
        if (j16 == null) {
            size = 0;
        } else {
            size = j16.size();
        }
        sb5.append(size);
        cVar.a(h16, sb5.toString());
        return j16;
    }
}
