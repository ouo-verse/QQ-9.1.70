package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StFeedDeatilSecondaryLoadRsp extends MessageMicro<FeedCloudRead$StFeedDeatilSecondaryLoadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"share_info", "feedDrawer", "shadingWords", "quality_feedback_banner", "guide_info", "extInfo", "quick_share"}, new Object[]{null, null, null, null, null, null, null}, FeedCloudRead$StFeedDeatilSecondaryLoadRsp.class);
    public FeedCloudRead$StGetFeedSharePanelRsp share_info = new FeedCloudRead$StGetFeedSharePanelRsp();
    public FeedCloudRead$StFeedDrawer feedDrawer = new FeedCloudRead$StFeedDrawer();
    public final PBRepeatMessageField<FeedCloudRead$StShadingWords> shadingWords = PBField.initRepeatMessage(FeedCloudRead$StShadingWords.class);
    public FeedCloudRead$StChoiceQuestionBanner quality_feedback_banner = new FeedCloudRead$StChoiceQuestionBanner();
    public FeedCloudMeta$StGuideInfo guide_info = new FeedCloudMeta$StGuideInfo();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudRead$QuickShare quick_share = new FeedCloudRead$QuickShare();
}
