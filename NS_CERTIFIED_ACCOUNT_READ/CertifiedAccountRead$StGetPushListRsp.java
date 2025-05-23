package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StPushSet;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetPushListRsp extends MessageMicro<CertifiedAccountRead$StGetPushListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "vecPushFeed", "totalNum", "isFinish"}, new Object[]{null, null, 0, 0}, CertifiedAccountRead$StGetPushListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StPushSet> vecPushFeed = PBField.initRepeatMessage(CertifiedAccountMeta$StPushSet.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
}
