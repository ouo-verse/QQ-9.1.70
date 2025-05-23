package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StTagMedalInfo extends MessageMicro<FeedCloudMeta$StTagMedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagID", "tagName", "rank"}, new Object[]{"", "", 0L}, FeedCloudMeta$StTagMedalInfo.class);
    public final PBStringField tagID = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBUInt64Field rank = PBField.initUInt64(0);
}
