package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class CommProtocolProto$commRequest extends MessageMicro<CommProtocolProto$commRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field auth_appid;
    public final PBStringField auth_ip;
    public final PBBytesField auth_key;
    public final PBEnumField auth_type;
    public final PBBytesField body;
    public final PBStringField client_ipv6;
    public final PBStringField client_release;
    public final PBEnumField client_type;
    public final PBEnumField encode_type;
    public final PBBytesField extra_room_data;
    public final PBStringField from_id;
    public final PBUInt64Field microtime;
    public final PBEnumField network;
    public final PBStringField openid;
    public final PBUInt64Field original_auth_appid;
    public final PBBytesField original_id;
    public final PBUInt32Field original_id_type;
    public final PBBytesField original_key;
    public final PBUInt32Field original_key_type;
    public final PBStringField req_context;
    public final PBUInt32Field sdkappid;
    public final PBStringField service_cmd;
    public final PBUInt64Field tinyid;
    public final PBUInt64Field uid;
    public final PBUInt64Field uin;
    public final PBStringField user_sig;
    public final PBUInt32Field version = PBField.initUInt32(1);
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBStringField client_ip = PBField.initString("");
    public final PBStringField service_ip = PBField.initString("");
    public final PBStringField business = PBField.initString("");

    static {
        String[] strArr = {"version", "app_name", "cmd", "seq", "client_ip", "service_ip", "business", "auth_key", StartupReportKey.AUTH_TYPE, "auth_ip", "auth_appid", "uid", "uin", "openid", "body", "microtime", AudienceReportConst.CLIENT_TYPE, "client_release", "user_sig", "network", "from_id", "original_id", "original_key", "original_key_type", "original_id_type", "original_auth_appid", "tinyid", "client_ipv6", "sdkappid", "extra_room_data", "req_context", j.f247824o0, "encode_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 104, 114, 122, 128, 136, 146, 154, 160, 170, 178, 186, 192, 200, 208, 216, 226, 232, 242, 250, 258, 264}, strArr, new Object[]{1, "", 0, 0L, "", "", "", byteStringMicro, 0, "", 0L, 0L, 0L, "", byteStringMicro, 0L, 0, "", "", -1, "", byteStringMicro, byteStringMicro, 0, 0, 0L, 0L, "", 0, byteStringMicro, "", "", 0}, CommProtocolProto$commRequest.class);
    }

    public CommProtocolProto$commRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.auth_key = PBField.initBytes(byteStringMicro);
        this.auth_type = PBField.initEnum(0);
        this.auth_ip = PBField.initString("");
        this.auth_appid = PBField.initUInt64(0L);
        this.uid = PBField.initUInt64(0L);
        this.uin = PBField.initUInt64(0L);
        this.openid = PBField.initString("");
        this.body = PBField.initBytes(byteStringMicro);
        this.microtime = PBField.initUInt64(0L);
        this.client_type = PBField.initEnum(0);
        this.client_release = PBField.initString("");
        this.user_sig = PBField.initString("");
        this.network = PBField.initEnum(-1);
        this.from_id = PBField.initString("");
        this.original_id = PBField.initBytes(byteStringMicro);
        this.original_key = PBField.initBytes(byteStringMicro);
        this.original_key_type = PBField.initUInt32(0);
        this.original_id_type = PBField.initUInt32(0);
        this.original_auth_appid = PBField.initUInt64(0L);
        this.tinyid = PBField.initUInt64(0L);
        this.client_ipv6 = PBField.initString("");
        this.sdkappid = PBField.initUInt32(0);
        this.extra_room_data = PBField.initBytes(byteStringMicro);
        this.req_context = PBField.initString("");
        this.service_cmd = PBField.initString("");
        this.encode_type = PBField.initEnum(0);
    }
}
