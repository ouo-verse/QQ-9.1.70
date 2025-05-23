package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StDelUserAppRsp extends MessageMicro<INTERFACE$StDelUserAppRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StDelUserAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
