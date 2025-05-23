package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$RecommendReq extends MessageMicro<AssistedChatPB$RecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 58, 64, 72, 80, 90, 98}, new String[]{"scene", "peer_tiny_id", "dialogs", "biz_type", "peer_uid", "req_count", "content", "festival_id", "req_offset", "need_binary_data", "prompt_id", "ext_data"}, new Object[]{0, 0L, null, 0, "", 0, "", 0, 0, Boolean.FALSE, "", ByteStringMicro.EMPTY}, AssistedChatPB$RecommendReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field peer_tiny_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<AssistedChatPB$Dialog> dialogs = PBField.initRepeatMessage(AssistedChatPB$Dialog.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBStringField peer_uid = PBField.initString("");
    public final PBUInt32Field req_count = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field festival_id = PBField.initUInt32(0);
    public final PBUInt32Field req_offset = PBField.initUInt32(0);
    public final PBBoolField need_binary_data = PBField.initBool(false);
    public final PBStringField prompt_id = PBField.initString("");
    public final PBBytesField ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
