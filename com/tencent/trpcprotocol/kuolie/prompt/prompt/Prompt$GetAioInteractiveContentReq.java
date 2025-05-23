package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes38.dex */
public final class Prompt$GetAioInteractiveContentReq extends MessageMicro<Prompt$GetAioInteractiveContentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"interactive_type", "param"}, new Object[]{0, null}, Prompt$GetAioInteractiveContentReq.class);
    public final PBEnumField interactive_type = PBField.initEnum(0);
    public Prompt$InteractiveParam param = new Prompt$InteractiveParam();
}
