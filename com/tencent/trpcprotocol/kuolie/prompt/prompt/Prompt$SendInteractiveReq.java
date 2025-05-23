package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes38.dex */
public final class Prompt$SendInteractiveReq extends MessageMicro<Prompt$SendInteractiveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"interactive_type", "param", "option", "sign"}, new Object[]{0, null, null, ByteStringMicro.EMPTY}, Prompt$SendInteractiveReq.class);
    public final PBEnumField interactive_type = PBField.initEnum(0);
    public Prompt$InteractiveParam param = new Prompt$InteractiveParam();
    public Prompt$InteractiveOption option = new Prompt$InteractiveOption();
    public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
}
