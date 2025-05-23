package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetSkinInfoReq extends MessageMicro<RedPackSkin$GetSkinInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24, 42, 48}, new String[]{"version", "skin_ids", "outer_skin_ids", "skin_from"}, new Object[]{"", 0, "", 0}, RedPackSkin$GetSkinInfoReq.class);
    public final PBStringField version = PBField.initString("");
    public final PBRepeatField<Integer> skin_ids = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<String> outer_skin_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField skin_from = PBField.initEnum(0);
}
