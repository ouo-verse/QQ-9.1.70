package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$MonthPayInfo extends MessageMicro<QZoneVipPayInfo$MonthPayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58, 66, 74, 82, 90}, new String[]{"monthVipType", "midasAppid", "discountType", QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, "monthMode", "monthNum", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "patternInfo", "productId", "payItem", "serviceType"}, new Object[]{0, "", 0, "", 0, 0, "", "", "", "", ""}, QZoneVipPayInfo$MonthPayInfo.class);
    public final PBEnumField monthVipType = PBField.initEnum(0);
    public final PBStringField midasAppid = PBField.initString("");
    public final PBEnumField discountType = PBField.initEnum(0);
    public final PBStringField discountId = PBField.initString("");
    public final PBEnumField monthMode = PBField.initEnum(0);
    public final PBInt32Field monthNum = PBField.initInt32(0);
    public final PBStringField orderId = PBField.initString("");
    public final PBStringField patternInfo = PBField.initString("");
    public final PBStringField productId = PBField.initString("");
    public final PBStringField payItem = PBField.initString("");
    public final PBStringField serviceType = PBField.initString("");
}
