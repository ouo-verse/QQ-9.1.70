package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$ShareTarget extends MessageMicro<FeedCloudWrite$ShareTarget> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"dest_uin", "type"}, new Object[]{"", 0}, FeedCloudWrite$ShareTarget.class);
    public final PBStringField dest_uin = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
