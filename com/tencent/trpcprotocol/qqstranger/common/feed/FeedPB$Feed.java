package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.state.data.SquareJSConst;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes38.dex */
public final class FeedPB$Feed extends MessageMicro<FeedPB$Feed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 50, 64, 74, 88, 96, 162, 168, 176, 184, 194}, new String[]{"feed_id", QAdVrReport.ElementID.AD_POSTER, SquareJSConst.Params.PARAMS_CUSTOM_TEXT, "images", AlbumCacheData.CREATE_TIME, QZoneHelper.QZoneAlbumConstants.KEY_LIKE_INFO, "security_beat", "comment_count", "comment_by_page", "emoji_id", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "recom_trace"}, new Object[]{"", null, ByteStringMicro.EMPTY, null, 0L, null, Boolean.FALSE, 0, null, 0, 0, 0, ""}, FeedPB$Feed.class);
    public final PBStringField feed_id = PBField.initString("");
    public QqstrangerUserInfoPB$UserInfo poster = new QqstrangerUserInfoPB$UserInfo();
    public final PBBytesField custom_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedPB$StImage> images = PBField.initRepeatMessage(FeedPB$StImage.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public FeedPB$LikeInfo like_info = new FeedPB$LikeInfo();
    public final PBBoolField security_beat = PBField.initBool(false);
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public FeedPB$CommentByPage comment_by_page = new FeedPB$CommentByPage();
    public final PBUInt32Field emoji_id = PBField.initUInt32(0);
    public final PBEnumField feed_type = PBField.initEnum(0);
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBStringField recom_trace = PBField.initString("");
}
