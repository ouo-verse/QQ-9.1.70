package com.tencent.biz.qqcircle.immersive.views.search.optimise.video;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchOptTaskRunner;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import gb0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import u30.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class QFSSearchPreloadManager {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f91163i = new int[10];

    /* renamed from: d, reason: collision with root package name */
    String f91167d;

    /* renamed from: f, reason: collision with root package name */
    boolean f91169f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Activity> f91170g;

    /* renamed from: h, reason: collision with root package name */
    final QFSSearchOptTaskRunner f91171h;

    /* renamed from: a, reason: collision with root package name */
    final Map<String, List<FeedCloudMeta$StFeed>> f91164a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f91165b = new ArrayList(2);

    /* renamed from: c, reason: collision with root package name */
    private final Collection<String> f91166c = new ArraySet();

    /* renamed from: e, reason: collision with root package name */
    int f91168e = -1;

    /* loaded from: classes4.dex */
    private class a implements RFWVideoPreloadManager.OnPreloadListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.OnPreloadListener
        public void beforePreloadStart(RFWVideoPreloadBean rFWVideoPreloadBean) {
            rFWVideoPreloadBean.setPreloadDuration(1000);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.OnPreloadListener
        public void onPreloadFinish(RFWVideoPreloadBean rFWVideoPreloadBean) {
            String vid = rFWVideoPreloadBean.getVid();
            if (rFWVideoPreloadBean.getPreloadStatus() == 2) {
                QFSSearchPreloadManager.p("QFSSearchPreloadManager", "#onPreloadFinish: success");
                QFSSearchPreloadManager.this.f91166c.add(vid);
            }
        }
    }

    static {
        int i3 = 0;
        while (i3 <= 4) {
            int i16 = i3 << 1;
            i3++;
            int[] iArr = f91163i;
            iArr[i16] = i3;
            iArr[i16 + 1] = -i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSSearchPreloadManager() {
        QFSSearchOptTaskRunner qFSSearchOptTaskRunner = new QFSSearchOptTaskRunner();
        this.f91171h = qFSSearchOptTaskRunner;
        qFSSearchOptTaskRunner.k(new a());
    }

    private void d(String str, int i3) {
        this.f91167d = str;
        this.f91168e = i3;
        if ("feed".equals(str)) {
            e(this.f91168e, 4, true);
        } else {
            f();
        }
    }

    private void e(int i3, int i16, boolean z16) {
        if (i3 >= 0 && i16 > 0) {
            int i17 = 0;
            for (int i18 : f91163i) {
                if (t("feed", i18 + i3, z16)) {
                    i17++;
                }
                if (i17 >= i16) {
                    return;
                }
            }
        }
    }

    private void f() {
        int i3 = 0;
        for (int i16 = 1; i16 <= 2; i16++) {
            if (t(this.f91167d, this.f91168e + i16, true)) {
                i3++;
            }
        }
        t("feed", 0, false);
        e(0, 4 - (i3 + 1), false);
    }

    @Nullable
    private String h(String str, boolean z16) {
        int i3;
        if (!TextUtils.isEmpty(str) && !this.f91165b.isEmpty()) {
            int indexOf = this.f91165b.indexOf(str);
            if (z16) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            int i16 = indexOf + i3;
            if (i16 >= 0 && i16 < this.f91165b.size()) {
                return this.f91165b.get(i16);
            }
        }
        return null;
    }

    @Nullable
    private List<FeedCloudMeta$StFeed> m(String str) {
        if (TextUtils.isEmpty(str) || !this.f91164a.containsKey(str)) {
            return null;
        }
        return this.f91164a.get(str);
    }

    private boolean n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!p.B(feedCloudMeta$StFeed)) {
            return true;
        }
        String str = feedCloudMeta$StFeed.video.fileId.get();
        if (this.f91166c.contains(str)) {
            return true;
        }
        boolean checkCacheExist = RFWVideoUtils.checkCacheExist(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), p.m(feedCloudMeta$StFeed), str);
        if (checkCacheExist) {
            this.f91166c.add(str);
        }
        return checkCacheExist;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 1, str2);
        }
    }

    private boolean t(String str, int i3, boolean z16) {
        final FeedCloudMeta$StFeed l3 = l(str, i3);
        if (l3 == null) {
            p("QFSSearchPreloadManager", "#realPreload: stFeed is null");
            return false;
        }
        if (o(str, i3, z16, l3) || n(l3)) {
            return false;
        }
        this.f91171h.e(new QFSSearchOptTaskRunner.QFSSearchOptTask(0, l3.video.fileId.get(), "group=" + str + ", index=" + i3) { // from class: com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPreloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                QFSSearchPreloadManager.p("QFSSearchPreloadManager", "#realPreload: " + this.f91160f);
                d.d().p(l3);
                if (!RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).preloadVideo(b.n(l3, false), QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE)) {
                    QLog.w("QFSSearchPreloadManager", 1, "#realPreload: preloadVideo fail");
                }
            }
        });
        return true;
    }

    private void x() {
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).releaseAllPreloadVideo();
        this.f91171h.f();
    }

    public void b(String str, List<FeedCloudMeta$StFeed> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            this.f91164a.put(str, list);
            this.f91165b.add(str);
        }
    }

    public void c(Activity activity) {
        if (activity == null) {
            this.f91170g = null;
        } else {
            this.f91170g = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Activity g() {
        WeakReference<Activity> weakReference = this.f91170g;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(String str) {
        List<FeedCloudMeta$StFeed> m3 = m(str);
        if (m3 == null) {
            return 0;
        }
        return m3.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j(String str) {
        return h(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k(String str) {
        return h(str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public FeedCloudMeta$StFeed l(String str, int i3) {
        List<FeedCloudMeta$StFeed> m3;
        if (i3 < 0 || (m3 = m(str)) == null || i3 >= m3.size()) {
            return null;
        }
        return m3.get(i3);
    }

    boolean o(String str, int i3, boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        throw null;
    }

    public void q() {
        u();
        this.f91171h.g();
    }

    public void r(String str, int i3) {
        this.f91169f = false;
        d(str, i3);
    }

    public void s(String str, int i3) {
        x();
        if (l(str, i3) == null) {
            QLog.w("QFSSearchPreloadManager", 1, "#onPrePlay: stFeed is null");
        } else {
            this.f91169f = true;
        }
    }

    public void u() {
        this.f91166c.clear();
        this.f91164a.clear();
        this.f91167d = null;
        this.f91168e = -1;
        this.f91165b.clear();
    }

    public void v(boolean z16) {
        if (!z16) {
            x();
        }
    }

    public void w(boolean z16) {
        this.f91169f = z16;
        if (z16) {
            x();
        } else {
            r(this.f91167d, this.f91168e);
        }
    }
}
