package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$OrderStateInfo extends MessageMicro<VacAdvGetAccess$OrderStateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"state", "total_num"}, new Object[]{0, 0}, VacAdvGetAccess$OrderStateInfo.class);
    public final PBInt32Field state = PBField.initInt32(0);
    public final PBInt32Field total_num = PBField.initInt32(0);
}
