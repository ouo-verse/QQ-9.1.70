package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceCommon$UserInfo extends MessageMicro<FaceCommon$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"Name", "IDCardNumber"}, new Object[]{"", ""}, FaceCommon$UserInfo.class);
    public final PBStringField Name = PBField.initString("");
    public final PBStringField IDCardNumber = PBField.initString("");
}
