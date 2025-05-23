package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$MoveFavoritesFeedsReq extends MessageMicro<FeedCloudFavoritessvr$MoveFavoritesFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"src_id", "dst_id", "feedsigns", "need_new_favorites", "new_favorites_info"}, new Object[]{0L, 0L, null, Boolean.FALSE, null}, FeedCloudFavoritessvr$MoveFavoritesFeedsReq.class);
    public final PBUInt64Field src_id = PBField.initUInt64(0);
    public final PBUInt64Field dst_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesFeedDetail> feedsigns = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesFeedDetail.class);
    public final PBBoolField need_new_favorites = PBField.initBool(false);
    public FeedCloudFavoritessvr$FavoritesInfo new_favorites_info = new FeedCloudFavoritessvr$FavoritesInfo();
}
