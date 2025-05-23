package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StImageUrl extends MessageMicro<CertifiedAccountMeta$StImageUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"levelType", "url", "width", "height"}, new Object[]{0, "", 0, 0}, CertifiedAccountMeta$StImageUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
