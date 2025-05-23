package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StNoticeCategoryItem extends MessageMicro<FeedCloudRead$StNoticeCategoryItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "category", UinConfigManager.KEY_ADS}, new Object[]{0, null, null}, FeedCloudRead$StNoticeCategoryItem.class);
    public final PBEnumField type = PBField.initEnum(0);
    public FeedCloudMeta$StNoticeCategory category = new FeedCloudMeta$StNoticeCategory();
    public FeedCloudMeta$StNotice notice = new FeedCloudMeta$StNotice();
}
