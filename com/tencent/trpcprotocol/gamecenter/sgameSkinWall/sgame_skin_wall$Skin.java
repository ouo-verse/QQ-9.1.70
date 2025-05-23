package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$Skin extends MessageMicro<sgame_skin_wall$Skin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"icon", "hero_name", "name", "goods_id", "qualities", "price", "badge"}, new Object[]{"", "", "", "", 0, 0, ""}, sgame_skin_wall$Skin.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField hero_name = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField goods_id = PBField.initString("");
    public final PBRepeatField<Integer> qualities = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field price = PBField.initInt32(0);
    public final PBStringField badge = PBField.initString("");
}
