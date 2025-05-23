package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$GetGradeDistributeInfoRsp extends MessageMicro<metadream_qgroup_datacard$GetGradeDistributeInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"info", "recent_game_num", "recent_user_num", "rank_page_url"}, new Object[]{null, 0, 0, ""}, metadream_qgroup_datacard$GetGradeDistributeInfoRsp.class);
    public final PBRepeatMessageField<metadream_qgroup_datacard$GradeDistributed> info = PBField.initRepeatMessage(metadream_qgroup_datacard$GradeDistributed.class);
    public final PBUInt32Field recent_game_num = PBField.initUInt32(0);
    public final PBUInt32Field recent_user_num = PBField.initUInt32(0);
    public final PBStringField rank_page_url = PBField.initString("");
}
