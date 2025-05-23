package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$User extends MessageMicro<sgame_skin_wall$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"nick", "avatar"}, new Object[]{"", ""}, sgame_skin_wall$User.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
}
