package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$VirtualAccount extends MessageMicro<ECOrderCommon$VirtualAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"virtual_account_type", "account", "account_name"}, new Object[]{0, "", ""}, ECOrderCommon$VirtualAccount.class);
    public final PBUInt32Field virtual_account_type = PBField.initUInt32(0);
    public final PBStringField account = PBField.initString("");
    public final PBStringField account_name = PBField.initString("");
}
