package VAC_ADV_GET_ACCESS;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacGroupBindGoodsReq extends MessageMicro<VacAdvGetAccess$VacGroupBindGoodsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48}, new String[]{"ware_house_id", "media_type", "content_type", "content_id", "product_list", "seller_id"}, new Object[]{100, 0, 0, "", null, 0L}, VacAdvGetAccess$VacGroupBindGoodsReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBRepeatMessageField<Product> product_list = PBField.initRepeatMessage(Product.class);
    public final PBUInt64Field seller_id = PBField.initUInt64(0);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Product extends MessageMicro<Product> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "index", "production_token"}, new Object[]{0L, 0L, ""}, Product.class);
        public final PBInt64Field product_id = PBField.initInt64(0);
        public final PBInt64Field index = PBField.initInt64(0);
        public final PBStringField production_token = PBField.initString("");
    }
}
