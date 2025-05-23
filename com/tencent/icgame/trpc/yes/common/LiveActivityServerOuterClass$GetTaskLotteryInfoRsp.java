package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetTaskLotteryInfoRsp extends MessageMicro<LiveActivityServerOuterClass$GetTaskLotteryInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"nick_list"}, new Object[]{""}, LiveActivityServerOuterClass$GetTaskLotteryInfoRsp.class);
    public final PBRepeatField<String> nick_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
