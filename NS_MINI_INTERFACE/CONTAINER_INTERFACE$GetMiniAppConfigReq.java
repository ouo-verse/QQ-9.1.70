package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$GetMiniAppConfigReq extends MessageMicro<CONTAINER_INTERFACE$GetMiniAppConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"common_info", "device_info", "user_info", "control_info", "appid"}, new Object[]{null, null, null, null, ""}, CONTAINER_INTERFACE$GetMiniAppConfigReq.class);
    public CONTAINER_INTERFACE$CommonInfo common_info = new CONTAINER_INTERFACE$CommonInfo();
    public CONTAINER_INTERFACE$DeviceInfo device_info = new CONTAINER_INTERFACE$DeviceInfo();
    public CONTAINER_INTERFACE$UserInfo user_info = new CONTAINER_INTERFACE$UserInfo();
    public CONTAINER_INTERFACE$ControlInfo control_info = new CONTAINER_INTERFACE$ControlInfo();
    public final PBStringField appid = PBField.initString("");
}
