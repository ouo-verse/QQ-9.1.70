package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$GetLatestUnReadMsgReq extends MessageMicro<OfficialAssistant$GetLatestUnReadMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"offset_msg_id"}, new Object[]{0L}, OfficialAssistant$GetLatestUnReadMsgReq.class);
    public final PBUInt64Field offset_msg_id = PBField.initUInt64(0);
}
