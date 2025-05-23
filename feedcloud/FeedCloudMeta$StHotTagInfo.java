package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StHotTagInfo extends MessageMicro<FeedCloudMeta$StHotTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58}, new String[]{"id", "title", QQWinkConstants.TAB_SUBTITLE, "description", "rank", "cover", "shareInfo"}, new Object[]{"", "", "", "", 0, null, null}, FeedCloudMeta$StHotTagInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398452id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subTitle = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
}
