package com.tencent.ecommerce.repo.proto.ecom.common_comm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECComm$OrderInfo extends MessageMicro<ECComm$OrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66}, new String[]{WadlProxyConsts.CHANNEL, "channel_name", "ext", "version", "client_plat", "client_ip", "content_id", "ad_id"}, new Object[]{0, "", null, "", 0, "", "", ""}, ECComm$OrderInfo.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBStringField channel_name = PBField.initString("");
    public ECComm$ReqExt ext = new ECComm$ReqExt();
    public final PBStringField version = PBField.initString("");
    public final PBUInt32Field client_plat = PBField.initUInt32(0);
    public final PBStringField client_ip = PBField.initString("");
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField ad_id = PBField.initString("");
}
