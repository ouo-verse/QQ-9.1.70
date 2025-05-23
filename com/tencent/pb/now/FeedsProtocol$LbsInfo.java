package com.tencent.pb.now;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$LbsInfo extends MessageMicro<FeedsProtocol$LbsInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBBytesField lat;
    public final PBBytesField lng;
    public final PBBytesField name;

    static {
        String[] strArr = {"lng", QCircleSchemeAttr.Polymerize.LAT, "city", "name"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, FeedsProtocol$LbsInfo.class);
    }

    public FeedsProtocol$LbsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.lng = PBField.initBytes(byteStringMicro);
        this.lat = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
    }
}
