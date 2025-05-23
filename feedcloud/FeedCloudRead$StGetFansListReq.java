package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFansListReq extends MessageMicro<FeedCloudRead$StGetFansListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56}, new String[]{"extInfo", "userId", "attachInfo", "count", "busiReqData", "fansMethod", "from"}, new Object[]{null, "", "", 0L, ByteStringMicro.EMPTY, 0, 0L}, FeedCloudRead$StGetFansListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt64Field count = PBField.initInt64(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field fansMethod = PBField.initUInt32(0);
    public final PBInt64Field from = PBField.initInt64(0);
}
