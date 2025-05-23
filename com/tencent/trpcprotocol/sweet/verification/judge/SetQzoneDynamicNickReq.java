package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SetQzoneDynamicNickReq extends MessageMicro<SetQzoneDynamicNickReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "module"}, new Object[]{0L, null}, SetQzoneDynamicNickReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public DynamicNickModule module = new DynamicNickModule();
}
