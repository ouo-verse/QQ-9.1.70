package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleAbnormalQuitEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleAbnormalQuitEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"partition_id", "game_openid", "game_roleid", "battle_id"}, new Object[]{0, "", "", ""}, YoloBattleSmobaOuterClass$YoloSmobaBattleAbnormalQuitEvent.class);
    public final PBInt32Field partition_id = PBField.initInt32(0);
    public final PBStringField game_openid = PBField.initString("");
    public final PBStringField game_roleid = PBField.initString("");
    public final PBStringField battle_id = PBField.initString("");
}
