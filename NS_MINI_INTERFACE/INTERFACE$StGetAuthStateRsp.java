package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetAuthStateRsp extends MessageMicro<INTERFACE$StGetAuthStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH}, new Object[]{null, null}, INTERFACE$StGetAuthStateRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StUserAuthInfo auth = new INTERFACE$StUserAuthInfo();
}
