package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacGetShopInfoRsp extends MessageMicro<VacAdvGetAccess$VacGetShopInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "shop_info"}, new Object[]{0, "", null}, VacAdvGetAccess$VacGetShopInfoRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public ShopInfo shop_info = new ShopInfo();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ShopInfo extends MessageMicro<ShopInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"media_name", "image_url"}, new Object[]{"", ""}, ShopInfo.class);
        public final PBStringField media_name = PBField.initString("");
        public final PBStringField image_url = PBField.initString("");
    }
}
