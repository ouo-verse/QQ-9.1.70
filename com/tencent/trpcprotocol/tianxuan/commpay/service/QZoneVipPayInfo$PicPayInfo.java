package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$PicPayInfo extends MessageMicro<QZoneVipPayInfo$PicPayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"midasAppid", "midasToken", "midasUrlParams", "zoneId", "productId", "payItem", "patternInfo"}, new Object[]{"", "", "", 0, "", "", ""}, QZoneVipPayInfo$PicPayInfo.class);
    public final PBStringField midasAppid = PBField.initString("");
    public final PBStringField midasToken = PBField.initString("");
    public final PBStringField midasUrlParams = PBField.initString("");
    public final PBInt32Field zoneId = PBField.initInt32(0);
    public final PBStringField productId = PBField.initString("");
    public final PBStringField payItem = PBField.initString("");
    public final PBStringField patternInfo = PBField.initString("");
}
