package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$rich_ui extends MessageMicro<SummaryCardBusiEntry$rich_ui> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"strName", "strServiceUrl", "rptUiList"}, new Object[]{"", "", null}, SummaryCardBusiEntry$rich_ui.class);
    public final PBStringField strName = PBField.initString("");
    public final PBStringField strServiceUrl = PBField.initString("");
    public final PBRepeatMessageField<SummaryCardBusiEntry$ui_info> rptUiList = PBField.initRepeatMessage(SummaryCardBusiEntry$ui_info.class);
}
