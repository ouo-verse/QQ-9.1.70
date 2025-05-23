package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$GetUserKeyRsp extends MessageMicro<GameCenterYunGameAuth$GetUserKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_key"}, new Object[]{""}, GameCenterYunGameAuth$GetUserKeyRsp.class);
    public final PBStringField user_key = PBField.initString("");
}
