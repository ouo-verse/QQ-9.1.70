package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class AioBubbleRecom$PayInfo extends MessageMicro<AioBubbleRecom$PayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"payUrl", "titleMsg", "textMsg", "buttonMsg"}, new Object[]{"", "", "", ""}, AioBubbleRecom$PayInfo.class);
    public final PBStringField payUrl = PBField.initString("");
    public final PBStringField titleMsg = PBField.initString("");
    public final PBStringField textMsg = PBField.initString("");
    public final PBStringField buttonMsg = PBField.initString("");
}
