package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattleGetBattleEventListRsp extends MessageMicro<YoloBattleOuterClass$YoloBattleGetBattleEventListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"event_list"}, new Object[]{null}, YoloBattleOuterClass$YoloBattleGetBattleEventListRsp.class);
    public final PBRepeatMessageField<YoloBattleOuterClass$YoloBattleEventReq> event_list = PBField.initRepeatMessage(YoloBattleOuterClass$YoloBattleEventReq.class);
}
