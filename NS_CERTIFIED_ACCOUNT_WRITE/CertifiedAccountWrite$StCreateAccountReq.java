package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountWrite$StCreateAccountReq extends MessageMicro<CertifiedAccountWrite$StCreateAccountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"extInfo", "name", "desc", "logo", "adminqq"}, new Object[]{null, "", "", "", ""}, CertifiedAccountWrite$StCreateAccountReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField adminqq = PBField.initString("");
}
