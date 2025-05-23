package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbC2CReadedReportResp extends MessageMicro<msg_svc$PbC2CReadedReportResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "sync_cookie"}, new Object[]{0, "", ByteStringMicro.EMPTY}, msg_svc$PbC2CReadedReportResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
