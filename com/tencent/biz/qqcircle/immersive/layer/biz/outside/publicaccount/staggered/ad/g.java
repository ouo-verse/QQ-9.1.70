package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/g;", "", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/c$a;", "info", "", "l", "", "exposureTimeMs", tl.h.F, "aid", "j", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "position", "spanIndex", "videoType", "f", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "adPosToInfoMap", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "c", "Ljava/util/HashSet;", "e", "()Ljava/util/HashSet;", "exposureAdSet", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f86760a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, c.CardExposureInfo> adPosToInfoMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<String> exposureAdSet = new HashSet<>();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedCloudMeta$StFeed feed, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(feed, "$feed");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(801).setFeedId(feed.f398449id.get()).setSubActionType(4).setPageId(306).setExt1("2").setExt3(String.valueOf(System.currentTimeMillis())).setExt5(String.valueOf(i3)).setExt6(String.valueOf(i16)).setExt7(String.valueOf(i17)).setExt14(feed.recomInfo.recomReasonV2.recomReason.get()).setReportInfo(feed.busiReport.get().toByteArray()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c.CardExposureInfo info, long j3) {
        Intrinsics.checkNotNullParameter(info, "$info");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(2).setPageId(306).setFeedId(info.getFeedId()).setExt1("2").setExt2(String.valueOf(info.getStartTimeMs())).setExt4(String.valueOf(j3)).setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt7(String.valueOf(info.getVideoType())).setExt12(String.valueOf(info.getCardHeight())).setExt13(String.valueOf(info.getExposureMaxHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c.CardExposureInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(5).setPageId(306).setFeedId(info.getFeedId()).setExt1("2").setExt2(String.valueOf(info.getStartTimeMs())).setExt4("1000").setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt7(String.valueOf(info.getVideoType())).setExt12(String.valueOf(info.getCardHeight())).setExt13(String.valueOf(info.getExposureMaxHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(c.CardExposureInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(1).setPageId(306).setFeedId(info.getFeedId()).setExt1("2").setExt2(String.valueOf(info.getStartTimeMs())).setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt7(String.valueOf(info.getVideoType())).setExt12(String.valueOf(info.getCardHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()));
    }

    @NotNull
    public final HashSet<String> e() {
        return exposureAdSet;
    }

    public final void f(@NotNull final FeedCloudMeta$StFeed feed, final int position, final int spanIndex, final int videoType) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.c
            @Override // java.lang.Runnable
            public final void run() {
                g.g(FeedCloudMeta$StFeed.this, position, spanIndex, videoType);
            }
        });
    }

    public final void h(@NotNull final c.CardExposureInfo info, final long exposureTimeMs) {
        Intrinsics.checkNotNullParameter(info, "info");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.e
            @Override // java.lang.Runnable
            public final void run() {
                g.i(c.CardExposureInfo.this, exposureTimeMs);
            }
        });
    }

    public final void j(long aid) {
        final c.CardExposureInfo cardExposureInfo;
        ConcurrentHashMap<Long, c.CardExposureInfo> concurrentHashMap = adPosToInfoMap;
        if (!concurrentHashMap.containsKey(Long.valueOf(aid)) || (cardExposureInfo = concurrentHashMap.get(Long.valueOf(aid))) == null) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.d
            @Override // java.lang.Runnable
            public final void run() {
                g.k(c.CardExposureInfo.this);
            }
        });
    }

    public final void l(@NotNull final c.CardExposureInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.f
            @Override // java.lang.Runnable
            public final void run() {
                g.m(c.CardExposureInfo.this);
            }
        });
    }

    public final void n(long aid, @NotNull c.CardExposureInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ConcurrentHashMap<Long, c.CardExposureInfo> concurrentHashMap = adPosToInfoMap;
        if (concurrentHashMap.containsKey(Long.valueOf(aid))) {
            return;
        }
        concurrentHashMap.put(Long.valueOf(aid), info);
    }
}
