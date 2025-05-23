package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCommInfo extends MessageMicro<FeedCloudMeta$StCommInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField pubType = PBField.initEnum(0);
    public final PBEnumField contentCategory = PBField.initEnum(0);
    public final PBBoolField isAddedFeed = PBField.initBool(false);
    public final PBBoolField show_qzone_auth_banner = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"pubType", "contentCategory", "isAddedFeed", "show_qzone_auth_banner"}, new Object[]{0, 0, bool, bool}, FeedCloudMeta$StCommInfo.class);
    }
}
