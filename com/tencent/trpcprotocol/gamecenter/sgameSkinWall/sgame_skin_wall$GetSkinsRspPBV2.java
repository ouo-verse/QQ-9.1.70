package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class sgame_skin_wall$GetSkinsRspPBV2 extends MessageMicro<sgame_skin_wall$GetSkinsRspPBV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"summary", "skins", "series", "details", "role_base_info", "hero_skilled_info", "role_info"}, new Object[]{null, null, null, null, null, null, null}, sgame_skin_wall$GetSkinsRspPBV2.class);
    public sgame_skin_wall$SummaryPBV2 summary = new sgame_skin_wall$SummaryPBV2();
    public final PBRepeatMessageField<sgame_skin_wall$SkinOwn> skins = PBField.initRepeatMessage(sgame_skin_wall$SkinOwn.class);
    public final PBRepeatMessageField<sgame_skin_wall$SeriesDisplay> series = PBField.initRepeatMessage(sgame_skin_wall$SeriesDisplay.class);
    public final PBRepeatMessageField<sgame_skin_wall$IDSkin> details = PBField.initRepeatMessage(sgame_skin_wall$IDSkin.class);
    public sgame_skin_wall$RoleBaseInfo role_base_info = new MessageMicro<sgame_skin_wall$RoleBaseInfo>() { // from class: com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$RoleBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"nick", "avatar"}, new Object[]{"", ""}, sgame_skin_wall$RoleBaseInfo.class);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField avatar = PBField.initString("");
    };
    public final PBRepeatMessageField<sgame_skin_wall$HeroSkilledInfo> hero_skilled_info = PBField.initRepeatMessage(sgame_skin_wall$HeroSkilledInfo.class);
    public sgame_skin_wall$GameAreaRole role_info = new sgame_skin_wall$GameAreaRole();
}
