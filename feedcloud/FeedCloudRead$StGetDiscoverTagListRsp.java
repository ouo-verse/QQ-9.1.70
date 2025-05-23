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
public final class FeedCloudRead$StGetDiscoverTagListRsp extends MessageMicro<FeedCloudRead$StGetDiscoverTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "tagList", "attachInfo", "isFinish", "busiRspData"}, new Object[]{null, null, "", 0, ByteStringMicro.EMPTY}, FeedCloudRead$StGetDiscoverTagListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
