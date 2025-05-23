package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$HeroSkilledInfo extends MessageMicro<sgame_skin_wall$HeroSkilledInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hero", "skill"}, new Object[]{"", null}, sgame_skin_wall$HeroSkilledInfo.class);
    public final PBStringField hero = PBField.initString("");
    public sgame_skin_wall$SkilledInfo skill = new MessageMicro<sgame_skin_wall$SkilledInfo>() { // from class: com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$SkilledInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"skilled_title", "skilled"}, new Object[]{"", 0}, sgame_skin_wall$SkilledInfo.class);
        public final PBStringField skilled_title = PBField.initString("");
        public final PBInt32Field skilled = PBField.initInt32(0);
    };
}
