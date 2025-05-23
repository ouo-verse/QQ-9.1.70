package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoRsp extends MessageMicro<LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"info", "nick_list", "uin_list"}, new Object[]{null, "", ""}, LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoRsp.class);
    public LiveActivityServerOuterClass$TaskInfo info = new LiveActivityServerOuterClass$TaskInfo();
    public final PBRepeatField<String> nick_list;
    public final PBRepeatField<String> uin_list;

    public LiveActivityServerOuterClass$GetCurrentLotteryBulletScreenTaskInfoRsp() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.nick_list = PBField.initRepeat(pBStringField);
        this.uin_list = PBField.initRepeat(pBStringField);
    }
}
