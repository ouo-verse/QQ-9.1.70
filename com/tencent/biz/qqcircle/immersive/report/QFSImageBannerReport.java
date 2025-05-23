package com.tencent.biz.qqcircle.immersive.report;

import android.view.View;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSImageBannerReport implements QFSImageBanner.b {

    /* renamed from: a, reason: collision with root package name */
    private FeedCloudMeta$StFeed f89680a;

    /* renamed from: b, reason: collision with root package name */
    private final int f89681b;

    /* renamed from: e, reason: collision with root package name */
    private int f89684e;

    /* renamed from: f, reason: collision with root package name */
    private int f89685f;

    /* renamed from: h, reason: collision with root package name */
    private long f89687h;

    /* renamed from: c, reason: collision with root package name */
    private int f89682c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f89683d = 1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f89686g = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f89688i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f89689j = true;

    public QFSImageBannerReport(int i3) {
        this.f89681b = i3;
    }

    private int j(int i3) {
        if (i3 < 0) {
            return 1;
        }
        return 1 + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k(int i3) {
        if (i3 <= 1) {
            return 1;
        }
        return 2;
    }

    private void m(final View view, String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, long j3) {
        final Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_REASON, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_TYPE, Integer.valueOf(i16));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_REPEAT_CNT, Integer.valueOf(i17));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_INDEX, Integer.valueOf(i18));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_INDEX, Integer.valueOf(i29));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_TYPE, Integer.valueOf(i19));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PIC_NUM, Integer.valueOf(i26));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_DISPLAY_TYPE, Integer.valueOf(i27));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_END_REASON, Integer.valueOf(i28));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_END_INDEX, Integer.valueOf(i29));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PLAY_DURATION, Long.valueOf(j3));
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport.3
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_ALBUM_END, view, buildElementParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final View view, String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        final Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_REASON, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_TYPE, Integer.valueOf(i16));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_REPEAT_CNT, Integer.valueOf(i17));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_INDEX, Integer.valueOf(i18));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_INDEX, Integer.valueOf(i18));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_TYPE, Integer.valueOf(i19));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PIC_NUM, Integer.valueOf(i26));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_DISPLAY_TYPE, Integer.valueOf(i27));
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport.2
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_ALBUM_START, view, buildElementParams);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.b
    public void a(View view, int i3, int i16, int i17, boolean z16) {
        String str;
        if (!this.f89688i) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f89680a;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        m(view, str, this.f89684e, k(i17), i17, this.f89685f, this.f89682c, i(), this.f89683d, i16, i3 + 1, System.currentTimeMillis() - this.f89687h);
        this.f89687h = 0L;
        this.f89688i = false;
        if (z16) {
            l();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.b
    public void b(final View view, int i3, final int i16) {
        final String str;
        int i17;
        int i18;
        if (this.f89688i) {
            return;
        }
        this.f89687h = System.currentTimeMillis();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f89680a;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (this.f89686g) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        this.f89684e = i17;
        int e16 = w20.a.j().e(str);
        if (e16 != 0 && (i18 = this.f89681b) != 0 && e16 != i18) {
            this.f89684e = 3;
        }
        this.f89685f = j(i3);
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport.1
            @Override // java.lang.Runnable
            public void run() {
                QFSImageBannerReport qFSImageBannerReport = QFSImageBannerReport.this;
                qFSImageBannerReport.n(view, str, qFSImageBannerReport.f89684e, QFSImageBannerReport.this.k(i16), i16, QFSImageBannerReport.this.f89685f, QFSImageBannerReport.this.f89682c, QFSImageBannerReport.this.i(), QFSImageBannerReport.this.f89683d);
            }
        });
        this.f89688i = true;
        this.f89686g = false;
        if (this.f89680a != null) {
            w20.a.j().s(this.f89680a.f398449id.get(), this.f89681b);
        }
    }

    protected int i() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f89680a;
        if (feedCloudMeta$StFeed == null) {
            return 0;
        }
        return feedCloudMeta$StFeed.images.size();
    }

    public void l() {
        if (this.f89689j && this.f89680a != null) {
            w20.a.j().s(this.f89680a.f398449id.get(), 0);
        }
        this.f89686g = true;
    }

    public QFSImageBannerReport o(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f89680a = feedCloudMeta$StFeed;
        return this;
    }

    public QFSImageBannerReport p(int i3) {
        this.f89683d = i3;
        return this;
    }

    public QFSImageBannerReport q(boolean z16) {
        this.f89689j = z16;
        return this;
    }
}
