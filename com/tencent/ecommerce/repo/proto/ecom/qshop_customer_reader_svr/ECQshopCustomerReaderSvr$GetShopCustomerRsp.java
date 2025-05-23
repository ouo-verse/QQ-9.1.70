package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$Customer;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$GetShopCustomerRsp extends MessageMicro<ECQshopCustomerReaderSvr$GetShopCustomerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"customer"}, new Object[]{null}, ECQshopCustomerReaderSvr$GetShopCustomerRsp.class);
    public ECCustomerInfo$Customer customer = new MessageMicro<ECCustomerInfo$Customer>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$Customer
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"shop_id", "zc_info", "status"}, new Object[]{"", null, 0}, ECCustomerInfo$Customer.class);
        public final PBStringField shop_id = PBField.initString("");
        public ECCustomerInfo$ZhichiInfo zc_info = new MessageMicro<ECCustomerInfo$ZhichiInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$ZhichiInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 80, 162, 242}, new String[]{"customer_code", "name", "sysnum", "email", NotificationActivity.PASSWORD, "bind_media_id", "max_agnet_count", "agent", "zc_cer"}, new Object[]{"", "", "", "", "", "", 0, null, null}, ECCustomerInfo$ZhichiInfo.class);
            public final PBStringField customer_code = PBField.initString("");
            public final PBStringField name = PBField.initString("");
            public final PBStringField sysnum = PBField.initString("");
            public final PBStringField email = PBField.initString("");
            public final PBStringField password = PBField.initString("");
            public final PBStringField bind_media_id = PBField.initString("");
            public final PBInt32Field max_agnet_count = PBField.initInt32(0);
            public final PBRepeatMessageField<ECCustomerInfo$Agent> agent = PBField.initRepeatMessage(ECCustomerInfo$Agent.class);
            public ECCustomerInfo$ZhichiCer zc_cer = new MessageMicro<ECCustomerInfo$ZhichiCer>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_customer_info.ECCustomerInfo$ZhichiCer
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"appid", "appkey", "link_appkey"}, new Object[]{"", "", ""}, ECCustomerInfo$ZhichiCer.class);
                public final PBStringField appid = PBField.initString("");
                public final PBStringField appkey = PBField.initString("");
                public final PBStringField link_appkey = PBField.initString("");
            };
        };
        public final PBInt32Field status = PBField.initInt32(0);
    };
}
