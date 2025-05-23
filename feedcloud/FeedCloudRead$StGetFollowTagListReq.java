package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFollowTagListReq extends MessageMicro<FeedCloudRead$StGetFollowTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "userId", "attachInfo", "count", "busiReqData"}, new Object[]{null, "", "", 0, ByteStringMicro.EMPTY}, FeedCloudRead$StGetFollowTagListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}
