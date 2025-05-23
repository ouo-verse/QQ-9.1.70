package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$RecvAnniversaryAwardRsp extends MessageMicro<LiveActivityServerOuterClass$RecvAnniversaryAwardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"award_list"}, new Object[]{null}, LiveActivityServerOuterClass$RecvAnniversaryAwardRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AwardItem> award_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$AwardItem.class);
}
