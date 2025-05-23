package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StCreateAccountRsp extends MessageMicro<CertifiedAccountWrite$StCreateAccountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CertifiedAccountWrite$StCreateAccountRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
