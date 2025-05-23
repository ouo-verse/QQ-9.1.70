package com.tencent.intimate_space.impl.message_channel;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class NTComposeMessageChannel$PostMessageToEngineRsp extends MessageMicro<NTComposeMessageChannel$PostMessageToEngineRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"scene_address", "data", "error"}, new Object[]{0L, ByteStringMicro.EMPTY, null}, NTComposeMessageChannel$PostMessageToEngineRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public NTComposeMessageChannel$NTComposeMessageChannelError error = new NTComposeMessageChannel$NTComposeMessageChannelError();
}
