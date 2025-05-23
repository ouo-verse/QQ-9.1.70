package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$SetUserGameDefaultRoleRsp extends MessageMicro<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"role_info", "openid", GameHallAuthServerlet.AUTH_STATUS}, new Object[]{null, "", 0}, YesGameInfoOuterClass$SetUserGameDefaultRoleRsp.class);
    public YesGameInfoOuterClass$YesGameRoleInfo role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
    public final PBStringField openid = PBField.initString("");
    public final PBInt32Field auth_status = PBField.initInt32(0);
}
