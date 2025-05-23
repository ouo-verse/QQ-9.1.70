package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$CreateFavoritesReq extends MessageMicro<FeedCloudFavoritessvr$CreateFavoritesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"info", "isDraft", "feed_signs"}, new Object[]{null, Boolean.FALSE, null}, FeedCloudFavoritessvr$CreateFavoritesReq.class);
    public FeedCloudFavoritessvr$FavoritesInfo info = new FeedCloudFavoritessvr$FavoritesInfo();
    public final PBBoolField isDraft = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesFeedDetail> feed_signs = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesFeedDetail.class);
}
