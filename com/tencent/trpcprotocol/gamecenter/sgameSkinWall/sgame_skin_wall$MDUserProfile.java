package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class sgame_skin_wall$MDUserProfile extends MessageMicro<sgame_skin_wall$MDUserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56, 64, 72, 80, 90, 96}, new String[]{"nickname", "avatar", "gender", "user_labels", "inner_game_images", "current_qualifying", "total_battle_times", "championship_battle_times", "played_maps", "costume_count", "jump_url", "has_role"}, new Object[]{"", "", 0, null, "", null, 0, 0, 0, 0, "", Boolean.FALSE}, sgame_skin_wall$MDUserProfile.class);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBEnumField gender = PBField.initEnum(0);
    public final PBRepeatMessageField<sgame_skin_wall$UserLabel> user_labels = PBField.initRepeatMessage(sgame_skin_wall$UserLabel.class);
    public final PBRepeatField<String> inner_game_images = PBField.initRepeat(PBStringField.__repeatHelper__);
    public sgame_skin_wall$QualifyingDegreeInfo current_qualifying = new sgame_skin_wall$QualifyingDegreeInfo();
    public final PBInt32Field total_battle_times = PBField.initInt32(0);
    public final PBInt32Field championship_battle_times = PBField.initInt32(0);
    public final PBInt32Field played_maps = PBField.initInt32(0);
    public final PBInt32Field costume_count = PBField.initInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBBoolField has_role = PBField.initBool(false);
}
