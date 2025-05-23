package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchGameCollection extends MessageMicro<FeedCloudRead$StSearchGameCollection> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 82, 90, 98, 162, 170}, new String[]{"background", "detail", "app_id", "channel_id", "header", "icons", "image", "gift_bag", "props", "game", "report", "extInfo"}, new Object[]{"", null, "", "", null, null, null, null, null, null, null, null}, FeedCloudRead$StSearchGameCollection.class);
    public final PBStringField background = PBField.initString("");
    public FeedCloudRead$StSearchGameDetail detail = new FeedCloudRead$StSearchGameDetail();
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public FeedCloudRead$StSearchHeaderColumn header = new FeedCloudRead$StSearchHeaderColumn();
    public final PBRepeatMessageField<FeedCloudRead$StSearchIconItem> icons = PBField.initRepeatMessage(FeedCloudRead$StSearchIconItem.class);
    public FeedCloudRead$StSearchImage image = new FeedCloudRead$StSearchImage();
    public FeedCloudRead$StSearchGoods gift_bag = new FeedCloudRead$StSearchGoods();
    public FeedCloudRead$StSearchGoods props = new FeedCloudRead$StSearchGoods();
    public FeedCloudRead$StSearchGame game = new FeedCloudRead$StSearchGame();
    public FeedCloudCommon$StCommonExt report = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
