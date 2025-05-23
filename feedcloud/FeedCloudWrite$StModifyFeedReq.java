package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StModifyFeedReq extends MessageMicro<FeedCloudWrite$StModifyFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, new String[]{"extInfo", "feed", "mBitmap", "from", "src", "modifyFeedExtInfo"}, new Object[]{null, null, 0L, 0, 0, null}, FeedCloudWrite$StModifyFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBUInt64Field mBitmap = PBField.initUInt64(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> modifyFeedExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
