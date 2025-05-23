package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$GetMiniAppConfigRsp extends MessageMicro<CONTAINER_INTERFACE$GetMiniAppConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"ext_info", "resp_config", "resp_control_info", "pkg_info"}, new Object[]{ByteStringMicro.EMPTY, null, null, null}, CONTAINER_INTERFACE$GetMiniAppConfigRsp.class);
    public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public CONTAINER_INTERFACE$RespConfig resp_config = new MessageMicro<CONTAINER_INTERFACE$RespConfig>() { // from class: NS_MINI_INTERFACE.CONTAINER_INTERFACE$RespConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{VipFunCallConstants.KEY_GROUP, "version", "contents"}, new Object[]{"", 0, null}, CONTAINER_INTERFACE$RespConfig.class);
        public final PBStringField group = PBField.initString("");
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBRepeatMessageField<CONTAINER_INTERFACE$Content> contents = PBField.initRepeatMessage(CONTAINER_INTERFACE$Content.class);
    };
    public CONTAINER_INTERFACE$RespControlInfo resp_control_info = new CONTAINER_INTERFACE$RespControlInfo();
    public CONTAINER_INTERFACE$MiniAppContainer pkg_info = new CONTAINER_INTERFACE$MiniAppContainer();
}
