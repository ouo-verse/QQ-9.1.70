package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* loaded from: classes31.dex */
public final class PROTOCAL$StQWebReq extends MessageMicro<PROTOCAL$StQWebReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88}, new String[]{"Seq", "qua", "deviceInfo", "busiBuff", "traceid", "Module", "Cmdname", IProfileProtocolConst.PARAM_LOGIN_SIG, "Crypto", "Extinfo", "contentType"}, new Object[]{0L, "", "", ByteStringMicro.EMPTY, "", "", "", null, null, null, 0}, PROTOCAL$StQWebReq.class);
    public final PBUInt64Field Seq = PBField.initUInt64(0);
    public final PBStringField qua = PBField.initString("");
    public final PBStringField deviceInfo = PBField.initString("");
    public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField traceid = PBField.initString("");
    public final PBStringField Module = PBField.initString("");
    public final PBStringField Cmdname = PBField.initString("");
    public PROTOCAL$StAuthInfo loginSig = new MessageMicro<PROTOCAL$StAuthInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway.PROTOCAL$StAuthInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatMessageField<COMM$Entry> Extinfo;
        public final PBStringField appid;
        public final PBStringField openid;
        public final PBStringField platform;
        public final PBBytesField sessionkey;
        public final PBBytesField sig;
        public final PBUInt32Field type;
        public final PBStringField uin = PBField.initString("");

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.sig = PBField.initBytes(byteStringMicro);
            this.platform = PBField.initString("");
            this.type = PBField.initUInt32(0);
            this.appid = PBField.initString("");
            this.openid = PBField.initString("");
            this.sessionkey = PBField.initBytes(byteStringMicro);
            this.Extinfo = PBField.initRepeatMessage(COMM$Entry.class);
        }

        static {
            String[] strArr = {"uin", PreloadTRTCPlayerParams.KEY_SIG, "platform", "type", "appid", "openid", "sessionkey", "Extinfo"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66}, strArr, new Object[]{"", byteStringMicro, "", 0, "", "", byteStringMicro, null}, PROTOCAL$StAuthInfo.class);
        }
    };
    public PROTOCAL$StEncryption Crypto = new MessageMicro<PROTOCAL$StEncryption>() { // from class: com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway.PROTOCAL$StEncryption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"method", "iv"}, new Object[]{0, ""}, PROTOCAL$StEncryption.class);
        public final PBUInt32Field method = PBField.initUInt32(0);

        /* renamed from: iv, reason: collision with root package name */
        public final PBStringField f105224iv = PBField.initString("");
    };
    public final PBRepeatMessageField<COMM$Entry> Extinfo = PBField.initRepeatMessage(COMM$Entry.class);
    public final PBUInt32Field contentType = PBField.initUInt32(0);
}
