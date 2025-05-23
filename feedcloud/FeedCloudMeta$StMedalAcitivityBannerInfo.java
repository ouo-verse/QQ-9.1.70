package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StMedalAcitivityBannerInfo extends MessageMicro<FeedCloudMeta$StMedalAcitivityBannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", "label", "joinText", "backUrl", "buttonText", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{"", "", "", "", "", ""}, FeedCloudMeta$StMedalAcitivityBannerInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField label = PBField.initString("");
    public final PBStringField joinText = PBField.initString("");
    public final PBStringField backUrl = PBField.initString("");
    public final PBStringField buttonText = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
}
