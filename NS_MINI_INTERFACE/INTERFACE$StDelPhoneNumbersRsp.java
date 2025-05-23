package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class INTERFACE$StDelPhoneNumbersRsp extends MessageMicro<INTERFACE$StDelPhoneNumbersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StDelPhoneNumbersRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
