package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$TicketInfo extends MessageMicro<ECOrderCommon$TicketInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"name", "available_time", "service_hotline", "announcement", "precondition", "ticket_sequences"}, new Object[]{"", "", "", "", "", ""}, ECOrderCommon$TicketInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField available_time = PBField.initString("");
    public final PBStringField service_hotline = PBField.initString("");
    public final PBStringField announcement = PBField.initString("");
    public final PBStringField precondition = PBField.initString("");
    public final PBRepeatField<String> ticket_sequences = PBField.initRepeat(PBStringField.__repeatHelper__);
}
