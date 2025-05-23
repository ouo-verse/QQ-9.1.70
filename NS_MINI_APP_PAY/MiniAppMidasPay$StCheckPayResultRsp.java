package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StCheckPayResultRsp extends MessageMicro<MiniAppMidasPay$StCheckPayResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "result"}, new Object[]{null, 0}, MiniAppMidasPay$StCheckPayResultRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
}
