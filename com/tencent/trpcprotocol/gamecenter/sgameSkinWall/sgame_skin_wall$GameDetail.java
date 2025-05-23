package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$GameDetail extends MessageMicro<sgame_skin_wall$GameDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 24, 32, 40, 58, 66, 74, 82, 90}, new String[]{"grade", "season_win_rate", "games_total", "mvp_total", "best_occupation", "best_hero_list", "encrpt_open_id", "partition", "platid", GdtGetUserInfoHandler.KEY_AREA}, new Object[]{0, Double.valueOf(0.0d), 0L, 0L, 0, null, "", "", "", ""}, sgame_skin_wall$GameDetail.class);
    public final PBEnumField grade = PBField.initEnum(0);
    public final PBDoubleField season_win_rate = PBField.initDouble(0.0d);
    public final PBInt64Field games_total = PBField.initInt64(0);
    public final PBInt64Field mvp_total = PBField.initInt64(0);
    public final PBEnumField best_occupation = PBField.initEnum(0);
    public final PBRepeatMessageField<sgame_skin_wall$UserHeroInfo> best_hero_list = PBField.initRepeatMessage(sgame_skin_wall$UserHeroInfo.class);
    public final PBStringField encrpt_open_id = PBField.initString("");
    public final PBStringField partition = PBField.initString("");
    public final PBStringField platid = PBField.initString("");
    public final PBStringField area = PBField.initString("");
}
