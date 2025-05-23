package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$AssistedSwitchRsp extends MessageMicro<AssistedChatPB$AssistedSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public AssistedChatPB$RspHead rsp_head = new AssistedChatPB$RspHead();
    public final PBBoolField enable_prologue = PBField.initBool(false);
    public final PBBoolField enable_improve_reply = PBField.initBool(false);
    public final PBBoolField enable_topic = PBField.initBool(false);
    public final PBBoolField enable_festival = PBField.initBool(false);
    public final PBBoolField enable_ai_assistant = PBField.initBool(false);
    public final PBBoolField enable_chat_help = PBField.initBool(false);
    public final PBUInt32Field improve_reply_min_words = PBField.initUInt32(0);
    public final PBUInt32Field improve_reply_max_words = PBField.initUInt32(0);
    public final PBStringField festival_button = PBField.initString("");
    public final PBUInt32Field festival_id = PBField.initUInt32(0);
    public final PBUInt32Field cache_ttl = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 88, 160, 168, 178, 184, 240}, new String[]{"rsp_head", "enable_prologue", "enable_improve_reply", "enable_topic", "enable_festival", "enable_ai_assistant", "enable_chat_help", "improve_reply_min_words", "improve_reply_max_words", "festival_button", "festival_id", "cache_ttl"}, new Object[]{null, bool, bool, bool, bool, bool, bool, 0, 0, "", 0, 0}, AssistedChatPB$AssistedSwitchRsp.class);
    }
}
