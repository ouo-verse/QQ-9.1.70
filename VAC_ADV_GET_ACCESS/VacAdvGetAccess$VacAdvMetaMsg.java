package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import common.QqAdGetProtos$QQAdGetRsp;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacAdvMetaMsg extends MessageMicro<VacAdvGetAccess$VacAdvMetaMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"adv_rsp", "insert_pos", "recomm_cookie"}, new Object[]{null, 0, ""}, VacAdvGetAccess$VacAdvMetaMsg.class);
    public QqAdGetProtos$QQAdGetRsp.AdInfo adv_rsp = new QqAdGetProtos$QQAdGetRsp.AdInfo();
    public final PBInt32Field insert_pos = PBField.initInt32(0);
    public final PBStringField recomm_cookie = PBField.initString("");
}
