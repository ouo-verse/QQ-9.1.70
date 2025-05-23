package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFollowRcmd;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFollowRcmdRsp extends MessageMicro<CertifiedAccountRead$StGetFollowRcmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "rcmdList"}, new Object[]{null, null}, CertifiedAccountRead$StGetFollowRcmdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StFollowRcmd> rcmdList = PBField.initRepeatMessage(CertifiedAccountMeta$StFollowRcmd.class);
}
