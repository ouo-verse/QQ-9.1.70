package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Order;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ProductSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Promotion;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$OrderFulfilDetail extends MessageMicro<ECQshopSampleSvr$OrderFulfilDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 322}, new String[]{"order", "product", "shop", "promotion", "ui_data"}, new Object[]{null, null, null, null, null}, ECQshopSampleSvr$OrderFulfilDetail.class);
    public ECSampleData$Order order = new ECSampleData$Order();
    public ECSampleData$ProductSnapshot product = new ECSampleData$ProductSnapshot();
    public ECSampleData$ShopSnapshot shop = new ECSampleData$ShopSnapshot();
    public ECSampleData$Promotion promotion = new MessageMicro<ECSampleData$Promotion>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Promotion
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"medium_list", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "total_amount", "progress_list"}, new Object[]{null, 0, 0, null}, ECSampleData$Promotion.class);
        public final PBRepeatMessageField<ECSampleData$Medium> medium_list = PBField.initRepeatMessage(ECSampleData$Medium.class);
        public final PBUInt32Field volume = PBField.initUInt32(0);
        public final PBUInt32Field total_amount = PBField.initUInt32(0);
        public final PBRepeatMessageField<ECSampleData$Progress> progress_list = PBField.initRepeatMessage(ECSampleData$Progress.class);
    };
    public ECQshopSampleSvr$OrderUIData ui_data = new ECQshopSampleSvr$OrderUIData();
}
