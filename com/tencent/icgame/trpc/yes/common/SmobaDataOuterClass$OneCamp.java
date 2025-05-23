package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$OneCamp extends MessageMicro<SmobaDataOuterClass$OneCamp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"npc_camp", "camp_players"}, new Object[]{0, null}, SmobaDataOuterClass$OneCamp.class);
    public final PBInt32Field npc_camp = PBField.initInt32(0);
    public final PBRepeatMessageField<SmobaDataOuterClass$CampPlayerInfo> camp_players = PBField.initRepeatMessage(SmobaDataOuterClass$CampPlayerInfo.class);
}
