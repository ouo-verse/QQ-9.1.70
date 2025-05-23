package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_service$RspGetLocation extends MessageMicro<qqstory_service$RspGetLocation> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBBytesField country;
    public final PBBytesField district;
    public final PBBytesField province;
    public qqstory_struct$ErrorInfo result = new qqstory_struct$ErrorInfo();
    public final PBBytesField street;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"result", "country", "province", "city", "district", "street"}, new Object[]{null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, qqstory_service$RspGetLocation.class);
    }

    public qqstory_service$RspGetLocation() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.country = PBField.initBytes(byteStringMicro);
        this.province = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
        this.district = PBField.initBytes(byteStringMicro);
        this.street = PBField.initBytes(byteStringMicro);
    }
}
