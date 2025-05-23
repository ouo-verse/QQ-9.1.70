package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$TabRedPointRsp extends MessageMicro<FeedsProtocol$TabRedPointRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_red"}, new Object[]{Boolean.FALSE}, FeedsProtocol$TabRedPointRsp.class);
    public final PBBoolField is_red = PBField.initBool(false);
}
