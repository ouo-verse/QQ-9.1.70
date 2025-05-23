package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetPublicAccountAuthInfoReq extends MessageMicro<GameDataAuthorizeSvr$GetPublicAccountAuthInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, GameDataAuthorizeSvr$GetPublicAccountAuthInfoReq.class);
    public final PBStringField appid = PBField.initString("");
}
