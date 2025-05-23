package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$GetGameDetailAndSkinWallRsp extends MessageMicro<sgame_skin_wall$GetGameDetailAndSkinWallRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"game_detail", "skin_wall", "md_user_profile"}, new Object[]{null, null, null}, sgame_skin_wall$GetGameDetailAndSkinWallRsp.class);
    public sgame_skin_wall$GameDetail game_detail = new sgame_skin_wall$GameDetail();
    public sgame_skin_wall$GetSkinsRspPBV2 skin_wall = new sgame_skin_wall$GetSkinsRspPBV2();
    public sgame_skin_wall$MDUserProfile md_user_profile = new sgame_skin_wall$MDUserProfile();
}
