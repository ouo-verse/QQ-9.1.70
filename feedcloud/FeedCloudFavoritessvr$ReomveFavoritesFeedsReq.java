package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$ReomveFavoritesFeedsReq extends MessageMicro<FeedCloudFavoritessvr$ReomveFavoritesFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "feedsigns"}, new Object[]{0L, null}, FeedCloudFavoritessvr$ReomveFavoritesFeedsReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f398436id = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesFeedDetail> feedsigns = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesFeedDetail.class);
}
