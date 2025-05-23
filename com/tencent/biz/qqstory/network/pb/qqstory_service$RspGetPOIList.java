package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_service$RspGetPOIList extends MessageMicro<qqstory_service$RspGetPOIList> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBBytesField country;
    public final PBBytesField next_cookie;
    public final PBBytesField province;
    public final PBBytesField street;
    public qqstory_struct$ErrorInfo result = new qqstory_struct$ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct$Address> poi_list = PBField.initRepeatMessage(qqstory_struct$Address.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66}, new String[]{"result", "poi_list", "is_end", "next_cookie", "country", "province", "city", "street"}, new Object[]{null, null, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, qqstory_service$RspGetPOIList.class);
    }

    public qqstory_service$RspGetPOIList() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.next_cookie = PBField.initBytes(byteStringMicro);
        this.country = PBField.initBytes(byteStringMicro);
        this.province = PBField.initBytes(byteStringMicro);
        this.city = PBField.initBytes(byteStringMicro);
        this.street = PBField.initBytes(byteStringMicro);
    }
}
