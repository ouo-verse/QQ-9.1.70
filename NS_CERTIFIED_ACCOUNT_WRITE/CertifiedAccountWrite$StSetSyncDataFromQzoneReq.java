package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StSetSyncDataFromQzoneReq extends MessageMicro<CertifiedAccountWrite$StSetSyncDataFromQzoneReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "feeds"}, new Object[]{null, null}, CertifiedAccountWrite$StSetSyncDataFromQzoneReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
}
