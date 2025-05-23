package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class FeedsProtocol$ShortVideoInfo extends MessageMicro<FeedsProtocol$ShortVideoInfo> {
    public static final int FEED_SOURCE_ANDROID = 2;
    public static final int FEED_SOURCE_IOS = 1;
    public static final int FEED_STATUS_DELETE = 1;
    public static final int FEED_STATUS_INVALID = 2;
    public static final int FEED_STATUS_VALID = 0;
    public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int TYPE_RECORD_VIDEO_FEED = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedsProtocol$UserInfo anchor_info;
    public final PBUInt32Field bg_color;
    public final PBUInt64Field create_time;
    public final PBBytesField doodle_pic_url;
    public final PBEnumField feed_source;
    public final PBEnumField feed_type;
    public final PBBytesField feeds_id;
    public final PBBytesField file_id;
    public final PBUInt64Field follow_uid;
    public final PBUInt32Field is_like;
    public final PBUInt32Field is_listen;
    public final PBBytesField jump_url;
    public FeedsProtocol$LbsInfo lbs_info;
    public final PBUInt32Field like_num;
    public final PBBytesField pic_url;
    public final PBRepeatMessageField<FeedsProtocol$RichTitleElement> rpt_msg_rich_title;
    public final PBBytesField share_url;
    public final PBUInt32Field up_status;
    public FeedsProtocol$UserInfo user_info = new FeedsProtocol$UserInfo();
    public final PBBytesField vid;
    public final PBUInt32Field video_hight;
    public final PBUInt32Field video_time;
    public final PBBytesField video_url;
    public final PBUInt32Field video_width;
    public final PBUInt32Field view_times;

    static {
        String[] strArr = {"user_info", "pic_url", "video_url", "anchor_info", AlbumCacheData.CREATE_TIME, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feeds_id", "file_id", "video_time", "rpt_msg_rich_title", "view_times", "video_width", "video_hight", "doodle_pic_url", "is_listen", "is_like", PictureConst.PHOTO_LIKE_NUM, GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "follow_uid", "jump_url", "up_status", "lbs_info", LayoutAttrDefine.BG_Color, "vid"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 66, 74, 80, 90, 96, 104, 112, 122, 128, 136, 144, 154, 160, 170, 176, 186, 192, 202}, strArr, new Object[]{null, byteStringMicro, byteStringMicro, null, 0L, 1, 1, byteStringMicro, byteStringMicro, 0, null, 0, 0, 0, byteStringMicro, 0, 0, 0, byteStringMicro, 0L, byteStringMicro, 0, null, 0, byteStringMicro}, FeedsProtocol$ShortVideoInfo.class);
    }

    public FeedsProtocol$ShortVideoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.video_url = PBField.initBytes(byteStringMicro);
        this.anchor_info = new FeedsProtocol$UserInfo();
        this.create_time = PBField.initUInt64(0L);
        this.feed_type = PBField.initEnum(1);
        this.feed_source = PBField.initEnum(1);
        this.feeds_id = PBField.initBytes(byteStringMicro);
        this.file_id = PBField.initBytes(byteStringMicro);
        this.video_time = PBField.initUInt32(0);
        this.rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol$RichTitleElement.class);
        this.view_times = PBField.initUInt32(0);
        this.video_width = PBField.initUInt32(0);
        this.video_hight = PBField.initUInt32(0);
        this.doodle_pic_url = PBField.initBytes(byteStringMicro);
        this.is_listen = PBField.initUInt32(0);
        this.is_like = PBField.initUInt32(0);
        this.like_num = PBField.initUInt32(0);
        this.share_url = PBField.initBytes(byteStringMicro);
        this.follow_uid = PBField.initUInt64(0L);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.up_status = PBField.initUInt32(0);
        this.lbs_info = new FeedsProtocol$LbsInfo();
        this.bg_color = PBField.initUInt32(0);
        this.vid = PBField.initBytes(byteStringMicro);
    }
}
