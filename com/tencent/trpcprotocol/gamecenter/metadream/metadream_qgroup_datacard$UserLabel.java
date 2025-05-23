package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$UserLabel extends MessageMicro<metadream_qgroup_datacard$UserLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"category", "labels"}, new Object[]{"", ""}, metadream_qgroup_datacard$UserLabel.class);
    public final PBStringField category = PBField.initString("");
    public final PBRepeatField<String> labels = PBField.initRepeat(PBStringField.__repeatHelper__);
}
