package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetGoodsDetailReq extends MessageMicro<FeedCloudRead$StGetGoodsDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "from", "entryFeed"}, new Object[]{null, 0, null}, FeedCloudRead$StGetGoodsDetailReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta$StFeed entryFeed = new FeedCloudMeta$StFeed();
}
