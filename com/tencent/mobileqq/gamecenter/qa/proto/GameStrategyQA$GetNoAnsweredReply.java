package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetNoAnsweredReply extends MessageMicro<GameStrategyQA$GetNoAnsweredReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WidgetCacheConstellationData.NUM, "jump_url"}, new Object[]{0L, ""}, GameStrategyQA$GetNoAnsweredReply.class);
    public final PBInt64Field num = PBField.initInt64(0);
    public final PBStringField jump_url = PBField.initString("");
}
