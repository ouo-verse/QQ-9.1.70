package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GameInfo extends MessageMicro<GameStrategyQA$GameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"appid", "name", "icon"}, new Object[]{0, "", ""}, GameStrategyQA$GameInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
