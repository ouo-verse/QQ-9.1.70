package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetActiveSkuInfoRsp extends MessageMicro<ECQqShopDetailSvr$GetActiveSkuInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sku_info", "toast"}, new Object[]{null, ""}, ECQqShopDetailSvr$GetActiveSkuInfoRsp.class);
    public ECQqShopDetailSvr$SkuInfo sku_info = new MessageMicro<ECQqShopDetailSvr$SkuInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$SkuInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 322}, new String[]{"sku_id", "spu_id", "price", "preview_pics", "spec_info", AlbumCacheData.CREATE_TIME, "update_time", "status", TabPreloadItem.TAB_NAME_DYNAMIC}, new Object[]{"", "", null, null, null, 0L, 0L, 0, null}, ECQqShopDetailSvr$SkuInfo.class);
        public final PBStringField sku_id = PBField.initString("");
        public final PBStringField spu_id = PBField.initString("");
        public ECQqShopDetailSvr$Price price = new ECQqShopDetailSvr$Price();
        public final PBRepeatMessageField<ECQqShopDetailSvr$PicInfo> preview_pics = PBField.initRepeatMessage(ECQqShopDetailSvr$PicInfo.class);
        public ECQqShopDetailSvr$SpecInfo spec_info = new MessageMicro<ECQqShopDetailSvr$SpecInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$SpecInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECQqShopDetailSvr$SpecInfo.class);
            public final PBRepeatMessageField<ECQqShopDetailSvr$SpecItem> items = PBField.initRepeatMessage(ECQqShopDetailSvr$SpecItem.class);
        };
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBInt64Field update_time = PBField.initInt64(0);
        public final PBInt32Field status = PBField.initInt32(0);
        public ECQqShopDetailSvr$SkuDynamic dynamic = new MessageMicro<ECQqShopDetailSvr$SkuDynamic>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$SkuDynamic
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"stock", "stock_nums", "buy_limit"}, new Object[]{"", 0L, null}, ECQqShopDetailSvr$SkuDynamic.class);
            public final PBStringField stock = PBField.initString("");
            public final PBInt64Field stock_nums = PBField.initInt64(0);
            public ECQqShopDetailSvr$BuyLimit buy_limit = new ECQqShopDetailSvr$BuyLimit();
        };
    };
    public final PBStringField toast = PBField.initString("");
}
