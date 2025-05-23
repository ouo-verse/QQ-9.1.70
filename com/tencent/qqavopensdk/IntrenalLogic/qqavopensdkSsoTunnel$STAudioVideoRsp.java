package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$STAudioVideoRsp extends MessageMicro<qqavopensdkSsoTunnel$STAudioVideoRsp> {
    public static final int RSPBODY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rspbody"}, new Object[]{null}, qqavopensdkSsoTunnel$STAudioVideoRsp.class);
    public qqavopensdkSsoTunnel$RspBody rspbody = new MessageMicro<qqavopensdkSsoTunnel$RspBody>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$RspBody
        public static final int BYTES_RSPBODY_FIELD_NUMBER = 2;
        public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_cmd_error_code", "bytes_rspbody"}, new Object[]{null, ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$RspBody.class);
        public qqavopensdkSsoTunnel$CmdErrorCode msg_cmd_error_code = new MessageMicro<qqavopensdkSsoTunnel$CmdErrorCode>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$CmdErrorCode
            public static final int BYTES_ERR_MSG_FIELD_NUMBER = 2;
            public static final int UINT32_CODE_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_code", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$CmdErrorCode.class);
            public final PBUInt32Field uint32_code = PBField.initUInt32(0);
            public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        public final PBBytesField bytes_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
