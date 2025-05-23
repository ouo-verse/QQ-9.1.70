package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$TransResp extends MessageMicro<msg_svc$TransResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "resp_tag", "resp_buff"}, new Object[]{0, "", 0, ByteStringMicro.EMPTY}, msg_svc$TransResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field resp_tag = PBField.initUInt32(0);
    public final PBBytesField resp_buff = PBField.initBytes(ByteStringMicro.EMPTY);
}
