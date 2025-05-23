package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$SingleColor extends MessageMicro<AvatarDressInfo$SingleColor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"color_config_id", "custom_color"}, new Object[]{0, 0}, AvatarDressInfo$SingleColor.class);
    public final PBUInt32Field color_config_id = PBField.initUInt32(0);
    public final PBInt32Field custom_color = PBField.initInt32(0);
}
