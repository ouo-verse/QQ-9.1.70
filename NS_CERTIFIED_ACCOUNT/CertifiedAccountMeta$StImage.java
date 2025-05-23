package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StImage extends MessageMicro<CertifiedAccountMeta$StImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"url", "width", "height", "vecImageUrl", "fileId"}, new Object[]{"", 0, 0, null, ""}, CertifiedAccountMeta$StImage.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StImageUrl> vecImageUrl = PBField.initRepeatMessage(CertifiedAccountMeta$StImageUrl.class);
    public final PBStringField fileId = PBField.initString("");
}
