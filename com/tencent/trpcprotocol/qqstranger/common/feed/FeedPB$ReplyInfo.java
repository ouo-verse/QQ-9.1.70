package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes38.dex */
public final class FeedPB$ReplyInfo extends MessageMicro<FeedPB$ReplyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50}, new String[]{QCircleAlphaUserReporter.KEY_USER, "c_time", "id", "content", "visible_to_public", "target_user"}, new Object[]{null, 0, "", null, Boolean.FALSE, null}, FeedPB$ReplyInfo.class);
    public QqstrangerUserInfoPB$UserInfo user = new QqstrangerUserInfoPB$UserInfo();
    public final PBUInt32Field c_time = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381610id = PBField.initString("");
    public FeedPB$Content content = new FeedPB$Content();
    public final PBBoolField visible_to_public = PBField.initBool(false);
    public QqstrangerUserInfoPB$UserInfo target_user = new QqstrangerUserInfoPB$UserInfo();
}
