package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.QqAdGetProtos$QQAdGet;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacAdvReq extends MessageMicro<VacAdvGetAccess$VacAdvReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 50}, new String[]{"qq", "device_info", "adv_pos", "vac_cps_req_info"}, new Object[]{0L, null, 0, null}, VacAdvGetAccess$VacAdvReq.class);

    /* renamed from: qq, reason: collision with root package name */
    public final PBUInt64Field f25136qq = PBField.initUInt64(0);
    public QqAdGetProtos$QQAdGet.DeviceInfo device_info = new QqAdGetProtos$QQAdGet.DeviceInfo();
    public final PBInt32Field adv_pos = PBField.initInt32(0);
    public VacAdvGetAccess$VacCpsReqInfo vac_cps_req_info = new MessageMicro<VacAdvGetAccess$VacCpsReqInfo>() { // from class: VAC_ADV_GET_ACCESS.VacAdvGetAccess$VacCpsReqInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26}, new String[]{"product_info"}, new Object[]{null}, VacAdvGetAccess$VacCpsReqInfo.class);
        public final PBRepeatMessageField<VacAdvGetAccess$CpsProductInfo> product_info = PBField.initRepeatMessage(VacAdvGetAccess$CpsProductInfo.class);
    };
}
