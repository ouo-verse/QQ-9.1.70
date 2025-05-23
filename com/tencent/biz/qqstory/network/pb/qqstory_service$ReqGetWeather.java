package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_service$ReqGetWeather extends MessageMicro<qqstory_service$ReqGetWeather> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"longitude", "latitude", "coordinate"}, new Object[]{0, 0, 0}, qqstory_service$ReqGetWeather.class);
    public final PBInt32Field longitude = PBField.initInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
}
