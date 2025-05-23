package com.tencent.biz.qqcircle.immersive.views.search.optimise.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchOptTaskRunner;
import com.tencent.biz.qqcircle.immersive.views.search.util.h;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import gb0.b;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class QFSSearchPrerenderManager extends QFSSearchPreloadManager {

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Integer> f91174j = new ArrayMap(1);

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Integer> f91175k = new ArrayMap();

    /* renamed from: l, reason: collision with root package name */
    private final Map<h, Integer> f91176l = new WeakHashMap();

    /* renamed from: m, reason: collision with root package name */
    private final a f91177m;

    /* loaded from: classes4.dex */
    private class a implements RFWPlayerPreRenderHelper.OnPrerenderListener {

        /* renamed from: a, reason: collision with root package name */
        private String f91181a;

        a() {
        }

        void a(String str) {
            this.f91181a = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.OnPrerenderListener
        public void onPrerenderFinish(boolean z16, String str, int i3) {
            if (TextUtils.equals(this.f91181a, str) && !z16) {
                QFSSearchPreloadManager.p("QFSSearchPreRenderManager", "onPrerenderFinish: failed, errorCode=" + i3);
            }
        }
    }

    protected QFSSearchPrerenderManager() {
        a aVar = new a();
        this.f91177m = aVar;
        this.f91171h.l(aVar);
    }

    private static boolean A(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean B(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (g() != null && L() && p.B(feedCloudMeta$StFeed) && A(str)) {
            return true;
        }
        return false;
    }

    private int C(String str, int i3, boolean z16, boolean z17) {
        if (!z16) {
            return H(str, this.f91168e, i3, z17);
        }
        return i3;
    }

    private int D(String str) {
        if (!this.f91175k.containsKey(str)) {
            return 0;
        }
        return this.f91175k.get(str).intValue();
    }

    @MainThread
    public static QFSSearchPrerenderManager E(Context context) {
        View decorView;
        if ((context instanceof Activity) && (decorView = ((Activity) context).getWindow().getDecorView()) != null) {
            Object tag = decorView.getTag(R.id.f57212mp);
            if (tag instanceof QFSSearchPrerenderManager) {
                return (QFSSearchPrerenderManager) tag;
            }
            QFSSearchPrerenderManager qFSSearchPrerenderManager = new QFSSearchPrerenderManager();
            decorView.setTag(R.id.f57212mp, qFSSearchPrerenderManager);
            return qFSSearchPrerenderManager;
        }
        if (QCircleHostConstants._AppSetting.isPublicVersion()) {
            return new QFSSearchPrerenderManager();
        }
        throw new IllegalArgumentException("context needs to be Activity");
    }

    private int F(String str) {
        Integer num = this.f91174j.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (h hVar : this.f91176l.keySet()) {
            if (TextUtils.equals(str, hVar.d())) {
                FeedCloudMeta$StFeed l3 = l(str, i3);
                if (l3 == null) {
                    return 0;
                }
                return hVar.c(l3.f398449id.get());
            }
        }
        return 0;
    }

    private int H(String str, int i3, int i16, boolean z16) {
        if (i16 != -100) {
            if (i16 != 0) {
                int i17 = i16 + i3;
                if (i17 < 0 && z16) {
                    i17 = i3 + 1;
                }
                if (i17 >= i(str)) {
                    return i3 - 1;
                }
                return i17;
            }
            return 0;
        }
        return -1;
    }

    private static boolean I(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && RFWPlayerPreRenderHelper.getInstance().isPreRender(feedCloudMeta$StFeed.video.fileId.get())) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Boolean J(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (!L()) {
            return null;
        }
        if (A(str) && I(feedCloudMeta$StFeed)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    private boolean K(int i3) {
        int i16 = this.f91168e;
        if (i3 == i16 + 1) {
            return true;
        }
        if (i3 == i16 - 1 && i16 == i(this.f91167d) - 1) {
            return true;
        }
        return false;
    }

    private static boolean L() {
        return RFWPlayerPreRenderHelper.getInstance().isPreRenderOpen();
    }

    private void O(String str, int i3, boolean z16) {
        FeedCloudMeta$StFeed l3;
        int C = C(str, i3, z16, true);
        if (C == F(str)) {
            return;
        }
        V(str, C);
        FeedCloudMeta$StFeed l16 = l(str, C);
        if (B(str, l16) && !I(l16) && l16 != (l3 = l(this.f91167d, this.f91168e))) {
            long currentTimeMillis = System.currentTimeMillis();
            R(l16, l3, str, C);
            QFSSearchPreloadManager.p("QFSSearchPreRenderManager", "#predictNextPlayDirection: group=" + str + ", index=" + C + ", costTime=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void P(String str, int i3, boolean z16) {
        String k3;
        if (z16 && !QCircleHostConstants._AppSetting.isPublicVersion()) {
            throw new IllegalArgumentException("non feed group can only use relative index");
        }
        if (i3 != -1) {
            if (i3 != 1) {
                k3 = null;
            } else {
                k3 = j(str);
            }
        } else {
            k3 = k(str);
        }
        if (!TextUtils.isEmpty(k3)) {
            O(k3, D(k3), true);
        }
    }

    private boolean T(String str, int i3, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (B(str, feedCloudMeta$StFeed) && z16 && K(i3)) {
            if (!I(feedCloudMeta$StFeed)) {
                V(str, i3);
                R(feedCloudMeta$StFeed, l(this.f91167d, this.f91168e), str, i3);
                QFSSearchPreloadManager.p("QFSSearchPreRenderManager", "#tryPrerender: preRender group=" + str + ", index=" + i3);
                return true;
            }
            return true;
        }
        return false;
    }

    private void V(String str, int i3) {
        this.f91174j.clear();
        if (i3 >= 0) {
            this.f91174j.put(str, Integer.valueOf(i3));
        }
    }

    public void M(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        O(str, i3, false);
    }

    public void N(String str, int i3, boolean z16) {
        if (!TextUtils.isEmpty(this.f91167d) && TextUtils.equals(str, this.f91167d)) {
            if ("feed".equals(str)) {
                if (C(str, i3, z16, false) >= 0) {
                    O(str, i3, z16);
                    return;
                } else {
                    P(str, -1, false);
                    return;
                }
            }
            P(str, i3, z16);
            return;
        }
        O(str, i3, z16);
    }

    public void Q() {
        QFSSearchPreloadManager.p("QFSSearchPreRenderManager", "#prerenderFocus: group=" + this.f91167d + ", index=" + this.f91168e);
        FeedCloudMeta$StFeed l3 = l(this.f91167d, this.f91168e);
        if (l3 != null) {
            R(l3, null, this.f91167d, this.f91168e);
        }
    }

    public void R(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final FeedCloudMeta$StFeed feedCloudMeta$StFeed2, final String str, final int i3) {
        QFSSearchPreloadManager.p("QFSSearchPreRenderManager", "#realPrerender: group=" + str + ", index=" + i3 + ", curGroup=" + this.f91167d + ", focusIndex=" + this.f91168e + ", isVideoBuffering=" + this.f91169f);
        if (this.f91169f) {
            return;
        }
        this.f91171h.e(new QFSSearchOptTaskRunner.QFSSearchOptTask(1, feedCloudMeta$StFeed.video.fileId.get()) { // from class: com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StVideo feedCloudMeta$StVideo;
                QFSSearchPrerenderManager.this.f91177m.a(feedCloudMeta$StFeed.video.fileId.get());
                RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setStartOffset(QFSSearchPrerenderManager.this.G(str, i3));
                RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
                RFWPlayerPreRenderBean preloadOriginData = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10007).setActivity(QFSSearchPrerenderManager.this.g()).setSourceType(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE).setPreloadOriginData(b.m(new e30.b(feedCloudMeta$StFeed).o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(i3))));
                FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = feedCloudMeta$StFeed;
                FeedCloudMeta$StVideo feedCloudMeta$StVideo2 = null;
                if (feedCloudMeta$StFeed3 != null) {
                    feedCloudMeta$StVideo = feedCloudMeta$StFeed3.video;
                } else {
                    feedCloudMeta$StVideo = null;
                }
                RFWPlayerPreRenderBean preloadVideo = preloadOriginData.setPreloadVideo(b.k(feedCloudMeta$StVideo));
                FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = feedCloudMeta$StFeed2;
                if (feedCloudMeta$StFeed4 != null) {
                    feedCloudMeta$StVideo2 = feedCloudMeta$StFeed4.video;
                }
                rFWPlayerPreRenderHelper.playerRender(b.f(preloadVideo.setCurrentPlayVideo(b.k(feedCloudMeta$StVideo2)).setMultiLevel(true).setPlayerOptions(startOffset)));
            }
        });
    }

    public void S(h hVar) {
        this.f91176l.put(hVar, 0);
    }

    public void U(String str, int i3) {
        this.f91175k.put(str, Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public void b(String str, List<FeedCloudMeta$StFeed> list) {
        boolean isEmpty = this.f91164a.isEmpty();
        super.b(str, list);
        if (isEmpty && !this.f91164a.isEmpty()) {
            R(l(str, 0), null, str, 0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public /* bridge */ /* synthetic */ void c(Activity activity) {
        super.c(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    protected boolean o(String str, int i3, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return T(str, i3, z16, feedCloudMeta$StFeed);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public void q() {
        super.q();
        this.f91176l.clear();
        RFWPlayerPreRenderHelper.getInstance().releaseRender();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public /* bridge */ /* synthetic */ void r(String str, int i3) {
        super.r(str, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public /* bridge */ /* synthetic */ void s(String str, int i3) {
        super.s(str, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public void u() {
        super.u();
        this.f91174j.clear();
        this.f91175k.clear();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public /* bridge */ /* synthetic */ void v(boolean z16) {
        super.v(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager
    public /* bridge */ /* synthetic */ void w(boolean z16) {
        super.w(z16);
    }
}
