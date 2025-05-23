package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$ProductCardRsp extends MessageMicro<ECQqShopDetailSvr$ProductCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 82, 162, 242, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 642, QVipServiceAccountFolderProcessor.CMD}, new String[]{"spu_id", "biz_type", "status", "product", "coupons", "shop", "shop_service", "button", "bulletin", "user_right", "active_info"}, new Object[]{"", 0, 0, null, null, null, null, null, null, null, null}, ECQqShopDetailSvr$ProductCardRsp.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBInt32Field biz_type = PBField.initInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public ECQqShopDetailSvr$Product product = new MessageMicro<ECQqShopDetailSvr$Product>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Product
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 34, 50, 58, 66, 74, 82, 90, 98, 104, 112, 122, 162, 402, 482}, new String[]{"spu_id", "title", "desc", Constants.Service.PROPERTIES, "video_pic", "carousel_pictures", "main_pics", "detail_pictures", "category", AlbumCacheData.CREATE_TIME, "update_time", "price_desc_txt", "price", "sku_infos", TabPreloadItem.TAB_NAME_DYNAMIC}, new Object[]{"", "", "", null, null, null, null, null, null, 0L, 0L, "", null, null, null}, ECQqShopDetailSvr$Product.class);
        public final PBStringField spu_id = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBRepeatMessageField<ECQqShopDetailSvr$Property> properties = PBField.initRepeatMessage(ECQqShopDetailSvr$Property.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$VideoPic> video_pic = PBField.initRepeatMessage(ECQqShopDetailSvr$VideoPic.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$PicInfo> carousel_pictures = PBField.initRepeatMessage(ECQqShopDetailSvr$PicInfo.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$PicInfo> main_pics = PBField.initRepeatMessage(ECQqShopDetailSvr$PicInfo.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$PicInfo> detail_pictures = PBField.initRepeatMessage(ECQqShopDetailSvr$PicInfo.class);
        public ECQqShopDetailSvr$Category category = new MessageMicro<ECQqShopDetailSvr$Category>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Category
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"first_cat_id", "first_cat_name", "second_cat_id", "second_cat_name", "third_cat_id", "third_cat_name", "forth_cat_id", "forth_cat_name", "fifth_cat_id", "fifth_cat_name"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, ECQqShopDetailSvr$Category.class);
            public final PBStringField first_cat_id = PBField.initString("");
            public final PBStringField first_cat_name = PBField.initString("");
            public final PBStringField second_cat_id = PBField.initString("");
            public final PBStringField second_cat_name = PBField.initString("");
            public final PBStringField third_cat_id = PBField.initString("");
            public final PBStringField third_cat_name = PBField.initString("");
            public final PBStringField forth_cat_id = PBField.initString("");
            public final PBStringField forth_cat_name = PBField.initString("");
            public final PBStringField fifth_cat_id = PBField.initString("");
            public final PBStringField fifth_cat_name = PBField.initString("");
        };
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBInt64Field update_time = PBField.initInt64(0);
        public final PBStringField price_desc_txt = PBField.initString("");
        public ECQqShopDetailSvr$Price price = new ECQqShopDetailSvr$Price();
        public final PBRepeatMessageField<ECQqShopDetailSvr$SkuInfo> sku_infos = PBField.initRepeatMessage(ECQqShopDetailSvr$SkuInfo.class);
        public ECQqShopDetailSvr$SpuDynamic dynamic = new MessageMicro<ECQqShopDetailSvr$SpuDynamic>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$SpuDynamic
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"stock", "buy_limit", "sales"}, new Object[]{"", null, ""}, ECQqShopDetailSvr$SpuDynamic.class);
            public final PBStringField stock = PBField.initString("");
            public ECQqShopDetailSvr$BuyLimit buy_limit = new ECQqShopDetailSvr$BuyLimit();
            public final PBStringField sales = PBField.initString("");
        };
    };
    public final PBRepeatMessageField<ECQqShopDetailSvr$Coupon> coupons = PBField.initRepeatMessage(ECQqShopDetailSvr$Coupon.class);
    public ECQqShopDetailSvr$Shop shop = new MessageMicro<ECQqShopDetailSvr$Shop>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Shop
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 162}, new String[]{"id", "name", "icon", "button", TabPreloadItem.TAB_NAME_DYNAMIC}, new Object[]{"", "", "", null, null}, ECQqShopDetailSvr$Shop.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f105245id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public ECQqShopDetailSvr$ButtonItem button = new MessageMicro<ECQqShopDetailSvr$ButtonItem>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ButtonItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"button_type", FileReaderHelper.TXT_EXT, "jump_url", "icon", "desc"}, new Object[]{0, "", "", "", ""}, ECQqShopDetailSvr$ButtonItem.class);
            public final PBInt32Field button_type = PBField.initInt32(0);
            public final PBStringField txt = PBField.initString("");
            public final PBStringField jump_url = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
        };
        public ECQqShopDetailSvr$ShopDynamic dynamic = new MessageMicro<ECQqShopDetailSvr$ShopDynamic>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ShopDynamic
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sales"}, new Object[]{""}, ECQqShopDetailSvr$ShopDynamic.class);
            public final PBStringField sales = PBField.initString("");
        };
    };
    public ECQqShopDetailSvr$Service shop_service = new MessageMicro<ECQqShopDetailSvr$Service>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Service
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"services"}, new Object[]{null}, ECQqShopDetailSvr$Service.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$ServiceItem> services = PBField.initRepeatMessage(ECQqShopDetailSvr$ServiceItem.class);
    };
    public ECQqShopDetailSvr$Button button = new MessageMicro<ECQqShopDetailSvr$Button>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Button
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"button_item"}, new Object[]{null}, ECQqShopDetailSvr$Button.class);
        public final PBRepeatMessageField<ECQqShopDetailSvr$ButtonItem> button_item = PBField.initRepeatMessage(ECQqShopDetailSvr$ButtonItem.class);
    };
    public ECQqShopDetailSvr$Bulletin bulletin = new MessageMicro<ECQqShopDetailSvr$Bulletin>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$Bulletin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{FileReaderHelper.TXT_EXT, "icon"}, new Object[]{"", ""}, ECQqShopDetailSvr$Bulletin.class);
        public final PBStringField txt = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
    };
    public ECQqShopDetailSvr$UserRight user_right = new MessageMicro<ECQqShopDetailSvr$UserRight>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$UserRight
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"role_id", "role_name", "role_desc"}, new Object[]{0, "", ""}, ECQqShopDetailSvr$UserRight.class);
        public final PBInt32Field role_id = PBField.initInt32(0);
        public final PBStringField role_name = PBField.initString("");
        public final PBStringField role_desc = PBField.initString("");
    };
    public ECQqShopDetailSvr$ActiveInfo active_info = new MessageMicro<ECQqShopDetailSvr$ActiveInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ActiveInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 82, 162, 242, 322}, new String[]{"active_id", "active_type", "active_status", "live_price", "live_sales", "live_stock", "live_time_range"}, new Object[]{"", "", 0, null, null, null, null}, ECQqShopDetailSvr$ActiveInfo.class);
        public final PBStringField active_id = PBField.initString("");
        public final PBStringField active_type = PBField.initString("");
        public final PBInt32Field active_status = PBField.initInt32(0);
        public ECQqShopDetailSvr$ActivePrice live_price = new MessageMicro<ECQqShopDetailSvr$ActivePrice>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ActivePrice
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 80, 88}, new String[]{Element.ELEMENT_NAME_MIN, "max", "original", "live", "live_special"}, new Object[]{0L, 0L, 0L, 0L, 0L}, ECQqShopDetailSvr$ActivePrice.class);
            public final PBInt64Field min = PBField.initInt64(0);
            public final PBInt64Field max = PBField.initInt64(0);
            public final PBInt64Field original = PBField.initInt64(0);
            public final PBInt64Field live = PBField.initInt64(0);
            public final PBInt64Field live_special = PBField.initInt64(0);
        };
        public ECQqShopDetailSvr$ActiveSales live_sales = new MessageMicro<ECQqShopDetailSvr$ActiveSales>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ActiveSales
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sale_nums", "sales_nums_txt"}, new Object[]{0L, ""}, ECQqShopDetailSvr$ActiveSales.class);
            public final PBInt64Field sale_nums = PBField.initInt64(0);
            public final PBStringField sales_nums_txt = PBField.initString("");
        };
        public ECQqShopDetailSvr$ActiveStock live_stock = new MessageMicro<ECQqShopDetailSvr$ActiveStock>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ActiveStock
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"total", "remain", "active"}, new Object[]{0L, 0L, 0L}, ECQqShopDetailSvr$ActiveStock.class);
            public final PBInt64Field total = PBField.initInt64(0);
            public final PBInt64Field remain = PBField.initInt64(0);
            public final PBInt64Field active = PBField.initInt64(0);
        };
        public ECQqShopDetailSvr$ActiveTimeRange live_time_range = new MessageMicro<ECQqShopDetailSvr$ActiveTimeRange>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr.ECQqShopDetailSvr$ActiveTimeRange
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"begin", "end"}, new Object[]{0L, 0L}, ECQqShopDetailSvr$ActiveTimeRange.class);
            public final PBInt64Field begin = PBField.initInt64(0);
            public final PBInt64Field end = PBField.initInt64(0);
        };
    };
}
