package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$BuyItemReq extends MessageMicro<QZoneVipPayInfo$BuyItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 32, 42}, new String[]{"businessType", "pageInfo", "clientPlat", VideoTemplateParser.ITEM_LIST}, new Object[]{0, null, 0, null}, QZoneVipPayInfo$BuyItemReq.class);
    public final PBInt32Field businessType = PBField.initInt32(0);
    public QZoneVipPayInfo$PageInfo pageInfo = new QZoneVipPayInfo$PageInfo();
    public final PBEnumField clientPlat = PBField.initEnum(0);
    public final PBRepeatMessageField<QZoneVipPayInfo$ItemInfo> itemList = PBField.initRepeatMessage(QZoneVipPayInfo$ItemInfo.class);
}
