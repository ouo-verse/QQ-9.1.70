package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$GetOAIDRsp extends MessageMicro<GameCenterYunGameAuth$GetOAIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oaid"}, new Object[]{""}, GameCenterYunGameAuth$GetOAIDRsp.class);
    public final PBStringField oaid = PBField.initString("");
}
