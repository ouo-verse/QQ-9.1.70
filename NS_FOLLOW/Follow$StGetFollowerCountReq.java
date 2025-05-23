package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StGetFollowerCountReq extends MessageMicro<Follow$StGetFollowerCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"business", "star"}, new Object[]{"", ""}, Follow$StGetFollowerCountReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBStringField star = PBField.initString("");
}
