package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StAppAdInfo extends MessageMicro<MiniAppAd$StAppAdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"strAppId", "iPosition", "strAdInfo"}, new Object[]{"", 0L, ""}, MiniAppAd$StAppAdInfo.class);
    public final PBStringField strAppId = PBField.initString("");
    public final PBInt64Field iPosition = PBField.initInt64(0);
    public final PBStringField strAdInfo = PBField.initString("");
}
