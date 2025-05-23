package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$Wifi extends MessageMicro<ExtendFriendSquareInfo$Wifi> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_mac", "int32_rssi"}, new Object[]{0L, 0}, ExtendFriendSquareInfo$Wifi.class);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
