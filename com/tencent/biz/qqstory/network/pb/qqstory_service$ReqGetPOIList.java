package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_service$ReqGetPOIList extends MessageMicro<qqstory_service$ReqGetPOIList> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field coordinate;
    public final PBUInt32Field count;
    public qqstory_struct$GpsMsg gps;
    public final PBBytesField keyword;
    public final PBBytesField start_cookie;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"keyword", "start_cookie", "count", "coordinate", "gps"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, null}, qqstory_service$ReqGetPOIList.class);
    }

    public qqstory_service$ReqGetPOIList() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.keyword = PBField.initBytes(byteStringMicro);
        this.start_cookie = PBField.initBytes(byteStringMicro);
        this.count = PBField.initUInt32(0);
        this.coordinate = PBField.initUInt32(0);
        this.gps = new qqstory_struct$GpsMsg();
    }
}
