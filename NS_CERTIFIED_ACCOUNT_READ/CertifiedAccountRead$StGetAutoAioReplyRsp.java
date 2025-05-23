package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StAutoAioReply;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetAutoAioReplyRsp extends MessageMicro<CertifiedAccountRead$StGetAutoAioReplyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "autoAioReply"}, new Object[]{null, null}, CertifiedAccountRead$StGetAutoAioReplyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StAutoAioReply autoAioReply = new CertifiedAccountMeta$StAutoAioReply();
}
