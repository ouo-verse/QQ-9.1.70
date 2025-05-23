package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$CommentByPage extends MessageMicro<FeedPB$CommentByPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"total_count", "rpt_comment_info", "attach_info", "is_over"}, new Object[]{0, null, "", Boolean.FALSE}, FeedPB$CommentByPage.class);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedPB$CommentInfo> rpt_comment_info = PBField.initRepeatMessage(FeedPB$CommentInfo.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField is_over = PBField.initBool(false);
}
