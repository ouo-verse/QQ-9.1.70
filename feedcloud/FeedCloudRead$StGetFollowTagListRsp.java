package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFollowTagListRsp extends MessageMicro<FeedCloudRead$StGetFollowTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"extInfo", "attachInfo", "hasNext", "tagInfos", "busiRspData"}, new Object[]{null, "", 0, null, ByteStringMicro.EMPTY}, FeedCloudRead$StGetFollowTagListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
