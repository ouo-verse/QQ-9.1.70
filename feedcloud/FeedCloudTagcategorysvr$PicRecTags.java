package feedcloud;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$PicRecTags extends MessageMicro<FeedCloudTagcategorysvr$PicRecTags> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"recomTags", LocalPhotoFaceInfo.SCORE}, new Object[]{"", Float.valueOf(0.0f)}, FeedCloudTagcategorysvr$PicRecTags.class);
    public final PBStringField recomTags = PBField.initString("");
    public final PBFloatField score = PBField.initFloat(0.0f);
}
