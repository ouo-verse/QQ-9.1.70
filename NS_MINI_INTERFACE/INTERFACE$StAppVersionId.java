package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppVersionId extends MessageMicro<INTERFACE$StAppVersionId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appId", "versionId"}, new Object[]{"", ""}, INTERFACE$StAppVersionId.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
}
