package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SafeMsg$SafeMoreInfo extends MessageMicro<SafeMsg$SafeMoreInfo> {
    public static final int STRFROMMOBILE_FIELD_NUMBER = 2;
    public static final int STRFROMNAME_FIELD_NUMBER = 3;
    public static final int STRMSGTXT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"strMsgTxt", "strFromMobile", "strFromName"}, new Object[]{"", "", ""}, SafeMsg$SafeMoreInfo.class);
    public static final SafeMsg$SafeMoreInfo __repeatHelper__ = new SafeMsg$SafeMoreInfo();
    public final PBStringField strMsgTxt = PBField.initString("");
    public final PBStringField strFromMobile = PBField.initString("");
    public final PBStringField strFromName = PBField.initString("");
}
