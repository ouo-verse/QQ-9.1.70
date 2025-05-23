package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$ShareItem extends MessageMicro<FeedCloudWrite$ShareItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"to_uin", "type"}, new Object[]{"", 0}, FeedCloudWrite$ShareItem.class);
    public final PBStringField to_uin = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
