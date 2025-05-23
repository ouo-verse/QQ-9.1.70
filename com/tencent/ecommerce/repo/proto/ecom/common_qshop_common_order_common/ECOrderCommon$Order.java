package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$Order extends MessageMicro<ECOrderCommon$Order> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74, 82, 98, 104, 112, 122, 130, 138, 144, 154, 162, 168, 176, 186, 194, 202, 210, 218, 224, 234, 810, 1608, 1618}, new String[]{"order_id", "source_info", "time_record", "time_point", "buyer_accounts", "state", "address", "transaction_snapshot", "comment_info", "after_sales_info", "shop_remarks", "refund_type", "cancel_type", "shop_settlement_info", "promotion_info", "alert_info", "product_trade_type", "virtual_account", "declaration_info", "buyer_update_address_cnt", "buyer_modify_address_disabled", "ticket_info", "ticket_user", "mystery_box_info", "click_id", "saas_info", "sub_type", "parent_order_ids", "ext_infos", "version", "sort_key"}, new Object[]{"", null, null, null, null, 0, null, null, null, null, "", 0, 0, null, null, null, 0, null, null, 0, Boolean.FALSE, null, null, null, "", null, 0, "", null, 0L, ""}, ECOrderCommon$Order.class);
    public final PBStringField order_id = PBField.initString("");
    public ECOrderCommon$SourceInfo source_info = new MessageMicro<ECOrderCommon$SourceInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SourceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 808, 818}, new String[]{"goods_type", WadlProxyConsts.CHANNEL, "channel_name", "saas_str", "saas_name", "content_id", "qqlive_room_id", "xworld_comment_id", "qqlive_session_id", "pindao_id", "os_type", "activity_id"}, new Object[]{0, 0, "", "", "", "", "", "", "", "", 0, ""}, ECOrderCommon$SourceInfo.class);
        public final PBUInt32Field goods_type = PBField.initUInt32(0);
        public final PBUInt32Field channel = PBField.initUInt32(0);
        public final PBStringField channel_name = PBField.initString("");
        public final PBStringField saas_str = PBField.initString("");
        public final PBStringField saas_name = PBField.initString("");
        public final PBStringField content_id = PBField.initString("");
        public final PBStringField qqlive_room_id = PBField.initString("");
        public final PBStringField xworld_comment_id = PBField.initString("");
        public final PBStringField qqlive_session_id = PBField.initString("");
        public final PBStringField pindao_id = PBField.initString("");
        public final PBUInt32Field os_type = PBField.initUInt32(0);
        public final PBStringField activity_id = PBField.initString("");
    };
    public ECOrderCommon$TimeRecord time_record = new MessageMicro<ECOrderCommon$TimeRecord>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TimeRecord
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 808}, new String[]{AlbumCacheData.CREATE_TIME, "pay_time", "cancel_time", "send_time", "receive_time", "refund_time", "box_allow_send_time", "update_time"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, ECOrderCommon$TimeRecord.class);
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBInt64Field pay_time = PBField.initInt64(0);
        public final PBInt64Field cancel_time = PBField.initInt64(0);
        public final PBInt64Field send_time = PBField.initInt64(0);
        public final PBInt64Field receive_time = PBField.initInt64(0);
        public final PBInt64Field refund_time = PBField.initInt64(0);
        public final PBInt64Field box_allow_send_time = PBField.initInt64(0);
        public final PBInt64Field update_time = PBField.initInt64(0);
    };
    public ECOrderCommon$TimePoint time_point = new MessageMicro<ECOrderCommon$TimePoint>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TimePoint
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"pay_deadline", "update_address_deadline", "deliver_deadline", "receipt_deadline", "after_sales_deadline", "mystery_box_retry_deadline", "mystery_box_allow_send_deadline", "set_allow_delivery_time"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, ECOrderCommon$TimePoint.class);
        public final PBInt64Field pay_deadline = PBField.initInt64(0);
        public final PBInt64Field update_address_deadline = PBField.initInt64(0);
        public final PBInt64Field deliver_deadline = PBField.initInt64(0);
        public final PBInt64Field receipt_deadline = PBField.initInt64(0);
        public final PBInt64Field after_sales_deadline = PBField.initInt64(0);
        public final PBInt64Field mystery_box_retry_deadline = PBField.initInt64(0);
        public final PBInt64Field mystery_box_allow_send_deadline = PBField.initInt64(0);
        public final PBInt64Field set_allow_delivery_time = PBField.initInt64(0);
    };
    public final PBRepeatMessageField<ECOrderCommon$Account> buyer_accounts = PBField.initRepeatMessage(ECOrderCommon$Account.class);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public ECOrderCommon$Address address = new ECOrderCommon$Address();
    public ECOrderCommon$TransactionSnapshot transaction_snapshot = new MessageMicro<ECOrderCommon$TransactionSnapshot>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TransactionSnapshot
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 80, 90, 98, 106, 114}, new String[]{"order_price", "discount", "free_shipping", "shipping_cost", "pay_info", "shop_info", "shipping_ids", "product_carts", "remarks", "ori_price", "shipping_info", "promos", "activity_info", "coupon_items"}, new Object[]{0L, 0L, Boolean.FALSE, 0, null, null, "", null, "", 0L, null, null, null, null}, ECOrderCommon$TransactionSnapshot.class);
        public final PBUInt64Field order_price = PBField.initUInt64(0);
        public final PBUInt64Field discount = PBField.initUInt64(0);
        public final PBBoolField free_shipping = PBField.initBool(false);
        public final PBUInt32Field shipping_cost = PBField.initUInt32(0);
        public ECOrderCommon$PayInfo pay_info = new MessageMicro<ECOrderCommon$PayInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PayInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{DefaultTVKDataProvider.KEY_PAY_TYPE, "pay_url_params", "pay_order_id", "pay_amount"}, new Object[]{0, "", "", 0L}, ECOrderCommon$PayInfo.class);
            public final PBUInt32Field pay_type = PBField.initUInt32(0);
            public final PBStringField pay_url_params = PBField.initString("");
            public final PBStringField pay_order_id = PBField.initString("");
            public final PBInt64Field pay_amount = PBField.initInt64(0);
        };
        public ECOrderCommon$ShopInfo shop_info = new ECOrderCommon$ShopInfo();
        public final PBRepeatField<String> shipping_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBRepeatMessageField<ECOrderCommon$ProductCart> product_carts = PBField.initRepeatMessage(ECOrderCommon$ProductCart.class);
        public final PBStringField remarks = PBField.initString("");
        public final PBUInt64Field ori_price = PBField.initUInt64(0);
        public ECOrderCommon$ShippingInfo shipping_info = new MessageMicro<ECOrderCommon$ShippingInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShippingInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"shipping_details"}, new Object[]{null}, ECOrderCommon$ShippingInfo.class);
            public final PBRepeatMessageField<ECOrderCommon$ShippingDetail> shipping_details = PBField.initRepeatMessage(ECOrderCommon$ShippingDetail.class);
        };
        public final PBRepeatMessageField<ECOrderCommon$Promo> promos = PBField.initRepeatMessage(ECOrderCommon$Promo.class);
        public ECOrderCommon$ActivityInfo activity_info = new MessageMicro<ECOrderCommon$ActivityInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ActivityInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"active_id", "active_type", "title", "icon_info"}, new Object[]{"", 0, "", null}, ECOrderCommon$ActivityInfo.class);
            public final PBStringField active_id = PBField.initString("");
            public final PBUInt32Field active_type = PBField.initUInt32(0);
            public final PBStringField title = PBField.initString("");
            public ECOrderCommon$ActiveIconInfo icon_info = new MessageMicro<ECOrderCommon$ActiveIconInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ActiveIconInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"detail_cover", "show_icon"}, new Object[]{null, null}, ECOrderCommon$ActiveIconInfo.class);
                public ECOrderCommon$PicInfo detail_cover = new ECOrderCommon$PicInfo();
                public ECOrderCommon$PicInfo show_icon = new ECOrderCommon$PicInfo();
            };
        };
        public final PBRepeatMessageField<ECOrderCommon$UsedCouponItem> coupon_items = PBField.initRepeatMessage(ECOrderCommon$UsedCouponItem.class);
    };
    public ECOrderCommon$CommentInfo comment_info = new MessageMicro<ECOrderCommon$CommentInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$CommentInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"has_comment", "comment_mappings"}, new Object[]{Boolean.FALSE, null}, ECOrderCommon$CommentInfo.class);
        public final PBBoolField has_comment = PBField.initBool(false);
        public final PBRepeatMessageField<ECOrderCommon$CommentMapping> comment_mappings = PBField.initRepeatMessage(ECOrderCommon$CommentMapping.class);
    };
    public ECOrderCommon$AfterSalesInfo after_sales_info = new MessageMicro<ECOrderCommon$AfterSalesInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$AfterSalesInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"in_after_sales", "after_sales_mappings"}, new Object[]{Boolean.FALSE, null}, ECOrderCommon$AfterSalesInfo.class);
        public final PBBoolField in_after_sales = PBField.initBool(false);
        public final PBRepeatMessageField<ECOrderCommon$AfterSalesMapping> after_sales_mappings = PBField.initRepeatMessage(ECOrderCommon$AfterSalesMapping.class);
    };
    public final PBStringField shop_remarks = PBField.initString("");
    public final PBUInt32Field refund_type = PBField.initUInt32(0);
    public final PBUInt32Field cancel_type = PBField.initUInt32(0);
    public ECOrderCommon$ShopSettlementInfo shop_settlement_info = new MessageMicro<ECOrderCommon$ShopSettlementInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopSettlementInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"settlement_state", "settlement_timestamp", "settlement_cash"}, new Object[]{0, 0L, 0}, ECOrderCommon$ShopSettlementInfo.class);
        public final PBUInt32Field settlement_state = PBField.initUInt32(0);
        public final PBInt64Field settlement_timestamp = PBField.initInt64(0);
        public final PBUInt32Field settlement_cash = PBField.initUInt32(0);
    };
    public ECOrderCommon$PromotionInfo promotion_info = new MessageMicro<ECOrderCommon$PromotionInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PromotionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 810, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834, h.CTRL_INDEX, 850, 856, 866}, new String[]{"promotion_type", "distribution_plan_type", "seller_account", "commission", "commission_rate", "settlement_info", "trace_key", "indirect", "open_id", "merchant_number", "organ_id", "platform_commission_rate", "platform_commission", "platform_settlement_info"}, new Object[]{0, 0, null, 0L, "", null, "", Boolean.FALSE, "", "", "", "", 0L, null}, ECOrderCommon$PromotionInfo.class);
        public final PBUInt32Field promotion_type = PBField.initUInt32(0);
        public final PBUInt32Field distribution_plan_type = PBField.initUInt32(0);
        public ECOrderCommon$Account seller_account = new MessageMicro<ECOrderCommon$Account>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$Account
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", ReportDataBuilder.KEY_ACCOUNT_ID}, new Object[]{0, ""}, ECOrderCommon$Account.class);
            public final PBUInt32Field account_type = PBField.initUInt32(0);
            public final PBStringField account_id = PBField.initString("");
        };
        public final PBInt64Field commission = PBField.initInt64(0);
        public final PBStringField commission_rate = PBField.initString("");
        public ECOrderCommon$SettlementInfo settlement_info = new MessageMicro<ECOrderCommon$SettlementInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SettlementInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"settlement_state", "settlement_time", "settlement_cash", "settlement_type"}, new Object[]{0, 0L, 0, 0}, ECOrderCommon$SettlementInfo.class);
            public final PBUInt32Field settlement_state = PBField.initUInt32(0);
            public final PBInt64Field settlement_time = PBField.initInt64(0);
            public final PBUInt32Field settlement_cash = PBField.initUInt32(0);
            public final PBUInt32Field settlement_type = PBField.initUInt32(0);
        };
        public final PBStringField trace_key = PBField.initString("");
        public final PBBoolField indirect = PBField.initBool(false);
        public final PBStringField open_id = PBField.initString("");
        public final PBStringField merchant_number = PBField.initString("");
        public final PBStringField organ_id = PBField.initString("");
        public final PBStringField platform_commission_rate = PBField.initString("");
        public final PBInt64Field platform_commission = PBField.initInt64(0);
        public ECOrderCommon$SettlementInfo platform_settlement_info = new MessageMicro<ECOrderCommon$SettlementInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SettlementInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"settlement_state", "settlement_time", "settlement_cash", "settlement_type"}, new Object[]{0, 0L, 0, 0}, ECOrderCommon$SettlementInfo.class);
            public final PBUInt32Field settlement_state = PBField.initUInt32(0);
            public final PBInt64Field settlement_time = PBField.initInt64(0);
            public final PBUInt32Field settlement_cash = PBField.initUInt32(0);
            public final PBUInt32Field settlement_type = PBField.initUInt32(0);
        };
    };
    public ECOrderCommon$AlertInfo alert_info = new MessageMicro<ECOrderCommon$AlertInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$AlertInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"alert_id", "operation_state", "evil_info"}, new Object[]{"", 0, null}, ECOrderCommon$AlertInfo.class);
        public final PBStringField alert_id = PBField.initString("");
        public final PBUInt32Field operation_state = PBField.initUInt32(0);
        public ECOrderCommon$EvilInfo evil_info = new MessageMicro<ECOrderCommon$EvilInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$EvilInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"evil_level", "evil_type", "beat_desc"}, new Object[]{0L, 0L, ""}, ECOrderCommon$EvilInfo.class);
            public final PBInt64Field evil_level = PBField.initInt64(0);
            public final PBRepeatField<Long> evil_type = PBField.initRepeat(PBInt64Field.__repeatHelper__);
            public final PBStringField beat_desc = PBField.initString("");
        };
    };
    public final PBUInt32Field product_trade_type = PBField.initUInt32(0);
    public ECOrderCommon$VirtualAccount virtual_account = new ECOrderCommon$VirtualAccount();
    public ECOrderCommon$DeclarationInfo declaration_info = new MessageMicro<ECOrderCommon$DeclarationInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$DeclarationInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"passed", "update_time", "declaration_id"}, new Object[]{Boolean.FALSE, 0L, ""}, ECOrderCommon$DeclarationInfo.class);
        public final PBBoolField passed = PBField.initBool(false);
        public final PBInt64Field update_time = PBField.initInt64(0);
        public final PBStringField declaration_id = PBField.initString("");
    };
    public final PBUInt32Field buyer_update_address_cnt = PBField.initUInt32(0);
    public final PBBoolField buyer_modify_address_disabled = PBField.initBool(false);
    public ECOrderCommon$TicketInfo ticket_info = new ECOrderCommon$TicketInfo();
    public ECOrderCommon$TicketUser ticket_user = new MessageMicro<ECOrderCommon$TicketUser>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TicketUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "id_card", "id"}, new Object[]{"", "", ""}, ECOrderCommon$TicketUser.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField id_card = PBField.initString("");

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f105238id = PBField.initString("");
    };
    public ECOrderCommon$MysteryBoxInfo mystery_box_info = new MessageMicro<ECOrderCommon$MysteryBoxInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$MysteryBoxInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field allow_delivery_trigger_type;
        public final PBEnumField box_store_type;
        public final PBUInt32Field box_type;
        public final PBUInt32Field draw_times_type;
        public final PBRepeatMessageField<ECOrderCommon$BriefYiFanAward> expected_buyall_awards;
        public final PBRepeatField<String> gift_order_ids;
        public final PBStringField promoter_media_id;
        public final PBRepeatField<String> related_box_order_ids;
        public final PBBoolField should_refund;
        public final PBBoolField with_ware_house;
        public final PBStringField yifan_group_id;
        public final PBStringField spu_id = PBField.initString("");
        public final PBStringField sku_id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public ECOrderCommon$PicInfo pic = new ECOrderCommon$PicInfo();
        public final PBInt64Field price = PBField.initInt64(0);
        public final PBStringField retry_token = PBField.initString("");
        public final PBRepeatMessageField<ECOrderCommon$MysteryBoxReward> rewards = PBField.initRepeatMessage(ECOrderCommon$MysteryBoxReward.class);
        public final PBEnumField lottery_type = PBField.initEnum(0);
        public final PBUInt32Field batch_draw_type = PBField.initUInt32(0);

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.related_box_order_ids = PBField.initRepeat(pBStringField);
            this.box_store_type = PBField.initEnum(0);
            this.promoter_media_id = PBField.initString("");
            this.allow_delivery_trigger_type = PBField.initUInt32(0);
            this.with_ware_house = PBField.initBool(false);
            this.box_type = PBField.initUInt32(0);
            this.draw_times_type = PBField.initUInt32(0);
            this.yifan_group_id = PBField.initString("");
            this.gift_order_ids = PBField.initRepeat(pBStringField);
            this.should_refund = PBField.initBool(false);
            this.expected_buyall_awards = PBField.initRepeatMessage(ECOrderCommon$BriefYiFanAward.class);
        }

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72, 82, 88, 98, 104, 112, 120, 128, 138, 146, 152, 162}, new String[]{"spu_id", "sku_id", "name", "pic", "price", "retry_token", "rewards", "lottery_type", "batch_draw_type", "related_box_order_ids", "box_store_type", "promoter_media_id", "allow_delivery_trigger_type", "with_ware_house", "box_type", "draw_times_type", "yifan_group_id", "gift_order_ids", "should_refund", "expected_buyall_awards"}, new Object[]{"", "", "", null, 0L, "", null, 0, 0, "", 0, "", 0, bool, 0, 0, "", "", bool, null}, ECOrderCommon$MysteryBoxInfo.class);
        }
    };
    public final PBStringField click_id = PBField.initString("");
    public ECOrderCommon$SaasInfo saas_info = new MessageMicro<ECOrderCommon$SaasInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SaasInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField ori_order_id = PBField.initString("");
        public final PBStringField boss_order_id = PBField.initString("");
        public final PBBoolField pdd_subsidy = PBField.initBool(false);
        public final PBBoolField hide_by_contract = PBField.initBool(false);
        public final PBUInt32Field pdd_subsidy_settlement_state = PBField.initUInt32(0);
        public final PBUInt32Field evaluation_state = PBField.initUInt32(0);
        public final PBStringField source_from = PBField.initString("");
        public final PBStringField h5_url = PBField.initString("");
        public final PBStringField busi_id = PBField.initString("");
        public final PBStringField hero_id = PBField.initString("");
        public final PBStringField skin_id = PBField.initString("");
        public final PBStringField act_id = PBField.initString("");
        public final PBStringField origin_product_id = PBField.initString("");
        public final PBStringField detail_product_id = PBField.initString("");
        public final PBBoolField ignore_settlement = PBField.initBool(false);
        public final PBInt32Field pay_type = PBField.initInt32(0);
        public final PBInt32Field days = PBField.initInt32(0);
        public final PBInt32Field renewal = PBField.initInt32(0);
        public final PBStringField source_media_product_id = PBField.initString("");
        public final PBInt32Field content_type = PBField.initInt32(0);

        static {
            String[] strArr = {"ori_order_id", "boss_order_id", "pdd_subsidy", "hide_by_contract", "pdd_subsidy_settlement_state", "evaluation_state", "source_from", "h5_url", "busi_id", "hero_id", "skin_id", "act_id", "origin_product_id", "detail_product_id", "ignore_settlement", DefaultTVKDataProvider.KEY_PAY_TYPE, "days", "renewal", "source_media_product_id", "content_type"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90, 98, 106, 114, 120, 128, 136, 144, 154, 160}, strArr, new Object[]{"", "", bool, bool, 0, 0, "", "", "", "", "", "", "", "", bool, 0, 0, 0, "", 0}, ECOrderCommon$SaasInfo.class);
        }
    };
    public final PBEnumField sub_type = PBField.initEnum(0);
    public final PBRepeatField<String> parent_order_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<ECOrderCommon$ExtInfo> ext_infos = PBField.initRepeatMessage(ECOrderCommon$ExtInfo.class);
    public final PBInt64Field version = PBField.initInt64(0);
    public final PBStringField sort_key = PBField.initString("");
}
