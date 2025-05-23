package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetCommentListReq extends MessageMicro<CertifiedAccountRead$StGetCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "userId", "feedId", "listNum", "from"}, new Object[]{null, "", "", 0, 0}, CertifiedAccountRead$StGetCommentListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
}
