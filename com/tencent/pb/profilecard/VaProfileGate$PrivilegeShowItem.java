package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$PrivilegeShowItem extends MessageMicro<VaProfileGate$PrivilegeShowItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"appid", "is_recommend", "item_id", "text", "icon"}, new Object[]{0, Boolean.FALSE, 0, "", ""}, VaProfileGate$PrivilegeShowItem.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBBoolField is_recommend = PBField.initBool(false);
    public final PBInt32Field item_id = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
