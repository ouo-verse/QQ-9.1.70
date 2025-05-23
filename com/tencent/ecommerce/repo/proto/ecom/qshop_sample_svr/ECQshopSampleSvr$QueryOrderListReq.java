package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Options;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$QueryOrderListReq extends MessageMicro<ECQshopSampleSvr$QueryOrderListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"options", "cookie"}, new Object[]{null, ""}, ECQshopSampleSvr$QueryOrderListReq.class);
    public ECSampleData$Options options = new MessageMicro<ECSampleData$Options>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Options
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"query_words", "order_status_list", "creative_id", "creative_name", "cate_name"}, new Object[]{"", 0, "", "", ""}, ECSampleData$Options.class);
        public final PBStringField query_words = PBField.initString("");
        public final PBRepeatField<Integer> order_status_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBStringField creative_id = PBField.initString("");
        public final PBStringField creative_name = PBField.initString("");
        public final PBStringField cate_name = PBField.initString("");
    };
    public final PBStringField cookie = PBField.initString("");
}
