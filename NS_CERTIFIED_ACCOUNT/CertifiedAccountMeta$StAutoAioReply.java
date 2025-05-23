package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StAutoAioReply extends MessageMicro<CertifiedAccountMeta$StAutoAioReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"autoState", "replyType", "replyText", "replyImage"}, new Object[]{0, 0, "", null}, CertifiedAccountMeta$StAutoAioReply.class);
    public final PBUInt32Field autoState = PBField.initUInt32(0);
    public final PBUInt32Field replyType = PBField.initUInt32(0);
    public final PBStringField replyText = PBField.initString("");
    public CertifiedAccountMeta$StImage replyImage = new CertifiedAccountMeta$StImage();
}
