package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$ui extends MessageMicro<SummaryCardBusiEntry$ui> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"url", "title", "content", "jump_url"}, new Object[]{"", "", "", ""}, SummaryCardBusiEntry$ui.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
