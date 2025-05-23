package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$HeartbeatReportRsp extends MessageMicro<GameStrategyQA$HeartbeatReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"interval_seconds"}, new Object[]{0}, GameStrategyQA$HeartbeatReportRsp.class);
    public final PBInt32Field interval_seconds = PBField.initInt32(0);
}
