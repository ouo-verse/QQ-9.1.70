package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class AlertReport$ButtonAction extends MessageMicro<AlertReport$ButtonAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_cmd", "uint32_button_id", "str_package_name", "uint32_app_id"}, new Object[]{0, 0, "", 0}, AlertReport$ButtonAction.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_button_id = PBField.initUInt32(0);
    public final PBStringField str_package_name = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
}
