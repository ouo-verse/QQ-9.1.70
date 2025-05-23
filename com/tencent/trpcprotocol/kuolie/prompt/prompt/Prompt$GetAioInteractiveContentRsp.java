package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class Prompt$GetAioInteractiveContentRsp extends MessageMicro<Prompt$GetAioInteractiveContentRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret_code", "err_msg", "content", "options"}, new Object[]{0, "", null, null}, Prompt$GetAioInteractiveContentRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public Prompt$InteractiveContent content = new Prompt$InteractiveContent();
    public final PBRepeatMessageField<Prompt$InteractiveOption> options = PBField.initRepeatMessage(Prompt$InteractiveOption.class);
}
