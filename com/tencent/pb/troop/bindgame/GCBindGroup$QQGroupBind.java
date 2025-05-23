package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GCBindGroup$QQGroupBind extends MessageMicro<GCBindGroup$QQGroupBind> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"group_code", "appid", "group_name", "group_pic"}, new Object[]{0L, 0, "", ""}, GCBindGroup$QQGroupBind.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField group_pic = PBField.initString("");
}
