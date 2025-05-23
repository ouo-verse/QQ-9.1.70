package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StGetTagsBackendReq extends MessageMicro<FeedCloudTagcategorysvr$StGetTagsBackendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"count"}, new Object[]{0}, FeedCloudTagcategorysvr$StGetTagsBackendReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
}
