package com.tencent.pb.now;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* loaded from: classes22.dex */
public final class FeedsProtocol$MediaInfo extends MessageMicro<FeedsProtocol$MediaInfo> {
    public static final int LIVE_AGGREGATE = 1;
    public static final int LIVE_ANCHOR = 4;
    public static final int PIC_FEEDS = 5;
    public static final int SHORT_VIDEO = 3;
    public static final int TEXT_FEEDS = 6;
    public static final int VIDEO_LIST = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 810, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"type", "msg_live_anchor", "video", AppConstants.TAG_RAW_SHORT_VIDEO, "live_aggregate", QCircleLpReportDc05507.KEY_PIC_INFO, "topic_cfg", "is_my_feeds", "text_feed"}, new Object[]{0, null, null, null, null, null, null, 0, null}, FeedsProtocol$MediaInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public FeedsProtocol$LiveAnchorItem msg_live_anchor = new MessageMicro<FeedsProtocol$LiveAnchorItem>() { // from class: com.tencent.pb.now.FeedsProtocol$LiveAnchorItem
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field anchor_type;
        public final PBUInt64Field begin_time;

        /* renamed from: id, reason: collision with root package name */
        public final PBBytesField f342131id;
        public final PBBytesField jump_url;
        public final PBBytesField location;
        public final PBUInt32Field room_id;
        public final PBBytesField room_img_url;
        public final PBBytesField room_name;
        public final PBRepeatMessageField<FeedsProtocol$RichTitleElement> rpt_msg_rich_title;
        public final PBUInt32Field sub_room_id;
        public FeedsProtocol$UserInfo user_info;
        public final PBUInt32Field watch_count;

        static {
            String[] strArr = {"id", "user_info", AudienceReportConst.ROOM_NAME, "rpt_msg_rich_title", "room_img_url", "location", "watch_count", "jump_url", "anchor_type", AudienceReportConst.ROOM_ID, "sub_room_id", QCircleLpReportDc05502.KEY_BEGIN_TIME};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 72, 80, 88, 96}, strArr, new Object[]{byteStringMicro, null, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0L}, FeedsProtocol$LiveAnchorItem.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.f342131id = PBField.initBytes(byteStringMicro);
            this.user_info = new FeedsProtocol$UserInfo();
            this.room_name = PBField.initBytes(byteStringMicro);
            this.rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol$RichTitleElement.class);
            this.room_img_url = PBField.initBytes(byteStringMicro);
            this.location = PBField.initBytes(byteStringMicro);
            this.watch_count = PBField.initUInt32(0);
            this.jump_url = PBField.initBytes(byteStringMicro);
            this.anchor_type = PBField.initUInt32(0);
            this.room_id = PBField.initUInt32(0);
            this.sub_room_id = PBField.initUInt32(0);
            this.begin_time = PBField.initUInt64(0L);
        }
    };
    public FeedsProtocol$VideoItem video = new FeedsProtocol$VideoItem();
    public FeedsProtocol$ShortVideoInfo short_video = new FeedsProtocol$ShortVideoInfo();
    public FeedsProtocol$LiveAggregateInfo live_aggregate = new FeedsProtocol$LiveAggregateInfo();
    public FeedsProtocol$PicFeedsInfo pic_info = new FeedsProtocol$PicFeedsInfo();
    public final PBRepeatMessageField<FeedsProtocol$TopicCfg> topic_cfg = PBField.initRepeatMessage(FeedsProtocol$TopicCfg.class);
    public final PBUInt32Field is_my_feeds = PBField.initUInt32(0);
    public FeedsProtocol$TextFeed text_feed = new FeedsProtocol$TextFeed();
}
