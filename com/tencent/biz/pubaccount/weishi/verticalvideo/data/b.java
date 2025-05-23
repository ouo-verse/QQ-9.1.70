package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stGetCollectionRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSCollectionRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b implements jz.b<c, j> {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f81966a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public boolean f81967b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f81968c;

    /* renamed from: d, reason: collision with root package name */
    public String f81969d;

    /* renamed from: e, reason: collision with root package name */
    public String f81970e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0833b {

        /* renamed from: a, reason: collision with root package name */
        public List<j> f81974a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f81975b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f81976c;

        /* renamed from: d, reason: collision with root package name */
        public String f81977d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f81978e;

        public C0833b(List<j> list, boolean z16, boolean z17, String str, boolean z18) {
            this.f81974a = list;
            this.f81975b = z16;
            this.f81976c = z17;
            this.f81977d = str;
            this.f81978e = z18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(boolean z16, boolean z17) {
        if (z16) {
            return 1;
        }
        if (z17) {
            return 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0833b h(stGetCollectionRsp stgetcollectionrsp, c cVar) {
        boolean z16 = stgetcollectionrsp.isFinished;
        boolean z17 = cVar.f81983g == 0;
        d(stgetcollectionrsp, cVar, z16, z17);
        ArrayList<stSimpleMetaFeed> arrayList = stgetcollectionrsp.feedList;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<stSimpleMetaFeed> it = arrayList.iterator();
            while (it.hasNext()) {
                stSimpleMetaFeed next = it.next();
                if (!this.f81966a.contains(next.f25129id)) {
                    this.f81966a.add(next.f25129id);
                    j f16 = i.f(next);
                    f16.l(stgetcollectionrsp.collection);
                    if (cVar.f81979c) {
                        f16.setChecked(TextUtils.equals(next.f25129id, cVar.f81982f));
                    }
                    arrayList2.add(f16);
                }
            }
            if (cVar.f81979c) {
                ((j) arrayList2.get(0)).setChecked(true);
            }
        }
        x.j("WSCollectionDataFetcher", "[WSCollectionDataManager.java][handleRspOnSubThread] itemDataList size:" + arrayList2.size() + ", mIsFinished:" + z16);
        return new C0833b(arrayList2, cVar.f81979c, z17, stgetcollectionrsp.attachInfo, z16);
    }

    @Override // jz.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(c cVar, jz.c<j> cVar2) {
        x.i("WSCollectionDataFetcher", "[WSCollectionDataManager.java][fetchData] params:" + cVar.toString());
        boolean z16 = cVar.f81983g == 0;
        if (i(z16)) {
            x.i("WSCollectionDataFetcher", "[WSCollectionDataManager.java][fetchData] is finished. isLoadMoreDown = " + cVar.f81983g);
            return false;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSCollectionRequest(cVar.f81981e, cVar.f81982f, f(z16), 4011, cVar.f81983g)).b(new a(cVar, cVar2));
        return true;
    }

    private void d(stGetCollectionRsp stgetcollectionrsp, c cVar, boolean z16, boolean z17) {
        if (z17) {
            this.f81968c = z16;
            this.f81970e = stgetcollectionrsp.attachInfo;
        } else {
            this.f81967b = z16;
            this.f81969d = stgetcollectionrsp.attachInfo;
        }
        if (cVar.f81979c) {
            String str = stgetcollectionrsp.attachInfo;
            this.f81970e = str;
            this.f81969d = str;
        }
    }

    private String f(boolean z16) {
        if (z16) {
            return this.f81970e;
        }
        return this.f81969d;
    }

    private boolean i(boolean z16) {
        if (z16) {
            return this.f81968c;
        }
        return this.f81967b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetCollectionRsp, C0833b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f81971a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.c f81972b;

        a(c cVar, jz.c cVar2) {
            this.f81971a = cVar;
            this.f81972b = cVar2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            super.b(jVar);
            jz.c cVar = this.f81972b;
            if (cVar != null) {
                int a16 = jVar.a();
                String b16 = jVar.b();
                c cVar2 = this.f81971a;
                cVar.i(a16, b16, cVar2.f81979c, cVar2.f81980d);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C0833b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetCollectionRsp> gVar, stGetCollectionRsp stgetcollectionrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return b.this.h(stgetcollectionrsp, this.f81971a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C0833b c0833b) {
            super.d(c0833b);
            if (this.f81972b != null) {
                this.f81972b.d0(c0833b.f81974a, false, c0833b.f81975b, Integer.valueOf(b.this.g(c0833b.f81975b, c0833b.f81976c)));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
