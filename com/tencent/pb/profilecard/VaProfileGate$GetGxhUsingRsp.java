package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetGxhUsingRsp extends MessageMicro<VaProfileGate$GetGxhUsingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56, 66, 74}, new String[]{"item_list", "jump_url", "is_on", "suit_list", "suit_jump_url", "title", "type", "ip_list", "ip_jump_url"}, new Object[]{null, "", Boolean.FALSE, null, "", "", 0, null, ""}, VaProfileGate$GetGxhUsingRsp.class);
    public final PBRepeatMessageField<VaProfileGate$GxhUsingItem> item_list = PBField.initRepeatMessage(VaProfileGate$GxhUsingItem.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBBoolField is_on = PBField.initBool(false);
    public final PBRepeatMessageField<VaProfileGate$GxhSuit> suit_list = PBField.initRepeatMessage(VaProfileGate$GxhSuit.class);
    public final PBStringField suit_jump_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBRepeatMessageField<VaProfileGate$GxhIPCollection> ip_list = PBField.initRepeatMessage(VaProfileGate$GxhIPCollection.class);
    public final PBStringField ip_jump_url = PBField.initString("");
}
