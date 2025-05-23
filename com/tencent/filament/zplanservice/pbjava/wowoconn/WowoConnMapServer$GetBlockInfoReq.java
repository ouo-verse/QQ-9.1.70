package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnMapServer$GetBlockInfoReq extends MessageMicro<WowoConnMapServer$GetBlockInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 800}, new String[]{"uin", "client_platform", "client_version", "device_level"}, new Object[]{0L, "", "", 0}, WowoConnMapServer$GetBlockInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField client_platform = PBField.initString("");
    public final PBStringField client_version = PBField.initString("");
    public final PBEnumField device_level = PBField.initEnum(0);
}
