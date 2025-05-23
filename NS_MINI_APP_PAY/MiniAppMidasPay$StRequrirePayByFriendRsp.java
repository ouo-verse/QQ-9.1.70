package NS_MINI_APP_PAY;

import NS_COMM.COMM;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class MiniAppMidasPay$StRequrirePayByFriendRsp extends MessageMicro<MiniAppMidasPay$StRequrirePayByFriendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", AppConstants.Key.COLUMN_IS_VALID}, new Object[]{null, 0}, MiniAppMidasPay$StRequrirePayByFriendRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field isValid = PBField.initInt32(0);
}
