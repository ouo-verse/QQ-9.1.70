package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StEntry extends MessageMicro<CertifiedAccountMeta$StEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"cover", "title", "updateCount", "type"}, new Object[]{null, "", 0, 0}, CertifiedAccountMeta$StEntry.class);
    public CertifiedAccountMeta$StImage cover = new CertifiedAccountMeta$StImage();
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field updateCount = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
