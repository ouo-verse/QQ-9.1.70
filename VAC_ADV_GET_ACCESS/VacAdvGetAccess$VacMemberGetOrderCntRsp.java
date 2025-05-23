package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacMemberGetOrderCntRsp extends MessageMicro<VacAdvGetAccess$VacMemberGetOrderCntRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"order_states"}, new Object[]{null}, VacAdvGetAccess$VacMemberGetOrderCntRsp.class);
    public final PBRepeatMessageField<VacAdvGetAccess$OrderStateInfo> order_states = PBField.initRepeatMessage(VacAdvGetAccess$OrderStateInfo.class);
}
