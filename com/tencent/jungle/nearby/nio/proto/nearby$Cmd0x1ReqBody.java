package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class nearby$Cmd0x1ReqBody extends MessageMicro<nearby$Cmd0x1ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_uid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_req_tinyid = PBField.initUInt64(0);
    public final PBBytesField bytes_user_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFixed32Field uint32_client_addr = PBField.initFixed32(0);
    public final PBBoolField bool_published = PBField.initBool(false);
    public final PBBoolField bool_bars = PBField.initBool(false);
    public final PBBoolField bool_fans = PBField.initBool(false);
    public final PBUInt64Field uint64_user_uid = PBField.initUInt64(0);
    public nearby$LoginSig user_login_sig = new MessageMicro<nearby$LoginSig>() { // from class: com.tencent.jungle.nearby.nio.proto.nearby$LoginSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, nearby$LoginSig.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBBoolField bool_face_score = PBField.initBool(false);
    public oidb_common$CommParamReq bytes_comm_param = new MessageMicro<oidb_common$CommParamReq>() { // from class: com.tencent.jungle.nearby.nio.proto.oidb_common$CommParamReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_version", "uint32_platform"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_common$CommParamReq.class);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    };
    public final PBUInt64Field uint64_req_nowid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_id_type = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 45, 48, 56, 64, 72, 82, 88, 96, 106, 112, 120}, new String[]{"uint32_seq", "uint64_req_uid", "uint64_req_tinyid", "bytes_user_cookie", "uint32_client_addr", "bool_published", "bool_bars", "bool_fans", "uint64_user_uid", "user_login_sig", "uint32_from", "bool_face_score", "bytes_comm_param", "uint64_req_nowid", "uint32_req_id_type"}, new Object[]{0, 0L, 0L, ByteStringMicro.EMPTY, 0, bool, bool, bool, 0L, null, 0, bool, null, 0L, 0}, nearby$Cmd0x1ReqBody.class);
    }
}
