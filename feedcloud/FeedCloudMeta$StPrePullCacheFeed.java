package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StPrePullCacheFeed extends MessageMicro<FeedCloudMeta$StPrePullCacheFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"id", QAdVrReport.ElementID.AD_POSTER, WadlProxyConsts.CREATE_TIME, "busiTranparent"}, new Object[]{"", null, 0L, null}, FeedCloudMeta$StPrePullCacheFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398456id = PBField.initString("");
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
