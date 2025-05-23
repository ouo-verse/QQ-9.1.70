package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$AcctivityPage extends MessageMicro<LiveActivityServerOuterClass$AcctivityPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"index", "task_list", "lottery_info", "name"}, new Object[]{0, null, null, ""}, LiveActivityServerOuterClass$AcctivityPage.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$TaskInfo> task_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$TaskInfo.class);
    public LiveActivityServerOuterClass$KplLotteryInfo lottery_info = new LiveActivityServerOuterClass$KplLotteryInfo();
    public final PBStringField name = PBField.initString("");
}
