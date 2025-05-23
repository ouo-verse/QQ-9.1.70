package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetRecommendUserListReq extends MessageMicro<CertifiedAccountRead$StGetRecommendUserListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "listNum", "from", "userId"}, new Object[]{null, 0, 0, ""}, CertifiedAccountRead$StGetRecommendUserListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
}
