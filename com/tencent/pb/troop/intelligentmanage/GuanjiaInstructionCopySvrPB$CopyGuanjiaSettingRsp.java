package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp extends MessageMicro<GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errcode", "toast_msg"}, new Object[]{0, ""}, GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBStringField toast_msg = PBField.initString("");
}
