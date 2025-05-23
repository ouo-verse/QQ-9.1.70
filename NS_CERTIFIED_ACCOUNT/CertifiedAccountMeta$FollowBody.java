package NS_CERTIFIED_ACCOUNT;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$FollowBody extends MessageMicro<CertifiedAccountMeta$FollowBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"relation"}, new Object[]{null}, CertifiedAccountMeta$FollowBody.class);
    public CertifiedAccountMeta$Relation relation = new MessageMicro<CertifiedAccountMeta$Relation>() { // from class: NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$Relation
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "uin", "opTime", "op"}, new Object[]{0L, 0L, 0, 0}, CertifiedAccountMeta$Relation.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field opTime = PBField.initUInt32(0);

        /* renamed from: op, reason: collision with root package name */
        public final PBInt32Field f24922op = PBField.initInt32(0);
    };
}
