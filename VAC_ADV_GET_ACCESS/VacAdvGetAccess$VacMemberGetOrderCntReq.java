package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacMemberGetOrderCntReq extends MessageMicro<VacAdvGetAccess$VacMemberGetOrderCntReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ware_house_id", "media_type", "buyer_id"}, new Object[]{102, 0, ""}, VacAdvGetAccess$VacMemberGetOrderCntReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(102);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBStringField buyer_id = PBField.initString("");
}
