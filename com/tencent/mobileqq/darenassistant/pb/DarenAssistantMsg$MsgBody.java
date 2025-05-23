package com.tencent.mobileqq.darenassistant.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class DarenAssistantMsg$MsgBody extends MessageMicro<DarenAssistantMsg$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_update_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_wording", "bytes_jump_url", "uint32_update_time"}, new Object[]{byteStringMicro, byteStringMicro, 0}, DarenAssistantMsg$MsgBody.class);
    }

    public DarenAssistantMsg$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.uint32_update_time = PBField.initUInt32(0);
    }
}
