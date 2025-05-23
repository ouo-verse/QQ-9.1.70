package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$PageInfo extends MessageMicro<QZoneVipPayInfo$PageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"aid", "qua", "enteranceId", "reportExtraInfo"}, new Object[]{"", "", "", ""}, QZoneVipPayInfo$PageInfo.class);
    public final PBStringField aid = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBStringField enteranceId = PBField.initString("");
    public final PBStringField reportExtraInfo = PBField.initString("");
}
