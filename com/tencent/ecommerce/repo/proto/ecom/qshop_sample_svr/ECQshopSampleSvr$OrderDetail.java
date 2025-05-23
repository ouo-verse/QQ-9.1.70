package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AfterSale;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$CreativeSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Logistics;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Order;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ProductSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$OrderDetail extends MessageMicro<ECQshopSampleSvr$OrderDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 322}, new String[]{"order", "creative", "product", "shop", "logistics", "after_sale", "ui_data"}, new Object[]{null, null, null, null, null, null, null}, ECQshopSampleSvr$OrderDetail.class);
    public ECSampleData$Order order = new ECSampleData$Order();
    public ECSampleData$CreativeSnapshot creative = new ECSampleData$CreativeSnapshot();
    public ECSampleData$ProductSnapshot product = new ECSampleData$ProductSnapshot();
    public ECSampleData$ShopSnapshot shop = new ECSampleData$ShopSnapshot();
    public ECSampleData$Logistics logistics = new ECSampleData$Logistics();
    public ECSampleData$AfterSale after_sale = new MessageMicro<ECSampleData$AfterSale>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AfterSale
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"abort_times", "abort_reason", "desc", "img_list"}, new Object[]{0, null, "", ""}, ECSampleData$AfterSale.class);
        public final PBUInt32Field abort_times = PBField.initUInt32(0);
        public ECSampleData$AbortReason abort_reason = new ECSampleData$AbortReason();
        public final PBStringField desc = PBField.initString("");
        public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public ECQshopSampleSvr$OrderUIData ui_data = new ECQshopSampleSvr$OrderUIData();
}
