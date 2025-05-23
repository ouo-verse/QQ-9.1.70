package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StReadControll extends MessageMicro<FeedCloudRead$StReadControll> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"weakConsistencyMode"}, new Object[]{Boolean.FALSE}, FeedCloudRead$StReadControll.class);
    public final PBBoolField weakConsistencyMode = PBField.initBool(false);
}
