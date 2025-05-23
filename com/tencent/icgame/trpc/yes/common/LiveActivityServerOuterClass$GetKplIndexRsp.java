package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetKplIndexRsp extends MessageMicro<LiveActivityServerOuterClass$GetKplIndexRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"current_watch_time", "general_list", "lottery_info"}, new Object[]{0, null, null}, LiveActivityServerOuterClass$GetKplIndexRsp.class);
    public final PBInt32Field current_watch_time = PBField.initInt32(0);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$TaskInfo> general_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$TaskInfo.class);
    public LiveActivityServerOuterClass$KplLotteryInfo lottery_info = new LiveActivityServerOuterClass$KplLotteryInfo();
}
