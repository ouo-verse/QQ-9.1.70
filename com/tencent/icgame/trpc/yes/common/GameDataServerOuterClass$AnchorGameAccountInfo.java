package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$AnchorGameAccountInfo extends MessageMicro<GameDataServerOuterClass$AnchorGameAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"game_id", "openid", "gopenid"}, new Object[]{0, "", ""}, GameDataServerOuterClass$AnchorGameAccountInfo.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField gopenid = PBField.initString("");
}
