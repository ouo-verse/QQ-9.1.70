package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.os.SystemClock;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.o;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007J2\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/g;", "", "", "position", "spanIndex", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "", "g", "f", "initBean", "o", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/o$a;", "info", "j", "", "exposureTimeMs", tl.h.F, "l", QCircleLpReportDc010001.KEY_SUBTYPE, "Lqqcircle/QQCircleDitto$StItemInfo;", QCircleAlphaUserReporter.KEY_USER, "pgId", com.tencent.luggage.wxa.c8.c.G, "d", "", "switchOnOrOff", DomainData.DOMAIN_NAME, "e", "b", "J", "staggeredEnterTimeMs", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f87070a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long staggeredEnterTimeMs;

    g() {
    }

    @JvmStatic
    public static final void g(int position, int spanIndex, @NotNull FeedCloudMeta$StFeed feed, @NotNull QCircleInitBean bean) {
        String str;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (feed.feedType.get() == 4) {
            return;
        }
        QCircleLpReportDc05507.DataBuilder pageId = new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(4).setFeedId(feed.f398449id.get()).setToUin(feed.poster.f398463id.get()).setAuthorUin(feed.poster.f398463id.get()).setPageId(f87070a.e(bean));
        if (feed.type.get() == 2) {
            str = "3";
        } else if (feed.dittoFeed.dittoId.get() == 42) {
            str = "4";
        } else {
            str = "1";
        }
        QCircleLpReportDc05507.report(pageId.setExt1(str).setExt3(String.valueOf(System.currentTimeMillis())).setExt5(String.valueOf(position)).setExt6(String.valueOf(spanIndex)).setExt14(feed.recomInfo.recomReasonV2.recomReason.get()).setReportInfo(feed.busiReport.get().toByteArray()).setActTime(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(o.CardExposureInfo info, QCircleInitBean initBean, long j3) {
        String str;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        QCircleLpReportDc05507.DataBuilder pageId = new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(2).setFeedId(info.getFeedId()).setToUin(info.getPosterId()).setAuthorUin(info.getPosterId()).setPageId(f87070a.e(initBean));
        if (info.getType() == 2) {
            str = "3";
        } else if (info.getDittoFeedId() == 42) {
            str = "4";
        } else {
            str = "1";
        }
        QCircleLpReportDc05507.report(pageId.setExt1(str).setExt2(String.valueOf(info.getStartTimeMs())).setExt4(String.valueOf(j3)).setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt12(String.valueOf(info.getCardHeight())).setExt13(String.valueOf(info.getExposureMaxHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()).setActTime(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(o.CardExposureInfo info, QCircleInitBean initBean) {
        String str;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        QCircleLpReportDc05507.DataBuilder pageId = new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(1).setFeedId(info.getFeedId()).setToUin(info.getPosterId()).setAuthorUin(info.getPosterId()).setPageId(f87070a.e(initBean));
        if (info.getType() == 2) {
            str = "3";
        } else if (info.getDittoFeedId() == 42) {
            str = "4";
        } else {
            str = "1";
        }
        QCircleLpReportDc05507.report(pageId.setExt1(str).setExt2(String.valueOf(info.getStartTimeMs())).setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt12(String.valueOf(info.getCardHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()).setActTime(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(o.CardExposureInfo info, QCircleInitBean bean, long j3) {
        String str;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        QCircleLpReportDc05507.DataBuilder pageId = new QCircleLpReportDc05507.DataBuilder().setActionType(801).setSubActionType(3).setFeedId(info.getFeedId()).setToUin(info.getPosterId()).setAuthorUin(info.getPosterId()).setPageId(f87070a.e(bean));
        if (info.getType() == 2) {
            str = "3";
        } else if (info.getDittoFeedId() == 42) {
            str = "4";
        } else {
            str = "1";
        }
        QCircleLpReportDc05507.report(pageId.setExt1(str).setExt2(String.valueOf(info.getStartTimeMs())).setExt4(String.valueOf(j3)).setExt5(String.valueOf(info.getPos())).setExt6(String.valueOf(info.getSpanIndex())).setExt12(String.valueOf(info.getCardHeight())).setExt14(info.getRecommendReason()).setReportInfo(info.getBusiReport()).setActTime(System.currentTimeMillis()));
    }

    public final void d(@Nullable FeedCloudMeta$StFeed feed, int subType, @Nullable QQCircleDitto$StItemInfo user, int pgId, int pos) {
        String str;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        PBStringField pBStringField;
        if (feed != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(608);
            dataBuilder.setSubActionType(subType);
            byte[] bArr = null;
            if (user != null && (pBStringField = user.f429300id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            dataBuilder.setToUin(str);
            dataBuilder.setExt10(ba.d(feed));
            dataBuilder.setPosition(pos);
            dataBuilder.setPageId(pgId);
            dataBuilder.setActTime(System.currentTimeMillis());
            dataBuilder.setFirstFeedId(w20.a.j().h());
            if (user != null && (pBBytesField = user.busiReport) != null && (byteStringMicro = pBBytesField.get()) != null) {
                bArr = byteStringMicro.toByteArray();
            }
            dataBuilder.setReportInfo(bArr);
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    public final int e(@NotNull QCircleInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        return an.a(bean, 306);
    }

    public final void f() {
        long uptimeMillis = SystemClock.uptimeMillis();
        staggeredEnterTimeMs = uptimeMillis;
        QLog.i("QFSPublicAccountStaggeredDCReporter", 1, "recordStaggeredEnter enterTime = " + uptimeMillis);
    }

    public final void h(@NotNull final o.CardExposureInfo info, final long exposureTimeMs, @NotNull final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (info.getFeedType() == 4) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.e
            @Override // java.lang.Runnable
            public final void run() {
                g.i(o.CardExposureInfo.this, initBean, exposureTimeMs);
            }
        });
    }

    public final void j(@NotNull final o.CardExposureInfo info, @NotNull final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (info.getFeedType() == 4) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(o.CardExposureInfo.this, initBean);
            }
        });
    }

    public final void l(@NotNull final o.CardExposureInfo info, final long exposureTimeMs, @NotNull final QCircleInitBean bean) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (info.getFeedType() == 4) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.d
            @Override // java.lang.Runnable
            public final void run() {
                g.m(o.CardExposureInfo.this, bean, exposureTimeMs);
            }
        });
    }

    public final void n(boolean switchOnOrOff) {
        int i3;
        QCircleLpReportDc05507.DataBuilder actionType = new QCircleLpReportDc05507.DataBuilder().setActionType(805);
        if (switchOnOrOff) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        QCircleLpReportDc05507.report(actionType.setSubActionType(i3).setPageId(306).setActTime(System.currentTimeMillis()));
    }

    public final void o(@NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (staggeredEnterTimeMs == 0) {
            QLog.e("QFSPublicAccountStaggeredDCReporter", 1, "reportOnStaggeredExist enterTime is zero");
        } else {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(800).setSubActionType(1).setPageId(e(initBean)).setExt1(String.valueOf(SystemClock.uptimeMillis() - staggeredEnterTimeMs)).setActTime(System.currentTimeMillis()));
        }
    }
}
