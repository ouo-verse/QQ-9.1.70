package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StWeixinSDKAppInfo extends MessageMicro<INTERFACE$StWeixinSDKAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"appid", "appName", "appIcon", "appDesc", "appType"}, new Object[]{"", "", "", "", 0}, INTERFACE$StWeixinSDKAppInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField appDesc = PBField.initString("");
    public final PBUInt32Field appType = PBField.initUInt32(0);
}
