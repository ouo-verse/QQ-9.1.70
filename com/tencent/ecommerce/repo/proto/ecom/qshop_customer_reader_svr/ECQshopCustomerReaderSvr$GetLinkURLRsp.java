package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$GetLinkURLRsp extends MessageMicro<ECQshopCustomerReaderSvr$GetLinkURLRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"chat_url", "block_info"}, new Object[]{"", null}, ECQshopCustomerReaderSvr$GetLinkURLRsp.class);
    public final PBStringField chat_url = PBField.initString("");
    public final PBRepeatMessageField<ECQshopCustomerReaderSvr$BlockInfo> block_info = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$BlockInfo.class);
}
