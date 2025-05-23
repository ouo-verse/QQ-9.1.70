package feedcloud;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$PicRecomEntry extends MessageMicro<FeedCloudTagcategorysvr$PicRecomEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"picId", "recomTags", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, ShortVideoConstants.PARAM_KEY_FILTER_ID, "exifInfo", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{"", "", "", "", null, null}, FeedCloudTagcategorysvr$PicRecomEntry.class);
    public final PBStringField picId = PBField.initString("");
    public final PBRepeatField<String> recomTags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField materialId = PBField.initString("");
    public final PBStringField filterId = PBField.initString("");
    public FeedCloudMeta$StExifInfo exifInfo = new FeedCloudMeta$StExifInfo();
    public final PBRepeatMessageField<FeedCloudTagcategorysvr$PicRecTags> tags = PBField.initRepeatMessage(FeedCloudTagcategorysvr$PicRecTags.class);
}
