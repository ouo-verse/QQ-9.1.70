package com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class AssistedChatExtDataPB$MessageExtData extends MessageMicro<AssistedChatExtDataPB$MessageExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"biz_type", "scene", "holiday_id", "recom_trace"}, new Object[]{0, 0, 0L, ByteStringMicro.EMPTY}, AssistedChatExtDataPB$MessageExtData.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt32Field holiday_id = PBField.initUInt32(0);
    public final PBBytesField recom_trace = PBField.initBytes(ByteStringMicro.EMPTY);
}
