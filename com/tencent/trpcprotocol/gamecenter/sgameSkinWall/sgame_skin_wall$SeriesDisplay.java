package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$SeriesDisplay extends MessageMicro<sgame_skin_wall$SeriesDisplay> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56, 64, 74}, new String[]{"name", "frds_own_all", "skins", "frds_beated_percent", "id", "own_all", "owns_skin_num", "type", "first_skin"}, new Object[]{"", null, null, 0, "", Boolean.FALSE, 0, 0, null}, sgame_skin_wall$SeriesDisplay.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<sgame_skin_wall$User> frds_own_all = PBField.initRepeatMessage(sgame_skin_wall$User.class);
    public final PBRepeatMessageField<sgame_skin_wall$SkinOwn> skins = PBField.initRepeatMessage(sgame_skin_wall$SkinOwn.class);
    public final PBInt32Field frds_beated_percent = PBField.initInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381302id = PBField.initString("");
    public final PBBoolField own_all = PBField.initBool(false);
    public final PBInt32Field owns_skin_num = PBField.initInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public sgame_skin_wall$Skin first_skin = new sgame_skin_wall$Skin();
}
