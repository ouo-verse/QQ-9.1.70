package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StCheckFollowReq extends MessageMicro<Follow$StCheckFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"business", "follower", "star"}, new Object[]{"", "", ""}, Follow$StCheckFollowReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBStringField follower = PBField.initString("");
    public final PBStringField star = PBField.initString("");
}
