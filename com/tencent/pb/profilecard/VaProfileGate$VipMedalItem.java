package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$VipMedalItem extends MessageMicro<VaProfileGate$VipMedalItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"item_id", "jump_url"}, new Object[]{0, ""}, VaProfileGate$VipMedalItem.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
}
