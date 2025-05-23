package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$App extends MessageMicro<faceproto$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"AppID", "OpenID", "Sign", "Time"}, new Object[]{0, "", "", ""}, faceproto$App.class);
    public final PBUInt32Field AppID = PBField.initUInt32(0);
    public final PBStringField OpenID = PBField.initString("");
    public final PBStringField Sign = PBField.initString("");
    public final PBStringField Time = PBField.initString("");
}
