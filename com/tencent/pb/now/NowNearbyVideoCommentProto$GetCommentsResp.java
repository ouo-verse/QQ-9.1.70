package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetCommentsResp extends MessageMicro<NowNearbyVideoCommentProto$GetCommentsResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "value"}, new Object[]{0L, null}, NowNearbyVideoCommentProto$GetCommentsResp.class);
    public final PBUInt64Field result = PBField.initUInt64(0);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto$Comment> value = PBField.initRepeatMessage(NowNearbyVideoCommentProto$Comment.class);
}
