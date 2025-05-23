package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class Prompt$InteractiveParam extends MessageMicro<Prompt$InteractiveParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"Interactive_object", "tinyid"}, new Object[]{"", 0L}, Prompt$InteractiveParam.class);
    public final PBStringField Interactive_object = PBField.initString("");
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
}
