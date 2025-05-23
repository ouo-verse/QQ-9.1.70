package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class richstatus_sticker$StickerInfo extends MessageMicro<richstatus_sticker$StickerInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField float_posX = PBField.initFloat(0.0f);
    public final PBFloatField float_posY = PBField.initFloat(0.0f);
    public final PBFloatField float_width = PBField.initFloat(0.0f);
    public final PBFloatField float_height = PBField.initFloat(0.0f);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29, 37, 40}, new String[]{"float_posX", "float_posY", "float_width", "float_height", "uint32_id"}, new Object[]{valueOf, valueOf, valueOf, valueOf, 0}, richstatus_sticker$StickerInfo.class);
    }
}
