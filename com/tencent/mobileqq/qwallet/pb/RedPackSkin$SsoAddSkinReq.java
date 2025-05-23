package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$SsoAddSkinReq extends MessageMicro<RedPackSkin$SsoAddSkinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"skin_id", "timestamp", "token"}, new Object[]{0, 0L, ""}, RedPackSkin$SsoAddSkinReq.class);
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField token = PBField.initString("");
}
