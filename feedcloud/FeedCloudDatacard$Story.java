package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudDatacard$Story extends MessageMicro<FeedCloudDatacard$Story> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "img_url", "video_url"}, new Object[]{0, "", ""}, FeedCloudDatacard$Story.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField img_url = PBField.initString("");
    public final PBStringField video_url = PBField.initString("");
}
