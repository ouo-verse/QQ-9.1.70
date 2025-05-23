package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.sm.e;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedExtraInfo extends MessageMicro<FeedCloudMeta$StFeedExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, e.P}, new String[]{"publisherSchema", QCircleScheme.AttrQQPublish.INNER_JUMP, WadlProxyConsts.CHANNEL, "self_declaration", "daily", "security_review_status"}, new Object[]{"", null, 0, null, null, 0}, FeedCloudMeta$StFeedExtraInfo.class);
    public final PBStringField publisherSchema = PBField.initString("");
    public FeedCloudMeta$StFeedAppInnnerJumpInfo inner_jump = new FeedCloudMeta$StFeedAppInnnerJumpInfo();
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public FeedCloudMeta$FeedSelfDeclaration self_declaration = new FeedCloudMeta$FeedSelfDeclaration();
    public FeedCloudMeta$DailyInfo daily = new FeedCloudMeta$DailyInfo();
    public final PBUInt32Field security_review_status = PBField.initUInt32(0);
}
