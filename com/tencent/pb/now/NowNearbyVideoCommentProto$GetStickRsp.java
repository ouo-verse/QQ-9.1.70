package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetStickRsp extends MessageMicro<NowNearbyVideoCommentProto$GetStickRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"result", "err_msg", "value", "total_num"}, new Object[]{0, "", null, 0L}, NowNearbyVideoCommentProto$GetStickRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<NowNearbyVideoCommentProto$Comment> value = PBField.initRepeatMessage(NowNearbyVideoCommentProto$Comment.class);
    public final PBUInt64Field total_num = PBField.initUInt64(0);
}
