package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class XwConnect$ImageRsp extends MessageMicro<XwConnect$ImageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"scene_address", "mipmap_data"}, new Object[]{0L, null}, XwConnect$ImageRsp.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBRepeatMessageField<XwConnect$ImagePixel> mipmap_data = PBField.initRepeatMessage(XwConnect$ImagePixel.class);
}
