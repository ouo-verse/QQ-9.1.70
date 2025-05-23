package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$HippoMsg extends MessageMicro<NowNearbyVideoCommentProto$HippoMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"uid", "comm", "action", "feeds_id", "comm_id"}, new Object[]{0L, null, 0, ByteStringMicro.EMPTY, 0L}, NowNearbyVideoCommentProto$HippoMsg.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public NowNearbyVideoCommentProto$AddCommentReq comm = new MessageMicro<NowNearbyVideoCommentProto$AddCommentReq>() { // from class: com.tencent.pb.now.NowNearbyVideoCommentProto$AddCommentReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 64}, new String[]{QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_id", "record_uid", "reply_uid", "feed_owner", "content", "is_aggregate_short_video", "anchor_uid"}, new Object[]{0L, "", 0L, 0L, 0L, null, 0, 0L}, NowNearbyVideoCommentProto$AddCommentReq.class);
        public final PBUInt64Field feed_type = PBField.initUInt64(0);
        public final PBStringField feed_id = PBField.initString("");
        public final PBUInt64Field record_uid = PBField.initUInt64(0);
        public final PBUInt64Field reply_uid = PBField.initUInt64(0);
        public final PBUInt64Field feed_owner = PBField.initUInt64(0);
        public NowNearbyVideoCommentProto$CommentMsgBody content = new NowNearbyVideoCommentProto$CommentMsgBody();
        public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
        public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    };
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field comm_id = PBField.initUInt64(0);
}
