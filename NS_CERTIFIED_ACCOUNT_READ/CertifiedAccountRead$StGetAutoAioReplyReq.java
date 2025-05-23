package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetAutoAioReplyReq extends MessageMicro<CertifiedAccountRead$StGetAutoAioReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "sceneType"}, new Object[]{null, 0}, CertifiedAccountRead$StGetAutoAioReplyReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field sceneType = PBField.initUInt32(0);
}
