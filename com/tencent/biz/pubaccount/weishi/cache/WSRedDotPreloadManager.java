package com.tencent.biz.pubaccount.weishi.cache;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi.event.WSExpEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.s;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import ty.g;

/* loaded from: classes32.dex */
public class WSRedDotPreloadManager implements wz.c<WSExpEvent> {

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<WSFeedsPreloadStrategy> f80427d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f80428e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final WSRedDotPreloadManager f80430a = new WSRedDotPreloadManager();
    }

    WSRedDotPreloadManager() {
        j();
    }

    public static WSRedDotPreloadManager d() {
        return a.f80430a;
    }

    private WSFeedsPreloadStrategy e() {
        int i3 = com.tencent.biz.pubaccount.weishi.config.experiment.e.c().k() ? 13 : 8;
        WSFeedsPreloadStrategy wSFeedsPreloadStrategy = this.f80427d.get(i3);
        if (wSFeedsPreloadStrategy != null) {
            return wSFeedsPreloadStrategy;
        }
        WSFeedsPreloadStrategy wSFeedsPreloadStrategy2 = new WSFeedsPreloadStrategy(i3);
        this.f80427d.put(i3, wSFeedsPreloadStrategy2);
        return wSFeedsPreloadStrategy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(WSFeedsPreloadStrategy wSFeedsPreloadStrategy, WSRedDotPushMsg wSRedDotPushMsg) {
        String g16 = bb.g(wSRedDotPushMsg);
        x.j("WSRedDotPreloadManager", "[preloadData] preloadFeedId:" + g16);
        wSFeedsPreloadStrategy.j(g16);
        s.h().q();
    }

    private void h() {
        if (com.tencent.biz.pubaccount.weishi.config.experiment.e.c().g()) {
            g.f437886a.f(new ty.a() { // from class: com.tencent.biz.pubaccount.weishi.cache.d
                @Override // ty.a
                public final void a(WSRedDotPushMsg wSRedDotPushMsg) {
                    WSRedDotPreloadManager.this.i(wSRedDotPushMsg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(WSRedDotPushMsg wSRedDotPushMsg) {
        final WSPushVideoModel wSPushVideoModel;
        x.j("WSRedDotPreloadManager", "[preloadVideoCover] hit preloadBigImage exp");
        if (wSRedDotPushMsg == null) {
            x.j("WSRedDotPreloadManager", "[preloadVideoCover] wsPushMsgData: null");
            return;
        }
        String i3 = ai.i("key_preload_msg_uin", "");
        String str = wSRedDotPushMsg.mFeedIds;
        if (TextUtils.equals(i3, str)) {
            x.j("WSRedDotPreloadManager", "[preloadVideoCover] has preloaded this feed");
            return;
        }
        ai.p("key_preload_msg_uin", str);
        IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
        if (TextUtils.isEmpty(wSRedDotPushMsg.mFeedIds)) {
            return;
        }
        if (iWSPushBaseStrategy != null && iWSPushBaseStrategy.getType() != 2 && (wSPushVideoModel = ((WSPushStrategyInfo) iWSPushBaseStrategy).mWSPushVideoModel) != null) {
            x.j("WSRedDotPreloadManager", "[preloadVideoCover] async downloadImageOnly");
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WSRedDotPreloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    WSPicLoader.g().f(wSPushVideoModel.f81340f, "");
                }
            });
        } else {
            x.j("WSRedDotPreloadManager", "[preloadVideoCover] invalid info");
        }
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        x.j("WSRedDotPreloadManager", "[onReceiveEvent] WSExpEvent receive and preload feeds");
        if (wSSimpleBaseEvent instanceof WSExpEvent) {
            com.tencent.biz.pubaccount.weishi.config.experiment.d policyEntities = ((WSExpEvent) wSSimpleBaseEvent).getPolicyEntities();
            boolean z16 = !com.tencent.biz.pubaccount.weishi.config.experiment.e.c().a(policyEntities);
            com.tencent.biz.pubaccount.weishi.config.experiment.e.c().l(policyEntities);
            if (z16) {
                e().k();
            }
            g();
        }
    }

    public void g() {
        if (this.f80428e) {
            x.b("WSRedDotPreloadManager", "===inPublicAcc not need preload===");
            return;
        }
        x.b("WSRedDotPreloadManager", "===startPreloadRedData===");
        h();
        final WSFeedsPreloadStrategy e16 = e();
        g.f437886a.f(new ty.a() { // from class: com.tencent.biz.pubaccount.weishi.cache.c
            @Override // ty.a
            public final void a(WSRedDotPushMsg wSRedDotPushMsg) {
                WSRedDotPreloadManager.f(WSFeedsPreloadStrategy.this, wSRedDotPushMsg);
            }
        });
    }

    @Override // wz.c
    public ArrayList<Class<WSExpEvent>> getEventClass() {
        ArrayList<Class<WSExpEvent>> arrayList = new ArrayList<>();
        arrayList.add(WSExpEvent.class);
        return arrayList;
    }

    public void j() {
        this.f80428e = false;
        x.j("WSRedDotPreloadManager", "[registerReceiver] exitPubicAcc");
        wz.b.b().d(this);
        com.tencent.biz.pubaccount.weishi.config.experiment.e.c().f();
    }

    public void k() {
        this.f80428e = true;
        x.j("WSRedDotPreloadManager", "[unRegisterReceiverAndCancelPreload] enterPublicAcc");
        wz.b.b().f(this);
        e().d();
    }
}
