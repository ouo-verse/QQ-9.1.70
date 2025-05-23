package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$ReportAuthorizeInfoReq extends MessageMicro<GameDataAuthorizeSvr$ReportAuthorizeInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"appid", "status", "authoritys"}, new Object[]{"", 0, null}, GameDataAuthorizeSvr$ReportAuthorizeInfoReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBRepeatMessageField<GameDataAuthorizeSvr$Authorization> authoritys = PBField.initRepeatMessage(GameDataAuthorizeSvr$Authorization.class);
}
