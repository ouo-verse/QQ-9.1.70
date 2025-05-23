package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$TabRule extends MessageMicro<CONTAINER_INTERFACE$TabRule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QAdVrReportParams.ParamKey.EXPERIMENT_ID, "group_id", "experiment_param"}, new Object[]{"", "", ""}, CONTAINER_INTERFACE$TabRule.class);
    public final PBStringField experiment_id = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField experiment_param = PBField.initString("");
}
