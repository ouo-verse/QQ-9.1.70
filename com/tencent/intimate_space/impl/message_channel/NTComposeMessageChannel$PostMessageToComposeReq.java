package com.tencent.intimate_space.impl.message_channel;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class NTComposeMessageChannel$PostMessageToComposeReq extends MessageMicro<NTComposeMessageChannel$PostMessageToComposeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"scene_address", "event_name", "data"}, new Object[]{0L, "", ByteStringMicro.EMPTY}, NTComposeMessageChannel$PostMessageToComposeReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBStringField event_name = PBField.initString("");
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
