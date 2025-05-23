package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;

/* loaded from: classes28.dex */
public final class ExtendFriendABTestConfig$GrayPolicyInfo extends MessageMicro<ExtendFriendABTestConfig$GrayPolicyInfo> implements Serializable {
    static final transient MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"grayPolicyId", "paramsInfoList", "sGroupKey", "sStrategyType", "expKey"}, new Object[]{"", null, "", "", ""}, ExtendFriendABTestConfig$GrayPolicyInfo.class);
    public PBStringField grayPolicyId = PBField.initString("");
    public PBRepeatMessageField<ExtendFriendABTestConfig$ExtendFriendParamsInfo> paramsInfoList = PBField.initRepeatMessage(ExtendFriendABTestConfig$ExtendFriendParamsInfo.class);
    public PBStringField sGroupKey = PBField.initString("");
    public PBStringField sStrategyType = PBField.initString("");
    public PBStringField expKey = PBField.initString("");
}
