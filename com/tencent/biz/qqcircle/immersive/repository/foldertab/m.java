package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudCommon$RecomNeedInfo;
import feedcloud.FeedCloudCommon$RecomReed;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends l {

    /* renamed from: e, reason: collision with root package name */
    private final n f89809e;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f89810a;

        /* renamed from: b, reason: collision with root package name */
        boolean f89811b;

        /* renamed from: c, reason: collision with root package name */
        boolean f89812c;

        /* renamed from: d, reason: collision with root package name */
        boolean f89813d;

        /* renamed from: e, reason: collision with root package name */
        boolean f89814e;

        /* renamed from: f, reason: collision with root package name */
        boolean f89815f;

        /* renamed from: g, reason: collision with root package name */
        boolean f89816g;

        /* renamed from: h, reason: collision with root package name */
        boolean f89817h;

        /* renamed from: i, reason: collision with root package name */
        int f89818i;

        /* renamed from: j, reason: collision with root package name */
        FeedCloudMeta$StFeed f89819j;

        /* renamed from: k, reason: collision with root package name */
        QCircleFolderBean f89820k;

        /* renamed from: l, reason: collision with root package name */
        QCircleReportBean f89821l;

        /* renamed from: m, reason: collision with root package name */
        final Map<String, Object> f89822m = new ConcurrentHashMap();

        public FeedCloudMeta$StFeed a() {
            return this.f89819j;
        }

        public boolean b() {
            return "load_more".equals(this.f89810a);
        }

        public a c(String str) {
            this.f89810a = str;
            return this;
        }

        public a d(boolean z16) {
            this.f89814e = z16;
            return this;
        }

        public a e(boolean z16) {
            this.f89811b = z16;
            return this;
        }

        public a f(boolean z16) {
            this.f89812c = z16;
            return this;
        }

        public a g(boolean z16) {
            this.f89813d = z16;
            return this;
        }

        public a h(boolean z16) {
            this.f89815f = z16;
            return this;
        }

        public a i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f89819j = feedCloudMeta$StFeed;
            return this;
        }

        public a j(QCircleFolderBean qCircleFolderBean) {
            this.f89820k = qCircleFolderBean;
            return this;
        }

        public a k(boolean z16) {
            this.f89816g = z16;
            return this;
        }

        public a l(boolean z16) {
            this.f89817h = z16;
            return this;
        }

        public a m(int i3) {
            this.f89818i = i3;
            return this;
        }

        public a n(QCircleReportBean qCircleReportBean) {
            this.f89821l = qCircleReportBean;
            return this;
        }
    }

    public m(@NonNull QFSTabFeedViewModel qFSTabFeedViewModel) {
        super(qFSTabFeedViewModel);
        this.f89809e = new n(this);
    }

    public void E() {
        this.f89809e.a();
    }

    public void F(a aVar) {
        this.f89809e.p(aVar);
    }

    public void H(List<e30.b> list) {
        this.f89809e.q(list);
    }

    public void I(String str, int i3, int i16) {
        this.f89809e.r(str, i3, i16);
    }

    public void J(List<e30.b> list) {
        List<FeedCloudMeta$StFeed> r16 = r(list);
        if (r16 != null && !r16.isEmpty()) {
            List<FeedCloudCommon$RecomReed> c16 = e30.d.c(r16);
            FeedCloudCommon$RecomNeedInfo feedCloudCommon$RecomNeedInfo = new FeedCloudCommon$RecomNeedInfo();
            feedCloudCommon$RecomNeedInfo.unableExpoFeeds.set(c16);
            uq3.k.a().k("sp_key_all_push_Unexposed_feed_info", feedCloudCommon$RecomNeedInfo.toByteArray());
            QLog.d("QFSTabRequestSender", 1, "saveUnexposedFeeds success,size:", Integer.valueOf(r16.size()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    public String l() {
        return "QFSTabFeedRepository";
    }
}
