package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$Address extends MessageMicro<qqstory_struct$Address> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField building;
    public final PBBytesField city;
    public final PBUInt32Field coordinate;
    public final PBBytesField country;
    public final PBBytesField district;
    public qqstory_struct$GpsMsg gps;
    public final PBBytesField province;
    public final PBBytesField street;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 64, 74, 82}, new String[]{"street", "province", "city", "country", "building", "coordinate", "gps", "district"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, null, byteStringMicro}, qqstory_struct$Address.class);
    }

    public qqstory_struct$Address() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.street = PBField.initBytes(byteStringMicro);
        this.province = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
        this.country = PBField.initBytes(byteStringMicro);
        this.building = PBField.initBytes(byteStringMicro);
        this.coordinate = PBField.initUInt32(0);
        this.gps = new qqstory_struct$GpsMsg();
        this.district = PBField.initBytes(byteStringMicro);
    }
}
