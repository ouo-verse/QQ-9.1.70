package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbBindUinMsgReadedConfirmResp extends MessageMicro<msg_svc$PbBindUinMsgReadedConfirmResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "sync_cookie", "bind_uin"}, new Object[]{0, "", ByteStringMicro.EMPTY, 0L}, msg_svc$PbBindUinMsgReadedConfirmResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0);
}
