package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFollowListReq extends MessageMicro<CertifiedAccountRead$StGetFollowListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"extInfo", "seq", "attach_info", "count", "source"}, new Object[]{null, 0, "", 0, 0}, CertifiedAccountRead$StGetFollowListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
}
