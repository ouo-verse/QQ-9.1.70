package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$CheckMentionRsp extends MessageMicro<GameStrategyQA$CheckMentionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"can_mention"}, new Object[]{Boolean.FALSE}, GameStrategyQA$CheckMentionRsp.class);
    public final PBBoolField can_mention = PBField.initBool(false);
}
