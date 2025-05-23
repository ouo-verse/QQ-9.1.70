package com.tencent.mobileqq.pskey.oidb.cmd0x102a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class oidb_cmd0x102a$GetPSkeyResponse extends MessageMicro<oidb_cmd0x102a$GetPSkeyResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"private_keys"}, new Object[]{null}, oidb_cmd0x102a$GetPSkeyResponse.class);
    public final PBRepeatMessageField<oidb_cmd0x102a$PSKey> private_keys = PBField.initRepeatMessage(oidb_cmd0x102a$PSKey.class);
}
