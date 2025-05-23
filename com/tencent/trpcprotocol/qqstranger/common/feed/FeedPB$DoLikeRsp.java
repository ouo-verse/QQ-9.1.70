package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes38.dex */
public final class FeedPB$DoLikeRsp extends MessageMicro<FeedPB$DoLikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24, 34}, new String[]{QZoneHelper.QZoneAlbumConstants.KEY_LIKE_INFO, "ret_code", "msg"}, new Object[]{null, 0, ""}, FeedPB$DoLikeRsp.class);
    public FeedPB$LikeInfo like_info = new FeedPB$LikeInfo();
    public final PBUInt32Field ret_code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381606msg = PBField.initString("");
}
