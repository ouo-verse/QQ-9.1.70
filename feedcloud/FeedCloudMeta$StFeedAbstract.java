package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedAbstract extends MessageMicro<FeedCloudMeta$StFeedAbstract> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 64, 74, 82, 90, 98, 106, 112, 120, 128}, new String[]{"id", "title", QAdVrReport.ElementID.AD_POSTER, "pic", "type", WadlProxyConsts.CREATE_TIME, "video", "fuelNum", "content", "images", "countInfo", "extInfo", "right", "topFeed", "stFeedType", "security_review_status"}, new Object[]{"", "", null, null, 0, 0L, null, 0, "", null, null, null, null, Boolean.FALSE, 0, 0}, FeedCloudMeta$StFeedAbstract.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398450id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StImage pic = new FeedCloudMeta$StImage();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public FeedCloudMeta$StVideo video = new FeedCloudMeta$StVideo();
    public final PBUInt32Field fuelNum = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StImage> images = PBField.initRepeatMessage(FeedCloudMeta$StImage.class);
    public FeedCloudMeta$StFeedCount countInfo = new FeedCloudMeta$StFeedCount();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public FeedCloudMeta$StRight right = new FeedCloudMeta$StRight();
    public final PBBoolField topFeed = PBField.initBool(false);
    public final PBUInt32Field stFeedType = PBField.initUInt32(0);
    public final PBUInt32Field security_review_status = PBField.initUInt32(0);
}
