package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ExpeDataAcc$ExpeEventReportReq extends MessageMicro<ExpeDataAcc$ExpeEventReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"actionInfos", "noNeedRsp"}, new Object[]{null, 0}, ExpeDataAcc$ExpeEventReportReq.class);
    public final PBRepeatMessageField<ExpeDataAcc$UserActionInfo> actionInfos = PBField.initRepeatMessage(ExpeDataAcc$UserActionInfo.class);
    public final PBInt32Field noNeedRsp = PBField.initInt32(0);
}
