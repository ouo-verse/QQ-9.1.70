package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StPushFeed extends MessageMicro<CertifiedAccountMeta$StPushFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"feedId", "cover", "userId", "title", "type", "feedCreateTime"}, new Object[]{"", null, "", "", 0, 0}, CertifiedAccountMeta$StPushFeed.class);
    public final PBStringField feedId = PBField.initString("");
    public CertifiedAccountMeta$StImage cover = new CertifiedAccountMeta$StImage();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field feedCreateTime = PBField.initUInt32(0);
}
