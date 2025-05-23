package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacShopUnbindWindowReq extends MessageMicro<VacAdvGetAccess$VacShopUnbindWindowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"ware_house_id", "media_type", "content_type", "content_id"}, new Object[]{100, 0, 0, ""}, VacAdvGetAccess$VacShopUnbindWindowReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
}
