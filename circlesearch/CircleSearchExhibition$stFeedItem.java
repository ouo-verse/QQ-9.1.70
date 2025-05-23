package circlesearch;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StRecommendInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$stFeedItem extends MessageMicro<CircleSearchExhibition$stFeedItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 154, 162}, new String[]{"feed_id", "uid", AlbumCacheData.CREATE_TIME, "content_id", "ext_info", "recommend_info"}, new Object[]{"", "", 0L, 0L, null, null}, CircleSearchExhibition$stFeedItem.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBUInt64Field content_id = PBField.initUInt64(0);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StRecommendInfo recommend_info = new FeedCloudMeta$StRecommendInfo();
}
