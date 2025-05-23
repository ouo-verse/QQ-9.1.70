package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$GetOAIDReq extends MessageMicro<GameCenterYunGameAuth$GetOAIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ticket"}, new Object[]{""}, GameCenterYunGameAuth$GetOAIDReq.class);
    public final PBStringField ticket = PBField.initString("");
}
