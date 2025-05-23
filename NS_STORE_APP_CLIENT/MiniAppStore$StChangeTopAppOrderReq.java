package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppStore$StChangeTopAppOrderReq extends MessageMicro<MiniAppStore$StChangeTopAppOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecAppInfo"}, new Object[]{null, null}, MiniAppStore$StChangeTopAppOrderReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
}
