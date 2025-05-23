package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SetQzoneDynamicNickRsp extends MessageMicro<SetQzoneDynamicNickRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"result"}, new Object[]{0}, SetQzoneDynamicNickRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
}
