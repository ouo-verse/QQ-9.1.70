package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StYuHengContentInfo extends MessageMicro<FeedCloudMeta$StYuHengContentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"vertices", "content_id"}, new Object[]{null, 0L}, FeedCloudMeta$StYuHengContentInfo.class);
    public FeedCloudMeta$FrameVertexInfo vertices = new FeedCloudMeta$FrameVertexInfo();
    public final PBInt64Field content_id = PBField.initInt64(0);
}
