package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes20.dex */
public final class WeiyunPB$MsgBody extends MessageMicro<WeiyunPB$MsgBody> {
    public static final int REQMSG_BODY_FIELD_NUMBER = 1;
    public static final int RSPMSG_BODY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ReqMsg_body", "RspMsg_body"}, new Object[]{null, null}, WeiyunPB$MsgBody.class);
    public WeiyunPB$ReqMsgBody ReqMsg_body = new WeiyunPB$ReqMsgBody();
    public WeiyunPB$RspMsgBody RspMsg_body = new WeiyunPB$RspMsgBody();
}
