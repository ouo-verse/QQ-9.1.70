package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoCollectReq extends MessageMicro<FeedCloudWrite$StDoCollectReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58}, new String[]{"extInfo", "from", "collectType", "collectAction", "feedAlbum", "feed", "collectionID"}, new Object[]{null, 0, 0, 0, null, null, ""}, FeedCloudWrite$StDoCollectReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field collectType = PBField.initUInt32(0);
    public final PBUInt32Field collectAction = PBField.initUInt32(0);
    public FeedCloudMeta$FeedAlbum feedAlbum = new FeedCloudMeta$FeedAlbum();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBStringField collectionID = PBField.initString("");
}
