package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$STAudioVideoReq extends MessageMicro<qqavopensdkSsoTunnel$STAudioVideoReq> {
    public static final int GAMEID_FIELD_NUMBER = 2;
    public static final int REQBODY_FIELD_NUMBER = 1;
    public static final int ROOMID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"reqBody", VirtualAppProxy.KEY_GAME_ID, "roomId"}, new Object[]{null, 0, 0L}, qqavopensdkSsoTunnel$STAudioVideoReq.class);
    public qqavopensdkSsoTunnel$ReqBody reqBody = new MessageMicro<qqavopensdkSsoTunnel$ReqBody>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$ReqBody
        public static final int BYTES_REQBODY_FIELD_NUMBER = 2;
        public static final int MSG_SDK_DATA_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_sdk_data", "bytes_reqbody"}, new Object[]{null, ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$ReqBody.class);
        public qqavopensdkSsoTunnel$SdkData msg_sdk_data = new MessageMicro<qqavopensdkSsoTunnel$SdkData>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$SdkData
            public static final int BYTES_SDK_APP_TOKEN_FIELD_NUMBER = 2;
            public static final int CMLB_TEST_FIELD_NUMBER = 9;
            public static final int TINYID_FIELD_NUMBER = 10;
            public static final int UINT32_SDK_APP_ID_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 72, 82}, new String[]{"uint32_sdk_app_id", "bytes_sdk_app_token", "cmlb_test", "tinyid"}, new Object[]{0, ByteStringMicro.EMPTY, Boolean.FALSE, ""}, qqavopensdkSsoTunnel$SdkData.class);
            public final PBUInt32Field uint32_sdk_app_id = PBField.initUInt32(0);
            public final PBBytesField bytes_sdk_app_token = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBBoolField cmlb_test = PBField.initBool(false);
            public final PBStringField tinyid = PBField.initString("");
        };
        public final PBBytesField bytes_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field gameId = PBField.initUInt32(0);
    public final PBUInt64Field roomId = PBField.initUInt64(0);
}
