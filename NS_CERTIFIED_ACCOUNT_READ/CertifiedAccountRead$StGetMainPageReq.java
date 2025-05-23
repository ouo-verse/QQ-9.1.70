package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetMainPageReq extends MessageMicro<CertifiedAccountRead$StGetMainPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "userId", "from"}, new Object[]{null, "", 0}, CertifiedAccountRead$StGetMainPageReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
}
