package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$GetUserWebImOrderListReq extends MessageMicro<ECQshopCustomerReaderSvr$GetUserWebImOrderListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"scene", "shop_id", "cookie"}, new Object[]{0, "", ByteStringMicro.EMPTY}, ECQshopCustomerReaderSvr$GetUserWebImOrderListReq.class);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBStringField shop_id = PBField.initString("");
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
