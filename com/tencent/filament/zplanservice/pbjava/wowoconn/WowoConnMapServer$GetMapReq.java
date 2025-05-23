package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnMapServer$GetMapReq extends MessageMicro<WowoConnMapServer$GetMapReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 800}, new String[]{"page_size", "page_num", "client_platform", "client_version", "friend_uin", "device_level"}, new Object[]{0L, 0L, "", "", 0L, 0}, WowoConnMapServer$GetMapReq.class);
    public final PBUInt64Field page_size = PBField.initUInt64(0);
    public final PBUInt64Field page_num = PBField.initUInt64(0);
    public final PBStringField client_platform = PBField.initString("");
    public final PBStringField client_version = PBField.initString("");
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBEnumField device_level = PBField.initEnum(0);
}
