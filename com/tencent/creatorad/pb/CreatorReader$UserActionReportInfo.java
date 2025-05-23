package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$UserActionReportInfo extends MessageMicro<CreatorReader$UserActionReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"adv_id", "trace_id", "exposure_url", "click_url"}, new Object[]{"", "", "", ""}, CreatorReader$UserActionReportInfo.class);
    public final PBStringField adv_id = PBField.initString("");
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField exposure_url = PBField.initString("");
    public final PBStringField click_url = PBField.initString("");
}
