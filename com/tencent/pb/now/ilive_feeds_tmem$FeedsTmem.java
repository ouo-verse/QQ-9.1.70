package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$FeedsTmem extends MessageMicro<ilive_feeds_tmem$FeedsTmem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90, 98, 104, 112, 122, 128}, new String[]{"publish_uin", AlbumCacheData.CREATE_TIME, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feed_status", "feeds_id", "feed_info", "view_times", "up_status", QCircleLpReportDc05507.KEY_PIC_INFO, "live_info", "chang_info", "nowid", LayoutAttrDefine.BG_Color, "lbs_info", "local_video_flag"}, new Object[]{0L, 0, 1, 0, 0, ByteStringMicro.EMPTY, null, 0, 1, null, null, null, 0L, 0, null, 0}, ilive_feeds_tmem$FeedsTmem.class);
    public final PBUInt64Field publish_uin = PBField.initUInt64(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBEnumField feed_status = PBField.initEnum(0);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public ilive_feeds_tmem$VideoFeed feed_info = new ilive_feeds_tmem$VideoFeed();
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    public final PBEnumField up_status = PBField.initEnum(1);
    public ilive_feeds_tmem$PicFeed pic_info = new ilive_feeds_tmem$PicFeed();
    public ilive_feeds_tmem$LiveFeed live_info = new ilive_feeds_tmem$LiveFeed();
    public ilive_feeds_tmem$ChangFeed chang_info = new ilive_feeds_tmem$ChangFeed();
    public final PBUInt64Field nowid = PBField.initUInt64(0);
    public final PBUInt32Field bg_color = PBField.initUInt32(0);
    public ilive_feeds_tmem$LbsInfoOld lbs_info = new MessageMicro<ilive_feeds_tmem$LbsInfoOld>() { // from class: com.tencent.pb.now.ilive_feeds_tmem$LbsInfoOld
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField lat;
        public final PBBytesField lng;
        public final PBBytesField location;

        static {
            String[] strArr = {"lng", QCircleSchemeAttr.Polymerize.LAT, "location"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, ilive_feeds_tmem$LbsInfoOld.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.lng = PBField.initBytes(byteStringMicro);
            this.lat = PBField.initBytes(byteStringMicro);
            this.location = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
}
