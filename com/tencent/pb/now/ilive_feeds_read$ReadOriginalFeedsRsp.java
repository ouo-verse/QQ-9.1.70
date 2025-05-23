package com.tencent.pb.now;

import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ilive_user_basic_info.ilive_user_basic_info$MedalInfo;
import com.tencent.luggage.wxa.uf.g;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadOriginalFeedsRsp extends MessageMicro<ilive_feeds_read$ReadOriginalFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 34}, new String[]{"result", "err_msg", "info"}, new Object[]{0, "", null}, ilive_feeds_read$ReadOriginalFeedsRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public ilive_feeds_read$FeedsInfo info = new MessageMicro<ilive_feeds_read$FeedsInfo>() { // from class: com.tencent.pb.now.ilive_feeds_read$FeedsInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public ilive_feeds_tmem$ChangFeed chang_info;
        public final PBInt32Field comment_num;
        public final PBRepeatMessageField<NowNearbyVideoCommentProto$Comment> comments;
        public final PBDoubleField distance;
        public ilive_feeds_tmem$VideoFeed feed_info;
        public final PBBytesField feeds_id;
        public final PBBytesField jump_url;
        public FeedsProtocol$LbsInfo lbs_info;
        public final PBInt32Field like;
        public ilive_feeds_tmem$FeedsTmemLike like_info;
        public ilive_feeds_tmem$LiveFeed live_info;
        public ilive_feeds_tmem$PicFeed pic_info;
        public ilive_feeds_read$FeedUserInfo publish_info;
        public final PBEnumField status;
        public ilive_feeds_tmem$TextFeed text_feed;
        public final PBRepeatMessageField<ilive_feeds_read$TopicCfg> topic_cfg;
        public final PBInt32Field type;
        public final PBUInt32Field view_times;
        public final PBUInt64Field publish_uin = PBField.initUInt64(0);
        public final PBUInt32Field create_time = PBField.initUInt32(0);
        public final PBEnumField feed_type = PBField.initEnum(1);
        public final PBEnumField feed_source = PBField.initEnum(0);

        static {
            int[] iArr = {8, 16, 24, 32, 50, 58, 64, 72, 82, 90, 98, 106, 114, 122, 154, 800, 810, 818, 824, 832, g.CTRL_INDEX, 850};
            String[] strArr = {"publish_uin", AlbumCacheData.CREATE_TIME, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feeds_id", "feed_info", "view_times", "status", QCircleLpReportDc05507.KEY_PIC_INFO, "live_info", "chang_info", "jump_url", "publish_info", "lbs_info", "text_feed", "like", QZoneHelper.QZoneAlbumConstants.KEY_LIKE_INFO, "comments", PictureConst.PHOTO_COMMENT_NUM, "type", Element.ELEMENT_NAME_DISTANCE, "topic_cfg"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0L, 0, 1, 0, byteStringMicro, null, 0, 1, null, null, null, byteStringMicro, null, null, null, 0, null, null, 0, 0, Double.valueOf(0.0d), null}, ilive_feeds_read$FeedsInfo.class);
        }

        /* JADX WARN: Type inference failed for: r1v11, types: [com.tencent.pb.now.ilive_feeds_tmem$FeedsTmemLike] */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.pb.now.ilive_feeds_read$FeedUserInfo] */
        /* JADX WARN: Type inference failed for: r1v9, types: [com.tencent.pb.now.ilive_feeds_tmem$TextFeed] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.feeds_id = PBField.initBytes(byteStringMicro);
            this.feed_info = new ilive_feeds_tmem$VideoFeed();
            this.view_times = PBField.initUInt32(0);
            this.status = PBField.initEnum(1);
            this.pic_info = new ilive_feeds_tmem$PicFeed();
            this.live_info = new ilive_feeds_tmem$LiveFeed();
            this.chang_info = new ilive_feeds_tmem$ChangFeed();
            this.jump_url = PBField.initBytes(byteStringMicro);
            this.publish_info = new MessageMicro<ilive_feeds_read$FeedUserInfo>() { // from class: com.tencent.pb.now.ilive_feeds_read$FeedUserInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"uin", "nick", "url", "medal_infos", "user_gender", "age"}, new Object[]{0L, "", ByteStringMicro.EMPTY, null, 0, 0}, ilive_feeds_read$FeedUserInfo.class);
                public final PBUInt64Field uin = PBField.initUInt64(0);
                public final PBStringField nick = PBField.initString("");
                public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBRepeatMessageField<ilive_user_basic_info$MedalInfo> medal_infos = PBField.initRepeatMessage(ilive_user_basic_info$MedalInfo.class);
                public final PBUInt32Field user_gender = PBField.initUInt32(0);
                public final PBUInt32Field age = PBField.initUInt32(0);
            };
            this.lbs_info = new FeedsProtocol$LbsInfo();
            this.text_feed = new MessageMicro<ilive_feeds_tmem$TextFeed>() { // from class: com.tencent.pb.now.ilive_feeds_tmem$TextFeed
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "topic"}, new Object[]{"", ""}, ilive_feeds_tmem$TextFeed.class);
                public final PBStringField text = PBField.initString("");
                public final PBRepeatField<String> topic = PBField.initRepeat(PBStringField.__repeatHelper__);
            };
            this.like = PBField.initInt32(0);
            this.like_info = new MessageMicro<ilive_feeds_tmem$FeedsTmemLike>() { // from class: com.tencent.pb.now.ilive_feeds_tmem$FeedsTmemLike
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"like_number", "like_list"}, new Object[]{0, 0}, ilive_feeds_tmem$FeedsTmemLike.class);
                public final PBUInt32Field like_number = PBField.initUInt32(0);
                public final PBRepeatField<Integer> like_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
            };
            this.comments = PBField.initRepeatMessage(NowNearbyVideoCommentProto$Comment.class);
            this.comment_num = PBField.initInt32(0);
            this.type = PBField.initInt32(0);
            this.distance = PBField.initDouble(0.0d);
            this.topic_cfg = PBField.initRepeatMessage(ilive_feeds_read$TopicCfg.class);
        }
    };
}
