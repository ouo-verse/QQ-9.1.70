package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;

/* loaded from: classes28.dex */
public final class ExtendFriendABTestConfig$ExtendFriendParamsInfo extends MessageMicro<ExtendFriendABTestConfig$ExtendFriendParamsInfo> implements Serializable {
    static final transient MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ExtendFriendABTestConfig$ExtendFriendParamsInfo.class);
    public PBStringField key = PBField.initString("");
    public PBStringField value = PBField.initString("");
}
