package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetCommentsReq extends MessageMicro<NowNearbyVideoCommentProto$GetCommentsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"comment_id"}, new Object[]{0L}, NowNearbyVideoCommentProto$GetCommentsReq.class);
    public final PBRepeatField<Long> comment_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
