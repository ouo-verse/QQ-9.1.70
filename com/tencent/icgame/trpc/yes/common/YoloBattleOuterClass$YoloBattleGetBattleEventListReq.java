package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattleGetBattleEventListReq extends MessageMicro<YoloBattleOuterClass$YoloBattleGetBattleEventListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"start_event_id"}, new Object[]{0}, YoloBattleOuterClass$YoloBattleGetBattleEventListReq.class);
    public final PBInt32Field start_event_id = PBField.initInt32(0);
}
