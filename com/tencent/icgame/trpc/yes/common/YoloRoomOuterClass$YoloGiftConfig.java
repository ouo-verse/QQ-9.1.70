package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloGiftConfig extends MessageMicro<YoloRoomOuterClass$YoloGiftConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"gift_id", "gift_num", "gift_name", "gift_material_id", "gift_price"}, new Object[]{0, 0, "", 0, 0}, YoloRoomOuterClass$YoloGiftConfig.class);
    public final PBInt32Field gift_id = PBField.initInt32(0);
    public final PBInt32Field gift_num = PBField.initInt32(0);
    public final PBStringField gift_name = PBField.initString("");
    public final PBInt32Field gift_material_id = PBField.initInt32(0);
    public final PBInt32Field gift_price = PBField.initInt32(0);
}
