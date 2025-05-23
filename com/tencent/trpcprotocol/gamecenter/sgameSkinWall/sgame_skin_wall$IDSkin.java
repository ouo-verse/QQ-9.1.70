package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$IDSkin extends MessageMicro<sgame_skin_wall$IDSkin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", SkinResFactory.SKIN_THEME_APK_SAVE_DIR}, new Object[]{"", null}, sgame_skin_wall$IDSkin.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381301id = PBField.initString("");
    public sgame_skin_wall$Skin skin = new sgame_skin_wall$Skin();
}
