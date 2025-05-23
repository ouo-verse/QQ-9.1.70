package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$RecommendItem extends MessageMicro<FeedCloudMeta$RecommendItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"suggestion_word"}, new Object[]{""}, FeedCloudMeta$RecommendItem.class);
    public final PBStringField suggestion_word = PBField.initString("");
}
