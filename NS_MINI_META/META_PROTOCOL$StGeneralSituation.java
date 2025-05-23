package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StGeneralSituation extends MessageMicro<META_PROTOCOL$StGeneralSituation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"dataType", "number", "dayContrast", "weekContrast", "monthContrast"}, new Object[]{1, 0L, "", "", ""}, META_PROTOCOL$StGeneralSituation.class);
    public final PBEnumField dataType = PBField.initEnum(1);
    public final PBUInt64Field number = PBField.initUInt64(0);
    public final PBStringField dayContrast = PBField.initString("");
    public final PBStringField weekContrast = PBField.initString("");
    public final PBStringField monthContrast = PBField.initString("");
}
