package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stFeedStatus;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.request.PersonalFeedListRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile String f81953a = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f81954b;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f81959a;

        /* renamed from: b, reason: collision with root package name */
        public String f81960b;

        public String toString() {
            return "ExtParams{mFeedId='" + this.f81959a + "', mTipMsg='" + this.f81960b + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f81961a;

        /* renamed from: b, reason: collision with root package name */
        boolean f81962b;

        /* renamed from: c, reason: collision with root package name */
        List<j> f81963c;

        /* renamed from: d, reason: collision with root package name */
        b f81964d;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final a f81965a = new a();
    }

    a() {
    }

    private com.tencent.biz.pubaccount.weishi.net.common.b<stGetPersonalFeedListRsp, c> c(boolean z16, boolean z17, jz.c<j> cVar) {
        return new C0832a(z17, z16, cVar);
    }

    private ArrayList<String> d(List<j> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            for (j jVar : list) {
                if (jVar != null && jVar.e() != null) {
                    arrayList.add(jVar.e().f25129id);
                }
            }
        }
        return arrayList;
    }

    public static a e() {
        return d.f81965a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c f(stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar, boolean z16, boolean z17, jz.c<j> cVar) {
        b bVar = new b();
        if (z16) {
            g(stgetpersonalfeedlistrsp, cVar);
            i(stgetpersonalfeedlistrsp, bVar);
        }
        this.f81953a = stgetpersonalfeedlistrsp.attach_info;
        boolean z18 = stgetpersonalfeedlistrsp.is_finished;
        this.f81954b = z18;
        ArrayList<stSimpleMetaFeed> arrayList = stgetpersonalfeedlistrsp.feeds;
        List<j> e16 = i.e(arrayList, z18);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSVerticalDataManager.java][onTaskResponse] dataList size:");
        sb5.append(e16.size());
        sb5.append(", isFirst = ");
        sb5.append(z16);
        sb5.append(", mAttachInfo = ");
        sb5.append(this.f81953a);
        sb5.append(", isFinish = ");
        sb5.append(stgetpersonalfeedlistrsp.is_finished);
        sb5.append(", size = ");
        sb5.append(arrayList != null ? arrayList.size() : 0);
        x.j("WSArkCardDataManagerLog", sb5.toString());
        if (dVar != null) {
            com.tencent.biz.pubaccount.weishi.report.c.b().d(stgetpersonalfeedlistrsp.traceId, dVar.f80962a);
        }
        c cVar2 = new c();
        cVar2.f81963c = e16;
        cVar2.f81961a = z16;
        cVar2.f81962b = z17;
        cVar2.f81964d = bVar;
        return cVar2;
    }

    private void g(stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, jz.c<j> cVar) {
        if (cVar instanceof AbsWSVerticalPagePresenter) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = ((AbsWSVerticalPagePresenter) cVar).O0();
            WSVerticalPageFragment wSVerticalPageFragment = O0 instanceof WSVerticalPageFragment ? (WSVerticalPageFragment) O0 : null;
            if (wSVerticalPageFragment == null || wSVerticalPageFragment.getBaseActivity() == null || wSVerticalPageFragment.getBaseActivity().isFinishing()) {
                return;
            }
            iz.a.g().s(10007, stgetpersonalfeedlistrsp.config);
        }
    }

    private void h() {
        this.f81953a = "";
        this.f81954b = false;
    }

    private void i(stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, b bVar) {
        stFeedStatus stfeedstatus = stgetpersonalfeedlistrsp.contextFeedStatus;
        if (stfeedstatus != null) {
            bVar.f81959a = stfeedstatus.feedId;
            bVar.f81960b = stfeedstatus.f25118msg;
            x.j("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][setExtParams] extParams:" + bVar);
        }
    }

    public void b(String str, int i3, boolean z16, boolean z17, List<j> list, jz.c<j> cVar) {
        String str2;
        if (z17 || z16) {
            h();
        }
        if (this.f81954b) {
            x.j("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
            return;
        }
        ArrayList<String> d16 = d(list);
        if (d16.size() > 0) {
            str2 = d16.get(0);
        } else {
            str2 = "";
        }
        x.f("WSArkCardDataManagerLog", "[WSArkCardDataManager.java] PersonalFeedListRequest isFirst = " + z17 + " feedId = " + str2 + " attachInfo = " + this.f81953a);
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new PersonalFeedListRequest(str, this.f81953a, z17, d16, i3)).b(c(z16, z17, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0832a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetPersonalFeedListRsp, c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81955a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f81956b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ jz.c f81957c;

        C0832a(boolean z16, boolean z17, jz.c cVar) {
            this.f81955a = z16;
            this.f81956b = z17;
            this.f81957c = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            super.b(jVar);
            jz.c cVar = this.f81957c;
            if (cVar != null) {
                cVar.i(jVar.a(), jVar.b(), this.f81955a, this.f81956b);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public c c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetPersonalFeedListRsp> gVar, stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return a.this.f(stgetpersonalfeedlistrsp, dVar, this.f81955a, this.f81956b, this.f81957c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(c cVar) {
            super.d(cVar);
            jz.c cVar2 = this.f81957c;
            if (cVar2 != null) {
                cVar2.d0(cVar.f81963c, cVar.f81962b, cVar.f81961a, cVar.f81964d);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
