package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StGetFollowerCountRsp extends MessageMicro<Follow$StGetFollowerCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"followerCount"}, new Object[]{0}, Follow$StGetFollowerCountRsp.class);
    public final PBUInt32Field followerCount = PBField.initUInt32(0);
}
