package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$GPS extends MessageMicro<ExtendFriendSquareInfo$GPS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "int32_type"}, new Object[]{900000000, 900000000, -10000000, 0}, ExtendFriendSquareInfo$GPS.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
}
