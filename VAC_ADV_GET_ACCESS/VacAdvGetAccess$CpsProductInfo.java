package VAC_ADV_GET_ACCESS;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class VacAdvGetAccess$CpsProductInfo extends MessageMicro<VacAdvGetAccess$CpsProductInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "catelog_id", "product_token"}, new Object[]{0L, 0L, ""}, VacAdvGetAccess$CpsProductInfo.class);
    public final PBUInt64Field product_id = PBField.initUInt64(0);
    public final PBUInt64Field catelog_id = PBField.initUInt64(0);
    public final PBStringField product_token = PBField.initString("");
}
