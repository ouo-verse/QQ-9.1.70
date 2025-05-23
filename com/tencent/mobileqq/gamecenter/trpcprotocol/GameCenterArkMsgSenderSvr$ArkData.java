package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterArkMsgSenderSvr$ArkData extends MessageMicro<GameCenterArkMsgSenderSvr$ArkData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "data"}, new Object[]{0, ""}, GameCenterArkMsgSenderSvr$ArkData.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField data = PBField.initString("");
}
