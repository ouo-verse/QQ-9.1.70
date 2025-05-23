package NS_MINI_SHARE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniProgramShare$StSendArkMsgReq extends MessageMicro<MiniProgramShare$StSendArkMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"extInfo", "appId", "openId", "arkJson", "apiName"}, new Object[]{null, "", "", "", ""}, MiniProgramShare$StSendArkMsgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appId = PBField.initString("");
    public final PBStringField openId = PBField.initString("");
    public final PBStringField arkJson = PBField.initString("");
    public final PBStringField apiName = PBField.initString("");
}
