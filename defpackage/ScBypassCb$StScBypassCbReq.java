package defpackage;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ScBypassCb$StScBypassCbReq extends MessageMicro<ScBypassCb$StScBypassCbReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"msgid", IPublicAccountBrowser.KEY_PUB_UIN, "cmd", "hitReason", "beat_common", "appid", "src"}, new Object[]{"", 0L, 0, 0, 0, 0, 0}, ScBypassCb$StScBypassCbReq.class);
    public final PBStringField msgid = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field hitReason = PBField.initUInt32(0);
    public final PBUInt32Field beat_common = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field src = PBField.initUInt32(0);
}
