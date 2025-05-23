package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MessageChannelErrorCode$MessageResponse extends MessageMicro<MessageChannelErrorCode$MessageResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"data", "error"}, new Object[]{ByteStringMicro.EMPTY, null}, MessageChannelErrorCode$MessageResponse.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public MessageChannelErrorCode$MessageChannelError error = new MessageChannelErrorCode$MessageChannelError();
}
