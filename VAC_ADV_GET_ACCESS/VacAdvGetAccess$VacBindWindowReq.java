package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacBindWindowReq extends MessageMicro<VacAdvGetAccess$VacBindWindowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 74, 82}, new String[]{"ware_house_id", "media_type", "content_type", "content_id", "content_name", "invitation_code", "group_owner_name", "group_owner_avatar_url", "invitation_code_str", "group_owner_openid"}, new Object[]{100, 0, 0, "", "", 0L, "", "", "", ""}, VacAdvGetAccess$VacBindWindowReq.class);
    public final PBEnumField ware_house_id = PBField.initEnum(100);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field content_type = PBField.initInt32(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField content_name = PBField.initString("");
    public final PBInt64Field invitation_code = PBField.initInt64(0);
    public final PBStringField group_owner_name = PBField.initString("");
    public final PBStringField group_owner_avatar_url = PBField.initString("");
    public final PBStringField invitation_code_str = PBField.initString("");
    public final PBStringField group_owner_openid = PBField.initString("");
}
