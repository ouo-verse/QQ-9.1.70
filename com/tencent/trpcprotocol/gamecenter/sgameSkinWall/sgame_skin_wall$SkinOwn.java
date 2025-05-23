package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$SkinOwn extends MessageMicro<sgame_skin_wall$SkinOwn> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"skin_id", "owned"}, new Object[]{"", Boolean.FALSE}, sgame_skin_wall$SkinOwn.class);
    public final PBStringField skin_id = PBField.initString("");
    public final PBBoolField owned = PBField.initBool(false);
}
