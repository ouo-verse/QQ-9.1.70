package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StCancelPushRsp extends MessageMicro<CertifiedAccountWrite$StCancelPushRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CertifiedAccountWrite$StCancelPushRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
