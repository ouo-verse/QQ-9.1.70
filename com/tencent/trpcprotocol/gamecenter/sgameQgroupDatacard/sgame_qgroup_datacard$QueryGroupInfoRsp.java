package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$QueryGroupInfoRsp extends MessageMicro<sgame_qgroup_datacard$QueryGroupInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 32, 41, 48, 56}, new String[]{"gradeDistributedList", "fightScore", "fightScoreRank", "weekPlayGameCount", "weekPlayUserCount"}, new Object[]{null, 0L, Double.valueOf(0.0d), 0L, 0L}, sgame_qgroup_datacard$QueryGroupInfoRsp.class);
    public final PBRepeatMessageField<sgame_qgroup_datacard$GradeDistributed> gradeDistributedList = PBField.initRepeatMessage(sgame_qgroup_datacard$GradeDistributed.class);
    public final PBInt64Field fightScore = PBField.initInt64(0);
    public final PBDoubleField fightScoreRank = PBField.initDouble(0.0d);
    public final PBInt64Field weekPlayGameCount = PBField.initInt64(0);
    public final PBInt64Field weekPlayUserCount = PBField.initInt64(0);
}
