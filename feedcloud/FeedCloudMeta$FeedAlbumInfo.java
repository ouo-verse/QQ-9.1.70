package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$FeedAlbumInfo extends MessageMicro<FeedCloudMeta$FeedAlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"album", "feed_serial_number"}, new Object[]{null, 0}, FeedCloudMeta$FeedAlbumInfo.class);
    public FeedCloudMeta$FeedAlbum album = new FeedCloudMeta$FeedAlbum();
    public final PBUInt32Field feed_serial_number = PBField.initUInt32(0);
}
