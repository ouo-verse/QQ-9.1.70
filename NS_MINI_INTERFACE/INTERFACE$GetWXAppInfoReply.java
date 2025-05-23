package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetWXAppInfoReply extends MessageMicro<INTERFACE$GetWXAppInfoReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"retCode", "appIcon", "appAliasName", "appName", "appDesc", "appRegisterInfo", "appCategories"}, new Object[]{0, "", "", "", "", "", null}, INTERFACE$GetWXAppInfoReply.class);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField appAliasName = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField appDesc = PBField.initString("");
    public final PBStringField appRegisterInfo = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$AppCategories> appCategories = PBField.initRepeatMessage(INTERFACE$AppCategories.class);
}
