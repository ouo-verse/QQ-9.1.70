package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$CallFollow extends MessageMicro<FeedCloudRead$CallFollow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"isCanCall", "text"}, new Object[]{Boolean.FALSE, ""}, FeedCloudRead$CallFollow.class);
    public final PBBoolField isCanCall = PBField.initBool(false);
    public final PBStringField text = PBField.initString("");
}
