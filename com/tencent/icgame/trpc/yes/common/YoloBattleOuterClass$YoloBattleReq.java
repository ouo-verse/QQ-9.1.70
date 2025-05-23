package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattleReq extends MessageMicro<YoloBattleOuterClass$YoloBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"battle_cmd", "base_info"}, new Object[]{1, null}, YoloBattleOuterClass$YoloBattleReq.class);
    public final PBEnumField battle_cmd = PBField.initEnum(1);
    public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
}
