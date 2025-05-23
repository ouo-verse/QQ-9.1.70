package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$QualifyingDegreeInfo extends MessageMicro<metadream_qgroup_datacard$QualifyingDegreeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 82}, new String[]{"qualifying", "degree", "star", "integral", "qualifying_degree", "icon_url"}, new Object[]{"", 0, 0, 0, 0, ""}, metadream_qgroup_datacard$QualifyingDegreeInfo.class);
    public final PBStringField qualifying = PBField.initString("");
    public final PBInt32Field degree = PBField.initInt32(0);
    public final PBInt32Field star = PBField.initInt32(0);
    public final PBInt32Field integral = PBField.initInt32(0);
    public final PBInt32Field qualifying_degree = PBField.initInt32(0);
    public final PBStringField icon_url = PBField.initString("");
}
