package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$BlockInfo extends MessageMicro<ECQshopCustomerReaderSvr$BlockInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"block_url", ZPlanPublishSource.FROM_SCHEME, "scheme_params_key"}, new Object[]{"", "", ""}, ECQshopCustomerReaderSvr$BlockInfo.class);
    public final PBStringField block_url = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField scheme_params_key = PBField.initString("");
}
