package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StNotifyPayRecordToActbossRsp extends MessageMicro<MiniAppMidasPay$StNotifyPayRecordToActbossRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"extInfo", "total_pay", "surplus", "lottery_count"}, new Object[]{null, 0L, 0L, 0L}, MiniAppMidasPay$StNotifyPayRecordToActbossRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt64Field total_pay = PBField.initInt64(0);
    public final PBInt64Field surplus = PBField.initInt64(0);
    public final PBInt64Field lottery_count = PBField.initInt64(0);
}
