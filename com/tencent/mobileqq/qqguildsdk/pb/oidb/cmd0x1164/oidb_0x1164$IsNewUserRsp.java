package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0x1164;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class oidb_0x1164$IsNewUserRsp extends MessageMicro<oidb_0x1164$IsNewUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_new"}, new Object[]{Boolean.FALSE}, oidb_0x1164$IsNewUserRsp.class);
    public final PBBoolField is_new = PBField.initBool(false);
}
