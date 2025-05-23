package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$BuyItemRsp extends MessageMicro<QZoneVipPayInfo$BuyItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66}, new String[]{"code", "msg", "info", "payMode", "useClientPlatform", "picInfo", "monthInfo", "reportData"}, new Object[]{0, "", "", 0, 0, null, null, ""}, QZoneVipPayInfo$BuyItemRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381667msg = PBField.initString("");
    public final PBStringField info = PBField.initString("");
    public final PBEnumField payMode = PBField.initEnum(0);
    public final PBEnumField useClientPlatform = PBField.initEnum(0);
    public QZoneVipPayInfo$PicPayInfo picInfo = new QZoneVipPayInfo$PicPayInfo();
    public QZoneVipPayInfo$MonthPayInfo monthInfo = new QZoneVipPayInfo$MonthPayInfo();
    public final PBStringField reportData = PBField.initString("");
}
