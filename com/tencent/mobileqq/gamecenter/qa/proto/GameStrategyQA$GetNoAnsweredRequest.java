package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetNoAnsweredRequest extends MessageMicro<GameStrategyQA$GetNoAnsweredRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"appid"}, new Object[]{0}, GameStrategyQA$GetNoAnsweredRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
