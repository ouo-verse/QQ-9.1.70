package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_lbs$ReqLbsReport extends MessageMicro<qqstory_lbs$ReqLbsReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list_data"}, new Object[]{null}, qqstory_lbs$ReqLbsReport.class);
    public final PBRepeatMessageField<qqstory_lbs$LbsData> list_data = PBField.initRepeatMessage(qqstory_lbs$LbsData.class);
}
