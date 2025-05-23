package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnEmtity$ImageSize extends MessageMicro<WowoConnEmtity$ImageSize> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"type", "width", "height"}, new Object[]{0, 0, 0}, WowoConnEmtity$ImageSize.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
