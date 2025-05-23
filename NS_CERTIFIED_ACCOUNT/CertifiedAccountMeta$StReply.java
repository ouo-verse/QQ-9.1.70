package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StReply extends MessageMicro<CertifiedAccountMeta$StReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "targetUser", "vecAtUin"}, new Object[]{"", null, 0L, "", null, 0L}, CertifiedAccountMeta$StReply.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24928id = PBField.initString("");
    public CertifiedAccountMeta$StUser postUser = new CertifiedAccountMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public CertifiedAccountMeta$StUser targetUser = new CertifiedAccountMeta$StUser();
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
