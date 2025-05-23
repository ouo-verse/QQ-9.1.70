package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class FeedsProtocol$PicFeedsInfo extends MessageMicro<FeedsProtocol$PicFeedsInfo> {
    public static final int FEED_SOURCE_ANDROID = 2;
    public static final int FEED_SOURCE_IOS = 1;
    public static final int TYPE_CHANG = 6;
    public static final int TYPE_CHANG_REPLAY = 7;
    public static final int TYPE_LIVE = 5;
    public static final int TYPE_PIC = 4;
    public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int TYPE_RECORD_VIDEO_FEED = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feeds_id;
    public final PBUInt32Field is_like;
    public final PBUInt32Field is_listen;
    public FeedsProtocol$LbsInfo lbs_info;
    public final PBUInt32Field like_num;
    public final PBRepeatMessageField<FeedsProtocol$RichTitleElement> rpt_msg_rich_title;
    public final PBBytesField share_url;
    public final PBUInt32Field view_times;
    public FeedsProtocol$UserInfo user_info = new FeedsProtocol$UserInfo();
    public final PBRepeatMessageField<FeedsProtocol$PicInfo> pic_infos = PBField.initRepeatMessage(FeedsProtocol$PicInfo.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBUInt32Field feed_type = PBField.initUInt32(0);
    public final PBUInt32Field feed_source = PBField.initUInt32(0);

    static {
        String[] strArr = {"user_info", "pic_infos", AlbumCacheData.CREATE_TIME, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", PictureConst.PHOTO_LIKE_NUM, GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "lbs_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 80, 88, 96, 104, 114, 122}, strArr, new Object[]{null, null, 0L, 0, 0, byteStringMicro, null, 0, 0, 0, 0, byteStringMicro, null}, FeedsProtocol$PicFeedsInfo.class);
    }

    public FeedsProtocol$PicFeedsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.feeds_id = PBField.initBytes(byteStringMicro);
        this.rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol$RichTitleElement.class);
        this.is_listen = PBField.initUInt32(0);
        this.view_times = PBField.initUInt32(0);
        this.is_like = PBField.initUInt32(0);
        this.like_num = PBField.initUInt32(0);
        this.share_url = PBField.initBytes(byteStringMicro);
        this.lbs_info = new FeedsProtocol$LbsInfo();
    }
}
