package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StBgm extends MessageMicro<FeedCloudMeta$StBgm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"album_mid", "singer_mid", "song_mid"}, new Object[]{"", "", ""}, FeedCloudMeta$StBgm.class);
    public final PBStringField album_mid = PBField.initString("");
    public final PBStringField singer_mid = PBField.initString("");
    public final PBStringField song_mid = PBField.initString("");
}
