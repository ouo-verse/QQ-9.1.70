package com.tencent.ecommerce.repo.proto.ecom.common_customer_info;

import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCustomerInfo$Agent extends MessageMicro<ECCustomerInfo$Agent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 66}, new String[]{"id", "name", "nick", "email", NotificationActivity.PASSWORD, "role_type", "media_id"}, new Object[]{"", "", "", "", "", 0, ""}, ECCustomerInfo$Agent.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105228id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBStringField password = PBField.initString("");
    public final PBInt32Field role_type = PBField.initInt32(0);
    public final PBStringField media_id = PBField.initString("");
}
