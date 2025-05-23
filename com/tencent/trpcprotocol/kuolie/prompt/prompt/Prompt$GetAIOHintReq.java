package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class Prompt$GetAIOHintReq extends MessageMicro<Prompt$GetAIOHintReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{INetChannelCallback.KEY_TINY_ID}, new Object[]{0L}, Prompt$GetAIOHintReq.class);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
}
