package oz;

import UserGrowth.stGetHistoryDramaRsp;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSHistoryDramaRequest;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d implements jz.b<jz.a, c> {

    /* renamed from: a, reason: collision with root package name */
    private String f424529a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<c> f424534a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f424535b;

        public b(ArrayList<c> arrayList, boolean z16) {
            this.f424534a = arrayList;
            this.f424535b = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b f(stGetHistoryDramaRsp stgethistorydramarsp) {
        this.f424529a = stgethistorydramarsp.attachInfo;
        ArrayList arrayList = new ArrayList();
        if (stgethistorydramarsp.dramas != null) {
            for (int i3 = 0; i3 < stgethistorydramarsp.dramas.size(); i3++) {
                arrayList.add(new c(stgethistorydramarsp.dramas.get(i3)));
            }
        } else {
            x.f("WSDramaHistoryDataFetcher", "[WSDramaHistoryDataFetcher.java][handleSuccessOnSubThread] historyDramaRsp.dramas is null!");
        }
        x.j("WSDramaHistoryDataFetcher", "[WSDramaHistoryDataFetcher.java][handleSuccessOnSubThread] data list:" + arrayList.size());
        return new b(arrayList, stgethistorydramarsp.isFinished);
    }

    @Override // jz.b
    public boolean a(jz.a aVar, jz.c<c> cVar) {
        boolean a16 = aVar.a();
        boolean b16 = aVar.b();
        if (a16) {
            this.f424529a = "";
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSHistoryDramaRequest(bb.q(), this.f424529a)).b(new a(a16, b16, cVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z16, boolean z17, j jVar, jz.c cVar) {
        if (cVar != null) {
            cVar.i(jVar.a(), jVar.b(), z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, boolean z17, b bVar, jz.c<c> cVar) {
        if (cVar != null) {
            cVar.d0(bVar.f424534a, z17, z16, Boolean.valueOf(!bVar.f424535b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetHistoryDramaRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f424530a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f424531b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ jz.c f424532c;

        a(boolean z16, boolean z17, jz.c cVar) {
            this.f424530a = z16;
            this.f424531b = z17;
            this.f424532c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            d.this.e(this.f424530a, this.f424531b, jVar, this.f424532c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetHistoryDramaRsp> gVar, stGetHistoryDramaRsp stgethistorydramarsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return d.this.f(stgethistorydramarsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b bVar) {
            super.d(bVar);
            d.this.g(this.f424530a, this.f424531b, bVar, this.f424532c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }
    }
}
