package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFollowListReq extends MessageMicro<FeedCloudRead$StGetFollowListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56, 64}, new String[]{"extInfo", "userId", "attachInfo", "count", "busiReqData", "filterRelation", "sortType", "followMethod"}, new Object[]{null, "", "", 0, ByteStringMicro.EMPTY, 0, 0, 0}, FeedCloudRead$StGetFollowListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField filterRelation = PBField.initEnum(0);
    public final PBUInt32Field sortType = PBField.initUInt32(0);
    public final PBUInt32Field followMethod = PBField.initUInt32(0);
}
