package com.tencent.mobileqq.trpc.qqecommerce.access;

import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.intervideo.nowproxy.customized_interface.CustomKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.QZonePushReporter;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VacAdvGet$GoodsInfo extends MessageMicro<VacAdvGet$GoodsInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField apurl;
    public final PBInt32Field audit_state;
    public final PBInt32Field category_id;
    public final PBStringField category_name;
    public final PBInt32Field commission;
    public VacAdvGet$CouponExt coupon_extra;
    public final PBRepeatMessageField<VacAdvGet$Coupon> coupons;
    public final PBInt64Field cur_price_64;
    public VacAdvGet$CustomReport custom_report;
    public final PBRepeatField<String> ext_img_urls;
    public final PBStringField h5_url;
    public final PBBoolField is_bind;
    public final PBBoolField is_collected;
    public final PBRepeatMessageField<VacAdvGet$Label> labels;
    public final PBInt32Field living_stream_state;
    public final PBUInt32Field merge_state;
    public final PBStringField mini_program_username;
    public VacAdvGet$Movie movie;
    public final PBInt64Field org_price_64;
    public final PBStringField production_token;
    public VacAdvGet$QQAppInfo qq_app_info;
    public final PBStringField qq_mini_program_url;

    /* renamed from: rl, reason: collision with root package name */
    public final PBStringField f303351rl;
    public final PBRepeatField<String> sell_points;
    public final PBDoubleField share;
    public final PBStringField shop_name;
    public final PBInt32Field state;
    public final PBStringField trace_id;
    public final PBUInt64Field update_time;
    public VacAdvGet$WeChatAppInfo wechat_app_info;
    public final PBStringField wx_mini_program_url;
    public final PBStringField goods_id = PBField.initString("");
    public final PBInt32Field ware_house_id = PBField.initInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBStringField source_str = PBField.initString("");
    public final PBStringField source_product_id = PBField.initString("");
    public final PBStringField main_img_url = PBField.initString("");
    public final PBStringField goods_name = PBField.initString("");
    public final PBStringField goods_desc = PBField.initString("");
    public final PBInt32Field cur_price = PBField.initInt32(0);
    public final PBInt32Field org_price = PBField.initInt32(0);
    public final PBInt32Field inventory = PBField.initInt32(0);
    public final PBStringField sale_tip = PBField.initString("");

    static {
        int[] iArr = {10, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 112, 122, 130, 138, 146, 152, 160, 169, 176, 184, 192, 202, 208, 218, 226, 234, 240, 248, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 304, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, 346};
        String[] strArr = {"goods_id", "ware_house_id", "source", "source_str", "source_product_id", "main_img_url", "goods_name", "goods_desc", "cur_price", "org_price", "inventory", "sale_tip", "sell_points", PictureConst.KEY_CATEGORY_ID, "category_name", "ext_img_urls", "shop_name", "qq_mini_program_url", "state", "audit_state", "share", "commission", "update_time", "is_bind", "production_token", "living_stream_state", "wx_mini_program_url", "h5_url", "mini_program_username", "cur_price_64", "org_price_64", "is_collected", "trace_id", "apurl", "rl", "qq_app_info", "wechat_app_info", "merge_state", "labels", "coupons", "movie", "coupon_extra", CustomKey.CUSTOM_REPORT};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", 0, 0, "", "", "", "", "", 0, 0, 0, "", "", 0, "", "", "", "", 0, 0, Double.valueOf(0.0d), 0, 0L, bool, "", 0, "", "", "", 0L, 0L, bool, "", "", "", null, null, 0, null, null, null, null, null}, VacAdvGet$GoodsInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$CouponExt] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$CustomReport] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$QQAppInfo] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$WeChatAppInfo] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$Movie] */
    public VacAdvGet$GoodsInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.sell_points = PBField.initRepeat(pBStringField);
        this.category_id = PBField.initInt32(0);
        this.category_name = PBField.initString("");
        this.ext_img_urls = PBField.initRepeat(pBStringField);
        this.shop_name = PBField.initString("");
        this.qq_mini_program_url = PBField.initString("");
        this.state = PBField.initInt32(0);
        this.audit_state = PBField.initInt32(0);
        this.share = PBField.initDouble(0.0d);
        this.commission = PBField.initInt32(0);
        this.update_time = PBField.initUInt64(0L);
        this.is_bind = PBField.initBool(false);
        this.production_token = PBField.initString("");
        this.living_stream_state = PBField.initInt32(0);
        this.wx_mini_program_url = PBField.initString("");
        this.h5_url = PBField.initString("");
        this.mini_program_username = PBField.initString("");
        this.cur_price_64 = PBField.initInt64(0L);
        this.org_price_64 = PBField.initInt64(0L);
        this.is_collected = PBField.initBool(false);
        this.trace_id = PBField.initString("");
        this.apurl = PBField.initString("");
        this.f303351rl = PBField.initString("");
        this.qq_app_info = new MessageMicro<VacAdvGet$QQAppInfo>() { // from class: com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$QQAppInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"app_id", "app_path", "app_schema"}, new Object[]{"", "", ""}, VacAdvGet$QQAppInfo.class);
            public final PBStringField app_id = PBField.initString("");
            public final PBStringField app_path = PBField.initString("");
            public final PBStringField app_schema = PBField.initString("");
        };
        this.wechat_app_info = new MessageMicro<VacAdvGet$WeChatAppInfo>() { // from class: com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$WeChatAppInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"app_username", "app_path", "app_token", "app_id", "ad_trace_data", SsoReporter.POS_ID_KEY, QZoneAdTianshuFeedData.KEY_SCHEMA_URL}, new Object[]{"", "", "", "", "", 0L, ""}, VacAdvGet$WeChatAppInfo.class);
            public final PBStringField app_username = PBField.initString("");
            public final PBStringField app_path = PBField.initString("");
            public final PBStringField app_token = PBField.initString("");
            public final PBStringField app_id = PBField.initString("");
            public final PBStringField ad_trace_data = PBField.initString("");
            public final PBUInt64Field pos_id = PBField.initUInt64(0);
            public final PBStringField schema_url = PBField.initString("");
        };
        this.merge_state = PBField.initUInt32(0);
        this.labels = PBField.initRepeatMessage(VacAdvGet$Label.class);
        this.coupons = PBField.initRepeatMessage(VacAdvGet$Coupon.class);
        this.movie = new MessageMicro<VacAdvGet$Movie>() { // from class: com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$Movie
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 49, 58, 66, 72, 80}, new String[]{"en_name", "alt_name", "director", LinkReportConstant$BizKey.ACTOR, "movie_len", "rating", "release_time", "classify", "score_num", "wish_num"}, new Object[]{"", "", "", "", 0, Double.valueOf(0.0d), "", "", 0, 0}, VacAdvGet$Movie.class);
            public final PBRepeatField<String> actor;
            public final PBRepeatField<String> alt_name;
            public final PBRepeatField<String> classify;
            public final PBRepeatField<String> director;
            public final PBStringField en_name = PBField.initString("");
            public final PBUInt32Field movie_len;
            public final PBDoubleField rating;
            public final PBStringField release_time;
            public final PBUInt32Field score_num;
            public final PBUInt32Field wish_num;

            {
                PBStringField pBStringField2 = PBStringField.__repeatHelper__;
                this.alt_name = PBField.initRepeat(pBStringField2);
                this.director = PBField.initRepeat(pBStringField2);
                this.actor = PBField.initRepeat(pBStringField2);
                this.movie_len = PBField.initUInt32(0);
                this.rating = PBField.initDouble(0.0d);
                this.release_time = PBField.initString("");
                this.classify = PBField.initRepeat(pBStringField2);
                this.score_num = PBField.initUInt32(0);
                this.wish_num = PBField.initUInt32(0);
            }
        };
        this.coupon_extra = new MessageMicro<VacAdvGet$CouponExt>() { // from class: com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$CouponExt
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56, 64, 72, 80}, new String[]{"log_url", "coupon_level", "coupon_content", "coupon_labels", "coupon_discount", "coupon_desc", "show_type", "reward_video", "coupon_level_new", "coupon_state"}, new Object[]{"", 0, "", "", 0L, "", 0, 0, 0, 0}, VacAdvGet$CouponExt.class);
            public final PBStringField log_url = PBField.initString("");
            public final PBEnumField coupon_level = PBField.initEnum(0);
            public final PBStringField coupon_content = PBField.initString("");
            public final PBRepeatField<String> coupon_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBInt64Field coupon_discount = PBField.initInt64(0);
            public final PBStringField coupon_desc = PBField.initString("");
            public final PBInt32Field show_type = PBField.initInt32(0);
            public final PBInt32Field reward_video = PBField.initInt32(0);
            public final PBInt32Field coupon_level_new = PBField.initInt32(0);
            public final PBInt32Field coupon_state = PBField.initInt32(0);
        };
        this.custom_report = new MessageMicro<VacAdvGet$CustomReport>() { // from class: com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$CustomReport
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"url", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, "click"}, new Object[]{"", "", ""}, VacAdvGet$CustomReport.class);
            public final PBStringField url = PBField.initString("");
            public final PBStringField exposure = PBField.initString("");
            public final PBStringField click = PBField.initString("");
        };
    }
}
