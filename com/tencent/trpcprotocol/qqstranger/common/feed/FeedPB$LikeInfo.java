package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;

/* loaded from: classes38.dex */
public final class FeedPB$LikeInfo extends MessageMicro<FeedPB$LikeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48}, new String[]{"id", "count", "liked_users", "my_like", "round_param", PictureConst.KEY_HAS_MORE}, new Object[]{"", 0, null, 0, "", 0}, FeedPB$LikeInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381608id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBRepeatMessageField<QqstrangerUserInfoPB$UserInfo> liked_users = PBField.initRepeatMessage(QqstrangerUserInfoPB$UserInfo.class);
    public final PBUInt32Field my_like = PBField.initUInt32(0);
    public final PBStringField round_param = PBField.initString("");
    public final PBInt32Field has_more = PBField.initInt32(0);
}
