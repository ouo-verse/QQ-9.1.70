package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$GradeDistributed extends MessageMicro<metadream_qgroup_datacard$GradeDistributed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"name", "icon", "count", "color"}, new Object[]{"", "", 0, ""}, metadream_qgroup_datacard$GradeDistributed.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField color = PBField.initString("");
}
