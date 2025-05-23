package jz;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public int f411218e;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.e f411220g;

    /* renamed from: a, reason: collision with root package name */
    private final List<j> f411214a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List<stFeed> f411215b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public String f411216c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f411217d = "";

    /* renamed from: f, reason: collision with root package name */
    public SparseIntArray f411219f = new SparseIntArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f411221a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f411222b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f411223c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f411224d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f411225e;

        a(boolean z16, boolean z17, long j3, int i3, c cVar) {
            this.f411221a = z16;
            this.f411222b = z17;
            this.f411223c = j3;
            this.f411224d = i3;
            this.f411225e = cVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            String str;
            boolean z16 = this.f411221a || this.f411222b;
            boolean d16 = lVar.d();
            long currentTimeMillis = System.currentTimeMillis() - this.f411223c;
            f.this.o(lVar, currentTimeMillis, this.f411224d, this.f411221a);
            c cVar = this.f411225e;
            if (cVar != null) {
                cVar.b(this.f411221a, this.f411222b, d16, lVar.f80999l);
            }
            if (!d16) {
                x.f("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + lVar.f80991d + ", msg: " + lVar.f80990c);
                com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
                return;
            }
            Object obj = lVar.f80999l;
            if (!(obj instanceof stFollowFeedsRsp)) {
                x.f("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + lVar.f80999l);
                com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, -1, "\u6570\u636e\u65e0\u6cd5\u89e3\u6790\u6216\u4e3a\u7a7a");
                return;
            }
            stFollowFeedsRsp stfollowfeedsrsp = (stFollowFeedsRsp) obj;
            f fVar = f.this;
            fVar.f411216c = stfollowfeedsrsp.attatch_info;
            fVar.f411218e = stfollowfeedsrsp.cache_size;
            if (lVar.f81000m != null) {
                com.tencent.biz.pubaccount.weishi.report.c.b().d(stfollowfeedsrsp.trace_id, lVar.f81000m.f80962a);
            }
            if (this.f411221a) {
                f fVar2 = f.this;
                String str2 = stfollowfeedsrsp.feeds_source;
                fVar2.f411217d = str2;
                WSFollowBeaconReport.n(str2);
            }
            if (r.q(stfollowfeedsrsp.feeds)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
                if (stfollowfeedsrsp.feeds == null) {
                    str = "null";
                } else {
                    str = "size = 0";
                }
                sb5.append(str);
                x.j("FollowRequest", sb5.toString());
                return;
            }
            x.j("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + stfollowfeedsrsp.feeds.size());
            f.this.k(stfollowfeedsrsp.feeds, z16, this.f411224d, stfollowfeedsrsp.is_finished, this.f411225e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final f f411227a = new f();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c<T> {
        void a(boolean z16, List<T> list, boolean z17);

        void b(boolean z16, boolean z17, boolean z18, Object obj);
    }

    f() {
    }

    public static f d() {
        return b.f411227a;
    }

    private com.tencent.biz.pubaccount.weishi.net.c g(boolean z16, boolean z17, int i3, long j3, c cVar) {
        return new a(z16, z17, j3, i3, cVar);
    }

    private List<j> l(List<stFeed> list) {
        ArrayList arrayList = new ArrayList();
        if (r.q(list)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            stFeed stfeed = list.get(i3);
            if (stfeed.feed_type == 2 && stfeed.feed != null) {
                this.f411219f.put(this.f411215b.size() + i3, this.f411214a.size() + arrayList.size());
                arrayList.add(i.f(stfeed.feed));
            }
        }
        this.f411214a.addAll(arrayList);
        x.b("WSVideoDataManager", "position map: " + this.f411219f.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(l lVar, long j3, int i3, boolean z16) {
        String str;
        x.i("weishi-beacon", "\u8bf7\u6c42\u5173\u6ce8\u6d41\u8017\u65f6\uff1a" + j3 + "\u6beb\u79d2");
        if (i3 != 10) {
            str = WSPublicAccReport.SOP_NAME_FOCUS;
        } else {
            str = WSPublicAccReport.SOP_NAME_VIDEO_PLAY;
        }
        com.tencent.biz.pubaccount.weishi.report.g.d().p(j3, lVar.f80994g, str, z16);
    }

    public <T> void c(boolean z16, boolean z17, String str, int i3, long j3, c<T> cVar) {
        String str2;
        if (!z16 && !z17) {
            str2 = this.f411216c;
        } else {
            str2 = "";
        }
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.b(str2, z16, z17, str, i3), null, g(z16, z17, i3, j3, cVar), 3001));
    }

    public List<j> e() {
        return this.f411214a;
    }

    public com.tencent.biz.pubaccount.weishi.player.e f() {
        return this.f411220g;
    }

    public com.tencent.biz.pubaccount.weishi.player.a h(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        com.tencent.biz.pubaccount.weishi.player.a aVar = fVar.f80803f;
        if (aVar == null) {
            aVar = new com.tencent.biz.pubaccount.weishi.presenter.b();
        }
        ((com.tencent.biz.pubaccount.weishi.presenter.b) aVar).r(fVar);
        return aVar;
    }

    public void i(List<stFeed> list) {
        l(list);
        this.f411215b = list;
        this.f411218e = 15;
    }

    public void j(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.player.e eVar = fVar.f80802e;
        if (eVar != null) {
            if (eVar.f81133i || !((wSPlayerWrapper = eVar.f81129e) == null || wSPlayerWrapper.B() == 0)) {
                eVar.f81133i = false;
            }
        }
    }

    public void m() {
        this.f411216c = "";
        this.f411217d = "";
        if (this.f411220g != null) {
            this.f411220g = null;
        }
        List<stFeed> list = this.f411215b;
        if (list != null) {
            list.clear();
        }
        this.f411214a.clear();
        SparseIntArray sparseIntArray = this.f411219f;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
    }

    public void n(stFeed stfeed) {
        this.f411215b.remove(stfeed);
        for (j jVar : this.f411214a) {
            if (TextUtils.equals(jVar.e().f25129id, stfeed.feed.f25129id)) {
                this.f411214a.remove(jVar);
                return;
            }
        }
    }

    public void p(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.f411220g = eVar;
    }

    public com.tencent.biz.pubaccount.weishi.player.e q(com.tencent.biz.pubaccount.weishi.holder.f fVar, long j3, int i3) {
        com.tencent.biz.pubaccount.weishi.player.e eVar = fVar.f80802e;
        if (eVar == null) {
            eVar = new com.tencent.biz.pubaccount.weishi.player.e();
        }
        eVar.f81127c = fVar.f80801d;
        eVar.f81125a = fVar.b();
        eVar.f81136l = fVar.f80803f;
        eVar.f81130f = 2;
        eVar.f81132h = j3;
        eVar.f81134j = false;
        eVar.f81131g = i3;
        eVar.f81135k = "follow_tab";
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<stFeed> list, boolean z16, int i3, boolean z17, c cVar) {
        if (z16) {
            this.f411215b.clear();
            this.f411214a.clear();
            this.f411219f.clear();
        }
        List<j> l3 = l(list);
        this.f411215b.addAll(list);
        if (cVar == null) {
            return;
        }
        if (i3 != 9) {
            if (i3 == 10) {
                cVar.a(true, l3, z17);
            }
        } else if (z16) {
            cVar.a(false, this.f411215b, z17);
        } else {
            cVar.a(true, list, z17);
        }
    }
}
