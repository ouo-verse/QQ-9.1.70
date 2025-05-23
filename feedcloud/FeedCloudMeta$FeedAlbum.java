package feedcloud;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$FeedAlbum extends MessageMicro<FeedCloudMeta$FeedAlbum> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56, 66, 74, 80, 90}, new String[]{"id", "title", "feed_count", "owner", "cover_url", "status", "version_number", "description", "visitorInfo", AlbumCacheData.CREATE_TIME, "collection_info"}, new Object[]{0L, "", 0, null, "", 0, 0L, "", null, 0L, null}, FeedCloudMeta$FeedAlbum.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f398441id = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field feed_count = PBField.initUInt32(0);
    public FeedCloudMeta$StUser owner = new FeedCloudMeta$StUser();
    public final PBStringField cover_url = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt64Field version_number = PBField.initUInt64(0);
    public final PBStringField description = PBField.initString("");
    public FeedCloudMeta$StVisitor visitorInfo = new FeedCloudMeta$StVisitor();
    public final PBInt64Field create_time = PBField.initInt64(0);
    public FeedCloudMeta$CollectionInfo collection_info = new FeedCloudMeta$CollectionInfo();
}
