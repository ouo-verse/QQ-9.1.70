package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes16.dex */
public final class QQGamePaAdInfo$GdtDataReportReq extends MessageMicro<QQGamePaAdInfo$GdtDataReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56}, new String[]{"uin", WinkDaTongReportConstant.ElementParamKey.ADID, "redCnt", "aciotnId", "viewId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE}, new Object[]{0L, 0, 0, 0, "", null, 0}, QQGamePaAdInfo$GdtDataReportReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBUInt32Field adid = PBField.initUInt32(0);
    public final PBUInt32Field redCnt = PBField.initUInt32(0);
    public final PBUInt32Field aciotnId = PBField.initUInt32(0);
    public final PBStringField viewId = PBField.initString("");
    public QQGamePaAdInfo$ReportUrl reportUrl = new QQGamePaAdInfo$ReportUrl();
    public final PBUInt32Field adType = PBField.initUInt32(0);
}
