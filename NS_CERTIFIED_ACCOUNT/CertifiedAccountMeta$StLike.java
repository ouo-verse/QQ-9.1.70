package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StLike extends MessageMicro<CertifiedAccountMeta$StLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"id", "count", "status", "vecUser"}, new Object[]{"", 0, 0, null}, CertifiedAccountMeta$StLike.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24926id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta$StUser.class);
}
