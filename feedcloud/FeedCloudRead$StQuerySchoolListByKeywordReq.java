package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StQuerySchoolListByKeywordReq extends MessageMicro<FeedCloudRead$StQuerySchoolListByKeywordReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"keyword", "count"}, new Object[]{"", 0}, FeedCloudRead$StQuerySchoolListByKeywordReq.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
}
