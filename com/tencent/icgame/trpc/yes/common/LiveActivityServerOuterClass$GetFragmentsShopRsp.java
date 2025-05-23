package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetFragmentsShopRsp extends MessageMicro<LiveActivityServerOuterClass$GetFragmentsShopRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"remaining_times", "list"}, new Object[]{0, null}, LiveActivityServerOuterClass$GetFragmentsShopRsp.class);
    public final PBInt32Field remaining_times = PBField.initInt32(0);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$GameCommodityInfo> list = PBField.initRepeatMessage(LiveActivityServerOuterClass$GameCommodityInfo.class);
}
