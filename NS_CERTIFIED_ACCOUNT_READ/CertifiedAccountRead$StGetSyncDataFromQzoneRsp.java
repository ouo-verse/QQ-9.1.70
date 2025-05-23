package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetSyncDataFromQzoneRsp extends MessageMicro<CertifiedAccountRead$StGetSyncDataFromQzoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feeds", "isFinish"}, new Object[]{null, null, 0}, CertifiedAccountRead$StGetSyncDataFromQzoneRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
}
