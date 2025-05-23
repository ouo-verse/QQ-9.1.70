package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StTagChallenge extends MessageMicro<FeedCloudMeta$StTagChallenge> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"title", QQWinkConstants.TAB_SUBTITLE, "tagChallengeRank"}, new Object[]{"", "", 0}, FeedCloudMeta$StTagChallenge.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField subTitle = PBField.initString("");
    public final PBUInt32Field tagChallengeRank = PBField.initUInt32(0);
}
