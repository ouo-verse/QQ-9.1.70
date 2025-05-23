package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetGiftListRsp extends MessageMicro<VaProfileGate$GetGiftListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"gift_url", "custom_url", "desc", "is_on", "gift_num"}, new Object[]{"", "", "", Boolean.FALSE, 0}, VaProfileGate$GetGiftListRsp.class);
    public final PBRepeatField<String> gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField custom_url = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBBoolField is_on = PBField.initBool(false);
    public final PBUInt32Field gift_num = PBField.initUInt32(0);
}
