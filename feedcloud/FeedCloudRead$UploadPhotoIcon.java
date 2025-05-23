package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$UploadPhotoIcon extends MessageMicro<FeedCloudRead$UploadPhotoIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pag_url", "pag_url_dark"}, new Object[]{"", ""}, FeedCloudRead$UploadPhotoIcon.class);
    public final PBStringField pag_url = PBField.initString("");
    public final PBStringField pag_url_dark = PBField.initString("");
}
