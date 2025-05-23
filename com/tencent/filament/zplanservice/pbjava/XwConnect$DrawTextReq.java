package com.tencent.filament.zplanservice.pbjava;

import com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$TextDesc;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class XwConnect$DrawTextReq extends MessageMicro<XwConnect$DrawTextReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"scene_address", "text_desc", "level_count"}, new Object[]{0L, null, 0}, XwConnect$DrawTextReq.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public WowoConnEmtity$TextDesc text_desc = new WowoConnEmtity$TextDesc();
    public final PBUInt32Field level_count = PBField.initUInt32(0);
}
