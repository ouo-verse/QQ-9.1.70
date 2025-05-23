package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class FeedsProtocol$TextFeed extends MessageMicro<FeedsProtocol$TextFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 64, 72, 80, 90, 98, 106, 114, 120, 130}, new String[]{"user_info", AlbumCacheData.CREATE_TIME, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", PictureConst.PHOTO_LIKE_NUM, GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "lbs_info", "share_main_title", "share_subheading", PictureConst.PHOTO_COMMENT_NUM, "text"}, new Object[]{null, 0, 0, 0, "", null, 0, 0, 0, 0, "", null, "", "", 0, ""}, FeedsProtocol$TextFeed.class);
    public FeedsProtocol$UserInfo user_info = new FeedsProtocol$UserInfo();
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt32Field feed_type = PBField.initUInt32(0);
    public final PBUInt32Field feed_source = PBField.initUInt32(0);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBRepeatMessageField<FeedsProtocol$RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol$RichTitleElement.class);
    public final PBUInt32Field is_listen = PBField.initUInt32(0);
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    public final PBUInt32Field is_like = PBField.initUInt32(0);
    public final PBUInt32Field like_num = PBField.initUInt32(0);
    public final PBStringField share_url = PBField.initString("");
    public FeedsProtocol$LbsInfo lbs_info = new FeedsProtocol$LbsInfo();
    public final PBStringField share_main_title = PBField.initString("");
    public final PBStringField share_subheading = PBField.initString("");
    public final PBUInt32Field comment_num = PBField.initUInt32(0);
    public final PBStringField text = PBField.initString("");
}
