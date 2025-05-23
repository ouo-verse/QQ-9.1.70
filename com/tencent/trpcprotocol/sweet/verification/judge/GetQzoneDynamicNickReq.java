package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GetQzoneDynamicNickReq extends MessageMicro<GetQzoneDynamicNickReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, GetQzoneDynamicNickReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
