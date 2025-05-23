package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StShare extends MessageMicro<FeedCloudMeta$StShare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112, 120, 130, 138, 146, 154, 162, 170}, new String[]{"title", "desc", "type", "url", "author", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "images", "publishTotalUser", "sharedCount", "qqNearByDetailUrl", "shareWebInfo", "feed_id", "prompt", "aio_pure_text", "url_infos"}, new Object[]{"", "", 0, "", null, null, null, null, "", "", null, ByteStringMicro.EMPTY, null, 0, 0, "", null, "", "", "", null}, FeedCloudMeta$StShare.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public FeedCloudMeta$StUser author = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StVideo video = new FeedCloudMeta$StVideo();
    public final PBStringField shorturl = PBField.initString("");
    public final PBStringField shareCardInfo = PBField.initString("");
    public FeedCloudMeta$StShareQzoneInfo shareQzoneInfo = new FeedCloudMeta$StShareQzoneInfo();
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudMeta$StImage> images = PBField.initRepeatMessage(FeedCloudMeta$StImage.class);
    public final PBUInt32Field publishTotalUser = PBField.initUInt32(0);
    public final PBUInt32Field sharedCount = PBField.initUInt32(0);
    public final PBStringField qqNearByDetailUrl = PBField.initString("");
    public FeedCloudMeta$StShareWebInfo shareWebInfo = new FeedCloudMeta$StShareWebInfo();
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField aio_pure_text = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StShareURLInfo> url_infos = PBField.initRepeatMessage(FeedCloudMeta$StShareURLInfo.class);
}
