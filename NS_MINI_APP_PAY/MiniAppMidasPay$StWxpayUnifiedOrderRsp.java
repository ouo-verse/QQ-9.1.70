package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StWxpayUnifiedOrderRsp extends MessageMicro<MiniAppMidasPay$StWxpayUnifiedOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "body"}, new Object[]{null, ByteStringMicro.EMPTY}, MiniAppMidasPay$StWxpayUnifiedOrderRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
}
