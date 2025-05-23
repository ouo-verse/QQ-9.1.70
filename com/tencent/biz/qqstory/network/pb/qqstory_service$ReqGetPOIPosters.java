package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_service$ReqGetPOIPosters extends MessageMicro<qqstory_service$ReqGetPOIPosters> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"coordinate", "gps", "version"}, new Object[]{0, null, 0}, qqstory_service$ReqGetPOIPosters.class);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct$GpsMsg gps = new qqstory_struct$GpsMsg();
    public final PBUInt32Field version = PBField.initUInt32(0);
}
