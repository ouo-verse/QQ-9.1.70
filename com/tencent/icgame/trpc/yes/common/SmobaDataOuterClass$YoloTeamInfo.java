package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloTeamInfo extends MessageMicro<SmobaDataOuterClass$YoloTeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 122}, new String[]{"teamid", "gvoicekey", "memberlist", "gamemode", "ailevel", "minshowgrade", "maxshowgrade", "minwangzheextragrade", "maxwangzheextragrade", "scoreperwangzhegrade", "teamfuture", "maxteammembernum", "curteammembernum", "rangerule", "battleinfo"}, new Object[]{null, "", null, 0, 0, 0, 0, 0, 0, 0, 0L, 0, 0, "", null}, SmobaDataOuterClass$YoloTeamInfo.class);
    public SmobaDataOuterClass$YoloTeamID teamid = new SmobaDataOuterClass$YoloTeamID();
    public final PBStringField gvoicekey = PBField.initString("");
    public final PBRepeatMessageField<SmobaDataOuterClass$YoloTeamMemberInfo> memberlist = PBField.initRepeatMessage(SmobaDataOuterClass$YoloTeamMemberInfo.class);
    public final PBUInt32Field gamemode = PBField.initUInt32(0);
    public final PBUInt32Field ailevel = PBField.initUInt32(0);
    public final PBUInt32Field minshowgrade = PBField.initUInt32(0);
    public final PBUInt32Field maxshowgrade = PBField.initUInt32(0);
    public final PBUInt32Field minwangzheextragrade = PBField.initUInt32(0);
    public final PBUInt32Field maxwangzheextragrade = PBField.initUInt32(0);
    public final PBUInt32Field scoreperwangzhegrade = PBField.initUInt32(0);
    public final PBUInt64Field teamfuture = PBField.initUInt64(0);
    public final PBUInt32Field maxteammembernum = PBField.initUInt32(0);
    public final PBUInt32Field curteammembernum = PBField.initUInt32(0);
    public final PBStringField rangerule = PBField.initString("");
    public SmobaDataOuterClass$YoloTeamBattleInfo battleinfo = new SmobaDataOuterClass$YoloTeamBattleInfo();
}
