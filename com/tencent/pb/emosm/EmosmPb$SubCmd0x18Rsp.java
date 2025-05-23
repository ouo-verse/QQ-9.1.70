package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x18Rsp extends MessageMicro<EmosmPb$SubCmd0x18Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bool_jump_flag", "uint32_author_id"}, new Object[]{Boolean.FALSE, 0}, EmosmPb$SubCmd0x18Rsp.class);
    public final PBBoolField bool_jump_flag = PBField.initBool(false);
    public final PBUInt32Field uint32_author_id = PBField.initUInt32(0);
}
