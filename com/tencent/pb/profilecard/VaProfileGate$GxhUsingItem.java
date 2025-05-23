package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$GxhUsingItem extends MessageMicro<VaProfileGate$GxhUsingItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"url", "app_name", "report_appid", "item_bg_color"}, new Object[]{"", "", 0, ""}, VaProfileGate$GxhUsingItem.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field report_appid = PBField.initUInt32(0);
    public final PBStringField item_bg_color = PBField.initString("");
}
