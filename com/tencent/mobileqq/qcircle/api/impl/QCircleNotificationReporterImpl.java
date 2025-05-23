package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J4\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J&\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J&\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J$\u0010\u001c\u001a\u00020\u000e*\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCircleNotificationReporterImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCircleNotificationReporter;", "()V", "buildCommon80aAttribute", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "clickReportInfo", "", "buildCommonDTParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", BaseConstants.EXTRA_PUSHID, "sessionId", "reportClick", "", CacheTable.TABLE_NAME, "reportClickTo80a", "reportClickToDC", "clickPushId", "clickSessionId", "reportClickToDT", "reportExposure", "reportExposureTo80a", "exposureReportInfo", "reportExposureToDC", "exposurePushId", "exposureSessionId", "reportExposureToDT", "putCommonDcParams", "Lcooperation/qqcircle/report/QCircleLpReportDc05504$DataBuilder;", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleNotificationReporterImpl implements IQCircleNotificationReporter {

    @NotNull
    private static final String TAG = "QCircleNotificationReporterImpl";

    private final oidb_cmd0x80a.AttributeList buildCommon80aAttribute(String clickReportInfo) {
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("push_report_info");
        attributeList.att_value.set(clickReportInfo);
        return attributeList;
    }

    private final HashMap<String, Object> buildCommonDTParams(String pushId, String sessionId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(new QCircleDTParamBuilder().buildElementParams());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LOCK_PUSH_ID, pushId);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_LOCK_PUSH_SESSION_ID, sessionId);
        return hashMap;
    }

    private final void putCommonDcParams(QCircleLpReportDc05504.DataBuilder dataBuilder, String str, String str2, String str3) {
        dataBuilder.setExt11(str3);
        dataBuilder.setExt7(str);
        dataBuilder.setExt12(str2);
    }

    private final void reportClickTo80a(String clickReportInfo) {
        ArrayList arrayListOf;
        oidb_cmd0x80a.AttributeList buildCommon80aAttribute = buildCommon80aAttribute(clickReportInfo);
        IReadInJoyReportUtils iReadInJoyReportUtils = (IReadInJoyReportUtils) QRoute.api(IReadInJoyReportUtils.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(buildCommon80aAttribute);
        iReadInJoyReportUtils.reportPushEffectEvent(97, arrayListOf);
    }

    private final void reportClickToDC(String clickPushId, String clickSessionId, String clickReportInfo) {
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(150);
        dataBuilder.setSubActionType(2);
        dataBuilder.setThrActionType(1);
        putCommonDcParams(dataBuilder, clickPushId, clickSessionId, clickReportInfo);
        QCircleLpReportDc05504.report(dataBuilder);
    }

    private final void reportClickToDT(String clickPushId, String clickSessionId) {
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_PUSH_POP_CLK, null, buildCommonDTParams(clickPushId, clickSessionId));
    }

    private final void reportExposureTo80a(String exposureReportInfo) {
        ArrayList arrayListOf;
        oidb_cmd0x80a.AttributeList buildCommon80aAttribute = buildCommon80aAttribute(exposureReportInfo);
        IReadInJoyReportUtils iReadInJoyReportUtils = (IReadInJoyReportUtils) QRoute.api(IReadInJoyReportUtils.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(buildCommon80aAttribute);
        iReadInJoyReportUtils.reportPushEffectEvent(96, arrayListOf);
    }

    private final void reportExposureToDC(String exposurePushId, String exposureSessionId, String exposureReportInfo) {
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        dataBuilder.setActionType(150);
        dataBuilder.setSubActionType(1);
        dataBuilder.setThrActionType(1);
        putCommonDcParams(dataBuilder, exposurePushId, exposureSessionId, exposureReportInfo);
        QCircleLpReportDc05504.report(dataBuilder);
    }

    private final void reportExposureToDT(String exposurePushId, String exposureSessionId) {
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_PUSH_POP_IMPL, null, buildCommonDTParams(exposurePushId, exposureSessionId));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter
    public void reportClick(@Nullable String pushId, @Nullable String sessionId, @Nullable String reportInfo) {
        QLog.i(TAG, 1, "reportClick, pushId=" + pushId + ", sessionId=" + sessionId + ", reportInfo=" + reportInfo);
        if (pushId == null) {
            pushId = "";
        }
        if (sessionId == null) {
            sessionId = "";
        }
        if (reportInfo == null) {
            reportInfo = "";
        }
        reportClickToDT(pushId, sessionId);
        reportClickToDC(pushId, sessionId, reportInfo);
        reportClickTo80a(reportInfo);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter
    public void reportExposure(@Nullable String pushId, @Nullable String sessionId, @Nullable String reportInfo) {
        QLog.i(TAG, 1, "reportExposure, pushId=" + pushId + ", sessionId=" + sessionId + ", reportInfo=" + reportInfo);
        if (pushId == null) {
            pushId = "";
        }
        if (sessionId == null) {
            sessionId = "";
        }
        if (reportInfo == null) {
            reportInfo = "";
        }
        reportExposureToDT(pushId, sessionId);
        reportExposureToDC(pushId, sessionId, reportInfo);
        reportExposureTo80a(reportInfo);
    }
}
