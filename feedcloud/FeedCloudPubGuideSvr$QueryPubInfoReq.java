package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$QueryPubInfoReq extends MessageMicro<FeedCloudPubGuideSvr$QueryPubInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"query_scene"}, new Object[]{0}, FeedCloudPubGuideSvr$QueryPubInfoReq.class);
    public final PBEnumField query_scene = PBField.initEnum(0);
}
