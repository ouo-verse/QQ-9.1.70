package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import common.QqAdGetProtos$QQAdGet;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacMemberGetGoodsListReq extends MessageMicro<VacAdvGetAccess$VacMemberGetGoodsListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90}, new String[]{"ware_house_id", "media_type", "content_type", "content_id", "trace_id", "buyer_id", "seller_id", "page_number", "page_size", "group_member_openid", "device_info"}, new Object[]{100, 0, 0, "", "", "", "", 0, 0, "", null}, VacAdvGetAccess$VacMemberGetGoodsListReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField buyer_id = PBField.initString("");
    public final PBStringField seller_id = PBField.initString("");
    public final PBInt32Field page_number = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBStringField group_member_openid = PBField.initString("");
    public QqAdGetProtos$QQAdGet.DeviceInfo device_info = new QqAdGetProtos$QQAdGet.DeviceInfo();
}
