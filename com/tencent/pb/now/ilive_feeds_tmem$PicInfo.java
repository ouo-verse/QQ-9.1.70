package com.tencent.pb.now;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$PicInfo extends MessageMicro<ilive_feeds_tmem$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBBytesField file_id;
    public final PBUInt32Field hight;
    public final PBBytesField lat;
    public final PBBytesField lng;
    public final PBBytesField pic_md5;
    public final PBBytesField url;
    public final PBUInt32Field width;

    static {
        String[] strArr = {"url", "hight", "width", "file_id", "pic_md5", "lng", QCircleSchemeAttr.Polymerize.LAT, "city"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66}, strArr, new Object[]{byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ilive_feeds_tmem$PicInfo.class);
    }

    public ilive_feeds_tmem$PicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.hight = PBField.initUInt32(0);
        this.width = PBField.initUInt32(0);
        this.file_id = PBField.initBytes(byteStringMicro);
        this.pic_md5 = PBField.initBytes(byteStringMicro);
        this.lng = PBField.initBytes(byteStringMicro);
        this.lat = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
    }
}
