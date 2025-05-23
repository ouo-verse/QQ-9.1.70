package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$MessageExtData extends MessageMicro<AssistedChatPB$MessageExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"biz_type", "scene", "holiday_id", "recom_trace"}, new Object[]{0, 0, 0L, ByteStringMicro.EMPTY}, AssistedChatPB$MessageExtData.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field holiday_id = PBField.initUInt64(0);
    public final PBBytesField recom_trace = PBField.initBytes(ByteStringMicro.EMPTY);
}
