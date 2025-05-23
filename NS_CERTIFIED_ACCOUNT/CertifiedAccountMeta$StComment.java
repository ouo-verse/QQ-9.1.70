package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StComment extends MessageMicro<CertifiedAccountMeta$StComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 58}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "vecAtUin", "replyCount", "vecReply"}, new Object[]{"", null, 0L, "", 0L, 0, null}, CertifiedAccountMeta$StComment.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24924id = PBField.initString("");
    public CertifiedAccountMeta$StUser postUser = new CertifiedAccountMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field replyCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StReply> vecReply = PBField.initRepeatMessage(CertifiedAccountMeta$StReply.class);
}
