package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GuideEntry extends MessageMicro<FeedCloudRead$GuideEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"jump_url", "jump_name", "name", "desc"}, new Object[]{"", "", "", ""}, FeedCloudRead$GuideEntry.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField jump_name = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
