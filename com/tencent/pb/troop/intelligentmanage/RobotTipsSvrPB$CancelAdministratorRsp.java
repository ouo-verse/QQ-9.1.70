package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class RobotTipsSvrPB$CancelAdministratorRsp extends MessageMicro<RobotTipsSvrPB$CancelAdministratorRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"has_tips", "tips"}, new Object[]{Boolean.FALSE, ""}, RobotTipsSvrPB$CancelAdministratorRsp.class);
    public final PBBoolField has_tips = PBField.initBool(false);
    public final PBStringField tips = PBField.initString("");
}
