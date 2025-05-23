package VAC_ADV_GET_ACCESS;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$MediaOrderInfo extends MessageMicro<VacAdvGetAccess$MediaOrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 80, 88, 96, 106, 114, 122, 128, 138, 146, 154, 160, 168, 178, 186, 194, 202, 216, 226, 232, 240, 248, 256}, new String[]{"order_id", "saas_type", "saas_type_str", "buyer_id", "seller_id", "ext_info", "order_price", "freight", "discount", "h5_url", "wx_mini_program_url", "qq_mini_program_url", "state", AlbumCacheData.CREATE_TIME, "product_pic", "product_title", "product_price", "product_num", "specification1", "specification2", "wx_mini_program", "qq_mini_program", ReportDataBuilder.KEY_PRODUCT_ID, "content_id", "content_type", "scene", "share_media_id", "root_id"}, new Object[]{"", "", "", "", "", "", 0L, 0L, 0L, "", "", "", 0, "", "", "", 0L, 0L, "", "", null, null, 0L, "", 0, 0, 0, 0L}, VacAdvGetAccess$MediaOrderInfo.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBStringField saas_type = PBField.initString("");
    public final PBStringField saas_type_str = PBField.initString("");
    public final PBStringField buyer_id = PBField.initString("");
    public final PBStringField seller_id = PBField.initString("");
    public final PBStringField ext_info = PBField.initString("");
    public final PBInt64Field order_price = PBField.initInt64(0);
    public final PBInt64Field freight = PBField.initInt64(0);
    public final PBInt64Field discount = PBField.initInt64(0);
    public final PBStringField h5_url = PBField.initString("");
    public final PBStringField wx_mini_program_url = PBField.initString("");
    public final PBStringField qq_mini_program_url = PBField.initString("");
    public final PBInt32Field state = PBField.initInt32(0);
    public final PBStringField create_time = PBField.initString("");
    public final PBStringField product_pic = PBField.initString("");
    public final PBStringField product_title = PBField.initString("");
    public final PBInt64Field product_price = PBField.initInt64(0);
    public final PBInt64Field product_num = PBField.initInt64(0);
    public final PBStringField specification1 = PBField.initString("");
    public final PBStringField specification2 = PBField.initString("");
    public VacAdvGetAccess$MiniProgramInfo wx_mini_program = new MessageMicro<VacAdvGetAccess$MiniProgramInfo>() { // from class: VAC_ADV_GET_ACCESS.VacAdvGetAccess$MiniProgramInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"username", "path", "type", "app_id"}, new Object[]{"", "", "", ""}, VacAdvGetAccess$MiniProgramInfo.class);
        public final PBStringField username = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public final PBStringField type = PBField.initString("");
        public final PBStringField app_id = PBField.initString("");
    };
    public VacAdvGetAccess$MiniProgramInfo qq_mini_program = new MessageMicro<VacAdvGetAccess$MiniProgramInfo>() { // from class: VAC_ADV_GET_ACCESS.VacAdvGetAccess$MiniProgramInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"username", "path", "type", "app_id"}, new Object[]{"", "", "", ""}, VacAdvGetAccess$MiniProgramInfo.class);
        public final PBStringField username = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public final PBStringField type = PBField.initString("");
        public final PBStringField app_id = PBField.initString("");
    };
    public final PBInt64Field product_id = PBField.initInt64(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBInt32Field share_media_id = PBField.initInt32(0);
    public final PBInt64Field root_id = PBField.initInt64(0);
}
