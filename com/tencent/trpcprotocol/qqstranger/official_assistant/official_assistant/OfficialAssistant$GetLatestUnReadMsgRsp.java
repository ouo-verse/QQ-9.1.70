package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$GetLatestUnReadMsgRsp extends MessageMicro<OfficialAssistant$GetLatestUnReadMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "msg", "messages"}, new Object[]{0, "", null}, OfficialAssistant$GetLatestUnReadMsgRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381614msg = PBField.initString("");
    public final PBRepeatMessageField<OfficialAssistant$Message> messages = PBField.initRepeatMessage(OfficialAssistant$Message.class);
}
