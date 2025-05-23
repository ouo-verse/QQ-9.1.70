package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.AdConstants$PBServiceTag;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.tvideo.protocol.pb.AdExtraInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportType;
import hx2.c;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u001dB5\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'\u0012\b\u0010,\u001a\u0004\u0018\u00010*\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010#R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/a;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "Lcom/tencent/tvideo/protocol/pb/RewardAdReportInfo;", CacheTable.TABLE_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tvideo/protocol/pb/RewardAdReportType;", AdMetricTag.Report.TYPE, "Lcom/tencent/tvideo/protocol/pb/AdExtraInfo;", "e", "", "reportTime", "", "j", "", "l", "d", "curTime", "k", h.F, "f", "g", "position", "i", DomainData.DOMAIN_NAME, "isUnlock", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "b", "a", "c", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel;", "mQAdRewardPlayModel", "", "Ljava/util/Set;", "mDuplicationSetByAdReport", "I", "mLastPlayTime", "", "Ljava/util/List;", "mRewardAdReportInfos", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "mOrderItem", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "mListener", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "mPlayLoadInfo", "<init>", "(Ljava/util/List;Lcom/tencent/tvideo/protocol/pb/AdOrderItem;Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a implements QAdRewardPlayModel.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QAdRewardPlayModel mQAdRewardPlayModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Set<String> mDuplicationSetByAdReport = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mLastPlayTime = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<RewardAdReportInfo> mRewardAdReportInfos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AdOrderItem mOrderItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QAdRewardPlayModel.b mListener;

    public a(@Nullable List<RewardAdReportInfo> list, @Nullable AdOrderItem adOrderItem, @Nullable b bVar, @Nullable QAdRewardPlayModel.b bVar2) {
        this.mRewardAdReportInfos = list;
        this.mOrderItem = adOrderItem;
        this.mListener = bVar2;
        this.mQAdRewardPlayModel = new QAdRewardPlayModel(bVar);
    }

    private final synchronized void d(int reportTime) {
        String l3 = l(reportTime);
        if (l3 != null) {
            this.mDuplicationSetByAdReport.add(l3);
        }
    }

    private final AdExtraInfo e(RewardAdReportType reportType) {
        if (reportType != RewardAdReportType.REWARD_AD_REPORT_TYPE_REACH && reportType != RewardAdReportType.REWARD_AD_REPORT_TYPE_UNLOCK) {
            return null;
        }
        return c();
    }

    private final String f() {
        AdOrderItem adOrderItem = this.mOrderItem;
        if (adOrderItem != null) {
            return adOrderItem.ad_report_param;
        }
        return null;
    }

    private final int g(RewardAdReportInfo reportInfo) {
        return (int) reportInfo.report_time;
    }

    private final String h() {
        AdOrderItem adOrderItem = this.mOrderItem;
        if (adOrderItem != null) {
            return adOrderItem.unique_id;
        }
        return null;
    }

    private final synchronized boolean j(int reportTime) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(this.mDuplicationSetByAdReport, l(reportTime));
        return contains;
    }

    private final boolean k(int reportTime, int curTime) {
        if (this.mLastPlayTime + 1 <= reportTime && curTime >= reportTime) {
            return true;
        }
        return false;
    }

    private final String l(int reportTime) {
        return "&uniQueId= " + h() + ", &reportTime= " + reportTime;
    }

    private final void m(RewardAdReportInfo reportInfo) {
        String c16 = c.f406571a.c();
        n.e("[RewardAd]QAdRewardPlayHandler", "sendUnlockRequest, currentTime = " + c16);
        RewardAdPlayRequestInfo.a d16 = new RewardAdPlayRequestInfo.a().c(f()).d(reportInfo);
        RewardAdReportType rewardAdReportType = reportInfo.report_type;
        Intrinsics.checkNotNullExpressionValue(rewardAdReportType, "reportInfo.report_type");
        this.mQAdRewardPlayModel.h(this, d16.a(e(rewardAdReportType)).e(c16).build(), AdConstants$PBServiceTag.REWARD_NORMAL);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
    public void a() {
        QAdRewardPlayModel.b bVar = this.mListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
    public void b(boolean isUnlock, @Nullable RewardAdNewUnlockInfo unlockInfo) {
        QAdRewardPlayModel.b bVar = this.mListener;
        if (bVar != null) {
            bVar.b(isUnlock, unlockInfo);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel.b
    @Nullable
    public AdExtraInfo c() {
        QAdRewardPlayModel.b bVar = this.mListener;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public final void i(int position) {
        List<RewardAdReportInfo> list = this.mRewardAdReportInfos;
        if (list == null) {
            return;
        }
        Intrinsics.checkNotNull(list);
        for (RewardAdReportInfo rewardAdReportInfo : list) {
            int g16 = g(rewardAdReportInfo);
            if (!j(g16) && k(g16, position)) {
                n.e("[RewardAd]QAdRewardPlayHandler", "doPlayReport, reportTime = " + g16 + ", curPosition = " + position);
                m(rewardAdReportInfo);
                d(g16);
            }
        }
        this.mLastPlayTime = position;
    }

    public final void n(@NotNull RewardAdReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        n.e("[RewardAd]QAdRewardPlayHandler", "tryUnlock");
        m(reportInfo);
    }
}
