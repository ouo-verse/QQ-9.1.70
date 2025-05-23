package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$WXAppInfo extends MessageMicro<INTERFACE$WXAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80}, new String[]{"appid", "appIcon", "appAliasName", "appName", "appDesc", "appRegisterInfo", "appCategories", "errCode", "appType", "scene"}, new Object[]{"", "", "", "", "", "", null, "", 0, 0}, INTERFACE$WXAppInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField appAliasName = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField appDesc = PBField.initString("");
    public final PBStringField appRegisterInfo = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$AppCategories> appCategories = PBField.initRepeatMessage(INTERFACE$AppCategories.class);
    public final PBStringField errCode = PBField.initString("");
    public final PBUInt32Field appType = PBField.initUInt32(0);
    public final PBUInt32Field scene = PBField.initUInt32(0);
}
