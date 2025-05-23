package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedDetailByIdReq extends MessageMicro<FeedsProtocol$FeedDetailByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"feed_id", "type", "follow_type", "follow_uid"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0L}, FeedsProtocol$FeedDetailByIdReq.class);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBUInt64Field follow_uid = PBField.initUInt64(0);
}
