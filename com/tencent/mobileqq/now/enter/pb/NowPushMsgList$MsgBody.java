package com.tencent.mobileqq.now.enter.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes9.dex */
public final class NowPushMsgList$MsgBody extends MessageMicro<NowPushMsgList$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_now_push_msg"}, new Object[]{null}, NowPushMsgList$MsgBody.class);
    public final PBRepeatMessageField<NowPushMsgList$NowPushMsg> rpt_now_push_msg = PBField.initRepeatMessage(NowPushMsgList$NowPushMsg.class);
}
