package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoCommentRsp extends MessageMicro<CertifiedAccountWrite$StDoCommentRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "comment"}, new Object[]{null, null}, CertifiedAccountWrite$StDoCommentRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StComment comment = new CertifiedAccountMeta$StComment();
}
