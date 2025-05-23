package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StGetFollowingCountReq extends MessageMicro<Follow$StGetFollowingCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"business", "follower"}, new Object[]{"", ""}, Follow$StGetFollowingCountReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBStringField follower = PBField.initString("");
}
