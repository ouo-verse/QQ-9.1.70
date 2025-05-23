package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$GameAreaRole extends MessageMicro<sgame_skin_wall$GameAreaRole> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "plat_id", "partition", "role_id", "role_name", "openid", "partition_name", "uin", "appid"}, new Object[]{0, 0, 0, "", "", "", "", 0L, ""}, sgame_skin_wall$GameAreaRole.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field plat_id = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBStringField role_id = PBField.initString("");
    public final PBStringField role_name = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField partition_name = PBField.initString("");
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBStringField appid = PBField.initString("");
}
