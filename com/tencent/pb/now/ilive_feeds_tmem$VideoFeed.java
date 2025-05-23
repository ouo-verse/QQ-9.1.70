package com.tencent.pb.now;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$VideoFeed extends MessageMicro<ilive_feeds_tmem$VideoFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field anchor_uin;
    public final PBBytesField city;
    public final PBBytesField desc;
    public final PBBytesField doodle_pic_url;
    public final PBUInt32Field end_time;
    public final PBBytesField feed_id;
    public final PBBytesField file_id;
    public final PBUInt32Field has_face;
    public final PBBytesField lat;
    public final PBBytesField lng;
    public final PBBytesField pic_url;
    public final PBUInt32Field start_time;
    public final PBRepeatField<ByteStringMicro> topic;
    public final PBBytesField vid;
    public final PBUInt32Field video_hight;
    public final PBBytesField video_md5;
    public final PBUInt32Field video_time;
    public final PBBytesField video_url;
    public final PBUInt32Field video_width;

    static {
        String[] strArr = {"pic_url", "video_url", "anchor_uin", "topic", "desc", "file_id", "video_width", "video_hight", "video_time", "video_md5", "vid", "start_time", "end_time", "doodle_pic_url", "lng", QCircleSchemeAttr.Polymerize.LAT, "city", "feed_id", "has_face"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 96, 104, 114, 122, 130, 138, 146, 152}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, ilive_feeds_tmem$VideoFeed.class);
    }

    public ilive_feeds_tmem$VideoFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.video_url = PBField.initBytes(byteStringMicro);
        this.anchor_uin = PBField.initUInt64(0L);
        this.topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.desc = PBField.initBytes(byteStringMicro);
        this.file_id = PBField.initBytes(byteStringMicro);
        this.video_width = PBField.initUInt32(0);
        this.video_hight = PBField.initUInt32(0);
        this.video_time = PBField.initUInt32(0);
        this.video_md5 = PBField.initBytes(byteStringMicro);
        this.vid = PBField.initBytes(byteStringMicro);
        this.start_time = PBField.initUInt32(0);
        this.end_time = PBField.initUInt32(0);
        this.doodle_pic_url = PBField.initBytes(byteStringMicro);
        this.lng = PBField.initBytes(byteStringMicro);
        this.lat = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.has_face = PBField.initUInt32(0);
    }
}
