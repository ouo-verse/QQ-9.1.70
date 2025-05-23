package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetConfReq extends MessageMicro<GameDataAuthorizeSvr$GetConfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"act_id"}, new Object[]{""}, GameDataAuthorizeSvr$GetConfReq.class);
    public final PBStringField act_id = PBField.initString("");
}
