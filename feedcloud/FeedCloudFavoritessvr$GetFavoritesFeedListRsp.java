package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$GetFavoritesFeedListRsp extends MessageMicro<FeedCloudFavoritessvr$GetFavoritesFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"favorites", "feedsigns", PictureConst.KEY_HAS_MORE, "attach_info"}, new Object[]{null, null, Boolean.FALSE, ""}, FeedCloudFavoritessvr$GetFavoritesFeedListRsp.class);
    public FeedCloudFavoritessvr$FavoritesInfo favorites = new FeedCloudFavoritessvr$FavoritesInfo();
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesFeedDetail> feedsigns = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesFeedDetail.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
}
