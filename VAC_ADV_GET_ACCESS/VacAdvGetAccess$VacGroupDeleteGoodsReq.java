package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacGroupDeleteGoodsReq extends MessageMicro<VacAdvGetAccess$VacGroupDeleteGoodsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"ware_house_id", "media_type", "content_type", "content_id", "product_list"}, new Object[]{100, 0, 0, "", 0L}, VacAdvGetAccess$VacGroupDeleteGoodsReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBRepeatField<Long> product_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
