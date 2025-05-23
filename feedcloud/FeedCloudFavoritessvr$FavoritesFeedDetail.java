package feedcloud;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$FavoritesFeedDetail extends MessageMicro<FeedCloudFavoritessvr$FavoritesFeedDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"id", "poster_id", AlbumCacheData.CREATE_TIME, "is_added"}, new Object[]{"", "", 0L, Boolean.FALSE}, FeedCloudFavoritessvr$FavoritesFeedDetail.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398433id = PBField.initString("");
    public final PBStringField poster_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBBoolField is_added = PBField.initBool(false);
}
