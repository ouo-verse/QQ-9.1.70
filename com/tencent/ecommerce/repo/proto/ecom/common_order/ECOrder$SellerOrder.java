package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.imsdk.BuildConfig;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$SellerOrder extends MessageMicro<ECOrder$SellerOrder> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 162, 242, 322, 402}, new String[]{BuildConfig.FLAVOR, "product", "settlement", "commission", "display", "subsidy"}, new Object[]{null, null, null, null, null, null}, ECOrder$SellerOrder.class);
    public ECOrder$BasicInfo basic = new ECOrder$BasicInfo();
    public ECOrder$ProductInfo product = new ECOrder$ProductInfo();
    public ECOrder$SettlementInfo settlement = new MessageMicro<ECOrder$SettlementInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$SettlementInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"settlement_time", "settlement_state", "settlement_cash", "settlement_type"}, new Object[]{"", 0L, 0L, 0L}, ECOrder$SettlementInfo.class);
        public final PBStringField settlement_time = PBField.initString("");
        public final PBInt64Field settlement_state = PBField.initInt64(0);
        public final PBInt64Field settlement_cash = PBField.initInt64(0);
        public final PBInt64Field settlement_type = PBField.initInt64(0);
    };
    public ECOrder$CommissionInfo commission = new MessageMicro<ECOrder$CommissionInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$CommissionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"commission", "commission_rate", "commission_mode"}, new Object[]{0L, "", 0}, ECOrder$CommissionInfo.class);
        public final PBInt64Field commission = PBField.initInt64(0);
        public final PBStringField commission_rate = PBField.initString("");
        public final PBInt32Field commission_mode = PBField.initInt32(0);
    };
    public ECOrder$DisplayInfo display = new MessageMicro<ECOrder$DisplayInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$DisplayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"indirect_wording"}, new Object[]{""}, ECOrder$DisplayInfo.class);
        public final PBStringField indirect_wording = PBField.initString("");
    };
    public ECOrder$SubsidyInfo subsidy = new MessageMicro<ECOrder$SubsidyInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$SubsidyInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"saas_type", WidgetCacheConstellationData.MONEY, "text"}, new Object[]{"", 0L, ""}, ECOrder$SubsidyInfo.class);
        public final PBStringField saas_type = PBField.initString("");
        public final PBInt64Field money = PBField.initInt64(0);
        public final PBStringField text = PBField.initString("");
    };
}
