package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacCpsGoodsListReq extends MessageMicro<VacAdvGetAccess$VacCpsGoodsListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"uid", "keyword", "category_list", "page_nu", "page_size"}, new Object[]{"", "", 0, 0, 0}, VacAdvGetAccess$VacCpsGoodsListReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField keyword = PBField.initString("");
    public final PBRepeatField<Integer> category_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field page_nu = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
}
