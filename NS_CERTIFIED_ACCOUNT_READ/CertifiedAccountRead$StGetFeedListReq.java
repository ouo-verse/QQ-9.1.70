package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFeedListReq extends MessageMicro<CertifiedAccountRead$StGetFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 80, 90}, new String[]{"extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "source", "livePageInfo"}, new Object[]{null, 0, 0, null, ByteStringMicro.EMPTY, "", 0, ""}, CertifiedAccountRead$StGetFeedListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public CertifiedAccountMeta$StFeed feed = new CertifiedAccountMeta$StFeed();
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBStringField livePageInfo = PBField.initString("");
}
