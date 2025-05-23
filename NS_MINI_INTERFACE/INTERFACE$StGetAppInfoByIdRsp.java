package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetAppInfoByIdRsp extends MessageMicro<INTERFACE$StGetAppInfoByIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "appInfo"}, new Object[]{null, null}, INTERFACE$StGetAppInfoByIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StApiAppInfo appInfo = new INTERFACE$StApiAppInfo();
}
