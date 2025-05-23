package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StGetTagBaseAllCategoryReq extends MessageMicro<FeedCloudTagbasesvr$StGetTagBaseAllCategoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"tagName", "useCache"}, new Object[]{"", Boolean.FALSE}, FeedCloudTagbasesvr$StGetTagBaseAllCategoryReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBBoolField useCache = PBField.initBool(false);
}
