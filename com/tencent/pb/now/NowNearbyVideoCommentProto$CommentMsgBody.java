package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$CommentMsgBody extends MessageMicro<NowNearbyVideoCommentProto$CommentMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msgs"}, new Object[]{null}, NowNearbyVideoCommentProto$CommentMsgBody.class);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto$CommentMsg> msgs = PBField.initRepeatMessage(NowNearbyVideoCommentProto$CommentMsg.class);
}
