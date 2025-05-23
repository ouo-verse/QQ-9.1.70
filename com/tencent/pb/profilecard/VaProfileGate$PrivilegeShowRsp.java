package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class VaProfileGate$PrivilegeShowRsp extends MessageMicro<VaProfileGate$PrivilegeShowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_show", "privilege_show_list"}, new Object[]{Boolean.FALSE, null}, VaProfileGate$PrivilegeShowRsp.class);
    public final PBBoolField is_show = PBField.initBool(false);
    public final PBRepeatMessageField<VaProfileGate$PrivilegeShowItem> privilege_show_list = PBField.initRepeatMessage(VaProfileGate$PrivilegeShowItem.class);
}
