package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StWxpayCheckMWebURLRsp extends MessageMicro<MiniAppMidasPay$StWxpayCheckMWebURLRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "is_valid"}, new Object[]{null, 0}, MiniAppMidasPay$StWxpayCheckMWebURLRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field is_valid = PBField.initInt32(0);
}
