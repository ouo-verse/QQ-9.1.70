package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadNearUserFeedsReq extends MessageMicro<ilive_feeds_read$ReadNearUserFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bus_id;
    public final PBUInt32Field id_type;
    public final PBBytesField lat;
    public final PBBytesField lng;
    public final PBUInt64Field tinyid;
    public final PBStringField version;
    public final PBUInt32Field version_code;
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);

    static {
        String[] strArr = {c.G, WidgetCacheConstellationData.NUM, "lng", QCircleSchemeAttr.Polymerize.LAT, "id_type", "bus_id", "tinyid", "version", "version_code"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34, 42, 48, 56, 64, 74, 80}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, 0, 0L, 0L, "", 0}, ilive_feeds_read$ReadNearUserFeedsReq.class);
    }

    public ilive_feeds_read$ReadNearUserFeedsReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.lng = PBField.initBytes(byteStringMicro);
        this.lat = PBField.initBytes(byteStringMicro);
        this.id_type = PBField.initUInt32(0);
        this.bus_id = PBField.initUInt64(0L);
        this.tinyid = PBField.initUInt64(0L);
        this.version = PBField.initString("");
        this.version_code = PBField.initUInt32(0);
    }
}
