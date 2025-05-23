package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGamePayRsp extends MessageMicro<MiniAppMidasPay$StGamePayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, MiniAppMidasPay$StGamePayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
