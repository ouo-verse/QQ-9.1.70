package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class TtsResBody$voice_item extends MessageMicro<TtsResBody$voice_item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"voice", "seq"}, new Object[]{ByteStringMicro.EMPTY, 0}, TtsResBody$voice_item.class);
    public final PBBytesField voice = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
}
