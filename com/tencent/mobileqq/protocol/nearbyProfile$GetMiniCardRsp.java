package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$GetMiniCardRsp extends MessageMicro<nearbyProfile$GetMiniCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "ret_msg", "is_show", "mini_card"}, new Object[]{0, "", Boolean.FALSE, null}, nearbyProfile$GetMiniCardRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_show = PBField.initBool(false);
    public final PBRepeatMessageField<nearbyProfile$MiniCard> mini_card = PBField.initRepeatMessage(nearbyProfile$MiniCard.class);
}
