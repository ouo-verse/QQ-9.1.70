package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.QqAdGetProtos$QQAdGet;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacManagerGetGoodsListReq extends MessageMicro<VacAdvGetAccess$VacManagerGetGoodsListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66, 72}, new String[]{"ware_house_id", "media_type", "content_type", "content_id", "page_number", "page_size", "group_owner_openid", "device_info", "seller_id"}, new Object[]{100, 0, 0, "", 0, 0, "", null, 0L}, VacAdvGetAccess$VacManagerGetGoodsListReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBInt32Field page_number = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBStringField group_owner_openid = PBField.initString("");
    public QqAdGetProtos$QQAdGet.DeviceInfo device_info = new QqAdGetProtos$QQAdGet.DeviceInfo();
    public final PBUInt64Field seller_id = PBField.initUInt64(0);
}
