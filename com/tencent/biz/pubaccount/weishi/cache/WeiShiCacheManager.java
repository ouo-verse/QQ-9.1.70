package com.tencent.biz.pubaccount.weishi.cache;

import UserGrowth.stDrama;
import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stGetFollowedDramasRsp;
import UserGrowth.stGetTabsRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.net.g;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.s;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jz.f;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WeiShiCacheManager {

    /* renamed from: a, reason: collision with root package name */
    private List<a00.b> f80431a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Set<String>> f80432b;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager$9, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass9 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.cache.a f80464d;
        final /* synthetic */ WeiShiCacheManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            x.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
            if (this.this$0.a0()) {
                final stSimpleGetFeedListRsp D = this.this$0.D(1);
                g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnonymousClass9.this.f80464d != null) {
                            x.b("CacheResponseLog", "getCachedRecommendData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                            AnonymousClass9.this.f80464d.a(D);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final WeiShiCacheManager f80467a = new WeiShiCacheManager();
    }

    WeiShiCacheManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public stSimpleGetFeedListRsp D(int i3) {
        return (stSimpleGetFeedListRsp) E(new stSimpleGetFeedListRsp(), i3);
    }

    private String F() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_falls_preload_feeds";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G() {
        return f.d().f411218e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_data_" + bb.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_drama_data_" + bb.y();
    }

    private Set<String> L(String str) {
        if (this.f80432b == null) {
            this.f80432b = new HashMap();
        }
        Set<String> set = this.f80432b.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f80432b.put(str, hashSet);
        return hashSet;
    }

    private String N() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_immersive_preload_feeds";
    }

    public static WeiShiCacheManager O() {
        return a.f80467a;
    }

    public static String P(int i3) {
        return ai.i("key_red_msg_valid_feed_id" + i3, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public stSimpleGetFeedListRsp R(boolean z16) {
        stSimpleGetFeedListRsp D;
        ArrayList<stSimpleMetaFeed> arrayList;
        x.b("WeiShiCacheManager", "\u8bfb\u53d6\u7011\u5e03\u6d41\u7f13\u5b58\u6570\u636e");
        stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
        stsimplegetfeedlistrsp.feeds = new ArrayList<>();
        if (z16 && (D = D(4)) != null && (arrayList = D.feeds) != null) {
            stsimplegetfeedlistrsp.feeds.addAll(arrayList);
        }
        stSimpleGetFeedListRsp D2 = D(1);
        if (D2 != null && D2.feeds != null) {
            x.b("WeiShiCacheManager", "\u7011\u5e03\u6d41\u7f13\u5b58\u6570\u91cf = " + D2.feeds.size());
            stsimplegetfeedlistrsp.feeds.addAll(D2.feeds);
        }
        return stsimplegetfeedlistrsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String U() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_vertical_data";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String W() {
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_tabs_info_" + bb.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X() {
        return iz.a.g().r();
    }

    public void A(final com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.4
            @Override // java.lang.Runnable
            public void run() {
                x.b("CacheResponseLog", "getCacheDataForFollowDrama startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                if (WeiShiCacheManager.this.a0()) {
                    final stGetFollowedDramasRsp stgetfolloweddramasrsp = (stGetFollowedDramasRsp) WeiShiCacheManager.this.E(new stGetFollowedDramasRsp(), 7);
                    g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                x.b("CacheResponseLog", "getCacheDataForFollowDrama endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                                aVar.a(stgetfolloweddramasrsp);
                            }
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    public void B(final boolean z16, final com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                x.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                if (WeiShiCacheManager.this.a0()) {
                    final stSimpleGetFeedListRsp S = bb.L(8) ? WeiShiCacheManager.this.S() : WeiShiCacheManager.this.R(z16);
                    WeiShiCacheManager.this.x(8);
                    g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                x.b("CacheResponseLog", "getCachedRecommendData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                                aVar.a(S);
                            }
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    public void C(final com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.15
            @Override // java.lang.Runnable
            public void run() {
                x.b("CacheResponseLog", "getCacheDataForTabsInfo startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                final stGetTabsRsp stgettabsrsp = (stGetTabsRsp) WeiShiCacheManager.this.E(new stGetTabsRsp(), 6);
                g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            x.b("CacheResponseLog", "getCacheDataForTabsInfo endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                            aVar.a(stgettabsrsp);
                        }
                    }
                });
            }
        }, 8, null, true);
    }

    public List<a00.b> J() {
        List<a00.b> list = this.f80431a;
        return list == null ? Collections.emptyList() : list;
    }

    public Set<String> K() {
        return L(bb.y());
    }

    public void M(final com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.2
            @Override // java.lang.Runnable
            public void run() {
                x.b("CacheResponseLog", "getPushPreloadCacheData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                if (WeiShiCacheManager.this.a0()) {
                    final stSimpleGetFeedListRsp D = WeiShiCacheManager.this.D(5);
                    WeiShiCacheManager.this.x(13);
                    g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                x.b("CacheResponseLog", "getPushPreloadCacheData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                                aVar.a(D);
                            }
                        }
                    });
                } else {
                    com.tencent.biz.pubaccount.weishi.cache.a aVar2 = aVar;
                    if (aVar2 == null) {
                        return;
                    }
                    aVar2.a(null);
                }
            }
        }, 8, null, true);
    }

    public int V() {
        return ai.c("key_red_msg_valid_count", 0);
    }

    public boolean Z(int i3) {
        long f16 = ai.f("key_red_msg_valid_timestamp" + i3, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = f16 - currentTimeMillis;
        x.f("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + f16 + "-" + currentTimeMillis + " = " + j3);
        return j3 > 0;
    }

    public boolean a0() {
        return true;
    }

    public void n(String str) {
        L(bb.y()).add(str);
    }

    public void q(List<stSimpleMetaFeed> list, stSimpleMetaFeed stsimplemetafeed, int i3, String str) {
        if (Y(list)) {
            return;
        }
        x.j("WeiShiCacheManager", "[onPause][handleCacheData] to cache");
        O().v(list, i3);
        ry.a.h(stsimplemetafeed, str);
    }

    public void r(final List<stFeed> list) {
        if (G() == 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.5
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.delete(WeiShiCacheManager.this.H(), false);
                }
            });
        } else {
            if (r.q(list)) {
                return;
            }
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.6
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<stFeed> arrayList = new ArrayList<>();
                    if (list.size() > WeiShiCacheManager.this.G()) {
                        for (int i3 = 0; i3 < WeiShiCacheManager.this.G(); i3++) {
                            arrayList.add((stFeed) list.get(i3));
                        }
                    } else {
                        arrayList = new ArrayList<>(list);
                    }
                    stFollowFeedsRsp stfollowfeedsrsp = new stFollowFeedsRsp();
                    stfollowfeedsrsp.feeds = arrayList;
                    WeiShiCacheManager weiShiCacheManager = WeiShiCacheManager.this;
                    if (weiShiCacheManager.p(stfollowfeedsrsp, weiShiCacheManager.H(), arrayList.size())) {
                        ai.p("key_ws_cache_v", bb.u());
                    }
                }
            });
        }
    }

    public void t(List<a00.b> list) {
        if (this.f80431a == null) {
            this.f80431a = new ArrayList();
        }
        this.f80431a.clear();
        this.f80431a.addAll(list);
    }

    public void v(List<stSimpleMetaFeed> list, final int i3) {
        if (X() == 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.7
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.delete(WeiShiCacheManager.this.T(), false);
                }
            });
        } else {
            if (list == null || list.size() <= 0) {
                return;
            }
            final ArrayList arrayList = new ArrayList(list);
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.8
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<stSimpleMetaFeed> arrayList2 = new ArrayList<>();
                    if (arrayList.size() >= WeiShiCacheManager.this.X()) {
                        int size = arrayList.size();
                        if (arrayList.size() - i3 > WeiShiCacheManager.this.X()) {
                            size = arrayList.size() - i3;
                        } else if (arrayList.size() - i3 > 0) {
                            size = WeiShiCacheManager.this.X();
                        }
                        for (int X = size - WeiShiCacheManager.this.X(); X < size; X++) {
                            arrayList2.add((stSimpleMetaFeed) arrayList.get(X));
                        }
                    } else {
                        arrayList2.addAll(arrayList);
                    }
                    stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
                    stsimplegetfeedlistrsp.feeds = arrayList2;
                    WeiShiCacheManager weiShiCacheManager = WeiShiCacheManager.this;
                    if (weiShiCacheManager.p(stsimplegetfeedlistrsp, weiShiCacheManager.T(), arrayList2.size())) {
                        ai.p("key_ws_cache_v", bb.u());
                    }
                }
            });
        }
    }

    public void x(final int i3) {
        x.j("WeiShiCacheManager", "[WeiShiCacheManager.java][clearRedDotPreloadCache] scene:" + i3);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.13
            @Override // java.lang.Runnable
            public void run() {
                ai.n("key_red_msg_valid_timestamp" + i3, System.currentTimeMillis());
                ai.p("key_red_msg_valid_feed_id" + i3, "");
                ai.l("key_red_msg_valid_count", 0);
                FileUtils.delete(WeiShiCacheManager.this.Q(i3), false);
            }
        });
    }

    public void y(final com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.11
            @Override // java.lang.Runnable
            public void run() {
                if (WeiShiCacheManager.this.a0()) {
                    final stSimpleGetFeedListRsp D = WeiShiCacheManager.this.D(4);
                    g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                x.b("CacheResponseLog", "getRecommendVerticalData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                                aVar.a(D);
                            }
                        }
                    });
                }
            }
        });
    }

    public void z(com.tencent.biz.pubaccount.weishi.cache.a aVar) {
        final WeakReference weakReference = new WeakReference(aVar);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.3
            @Override // java.lang.Runnable
            public void run() {
                x.b("CacheResponseLog", "getCacheDataForFollow startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                if (WeiShiCacheManager.this.a0()) {
                    final stFollowFeedsRsp stfollowfeedsrsp = (stFollowFeedsRsp) WeiShiCacheManager.this.E(new stFollowFeedsRsp(), 3);
                    g.b().d(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.biz.pubaccount.weishi.cache.a aVar2 = (com.tencent.biz.pubaccount.weishi.cache.a) weakReference.get();
                            if (aVar2 != null) {
                                x.b("CacheResponseLog", "getCacheDataForFollow endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
                                aVar2.a(stfollowfeedsrsp);
                            }
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public stSimpleGetFeedListRsp S() {
        if (Z(8) && V() >= 8) {
            x.b("WeiShiCacheManager", "\u4ec5\u8bfb\u53d6\u7ea2\u70b9\u7f13\u5b58");
            return D(2);
        }
        x.b("WeiShiCacheManager", "\u8bfb\u53d6\u7ea2\u70b9\u7f13\u5b58\u548c\u7011\u5e03\u6d41\u7f13\u5b58");
        stSimpleGetFeedListRsp D = D(2);
        stSimpleGetFeedListRsp D2 = D(1);
        stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
        stsimplegetfeedlistrsp.feeds = new ArrayList<>();
        if (D != null && D.feeds != null) {
            x.b("WeiShiCacheManager", "\u7ea2\u70b9\u7f13\u5b58\u6570\u91cf = " + D.feeds.size());
            stsimplegetfeedlistrsp.feeds.addAll(D.feeds);
        }
        if (D2 != null && D2.feeds != null) {
            x.b("WeiShiCacheManager", "\u7011\u5e03\u6d41\u7f13\u5b58\u6570\u91cf = " + D2.feeds.size());
            stsimplegetfeedlistrsp.feeds.addAll(D2.feeds);
        }
        return stsimplegetfeedlistrsp;
    }

    public void o(final List<stSimpleMetaFeed> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.10
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<stSimpleMetaFeed> arrayList = new ArrayList<>(list);
                stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
                stsimplegetfeedlistrsp.feeds = arrayList;
                WeiShiCacheManager weiShiCacheManager = WeiShiCacheManager.this;
                if (weiShiCacheManager.p(stsimplegetfeedlistrsp, weiShiCacheManager.U(), list.size())) {
                    ai.p("key_ws_cache_v", bb.u());
                }
            }
        });
    }

    public void s(final stGetFollowedDramasRsp stgetfolloweddramasrsp) {
        ArrayList<stDrama> arrayList;
        if (stgetfolloweddramasrsp == null || (arrayList = stgetfolloweddramasrsp.dramas) == null || arrayList.size() == 0) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.16
            @Override // java.lang.Runnable
            public void run() {
                if (s.d(stgetfolloweddramasrsp, WeiShiCacheManager.this.I())) {
                    ai.p("key_ws_cache_v", bb.u());
                }
            }
        });
    }

    public void u(final List<stSimpleMetaFeed> list, final long j3, final int i3) {
        if (list != null && list.size() > 0) {
            final ArrayList<stSimpleMetaFeed> arrayList = new ArrayList<>(list);
            final stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
            stsimplegetfeedlistrsp.feeds = arrayList;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.12
                @Override // java.lang.Runnable
                public void run() {
                    WeiShiCacheManager weiShiCacheManager = WeiShiCacheManager.this;
                    boolean p16 = weiShiCacheManager.p(stsimplegetfeedlistrsp, weiShiCacheManager.Q(i3), arrayList.size());
                    if (p16) {
                        String str = ((stSimpleMetaFeed) list.get(0)).f25129id;
                        x.i("WSFeedsPreloadStrategy", "WSRedDot preload feedId:" + str);
                        ai.n("key_red_msg_valid_timestamp" + i3, System.currentTimeMillis() + j3);
                        ai.p("key_red_msg_valid_feed_id" + i3, str);
                        ai.l("key_red_msg_valid_count", list.size());
                        ai.p("key_ws_cache_v", bb.u());
                        WSPicLoader.g().t(arrayList, true);
                    }
                    x.f("WeiShiCacheManager", "cacheRedDotData isSuccess: " + p16);
                }
            });
            return;
        }
        x(i3);
    }

    public void w(final stGetTabsRsp stgettabsrsp) {
        if (stgettabsrsp == null || stgettabsrsp.Tabs == null) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager.14
            @Override // java.lang.Runnable
            public void run() {
                if (s.d(stgettabsrsp, WeiShiCacheManager.this.W())) {
                    ai.p("key_ws_cache_v", bb.u());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends JceStruct> T E(T t16, int i3) {
        String str;
        if (i3 == 1) {
            str = T();
        } else if (i3 == 2) {
            str = F();
        } else if (i3 == 5) {
            str = N();
        } else if (i3 == 3) {
            str = H();
        } else if (i3 == 4) {
            str = U();
        } else if (i3 == 6) {
            str = W();
        } else if (i3 == 7) {
            str = I();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) s.c(t16, str);
    }

    private boolean Y(List<stSimpleMetaFeed> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        int hashCode = list.get(list.size() - 1).hashCode();
        if (hashCode == v.b().a()) {
            x.j("WeiShiCacheManager", "[onPause][handleCacheData] has been cached\uff0cnot cache again");
            return true;
        }
        v.b().i(hashCode);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Q(int i3) {
        if (i3 == 13) {
            return N();
        }
        return F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(JceStruct jceStruct, String str, int i3) {
        if (i3 <= 0) {
            return false;
        }
        return s.d(jceStruct, str);
    }
}
