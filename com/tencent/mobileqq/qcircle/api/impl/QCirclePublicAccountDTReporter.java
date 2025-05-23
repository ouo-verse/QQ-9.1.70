package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountDTReporter;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountReporter;", "()V", "buildCommonParams", "", "", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "messageInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "getRedDotType", "reportMessageCellExposure", "", "exposureTimeSec", "", "isFirstReport", "", "reportProfilePageFollowClick", "reportProfilePageUnfollowClick", "reportRedPointClick", "clickTimeMills", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "reportUnFollowInProfilePageActionSheet", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountDTReporter implements IQCirclePublicAccountReporter {
    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, Object> buildCommonParams(BaseQQAppInterface app, QCirclePublicAccountMessageInfo messageInfo) {
        String str;
        String reportData;
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QCIRCLE_PUBLIC_ACCOUNT);
        String str2 = "";
        if (messageInfo == null || (str = messageInfo.getFeedId()) == null) {
            str = "";
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_FEEDID, str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, getRedDotType(app, messageInfo));
        if (!uq3.c.o7() || !(((IQCirclePublicAccountMessageService) app.getRuntimeService(IQCirclePublicAccountMessageService.class)).getRedDotTypeFromCached() instanceof QCirclePublicAccountRedDotType.NoneRedDot)) {
            if (messageInfo != null && (reportData = messageInfo.getReportData()) != null) {
                str2 = reportData;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str2);
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_MESSAGE_INDEX, Integer.valueOf(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getPubAccountRecentUserPosInMessageList()));
        if (messageInfo != null) {
            i3 = Intrinsics.areEqual(messageInfo.getHasOrangeWord(), Boolean.TRUE);
        } else {
            i3 = 0;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_MESSAGE_COLOR, Integer.valueOf(i3));
        return hashMap;
    }

    private final String getRedDotType(BaseQQAppInterface app, QCirclePublicAccountMessageInfo messageInfo) {
        if (messageInfo == null || messageInfo.getRedDotType() == 0) {
            return "none";
        }
        int redDotType = messageInfo.getRedDotType();
        if (redDotType != 2) {
            if (redDotType != 3) {
                return "none";
            }
            return QCircleDaTongConstant.ElementParamValue.QCIRCLE_NUMBER;
        }
        return QCircleDaTongConstant.ElementParamValue.QCIRCLE_LITTLE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    @NotNull
    public String getDTAppKey() {
        return IQCirclePublicAccountReporter.DefaultImpls.getDTAppKey(this);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public int getPubAccountRecentUserPosInMessageList() {
        return IQCirclePublicAccountReporter.DefaultImpls.getPubAccountRecentUserPosInMessageList(this);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportCancelSetTop(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportCancelSetTop(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportDelete(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportDelete(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportMessageCellExposure(this, baseQQAppInterface, j3, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposureCost(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, @NotNull QCirclePublicAccountRedDotType qCirclePublicAccountRedDotType, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportMessageCellExposureCost(this, baseQQAppInterface, j3, qCirclePublicAccountRedDotType, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCancelSetTop(@NotNull BaseQQAppInterface baseQQAppInterface) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageCancelSetTop(this, baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCloseReceiveMessage(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageCloseReceiveMessage(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageFollowClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        HashMap hashMap = new HashMap();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PUBLIC_ACCOUNT_HOME_PAGE);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GZH_FOLLOW);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageOpenReceiveMessage(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageOpenReceiveMessage(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageSetTop(@NotNull BaseQQAppInterface baseQQAppInterface) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageSetTop(this, baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageShareClick(@NotNull BaseQQAppInterface baseQQAppInterface) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageShareClick(this, baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageTipOffClick(@NotNull BaseQQAppInterface baseQQAppInterface) {
        IQCirclePublicAccountReporter.DefaultImpls.reportProfilePageTipOffClick(this, baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageUnfollowClick(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        HashMap hashMap = new HashMap();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PUBLIC_ACCOUNT_HOME_PAGE);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GZH_UNFOLLOW);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointBack(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, int i3) {
        IQCirclePublicAccountReporter.DefaultImpls.reportRedPointBack(this, baseQQAppInterface, j3, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointClick(@NotNull BaseQQAppInterface app, long clickTimeMills, @NotNull QCirclePublicAccountLauncherSource source, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(source, "source");
        HashMap hashMap = new HashMap();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put("xsj_action_type", "clck");
        if (source != QCirclePublicAccountLauncherSource.MESSAGE_TAB && source != QCirclePublicAccountLauncherSource.AIO) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_IS_MESSAGE_LIST, Integer.valueOf(i3));
        hashMap.putAll(buildCommonParams(app, messageInfo));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointExposureOnce(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportRedPointExposureOnce(this, baseQQAppInterface, j3, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointReceive(@NotNull BaseQQAppInterface baseQQAppInterface, boolean z16, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportRedPointReceive(this, baseQQAppInterface, z16, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportSetTop(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportSetTop(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversation(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportUnFollowInConversation(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversationActionSheet(@NotNull BaseQQAppInterface baseQQAppInterface, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportUnFollowInConversationActionSheet(this, baseQQAppInterface, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInProfilePageActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        HashMap hashMap = new HashMap();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PUBLIC_ACCOUNT_HOME_PAGE);
        hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GZH_UNFOLLOW_CONFIRM);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo, boolean isFirstReport) {
        Intrinsics.checkNotNullParameter(app, "app");
        HashMap hashMap = new HashMap();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put("xsj_action_type", "imp");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_IMP_FIRST, Integer.valueOf(isFirstReport ? 1 : 0));
        hashMap.putAll(buildCommonParams(app, messageInfo));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, hashMap);
    }
}
