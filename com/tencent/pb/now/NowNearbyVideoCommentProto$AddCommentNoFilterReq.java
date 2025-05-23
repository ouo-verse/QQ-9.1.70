package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$AddCommentNoFilterReq extends MessageMicro<NowNearbyVideoCommentProto$AddCommentNoFilterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_id", "video_recorder", "video_owner", "video_anchor", "reply_user", "content", "is_aggregate_short_video", "reply_comment_id"}, new Object[]{0L, "", null, null, null, null, null, 0, 0L}, NowNearbyVideoCommentProto$AddCommentNoFilterReq.class);
    public final PBUInt64Field feed_type = PBField.initUInt64(0);
    public final PBStringField feed_id = PBField.initString("");
    public NowNearbyVideoCommentProto$UserInfo video_recorder = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$UserInfo video_owner = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$UserInfo video_anchor = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$UserInfo reply_user = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$CommentMsgBody content = new NowNearbyVideoCommentProto$CommentMsgBody();
    public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
    public final PBUInt64Field reply_comment_id = PBField.initUInt64(0);
}
