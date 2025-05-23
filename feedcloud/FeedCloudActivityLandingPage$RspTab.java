package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$RspTab extends MessageMicro<FeedCloudActivityLandingPage$RspTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"id", "name", "order"}, new Object[]{"", "", 0}, FeedCloudActivityLandingPage$RspTab.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398425id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field order = PBField.initInt32(0);
}
