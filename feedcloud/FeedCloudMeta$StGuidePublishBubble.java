package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StGuidePublishBubble extends MessageMicro<FeedCloudMeta$StGuidePublishBubble> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "backgroundImage", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{"", null, ""}, FeedCloudMeta$StGuidePublishBubble.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398451id = PBField.initString("");
    public FeedCloudMeta$StImage backgroundImage = new FeedCloudMeta$StImage();
    public final PBStringField jumpUrl = PBField.initString("");
}
