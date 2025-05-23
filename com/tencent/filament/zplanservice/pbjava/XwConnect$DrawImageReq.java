package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class XwConnect$DrawImageReq extends MessageMicro<XwConnect$DrawImageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"scene_address", "url", "level_count"}, new Object[]{0L, "", 0}, XwConnect$DrawImageReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field level_count = PBField.initUInt32(0);
}
