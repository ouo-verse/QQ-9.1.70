package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ExtendFriendABTestConfig$GetTabTestInfoRsp extends MessageMicro<ExtendFriendABTestConfig$GetTabTestInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"grayPolicyInfoList"}, new Object[]{null}, ExtendFriendABTestConfig$GetTabTestInfoRsp.class);
    public final PBRepeatMessageField<ExtendFriendABTestConfig$GrayPolicyInfo> grayPolicyInfoList = PBField.initRepeatMessage(ExtendFriendABTestConfig$GrayPolicyInfo.class);
}
