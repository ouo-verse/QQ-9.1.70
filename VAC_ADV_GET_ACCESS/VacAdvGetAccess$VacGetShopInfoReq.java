package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacGetShopInfoReq extends MessageMicro<VacAdvGetAccess$VacGetShopInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"ware_house_id", "media_type", "invitation_code", "invitation_code_str"}, new Object[]{100, 0, 0L, ""}, VacAdvGetAccess$VacGetShopInfoReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt64Field invitation_code = PBField.initInt64(0);
    public final PBStringField invitation_code_str = PBField.initString("");
}
