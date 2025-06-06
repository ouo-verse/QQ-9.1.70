package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes5.dex */
public final class SerializationPB$CommentLikeFeed extends MessageMicro<SerializationPB$CommentLikeFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88}, new String[]{"comment_count", "freind_commnet_count", "fan_comment_count", "comment_is_end", "comment_last_cookie", "like_count", "friend_like_count", "fan_like_count", "had_like", "view_total_time", "deny_comment"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0, 0, 0L, 0}, SerializationPB$CommentLikeFeed.class);
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBUInt32Field freind_commnet_count = PBField.initUInt32(0);
    public final PBUInt32Field fan_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field comment_is_end = PBField.initUInt32(0);
    public final PBStringField comment_last_cookie = PBField.initString("");
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBUInt32Field friend_like_count = PBField.initUInt32(0);
    public final PBUInt32Field fan_like_count = PBField.initUInt32(0);
    public final PBUInt32Field had_like = PBField.initUInt32(0);
    public final PBUInt64Field view_total_time = PBField.initUInt64(0);
    public final PBUInt32Field deny_comment = PBField.initUInt32(0);
}
