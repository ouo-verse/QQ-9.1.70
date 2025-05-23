package face;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceForeignIp$AvailableResponse extends MessageMicro<FaceForeignIp$AvailableResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0, ""}, FaceForeignIp$AvailableResponse.class);
    public final PBEnumField ret = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398125msg = PBField.initString("");
}
