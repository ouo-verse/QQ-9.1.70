package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamBattleInfo extends MessageMicro<SmobaDataOuterClass$YoloTeamBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"mapacntnum", "maptype", "mapid", "pkai", "iswarmbattle"}, new Object[]{0, 0, 0, 0, 0}, SmobaDataOuterClass$YoloTeamBattleInfo.class);
    public final PBUInt32Field mapacntnum = PBField.initUInt32(0);
    public final PBUInt32Field maptype = PBField.initUInt32(0);
    public final PBUInt32Field mapid = PBField.initUInt32(0);
    public final PBUInt32Field pkai = PBField.initUInt32(0);
    public final PBUInt32Field iswarmbattle = PBField.initUInt32(0);
}
