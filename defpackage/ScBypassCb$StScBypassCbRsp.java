package defpackage;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ScBypassCb$StScBypassCbRsp extends MessageMicro<ScBypassCb$StScBypassCbRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ""}, ScBypassCb$StScBypassCbRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
}
