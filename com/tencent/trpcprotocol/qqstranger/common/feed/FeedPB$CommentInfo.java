package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes38.dex */
public final class FeedPB$CommentInfo extends MessageMicro<FeedPB$CommentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56}, new String[]{QCircleAlphaUserReporter.KEY_USER, "c_time", "id", "content", "resp_num", "rpt_reply", "visible_to_public"}, new Object[]{null, 0, "", null, 0, null, Boolean.FALSE}, FeedPB$CommentInfo.class);
    public QqstrangerUserInfoPB$UserInfo user = new QqstrangerUserInfoPB$UserInfo();
    public final PBUInt32Field c_time = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381604id = PBField.initString("");
    public FeedPB$Content content = new FeedPB$Content();
    public final PBUInt32Field resp_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedPB$ReplyInfo> rpt_reply = PBField.initRepeatMessage(FeedPB$ReplyInfo.class);
    public final PBBoolField visible_to_public = PBField.initBool(false);
}
