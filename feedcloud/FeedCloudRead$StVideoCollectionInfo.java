package feedcloud;

import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StVideoCollectionInfo extends MessageMicro<FeedCloudRead$StVideoCollectionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88}, new String[]{"collectionID", "collectionName", "collectionDesc", "cover", "authorSchema", MessageForQQStory.KEY_AUTHOR_NAME, "btnName", "btnSchema", "detail", "moreSchema", "btnIndex"}, new Object[]{"", "", "", "", "", "", "", "", null, "", 0}, FeedCloudRead$StVideoCollectionInfo.class);
    public final PBStringField collectionID = PBField.initString("");
    public final PBStringField collectionName = PBField.initString("");
    public final PBStringField collectionDesc = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField authorSchema = PBField.initString("");
    public final PBStringField authorName = PBField.initString("");
    public final PBStringField btnName = PBField.initString("");
    public final PBStringField btnSchema = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$StCollectionDetail> detail = PBField.initRepeatMessage(FeedCloudRead$StCollectionDetail.class);
    public final PBStringField moreSchema = PBField.initString("");
    public final PBInt32Field btnIndex = PBField.initInt32(0);
}
