package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$Comment extends MessageMicro<NowNearbyVideoCommentProto$Comment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56}, new String[]{"comment_id", "publish_info", "reply_info", "content", AlbumCacheData.CREATE_TIME, "update_time", "type"}, new Object[]{0L, null, null, null, 0L, 0L, 0}, NowNearbyVideoCommentProto$Comment.class);
    public final PBUInt64Field comment_id = PBField.initUInt64(0);
    public NowNearbyVideoCommentProto$UserInfo publish_info = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$UserInfo reply_info = new NowNearbyVideoCommentProto$UserInfo();
    public NowNearbyVideoCommentProto$CommentMsgBody content = new NowNearbyVideoCommentProto$CommentMsgBody();
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
