package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StGetWalletPayLinkRsp extends MessageMicro<MiniAppMidasPay$StGetWalletPayLinkRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK}, new Object[]{null, ""}, MiniAppMidasPay$StGetWalletPayLinkRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
}
