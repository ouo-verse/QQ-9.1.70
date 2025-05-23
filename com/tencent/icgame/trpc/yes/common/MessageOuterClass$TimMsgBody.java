package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$TimMsgBody extends MessageMicro<MessageOuterClass$TimMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "content", "from_user", "update_text"}, new Object[]{0, null, null, ""}, MessageOuterClass$TimMsgBody.class);
    public final PBInt32Field msg_type = PBField.initInt32(0);
    public MessageOuterClass$MsgContent content = new MessageOuterClass$MsgContent();
    public CommonOuterClass$QQUserId from_user = new CommonOuterClass$QQUserId();
    public final PBStringField update_text = PBField.initString("");
}
