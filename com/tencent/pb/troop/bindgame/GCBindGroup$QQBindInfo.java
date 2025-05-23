package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GCBindGroup$QQBindInfo extends MessageMicro<GCBindGroup$QQBindInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"appid", "group_code", "app_name"}, new Object[]{0, 0L, ""}, GCBindGroup$QQBindInfo.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBStringField app_name = PBField.initString("");
}
