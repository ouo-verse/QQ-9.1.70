package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StLike;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoLikeRsp extends MessageMicro<CertifiedAccountWrite$StDoLikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "like"}, new Object[]{null, null}, CertifiedAccountWrite$StDoLikeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StLike like = new CertifiedAccountMeta$StLike();
}
