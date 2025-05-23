package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$SpecItem extends MessageMicro<ECQshopCustomerReaderSvr$SpecItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "value"}, new Object[]{"", "", ""}, ECQshopCustomerReaderSvr$SpecItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105247id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
