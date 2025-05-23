package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetCommentListNoFilterResp extends MessageMicro<NowNearbyVideoCommentProto$GetCommentListNoFilterResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"result", "lists", "total_num", "end_flag"}, new Object[]{0L, null, 0L, 0L}, NowNearbyVideoCommentProto$GetCommentListNoFilterResp.class);
    public final PBUInt64Field result = PBField.initUInt64(0);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto$Comment> lists = PBField.initRepeatMessage(NowNearbyVideoCommentProto$Comment.class);
    public final PBUInt64Field total_num = PBField.initUInt64(0);
    public final PBUInt64Field end_flag = PBField.initUInt64(0);
}
