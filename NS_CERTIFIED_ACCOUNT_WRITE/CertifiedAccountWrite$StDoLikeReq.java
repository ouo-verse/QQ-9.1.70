package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StLike;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDoLikeReq extends MessageMicro<CertifiedAccountWrite$StDoLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "likeType", "like", "feed"}, new Object[]{null, 0, null, null}, CertifiedAccountWrite$StDoLikeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field likeType = PBField.initUInt32(0);
    public CertifiedAccountMeta$StLike like = new CertifiedAccountMeta$StLike();
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
}
