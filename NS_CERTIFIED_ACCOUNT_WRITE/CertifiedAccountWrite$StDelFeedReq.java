package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StDelFeedReq extends MessageMicro<CertifiedAccountWrite$StDelFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feed", "from"}, new Object[]{null, null, 0}, CertifiedAccountWrite$StDelFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
}
