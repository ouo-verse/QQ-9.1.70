package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StShadingWords extends MessageMicro<FeedCloudRead$StShadingWords> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feedID", "shadingWord"}, new Object[]{"", null}, FeedCloudRead$StShadingWords.class);
    public final PBStringField feedID = PBField.initString("");
    public FeedCloudMeta$StShadingWords shadingWord = new FeedCloudMeta$StShadingWords();
}
