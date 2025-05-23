package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRecomTagListRsp extends MessageMicro<FeedCloudRead$StGetRecomTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "tagList", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudRead$StGetRecomTagListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
