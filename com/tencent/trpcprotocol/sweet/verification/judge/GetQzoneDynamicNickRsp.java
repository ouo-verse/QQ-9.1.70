package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GetQzoneDynamicNickRsp extends MessageMicro<GetQzoneDynamicNickRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"module", "is_gray"}, new Object[]{null, Boolean.FALSE}, GetQzoneDynamicNickRsp.class);
    public DynamicNickModule module = new DynamicNickModule();
    public final PBBoolField is_gray = PBField.initBool(false);
}
