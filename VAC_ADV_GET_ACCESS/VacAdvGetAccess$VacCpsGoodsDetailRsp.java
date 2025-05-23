package VAC_ADV_GET_ACCESS;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacCpsGoodsDetailRsp extends MessageMicro<VacAdvGetAccess$VacCpsGoodsDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "goods_info"}, new Object[]{0, "", null}, VacAdvGetAccess$VacCpsGoodsDetailRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public VacAdvGetAccess$GoodsInfo goods_info = new MessageMicro<VacAdvGetAccess$GoodsInfo>() { // from class: VAC_ADV_GET_ACCESS.VacAdvGetAccess$GoodsInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 112, 122, 130, 138, 146, 152, 160, 169, 176, 184, 192, 202, 208, 218, 226, 234}, new String[]{"goods_id", "ware_house_id", "source", "source_str", "source_product_id", "main_img_url", "goods_name", "goods_desc", "cur_price", "org_price", "inventory", "sale_tip", "sell_points", PictureConst.KEY_CATEGORY_ID, "category_name", "ext_img_urls", "shop_name", "qq_mini_program_url", "state", "audit_state", "share", "commission", "update_time", "is_bind", "production_token", "living_stream_state", "wx_mini_program_url", "h5_url", "mini_program_username"}, new Object[]{"", 0, 0, "", "", "", "", "", 0, 0, 0, "", "", 0, "", "", "", "", 0, 0, Double.valueOf(0.0d), 0, 0L, Boolean.FALSE, "", 0, "", "", ""}, VacAdvGetAccess$GoodsInfo.class);
        public final PBInt32Field audit_state;
        public final PBInt32Field category_id;
        public final PBStringField category_name;
        public final PBInt32Field commission;
        public final PBRepeatField<String> ext_img_urls;
        public final PBStringField h5_url;
        public final PBBoolField is_bind;
        public final PBInt32Field living_stream_state;
        public final PBStringField mini_program_username;
        public final PBStringField production_token;
        public final PBStringField qq_mini_program_url;
        public final PBRepeatField<String> sell_points;
        public final PBDoubleField share;
        public final PBStringField shop_name;
        public final PBInt32Field state;
        public final PBUInt64Field update_time;
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

        {
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
        }
    };
}
