package com.tencent.pb.now;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
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
public final class ilive_feeds_write$AddFeedReq extends MessageMicro<ilive_feeds_write$AddFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 64, 72, 82}, new String[]{QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feed_video", "feed_upload_status", QCircleLpReportDc05507.KEY_PIC_INFO, "live_info", "chang_info", "nowid", "local_video_flag", "lbs_info"}, new Object[]{1, 0, null, 1, null, null, null, 0L, 0, null}, ilive_feeds_write$AddFeedReq.class);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBEnumField feed_source = PBField.initEnum(0);
    public ilive_feeds_tmem$VideoFeed feed_video = new ilive_feeds_tmem$VideoFeed();
    public final PBEnumField feed_upload_status = PBField.initEnum(1);
    public ilive_feeds_tmem$PicFeed pic_info = new ilive_feeds_tmem$PicFeed();
    public ilive_feeds_tmem$LiveFeed live_info = new ilive_feeds_tmem$LiveFeed();
    public ilive_feeds_tmem$ChangFeed chang_info = new ilive_feeds_tmem$ChangFeed();
    public final PBUInt64Field nowid = PBField.initUInt64(0);
    public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
    public ilive_feeds_write$LbsInfo lbs_info = new MessageMicro<ilive_feeds_write$LbsInfo>() { // from class: com.tencent.pb.now.ilive_feeds_write$LbsInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField city;
        public final PBBytesField lat;
        public final PBBytesField lng;
        public final PBBytesField name;

        static {
            String[] strArr = {"lng", QCircleSchemeAttr.Polymerize.LAT, "city", "name"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ilive_feeds_write$LbsInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.lng = PBField.initBytes(byteStringMicro);
            this.lat = PBField.initBytes(byteStringMicro);
            this.city = PBField.initBytes(byteStringMicro);
            this.name = PBField.initBytes(byteStringMicro);
        }
    };
}
