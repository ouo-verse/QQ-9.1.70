package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$CateInfo extends MessageMicro<FeedCloudMeta$CateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cate", "subCate"}, new Object[]{"", ""}, FeedCloudMeta$CateInfo.class);
    public final PBStringField cate = PBField.initString("");
    public final PBStringField subCate = PBField.initString("");
}
