package com.tencent.ecommerce.repo.proto.ecom.common_customer_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCustomerInfo$OperateFlow extends MessageMicro<ECCustomerInfo$OperateFlow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"shop_id", "oper_type", JsonRuleKey.OPERATOR, "account", "role_type", "ts"}, new Object[]{"", 0, null, null, 0, 0L}, ECCustomerInfo$OperateFlow.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBInt32Field oper_type = PBField.initInt32(0);
    public ECCustomerInfo$AccountInfo operator = new MessageMicro<ECCustomerInfo$AccountInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$AccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26}, new String[]{"media_id", "media_name"}, new Object[]{"", ""}, ECCustomerInfo$AccountInfo.class);
        public final PBStringField media_id = PBField.initString("");
        public final PBStringField media_name = PBField.initString("");
    };
    public ECCustomerInfo$AccountInfo account = new MessageMicro<ECCustomerInfo$AccountInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$AccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26}, new String[]{"media_id", "media_name"}, new Object[]{"", ""}, ECCustomerInfo$AccountInfo.class);
        public final PBStringField media_id = PBField.initString("");
        public final PBStringField media_name = PBField.initString("");
    };
    public final PBInt32Field role_type = PBField.initInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f105229ts = PBField.initInt64(0);
}
