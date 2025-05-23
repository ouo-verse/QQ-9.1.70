package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StDelParentIndexRsp extends MessageMicro<FeedCloudTagbasesvr$StDelParentIndexRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"delCategoryInfo", "delTagInfo"}, new Object[]{null, null}, FeedCloudTagbasesvr$StDelParentIndexRsp.class);
    public FeedCloudTagbasesvr$StTagBaseInfo delCategoryInfo = new FeedCloudTagbasesvr$StTagBaseInfo();
    public FeedCloudTagbasesvr$StTagBaseInfo delTagInfo = new FeedCloudTagbasesvr$StTagBaseInfo();
}
