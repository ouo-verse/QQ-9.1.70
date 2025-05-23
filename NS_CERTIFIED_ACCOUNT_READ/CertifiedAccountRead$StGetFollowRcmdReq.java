package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFollowRcmdReq extends MessageMicro<CertifiedAccountRead$StGetFollowRcmdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CertifiedAccountRead$StGetFollowRcmdReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
