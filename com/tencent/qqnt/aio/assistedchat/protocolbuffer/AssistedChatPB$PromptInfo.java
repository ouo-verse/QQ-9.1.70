package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$PromptInfo extends MessageMicro<AssistedChatPB$PromptInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"prompt_name", "prompt_content", "prompt_color", "prompt_id"}, new Object[]{"", "", 0L, ""}, AssistedChatPB$PromptInfo.class);
    public final PBStringField prompt_name = PBField.initString("");
    public final PBStringField prompt_content = PBField.initString("");
    public final PBUInt64Field prompt_color = PBField.initUInt64(0);
    public final PBStringField prompt_id = PBField.initString("");
}
