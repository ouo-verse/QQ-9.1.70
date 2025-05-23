package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class account_detail_dynamic_list$RetInfo extends MessageMicro<account_detail_dynamic_list$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0, ""}, account_detail_dynamic_list$RetInfo.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_info = PBField.initString("");
}
