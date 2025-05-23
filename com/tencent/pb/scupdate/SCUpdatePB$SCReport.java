package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCReport extends MessageMicro<SCUpdatePB$SCReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"rpver", "item_list"}, new Object[]{0L, null}, SCUpdatePB$SCReport.class);
    public final PBInt64Field rpver = PBField.initInt64(0);
    public final PBRepeatMessageField<SCUpdatePB$ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB$ItemVersion.class);
}
