package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class sgame_skin_wall$SummaryPBV2 extends MessageMicro<sgame_skin_wall$SummaryPBV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58}, new String[]{"owned", "total", "price", "frds_beated_percent", "stats", "honor", "honor_badge_url"}, new Object[]{0, 0, 0, 0, null, 0, ""}, sgame_skin_wall$SummaryPBV2.class);
    public final PBInt32Field owned = PBField.initInt32(0);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBInt32Field price = PBField.initInt32(0);
    public final PBInt32Field frds_beated_percent = PBField.initInt32(0);
    public final PBRepeatMessageField<sgame_skin_wall$SummaryStatsPBV2> stats = PBField.initRepeatMessage(sgame_skin_wall$SummaryStatsPBV2.class);
    public final PBEnumField honor = PBField.initEnum(0);
    public final PBStringField honor_badge_url = PBField.initString("");
}
