package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$SearchQuestionsRequest extends MessageMicro<GameStrategyQA$SearchQuestionsRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"keyword", "appid"}, new Object[]{"", 0}, GameStrategyQA$SearchQuestionsRequest.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
