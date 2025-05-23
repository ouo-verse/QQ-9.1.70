package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;

/* loaded from: classes10.dex */
public final class CommonPayInfo$DeliverItemReq extends MessageMicro<CommonPayInfo$DeliverItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34, 42, 50}, new String[]{"businessType", "useClientPlatform", VideoTemplateParser.ITEM_LIST, "verifiedInfo", "payInfo"}, new Object[]{0, 0, null, "", null}, CommonPayInfo$DeliverItemReq.class);
    public final PBInt32Field businessType = PBField.initInt32(0);
    public final PBEnumField useClientPlatform = PBField.initEnum(0);
    public final PBRepeatMessageField<CommonPayInfo$ItemInfo> itemList = PBField.initRepeatMessage(CommonPayInfo$ItemInfo.class);
    public final PBStringField verifiedInfo = PBField.initString("");
    public CommonPayInfo$PayInfo payInfo = new MessageMicro<CommonPayInfo$PayInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$PayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"totalPrice", "amt", "aid", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "portalBillNo", "monthNum"}, new Object[]{0, 0, "", "", "", 0}, CommonPayInfo$PayInfo.class);
        public final PBInt32Field totalPrice = PBField.initInt32(0);
        public final PBInt32Field amt = PBField.initInt32(0);
        public final PBStringField aid = PBField.initString("");
        public final PBStringField orderId = PBField.initString("");
        public final PBStringField portalBillNo = PBField.initString("");
        public final PBInt32Field monthNum = PBField.initInt32(0);
    };
}
