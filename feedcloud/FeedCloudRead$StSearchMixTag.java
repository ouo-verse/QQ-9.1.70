package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchMixTag extends MessageMicro<FeedCloudRead$StSearchMixTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagInfo", "picBanner", "isShowTagMedal"}, new Object[]{null, null, Boolean.FALSE}, FeedCloudRead$StSearchMixTag.class);
    public FeedCloudMeta$StTagInfo tagInfo = new FeedCloudMeta$StTagInfo();
    public FeedCloudRead$StSearchMixTagBanner picBanner = new FeedCloudRead$StSearchMixTagBanner();
    public final PBBoolField isShowTagMedal = PBField.initBool(false);
}
