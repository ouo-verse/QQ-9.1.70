package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$GetActivityTabListRsp extends MessageMicro<FeedCloudActivityLandingPage$GetActivityTabListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"tab_list", "total"}, new Object[]{null, 0}, FeedCloudActivityLandingPage$GetActivityTabListRsp.class);
    public final PBRepeatMessageField<FeedCloudActivityLandingPage$RspTab> tab_list = PBField.initRepeatMessage(FeedCloudActivityLandingPage$RspTab.class);
    public final PBInt32Field total = PBField.initInt32(0);
}
