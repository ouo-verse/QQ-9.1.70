package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$LoginInfo extends MessageMicro<AioBubbleRecom$LoginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"opplat", "clientVer", "keyType"}, new Object[]{0, "", 0}, AioBubbleRecom$LoginInfo.class);
    public final PBInt32Field opplat = PBField.initInt32(0);
    public final PBStringField clientVer = PBField.initString("");
    public final PBInt32Field keyType = PBField.initInt32(0);
}
