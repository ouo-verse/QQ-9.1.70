package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$AddSkinReq extends MessageMicro<RedPackSkin$AddSkinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{WadlProxyConsts.CHANNEL, "uin", "skin_id", "timestamp", "token", "sign"}, new Object[]{0, 0L, 0, 0L, "", ""}, RedPackSkin$AddSkinReq.class);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField token = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
