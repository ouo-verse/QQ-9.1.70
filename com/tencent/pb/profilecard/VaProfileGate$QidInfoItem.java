package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$QidInfoItem extends MessageMicro<VaProfileGate$QidInfoItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"qid", "url", "color", "logo_url"}, new Object[]{"", "", "", ""}, VaProfileGate$QidInfoItem.class);
    public final PBStringField qid = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBStringField logo_url = PBField.initString("");
}
