package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacCpsGoodsDetailReq extends MessageMicro<VacAdvGetAccess$VacCpsGoodsDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uid", "goods_id", "ware_house_id"}, new Object[]{"", "", 0}, VacAdvGetAccess$VacCpsGoodsDetailReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField goods_id = PBField.initString("");
    public final PBInt32Field ware_house_id = PBField.initInt32(0);
}
