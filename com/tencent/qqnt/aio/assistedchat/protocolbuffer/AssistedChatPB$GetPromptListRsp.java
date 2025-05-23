package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes23.dex */
public final class AssistedChatPB$GetPromptListRsp extends MessageMicro<AssistedChatPB$GetPromptListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rsp_head", "infos"}, new Object[]{null, null}, AssistedChatPB$GetPromptListRsp.class);
    public AssistedChatPB$RspHead rsp_head = new AssistedChatPB$RspHead();
    public final PBRepeatMessageField<AssistedChatPB$PromptInfo> infos = PBField.initRepeatMessage(AssistedChatPB$PromptInfo.class);
}
