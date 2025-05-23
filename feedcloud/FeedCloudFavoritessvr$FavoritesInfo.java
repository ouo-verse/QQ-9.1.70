package feedcloud;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$FavoritesInfo extends MessageMicro<FeedCloudFavoritessvr$FavoritesInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 64, 72}, new String[]{"id", "title", "owner_id", "feed_num", "status", "cover_url", AlbumCacheData.CREATE_TIME, "last_modified_time", "newest_sort_time"}, new Object[]{0L, "", "", 0L, 0, "", 0L, 0L, 0L}, FeedCloudFavoritessvr$FavoritesInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f398434id = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField owner_id = PBField.initString("");
    public final PBInt64Field feed_num = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField cover_url = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field last_modified_time = PBField.initInt64(0);
    public final PBInt64Field newest_sort_time = PBField.initInt64(0);
}
