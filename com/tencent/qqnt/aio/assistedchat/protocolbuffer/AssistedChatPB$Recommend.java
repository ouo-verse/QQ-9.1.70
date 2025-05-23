package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$Recommend extends MessageMicro<AssistedChatPB$Recommend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"id", "content", "recom_trace", "festival_id", "prompt"}, new Object[]{"", "", "", 0, null}, AssistedChatPB$Recommend.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f349417id = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField recom_trace = PBField.initString("");
    public final PBUInt32Field festival_id = PBField.initUInt32(0);
    public AssistedChatPB$PromptInfo prompt = new AssistedChatPB$PromptInfo();
}
