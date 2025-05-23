package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFeedDetailReq extends MessageMicro<CertifiedAccountRead$StGetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58}, new String[]{"extInfo", "from", "userId", "feedId", WadlProxyConsts.CREATE_TIME, "adres", "adAttchInfo"}, new Object[]{null, 0, "", "", 0L, ByteStringMicro.EMPTY, ""}, CertifiedAccountRead$StGetFeedDetailReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField adAttchInfo = PBField.initString("");
}
