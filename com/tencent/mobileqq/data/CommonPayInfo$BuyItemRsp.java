package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;

/* loaded from: classes10.dex */
public final class CommonPayInfo$BuyItemRsp extends MessageMicro<CommonPayInfo$BuyItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"code", "msg", "info", "payMode", "useClientPlatform", "picInfo", "monthInfo"}, new Object[]{0, "", "", 0, 0, null, null}, CommonPayInfo$BuyItemRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f203067msg = PBField.initString("");
    public final PBStringField info = PBField.initString("");
    public final PBEnumField payMode = PBField.initEnum(0);
    public final PBEnumField useClientPlatform = PBField.initEnum(0);
    public CommonPayInfo$PicPayInfo picInfo = new MessageMicro<CommonPayInfo$PicPayInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$PicPayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"midasAppid", "midasToken", "midasUrlParams", "zoneId", "productId", "payItem", "patternInfo"}, new Object[]{"", "", "", 0, "", "", ""}, CommonPayInfo$PicPayInfo.class);
        public final PBStringField midasAppid = PBField.initString("");
        public final PBStringField midasToken = PBField.initString("");
        public final PBStringField midasUrlParams = PBField.initString("");
        public final PBInt32Field zoneId = PBField.initInt32(0);
        public final PBStringField productId = PBField.initString("");
        public final PBStringField payItem = PBField.initString("");
        public final PBStringField patternInfo = PBField.initString("");
    };
    public CommonPayInfo$MonthPayInfo monthInfo = new MessageMicro<CommonPayInfo$MonthPayInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$MonthPayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58, 66, 74, 82, 90}, new String[]{"monthVipType", "midasAppid", "discountType", QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, "monthMode", "monthNum", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "patternInfo", "productId", "payItem", "serviceType"}, new Object[]{0, "", 0, "", 0, 0, "", "", "", "", ""}, CommonPayInfo$MonthPayInfo.class);
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
    };
}
