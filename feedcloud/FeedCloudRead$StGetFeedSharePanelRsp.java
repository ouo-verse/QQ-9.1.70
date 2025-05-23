package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedSharePanelRsp extends MessageMicro<FeedCloudRead$StGetFeedSharePanelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"share_info", "is_collect", "profile_card_cover_data"}, new Object[]{null, Boolean.FALSE, null}, FeedCloudRead$StGetFeedSharePanelRsp.class);
    public FeedCloudMeta$StShare share_info = new FeedCloudMeta$StShare();
    public final PBBoolField is_collect = PBField.initBool(false);
    public FeedCloudRead$ProfileCardCover profile_card_cover_data = new FeedCloudRead$ProfileCardCover();
}
