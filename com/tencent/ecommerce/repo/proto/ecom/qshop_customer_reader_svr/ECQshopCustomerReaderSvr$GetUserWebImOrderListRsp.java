package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$GetUserWebImOrderListRsp extends MessageMicro<ECQshopCustomerReaderSvr$GetUserWebImOrderListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"cookie", "is_end", "orders"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, ECQshopCustomerReaderSvr$GetUserWebImOrderListRsp.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field is_end = PBField.initInt32(0);
    public final PBRepeatMessageField<ECQshopCustomerReaderSvr$OrderItem> orders = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$OrderItem.class);
}
