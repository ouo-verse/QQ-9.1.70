package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$UserDefaultRole extends MessageMicro<GameDataServerOuterClass$UserDefaultRole> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"uid", "openid", GameHallAuthServerlet.AUTH_STATUS, "role_info", "game_role_info", "user_id"}, new Object[]{0L, "", 0, null, null, null}, GameDataServerOuterClass$UserDefaultRole.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBInt32Field auth_status = PBField.initInt32(0);
    public GameRoleOuterClass$SmobaGameRoleInfo role_info = new GameRoleOuterClass$SmobaGameRoleInfo();
    public YesGameInfoOuterClass$YesGameRoleInfo game_role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
