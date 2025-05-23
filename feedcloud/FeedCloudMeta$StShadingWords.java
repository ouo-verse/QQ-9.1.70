package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StShadingWords extends MessageMicro<FeedCloudMeta$StShadingWords> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"text", "ext_info"}, new Object[]{"", null}, FeedCloudMeta$StShadingWords.class);
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> ext_info = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
