package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_service$ReqGetLocation extends MessageMicro<qqstory_service$ReqGetLocation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"coordinate", "gps"}, new Object[]{0, null}, qqstory_service$ReqGetLocation.class);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct$GpsMsg gps = new qqstory_struct$GpsMsg();
}
