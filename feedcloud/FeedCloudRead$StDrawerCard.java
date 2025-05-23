package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StDrawerCard extends MessageMicro<FeedCloudRead$StDrawerCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", ITVKPlayerEventListener.KEY_USER_INFO, QCircleScheme.AttrDetail.FEED_INFO, "recomUserReason"}, new Object[]{0, null, null, ""}, FeedCloudRead$StDrawerCard.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public FeedCloudMeta$StUser userInfo = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StFeed feedInfo = new FeedCloudMeta$StFeed();
    public final PBStringField recomUserReason = PBField.initString("");
}
