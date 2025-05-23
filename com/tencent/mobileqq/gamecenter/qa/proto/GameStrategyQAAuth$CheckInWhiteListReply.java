package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAAuth$CheckInWhiteListReply extends MessageMicro<GameStrategyQAAuth$CheckInWhiteListReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_in_whitelist"}, new Object[]{Boolean.FALSE}, GameStrategyQAAuth$CheckInWhiteListReply.class);
    public final PBBoolField is_in_whitelist = PBField.initBool(false);
}
