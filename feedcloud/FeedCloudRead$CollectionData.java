package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$CollectionData extends MessageMicro<FeedCloudRead$CollectionData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"albumList", "feeds"}, new Object[]{null, null}, FeedCloudRead$CollectionData.class);
    public final PBRepeatMessageField<FeedCloudMeta$FeedAlbum> albumList = PBField.initRepeatMessage(FeedCloudMeta$FeedAlbum.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
