package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0006H\u0016J*\u0010!\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010%\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010&\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010(\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010)\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010*\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010+\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010,\u001a\u00020\u000b*\u00020-2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\f\u0010.\u001a\u00020\u0006*\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountDCReporter;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountReporter;", "()V", "messageInfoOnClick", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "getRedDotTypeForReport", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "messageInfo", "reportCancelSetTop", "", "reportDelete", "reportMessageCellExposure", "exposureTimeSec", "", "isFirstReport", "", "reportMessageCellExposureCost", "costMills", "redDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "reportProfilePageCancelSetTop", "reportProfilePageCloseReceiveMessage", "reportProfilePageFollowClick", "reportProfilePageOpenReceiveMessage", "reportProfilePageSetTop", "reportProfilePageShareClick", "reportProfilePageTipOffClick", "reportProfilePageUnfollowClick", "reportRedPointBack", "costTime", "type", "reportRedPointClick", "clickTimeMills", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "reportRedPointExposureOnce", "reportRedPointReceive", "isNum", "reportSetTop", "reportUnFollowInConversation", "reportUnFollowInConversationActionSheet", "reportUnFollowInProfilePageActionSheet", "initCommonData", "Lcooperation/qqcircle/report/QCircleLpReportDc05504$DataBuilder;", "toInt", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountDCReporter implements IQCirclePublicAccountReporter {

    @NotNull
    public static final String LAST_MESSAGE_RECEIVE_REPORT_DATA = "qcircle_public_account_last_message_report_data";

    @NotNull
    public static final String MESSAGE_FIRST_EXPOSURE_TIME_SEC = "qcircle_public_account_message_exposure_time_sec";
    public static final int REPORT_RED_DOT_TYPE_NONE = 3;
    public static final int REPORT_RED_DOT_TYPE_NORMAL = 4;
    public static final int REPORT_RED_DOT_TYPE_NUM = 5;

    @NotNull
    private static final String TAG = "QCirclePublicAccountDCReporter";

    @Nullable
    private QCirclePublicAccountMessageInfo messageInfoOnClick;

    private final int getRedDotTypeForReport(BaseQQAppInterface app, QCirclePublicAccountMessageInfo messageInfo) {
        if (messageInfo == null || messageInfo.getRedDotType() == 0) {
            return 3;
        }
        int redDotType = messageInfo.getRedDotType();
        if (redDotType != 2) {
            if (redDotType != 3) {
                return 3;
            }
            return 5;
        }
        return 4;
    }

    private final void initCommonData(QCircleLpReportDc05504.DataBuilder dataBuilder, QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        boolean z16;
        String str;
        String str2;
        String feedId;
        dataBuilder.setExt2(String.valueOf(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getPubAccountRecentUserPosInMessageList()));
        if (qCirclePublicAccountMessageInfo != null) {
            z16 = Intrinsics.areEqual(qCirclePublicAccountMessageInfo.getHasOrangeWord(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        dataBuilder.setExt3(str);
        String str3 = "";
        if (qCirclePublicAccountMessageInfo == null || (str2 = qCirclePublicAccountMessageInfo.getReportData()) == null) {
            str2 = "";
        }
        dataBuilder.setExt5(str2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        if (qCirclePublicAccountMessageInfo != null && (feedId = qCirclePublicAccountMessageInfo.getFeedId()) != null) {
            str3 = feedId;
        }
        dataBuilder.setExt15(str3);
    }

    private final int toInt(QCirclePublicAccountRedDotType qCirclePublicAccountRedDotType) {
        if (qCirclePublicAccountRedDotType instanceof QCirclePublicAccountRedDotType.NoneRedDot) {
            return 3;
        }
        if (qCirclePublicAccountRedDotType instanceof QCirclePublicAccountRedDotType.NormalRedDot) {
            return 4;
        }
        if (qCirclePublicAccountRedDotType instanceof QCirclePublicAccountRedDotType.NumRedDot) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
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
    public void reportCancelSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(6);
        dataBuilder.setThrActionType(getRedDotTypeForReport(app, messageInfo));
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportDelete(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(8);
        dataBuilder.setThrActionType(getRedDotTypeForReport(app, messageInfo));
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        IQCirclePublicAccountReporter.DefaultImpls.reportMessageCellExposure(this, baseQQAppInterface, j3, qCirclePublicAccountMessageInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposureCost(@NotNull BaseQQAppInterface app, long costMills, @NotNull QCirclePublicAccountRedDotType redDotType, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(redDotType, "redDotType");
        QLog.i(TAG, 1, "reportMessageCellExposureCost, costMills=" + costMills + ", redDotType=" + toInt(redDotType));
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(11);
        dataBuilder.setThrActionType(toInt(redDotType));
        dataBuilder.setExt16(String.valueOf(costMills));
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCancelSetTop(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(135);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCloseReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(134);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageFollowClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(137);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageOpenReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(134);
        dataBuilder.setSubActionType(1);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageSetTop(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(135);
        dataBuilder.setSubActionType(1);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageShareClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(132);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageTipOffClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(133);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageUnfollowClick(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(131);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointBack(@NotNull BaseQQAppInterface app, long costTime, int type) {
        String str;
        Intrinsics.checkNotNullParameter(app, "app");
        int redDotTypeForReport = getRedDotTypeForReport(app, this.messageInfoOnClick);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportRedPointBack, redDotTypeForReport=");
        sb5.append(redDotTypeForReport);
        sb5.append(", feedId=");
        QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = this.messageInfoOnClick;
        if (qCirclePublicAccountMessageInfo != null) {
            str = qCirclePublicAccountMessageInfo.getFeedId();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", cost=");
        sb5.append(costTime);
        QLog.i(TAG, 1, sb5.toString());
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, this.messageInfoOnClick);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(12);
        dataBuilder.setThrActionType(redDotTypeForReport);
        dataBuilder.setExt16(String.valueOf(costTime));
        dataBuilder.setExt12(String.valueOf(type));
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointClick(@NotNull BaseQQAppInterface app, long clickTimeMills, @NotNull QCirclePublicAccountLauncherSource source, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo;
        Long receiveTimeSec;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(source, "source");
        this.messageInfoOnClick = messageInfo;
        if (source != QCirclePublicAccountLauncherSource.MESSAGE_TAB && source != QCirclePublicAccountLauncherSource.AIO) {
            return;
        }
        long j3 = 0;
        long f16 = k.a().f(MESSAGE_FIRST_EXPOSURE_TIME_SEC, 0L);
        if (f16 == 0) {
            f16 = k.b().f(MESSAGE_FIRST_EXPOSURE_TIME_SEC, 0L);
        }
        String str = null;
        if (uq3.c.o7()) {
            qCirclePublicAccountMessageInfo = null;
        } else {
            qCirclePublicAccountMessageInfo = messageInfo;
        }
        int redDotTypeForReport = getRedDotTypeForReport(app, qCirclePublicAccountMessageInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportRedPointClick, redDotTypeForReport=");
        sb5.append(redDotTypeForReport);
        sb5.append(", feedId=");
        if (messageInfo != null) {
            str = messageInfo.getFeedId();
        }
        sb5.append(str);
        QLog.i(TAG, 1, sb5.toString());
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(2);
        dataBuilder.setThrActionType(redDotTypeForReport);
        if (dataBuilder.getThrActionType() == 4 || dataBuilder.getThrActionType() == 5) {
            if (messageInfo != null && (receiveTimeSec = messageInfo.getReceiveTimeSec()) != null) {
                j3 = receiveTimeSec.longValue();
            }
            dataBuilder.setExt12(String.valueOf(j3));
            dataBuilder.setExt13(String.valueOf(f16));
            dataBuilder.setExt14(String.valueOf(clickTimeMills / 1000));
        }
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointExposureOnce(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Integer num;
        long j3;
        Long receiveTimeSec;
        Intrinsics.checkNotNullParameter(app, "app");
        int redDotTypeForReport = getRedDotTypeForReport(app, messageInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportRedPointExposureOnce, messageInfoRedDotType = ");
        String str = null;
        if (messageInfo != null) {
            num = Integer.valueOf(messageInfo.getRedDotType());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", redDotTypeForReport=");
        sb5.append(redDotTypeForReport);
        sb5.append(",feedId=");
        if (messageInfo != null) {
            str = messageInfo.getFeedId();
        }
        sb5.append(str);
        QLog.i(TAG, 1, sb5.toString());
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(1);
        dataBuilder.setThrActionType(redDotTypeForReport);
        if (dataBuilder.getThrActionType() == 4 || dataBuilder.getThrActionType() == 5) {
            if (messageInfo != null && (receiveTimeSec = messageInfo.getReceiveTimeSec()) != null) {
                j3 = receiveTimeSec.longValue();
            } else {
                j3 = 0;
            }
            dataBuilder.setExt12(String.valueOf(j3));
            dataBuilder.setExt13(String.valueOf(exposureTimeSec));
        }
        QCircleLpReportDc05504.report(dataBuilder);
        k.a().n(MESSAGE_FIRST_EXPOSURE_TIME_SEC, exposureTimeSec);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointReceive(@NotNull BaseQQAppInterface app, boolean isNum, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        boolean z16;
        int i3;
        long j3;
        String reportData;
        Long receiveTimeSec;
        Intrinsics.checkNotNullParameter(app, "app");
        String str = "";
        String lastMessageReceiveReportData = k.a().h(LAST_MESSAGE_RECEIVE_REPORT_DATA, "");
        Intrinsics.checkNotNullExpressionValue(lastMessageReceiveReportData, "lastMessageReceiveReportData");
        if (lastMessageReceiveReportData.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            lastMessageReceiveReportData = k.b().h(LAST_MESSAGE_RECEIVE_REPORT_DATA, "");
        }
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(3);
        if (isNum) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        dataBuilder.setThrActionType(i3);
        dataBuilder.setExt11(lastMessageReceiveReportData);
        if (messageInfo != null && (receiveTimeSec = messageInfo.getReceiveTimeSec()) != null) {
            j3 = receiveTimeSec.longValue();
        } else {
            j3 = 0;
        }
        dataBuilder.setExt12(String.valueOf(j3));
        QCircleLpReportDc05504.report(dataBuilder);
        k a16 = k.a();
        if (messageInfo != null && (reportData = messageInfo.getReportData()) != null) {
            str = reportData;
        }
        a16.p(LAST_MESSAGE_RECEIVE_REPORT_DATA, str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(5);
        dataBuilder.setThrActionType(getRedDotTypeForReport(app, messageInfo));
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversation(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(7);
        dataBuilder.setThrActionType(getRedDotTypeForReport(app, messageInfo));
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversationActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(9);
        dataBuilder.setThrActionType(getRedDotTypeForReport(app, messageInfo));
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInProfilePageActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(136);
        dataBuilder.setSubActionType(2);
        dataBuilder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05504.report(dataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo, boolean isFirstReport) {
        Long receiveTimeSec;
        Intrinsics.checkNotNullParameter(app, "app");
        int redDotTypeForReport = getRedDotTypeForReport(app, messageInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportMessageCellExposure, messageInfoRedDotType = ");
        sb5.append(messageInfo != null ? Integer.valueOf(messageInfo.getRedDotType()) : null);
        sb5.append(", redDotTypeForReport=");
        sb5.append(redDotTypeForReport);
        sb5.append(",feedId=");
        sb5.append(messageInfo != null ? messageInfo.getFeedId() : null);
        QLog.i(TAG, 1, sb5.toString());
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        initCommonData(dataBuilder, messageInfo);
        dataBuilder.setActionType(116);
        dataBuilder.setSubActionType(10);
        dataBuilder.setThrActionType(redDotTypeForReport);
        if (dataBuilder.getThrActionType() == 4 || dataBuilder.getThrActionType() == 5) {
            dataBuilder.setExt12(String.valueOf((messageInfo == null || (receiveTimeSec = messageInfo.getReceiveTimeSec()) == null) ? 0L : receiveTimeSec.longValue()));
            dataBuilder.setExt13(String.valueOf(exposureTimeSec));
        }
        QCircleLpReportDc05504.report(dataBuilder);
    }
}
