package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StRight extends MessageMicro<FeedCloudMeta$StRight> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"ugcRight", "rightDisplayText", "iconUrl", WadlProxyConsts.KEY_JUMP_URL, "notAllowDownLoad", "commentRightFlag"}, new Object[]{null, "", "", "", Boolean.FALSE, 0}, FeedCloudMeta$StRight.class);
    public FeedCloudMeta$RightInfo ugcRight = new FeedCloudMeta$RightInfo();
    public final PBStringField rightDisplayText = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBBoolField notAllowDownLoad = PBField.initBool(false);
    public final PBEnumField commentRightFlag = PBField.initEnum(0);
}
