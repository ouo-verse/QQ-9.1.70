package com.tencent.mobileqq.now.wnsilivehead;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.rmonitor.custom.ICustomDataEditor;

/* loaded from: classes9.dex */
public final class WnsHeadProto$ForwardReq extends MessageMicro<WnsHeadProto$ForwardReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busi_buf;
    public final PBBytesField client_id;
    public final PBUInt32Field codec;
    public final PBUInt32Field orginal_key_type;
    public final PBStringField original_id;
    public final PBUInt32Field original_id_type;
    public final PBStringField original_key;
    public final PBUInt32Field stream_type;
    public final PBUInt32Field target_env;
    public final PBStringField token;
    public final PBUInt32Field version_code;
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);

    /* renamed from: a2, reason: collision with root package name */
    public final PBStringField f254410a2 = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");

    static {
        String[] strArr = {"uid", "tinyid", ICustomDataEditor.STRING_ARRAY_PARAM_2, "platform", "version", "busi_buf", "version_code", "stream_type", "original_id", "original_key", "original_id_type", "codec", "token", "target_env", CommonConstant.ReqAccessTokenParam.CLIENT_ID, "orginal_key_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 56, 64, 74, 82, 88, 96, 106, 112, 130, 136}, strArr, new Object[]{0L, 0L, "", 0, "", byteStringMicro, 0, 0, "", "", 0, 0, "", 0, byteStringMicro, 0}, WnsHeadProto$ForwardReq.class);
    }

    public WnsHeadProto$ForwardReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busi_buf = PBField.initBytes(byteStringMicro);
        this.version_code = PBField.initUInt32(0);
        this.stream_type = PBField.initUInt32(0);
        this.original_id = PBField.initString("");
        this.original_key = PBField.initString("");
        this.original_id_type = PBField.initUInt32(0);
        this.codec = PBField.initUInt32(0);
        this.token = PBField.initString("");
        this.target_env = PBField.initUInt32(0);
        this.client_id = PBField.initBytes(byteStringMicro);
        this.orginal_key_type = PBField.initUInt32(0);
    }
}
