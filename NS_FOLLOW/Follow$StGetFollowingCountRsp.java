package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StGetFollowingCountRsp extends MessageMicro<Follow$StGetFollowingCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"followingCount"}, new Object[]{0}, Follow$StGetFollowingCountRsp.class);
    public final PBUInt32Field followingCount = PBField.initUInt32(0);
}
