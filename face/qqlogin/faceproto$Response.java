package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$Response extends MessageMicro<faceproto$Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"Ret", "ErrMsg", "IDKey", "NeedRetry", "redirect_url"}, new Object[]{0, "", "", Boolean.FALSE, ""}, faceproto$Response.class);
    public final PBUInt32Field Ret = PBField.initUInt32(0);
    public final PBStringField ErrMsg = PBField.initString("");
    public final PBStringField IDKey = PBField.initString("");
    public final PBBoolField NeedRetry = PBField.initBool(false);
    public final PBStringField redirect_url = PBField.initString("");
}
