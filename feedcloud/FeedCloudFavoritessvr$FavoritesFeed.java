package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$FavoritesFeed extends MessageMicro<FeedCloudFavoritessvr$FavoritesFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48}, new String[]{"favorites_id", "feed_sign", "collect_time", "c_time", "owner_id", "sort_time"}, new Object[]{0L, null, 0L, 0L, "", 0L}, FeedCloudFavoritessvr$FavoritesFeed.class);
    public final PBUInt64Field favorites_id = PBField.initUInt64(0);
    public FeedCloudFavoritessvr$FavoritesFeedDetail feed_sign = new FeedCloudFavoritessvr$FavoritesFeedDetail();
    public final PBInt64Field collect_time = PBField.initInt64(0);
    public final PBInt64Field c_time = PBField.initInt64(0);
    public final PBStringField owner_id = PBField.initString("");
    public final PBInt64Field sort_time = PBField.initInt64(0);
}
