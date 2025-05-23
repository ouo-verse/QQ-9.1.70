package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StMessageStatus extends MessageMicro<CertifiedAccountMeta$StMessageStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"readStatus", "jumpURL", WadlProxyConsts.NOTICE_COUNT}, new Object[]{0, "", 0}, CertifiedAccountMeta$StMessageStatus.class);
    public final PBUInt32Field readStatus = PBField.initUInt32(0);
    public final PBStringField jumpURL = PBField.initString("");
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
}
