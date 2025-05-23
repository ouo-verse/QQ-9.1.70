package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoReplyReq extends MessageMicro<CertifiedAccountWrite$StDoReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48}, new String[]{"extInfo", "replyType", "reply", "comment", "feed", "from"}, new Object[]{null, 0, null, null, null, 0}, CertifiedAccountWrite$StDoReplyReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field replyType = PBField.initUInt32(0);
    public CertifiedAccountMeta$StReply reply = new CertifiedAccountMeta$StReply();
    public CertifiedAccountMeta$StComment comment = new CertifiedAccountMeta$StComment();
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
}
