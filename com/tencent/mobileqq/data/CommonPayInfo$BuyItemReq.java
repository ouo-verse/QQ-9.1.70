package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;

/* loaded from: classes10.dex */
public final class CommonPayInfo$BuyItemReq extends MessageMicro<CommonPayInfo$BuyItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 32, 42}, new String[]{"businessType", "pageInfo", "clientPlat", VideoTemplateParser.ITEM_LIST}, new Object[]{0, null, 0, null}, CommonPayInfo$BuyItemReq.class);
    public final PBInt32Field businessType = PBField.initInt32(0);
    public CommonPayInfo$PageInfo pageInfo = new MessageMicro<CommonPayInfo$PageInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$PageInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"aid", "qua", "enteranceId", "reportExtraInfo"}, new Object[]{"", "", "", ""}, CommonPayInfo$PageInfo.class);
        public final PBStringField aid = PBField.initString("");
        public final PBStringField qua = PBField.initString("");
        public final PBStringField enteranceId = PBField.initString("");
        public final PBStringField reportExtraInfo = PBField.initString("");
    };
    public final PBEnumField clientPlat = PBField.initEnum(0);
    public final PBRepeatMessageField<CommonPayInfo$ItemInfo> itemList = PBField.initRepeatMessage(CommonPayInfo$ItemInfo.class);
}
