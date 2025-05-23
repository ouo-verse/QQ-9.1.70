package com.tencent.mobileqq.ilive.pb;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LiveRoomList {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetFeedsListReq extends MessageMicro<GetFeedsListReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"page_size", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, QAdRewardDefine$SecurityData.PENETRATE_INFO, "recom_info", "index", AudienceReportConst.ROOM_ID}, new Object[]{0, 0, null, "", 0, 0L}, GetFeedsListReq.class);
        public final PBUInt32Field page_size = PBField.initUInt32(0);
        public final PBInt32Field source_type = PBField.initInt32(0);
        public final PBRepeatMessageField<KV> penetrate_info = PBField.initRepeatMessage(KV.class);
        public final PBStringField recom_info = PBField.initString("");
        public final PBUInt32Field index = PBField.initUInt32(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField aid = PBField.initString("");
        public final PBStringField item_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetFeedsListRsp extends MessageMicro<GetFeedsListRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feeds", "is_finished", QAdRewardDefine$SecurityData.PENETRATE_INFO, "circle_flag"}, new Object[]{null, 0, null, 0}, GetFeedsListRsp.class);
        public final PBRepeatMessageField<Feeds> feeds = PBField.initRepeatMessage(Feeds.class);
        public final PBInt32Field is_finished = PBField.initInt32(0);
        public final PBRepeatMessageField<KV> penetrate_info = PBField.initRepeatMessage(KV.class);
        public final PBInt32Field circle_flag = PBField.initInt32(0);

        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class Feeds extends MessageMicro<Feeds> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"room", "stream"}, new Object[]{null, null}, Feeds.class);
            public Room room = new Room();
            public Stream stream = new Stream();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetLivingAnchorInfoReq extends MessageMicro<GetLivingAnchorInfoReq> {
        public static final int ROOM_ID_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{0L}, GetLivingAnchorInfoReq.class);
        public final PBRepeatField<Long> room_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetLivingAnchorInfoRsp extends MessageMicro<GetLivingAnchorInfoRsp> {
        public static final int FEEDS_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{null}, GetLivingAnchorInfoRsp.class);
        public final PBRepeatMessageField<GetFeedsListRsp.Feeds> feeds = PBField.initRepeatMessage(GetFeedsListRsp.Feeds.class);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetQLiveInfoReq extends MessageMicro<GetQLiveInfoReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{0L}, GetQLiveInfoReq.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class GetQLiveInfoRsp extends MessageMicro<GetQLiveInfoRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{ByteStringMicro.EMPTY}, GetQLiveInfoRsp.class);
        public final PBBytesField feeds = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class KV extends MessageMicro<KV> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, KV.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class Room extends MessageMicro<Room> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 64, 72, 82, 90, 96, 104}, new String[]{AudienceReportConst.ROOM_ID, "cover_url", "title", "popularity", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "room_type", "video_source", "game_id", "game_tag_id", AudienceReportConst.ANCHOR_NAME, "anchor_icon", "anchor_uid", "equip_status"}, new Object[]{0L, "", "", 0L, null, 0, 0L, 0, 0, "", "", 0L, 0L}, Room.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField cover_url = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBUInt64Field popularity = PBField.initUInt64(0);
        public final PBRepeatMessageField<KV> report_info = PBField.initRepeatMessage(KV.class);
        public final PBUInt32Field room_type = PBField.initUInt32(0);
        public final PBUInt64Field video_source = PBField.initUInt64(0);
        public final PBUInt32Field game_id = PBField.initUInt32(0);
        public final PBUInt32Field game_tag_id = PBField.initUInt32(0);
        public final PBStringField anchor_name = PBField.initString("");
        public final PBStringField anchor_icon = PBField.initString("");
        public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
        public final PBUInt64Field equip_status = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class Stream extends MessageMicro<Stream> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"rtmp", "flv_url", "is_use_flv", "rtmp_360", "rtmp_540", "rtmp_720", "rtmp_1080", "flv_360", "flv_540", "flv_720", "flv_1080"}, new Object[]{"", "", Boolean.FALSE, "", "", "", "", "", "", "", ""}, Stream.class);
        public final PBStringField rtmp = PBField.initString("");
        public final PBStringField flv_url = PBField.initString("");
        public final PBBoolField is_use_flv = PBField.initBool(false);
        public final PBStringField rtmp_360 = PBField.initString("");
        public final PBStringField rtmp_540 = PBField.initString("");
        public final PBStringField rtmp_720 = PBField.initString("");
        public final PBStringField rtmp_1080 = PBField.initString("");
        public final PBStringField flv_360 = PBField.initString("");
        public final PBStringField flv_540 = PBField.initString("");
        public final PBStringField flv_720 = PBField.initString("");
        public final PBStringField flv_1080 = PBField.initString("");
    }

    LiveRoomList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
