package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$DelCommentReq extends MessageMicro<NowNearbyVideoCommentProto$DelCommentReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField biz_date;
    public final PBUInt64Field comment_id = PBField.initUInt64(0);
    public final PBBytesField feed_id;
    public final PBUInt32Field from_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"comment_id", "feed_id", "from_type", "biz_date"}, new Object[]{0L, byteStringMicro, 0, byteStringMicro}, NowNearbyVideoCommentProto$DelCommentReq.class);
    }

    public NowNearbyVideoCommentProto$DelCommentReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.from_type = PBField.initUInt32(0);
        this.biz_date = PBField.initBytes(byteStringMicro);
    }
}
