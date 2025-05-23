package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StFollowReq extends MessageMicro<Follow$StFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 33, 40}, new String[]{"business", "follower", "star", "weight", VasLiveIPCModule.KEY_FOLLOW_TYPE}, new Object[]{"", "", "", Double.valueOf(0.0d), 0}, Follow$StFollowReq.class);
    public final PBStringField business = PBField.initString("");
    public final PBStringField follower = PBField.initString("");
    public final PBStringField star = PBField.initString("");
    public final PBDoubleField weight = PBField.initDouble(0.0d);
    public final PBInt32Field followType = PBField.initInt32(0);
}
