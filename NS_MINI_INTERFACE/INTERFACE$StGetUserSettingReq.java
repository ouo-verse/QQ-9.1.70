package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserSettingReq extends MessageMicro<INTERFACE$StGetUserSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"extInfo", "appid", "openid", "settingItem", "templateIds"}, new Object[]{null, "", "", "", ""}, INTERFACE$StGetUserSettingReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField settingItem = PBField.initString("");
    public final PBRepeatField<String> templateIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}
