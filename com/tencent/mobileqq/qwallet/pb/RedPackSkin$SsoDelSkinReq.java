package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$SsoDelSkinReq extends MessageMicro<RedPackSkin$SsoDelSkinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"skin_from", "skin_id", "outer_skin_id"}, new Object[]{0, 0, ""}, RedPackSkin$SsoDelSkinReq.class);
    public final PBEnumField skin_from = PBField.initEnum(0);
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBStringField outer_skin_id = PBField.initString("");
}
