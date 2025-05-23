package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetCardRsp extends MessageMicro<VaProfileGate$GetCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"item_list", "jump_url", "is_on", "nameplate_id"}, new Object[]{null, "", Boolean.FALSE, 0}, VaProfileGate$GetCardRsp.class);
    public final PBRepeatMessageField<VaProfileGate$CardItem> item_list = PBField.initRepeatMessage(VaProfileGate$CardItem.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBBoolField is_on = PBField.initBool(false);
    public final PBUInt32Field nameplate_id = PBField.initUInt32(0);
}
