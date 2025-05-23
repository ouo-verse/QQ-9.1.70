package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StAutoAioReply;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StModAutoAioReplyReq extends MessageMicro<CertifiedAccountWrite$StModAutoAioReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "sceneType", "modType", "autoAioReply"}, new Object[]{null, 0, 0, null}, CertifiedAccountWrite$StModAutoAioReplyReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field sceneType = PBField.initUInt32(0);
    public final PBUInt32Field modType = PBField.initUInt32(0);
    public CertifiedAccountMeta$StAutoAioReply autoAioReply = new CertifiedAccountMeta$StAutoAioReply();
}
