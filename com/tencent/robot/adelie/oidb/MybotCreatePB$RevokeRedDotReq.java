package com.tencent.robot.adelie.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes25.dex */
public final class MybotCreatePB$RevokeRedDotReq extends MessageMicro<MybotCreatePB$RevokeRedDotReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"revoke_id"}, new Object[]{""}, MybotCreatePB$RevokeRedDotReq.class);
    public final PBStringField revoke_id = PBField.initString("");
}
