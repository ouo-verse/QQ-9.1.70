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
public final class CommonPayInfo$VerifyItemReq extends MessageMicro<CommonPayInfo$VerifyItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34, 42}, new String[]{"businessType", "clientPlatform", VideoTemplateParser.ITEM_LIST, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID}, new Object[]{0, 0, null, ""}, CommonPayInfo$VerifyItemReq.class);
    public final PBInt32Field businessType = PBField.initInt32(0);
    public final PBEnumField clientPlatform = PBField.initEnum(0);
    public final PBRepeatMessageField<CommonPayInfo$ItemInfo> itemList = PBField.initRepeatMessage(CommonPayInfo$ItemInfo.class);
    public final PBStringField orderId = PBField.initString("");
}
