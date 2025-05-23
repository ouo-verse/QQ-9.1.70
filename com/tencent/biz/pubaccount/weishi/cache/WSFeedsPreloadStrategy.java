package com.tencent.biz.pubaccount.weishi.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.g;
import com.tencent.biz.pubaccount.weishi.net.j;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import i10.i;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class WSFeedsPreloadStrategy {

    /* renamed from: a, reason: collision with root package name */
    private String f80419a = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f80420b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f80421c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f80422d;

    /* renamed from: e, reason: collision with root package name */
    private int f80423e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            WSFeedsPreloadStrategy.this.h(lVar);
        }
    }

    public WSFeedsPreloadStrategy(int i3) {
        this.f80423e = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final int i3) {
        x.b("WSFeedsPreloadStrategy", "[checkSendRequest] checkCount: " + i3);
        if (i3 == 0) {
            return;
        }
        boolean H = bb.H();
        x.b("WSFeedsPreloadStrategy", "[checkSendRequest] inRealActionLoginB: " + H);
        if (!H) {
            m(str);
            x.b("WSFeedsPreloadStrategy", "[checkSendRequest] sendRequest!");
        } else {
            this.f80421c = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WSFeedsPreloadStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    WSFeedsPreloadStrategy.this.e(str, i3 - 1);
                    x.b("WSFeedsPreloadStrategy", "[checkSendRequest] postDelayed finish: 30s");
                }
            };
            g.b().c(this.f80421c, 30000L);
            x.b("WSFeedsPreloadStrategy", "[checkSendRequest] postDelayed start!");
        }
    }

    private ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f80419a);
        return arrayList;
    }

    private long g() {
        return com.tencent.biz.pubaccount.weishi.config.experiment.e.c().e() * 1000;
    }

    private void l(String str) {
        this.f80419a = str;
        this.f80420b = false;
        ai.p("key_red_dot_msg_uin", str);
    }

    private void m(final String str) {
        ty.g.f437886a.f(new ty.a() { // from class: com.tencent.biz.pubaccount.weishi.cache.b
            @Override // ty.a
            public final void a(WSRedDotPushMsg wSRedDotPushMsg) {
                WSFeedsPreloadStrategy.this.i(str, wSRedDotPushMsg);
            }
        });
    }

    public void d() {
        if (this.f80421c != null) {
            g.b().e(this.f80421c);
            this.f80421c = null;
            x.b("WSFeedsPreloadStrategy", "[cancelPostDelayRunnable]");
        }
    }

    public synchronized void j(String str) {
        if (!com.tencent.biz.pubaccount.weishi.config.experiment.e.c().h()) {
            x.j("WSFeedsPreloadStrategy", "[preloadRedDotData] mHadCleanPreCache:" + this.f80422d);
            if (!this.f80422d) {
                WeiShiCacheManager.O().x(this.f80423e);
            }
            this.f80422d = true;
            return;
        }
        x.b("WSFeedsPreloadStrategy", "[preloadRedDotData] mCurrentUniSeq=structMsg.uniSeq: " + str);
        if (TextUtils.equals(this.f80419a, str)) {
            if (this.f80420b) {
                return;
            }
            if (WeiShiCacheManager.O().Z(this.f80423e)) {
                x.j("WSFeedsPreloadStrategy", "[preloadRedDotData] isRedCacheInValidDuration: true");
                return;
            }
            x.j("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: " + com.tencent.biz.pubaccount.weishi.config.experiment.e.c().j());
            if (!com.tencent.biz.pubaccount.weishi.config.experiment.e.c().j()) {
                x.j("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: false");
                return;
            }
        } else {
            l(str);
        }
        x.j("WSFeedsPreloadStrategy", "[preloadRedDotData] mCurrentUniSeq: " + this.f80419a + ", mIsSendingRequest: " + this.f80420b);
        d();
        e(this.f80419a, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(l lVar) {
        this.f80420b = false;
        if (lVar == null) {
            x.f("WSFeedsPreloadStrategy", "WSRedDot preloadTask is null.");
            return;
        }
        x.b("WSFeedsPreloadStrategy", "onTaskResponse-resultCode:" + lVar.f80992e + " | resultBean:" + lVar.f80999l + " | thread:" + Thread.currentThread().getName());
        if (!lVar.d()) {
            x.f("WSFeedsPreloadStrategy", "WSRedDot preload request error. resultCode=" + lVar.f80992e);
            return;
        }
        j jVar = lVar.f80994g;
        if (jVar instanceof i) {
            i iVar = (i) jVar;
            x.b("WSFeedsPreloadStrategy", "WSRedDot recommendRequest.mRequestId=" + iVar.C + ", mCurrentUniSeq=" + this.f80419a);
            if (TextUtils.equals(iVar.C, this.f80419a)) {
                Object obj = lVar.f80999l;
                if ((obj instanceof stSimpleGetFeedListRsp) && ((stSimpleGetFeedListRsp) obj).feeds != null && ((stSimpleGetFeedListRsp) obj).feeds.size() > 0) {
                    stSimpleGetFeedListRsp stsimplegetfeedlistrsp = (stSimpleGetFeedListRsp) lVar.f80999l;
                    ArrayList<stSimpleMetaFeed> arrayList = stsimplegetfeedlistrsp.feeds;
                    if (lVar.f81000m != null) {
                        com.tencent.biz.pubaccount.weishi.report.c.b().d(stsimplegetfeedlistrsp.trace_id, lVar.f81000m.f80962a);
                    }
                    WeiShiCacheManager.O().u(arrayList, g(), this.f80423e);
                    x.i("WSFeedsPreloadStrategy", "WSRedDot preloadList.size:" + arrayList.size());
                    this.f80422d = false;
                    return;
                }
            }
            x.f("WSFeedsPreloadStrategy", "WSRedDot preloadList is empty. task.mResultBean=" + lVar.f80999l);
        }
    }

    public void k() {
        this.f80420b = false;
        WeiShiCacheManager.O().x(this.f80423e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void i(String str, WSRedDotPushMsg wSRedDotPushMsg) {
        String str2;
        if (wSRedDotPushMsg != null) {
            str2 = wSRedDotPushMsg.mMsgData;
        } else {
            str2 = "";
        }
        String str3 = str2;
        x.j("WSFeedsPreloadStrategy", "[realPreloadRedData] scene:" + this.f80423e + ", feedId=" + str + ", wsPushMsgData.mMsgData=" + str3);
        i iVar = new i(null, (byte) 0, (byte) 1, f(), this.f80423e, null, null, null, str3);
        iVar.C = str;
        l lVar = new l(iVar, null, new a(), 1001);
        this.f80420b = true;
        g.b().g(lVar);
    }
}
