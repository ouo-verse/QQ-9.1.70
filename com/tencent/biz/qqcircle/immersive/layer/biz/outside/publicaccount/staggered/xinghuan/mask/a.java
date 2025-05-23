package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/mask/a;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "c", "", "exposureTimeMs", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f87148a = new a();

    a() {
    }

    public final void a(int clickType, @NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(806).setSubActionType(3).setFeedId(feed.f398449id.get()).setSealTransfer(feed.recomInfo.recomTrace.get()).setPageId(306).setExt1(String.valueOf(clickType)).setExt3(String.valueOf(System.currentTimeMillis())).setReportInfo(feed.busiReport.get().toByteArray()));
    }

    public final void b(long exposureTimeMs, @NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(806).setSubActionType(2).setFeedId(feed.f398449id.get()).setSealTransfer(feed.recomInfo.recomTrace.get()).setPageId(306).setExt2(String.valueOf(System.currentTimeMillis())).setExt4(String.valueOf(exposureTimeMs)).setReportInfo(feed.busiReport.get().toByteArray()));
    }

    public final void c(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(806).setSubActionType(1).setFeedId(feed.f398449id.get()).setSealTransfer(feed.recomInfo.recomTrace.get()).setPageId(306).setExt2(String.valueOf(System.currentTimeMillis())).setReportInfo(feed.busiReport.get().toByteArray()));
    }
}
