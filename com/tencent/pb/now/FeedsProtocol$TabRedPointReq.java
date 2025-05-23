package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$TabRedPointReq extends MessageMicro<FeedsProtocol$TabRedPointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_get"}, new Object[]{Boolean.FALSE}, FeedsProtocol$TabRedPointReq.class);
    public final PBBoolField is_get = PBField.initBool(false);
}
