package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$GetConfigRsp extends MessageMicro<CONTAINER_INTERFACE$GetConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"ext_info", Constants.Configs.CONFIGS, "debug_msgs", "resp_control_info"}, new Object[]{ByteStringMicro.EMPTY, null, "", null}, CONTAINER_INTERFACE$GetConfigRsp.class);
    public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CONTAINER_INTERFACE$RespConfig> configs = PBField.initRepeatMessage(CONTAINER_INTERFACE$RespConfig.class);
    public final PBRepeatField<String> debug_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public CONTAINER_INTERFACE$RespControlInfo resp_control_info = new CONTAINER_INTERFACE$RespControlInfo();
}
