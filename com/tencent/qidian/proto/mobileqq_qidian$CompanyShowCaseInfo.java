package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$CompanyShowCaseInfo extends MessageMicro<mobileqq_qidian$CompanyShowCaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"string_show_case_title", "string_show_case_link", "string_show_case_image"}, new Object[]{"", "", ""}, mobileqq_qidian$CompanyShowCaseInfo.class);
    public final PBStringField string_show_case_title = PBField.initString("");
    public final PBStringField string_show_case_link = PBField.initString("");
    public final PBStringField string_show_case_image = PBField.initString("");
}
