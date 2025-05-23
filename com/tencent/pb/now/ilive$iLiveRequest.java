package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive$iLiveRequest extends MessageMicro<ilive$iLiveRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field auth_appid;
    public final PBUInt32Field auth_ip;
    public final PBBytesField auth_key;
    public final PBUInt32Field auth_type;
    public final PBBytesField binary_body;
    public final PBStringField business;
    public final PBUInt64Field buss_id;
    public final PBUInt32Field client_ip;
    public final PBUInt32Field client_port;
    public final PBUInt32Field client_type;
    public final PBUInt32Field codec;

    /* renamed from: ex, reason: collision with root package name */
    public final PBBytesField f342140ex;
    public final PBUInt32Field flag;
    public final PBUInt64Field original_auth_appid;
    public final PBBytesField original_id;
    public final PBUInt32Field original_id_type;
    public final PBBytesField original_key;
    public final PBUInt32Field original_key_type;
    public final PBUInt32Field service_ip;
    public final PBUInt64Field tinyid;
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);

    static {
        String[] strArr = {"version", "cmd", "subcmd", "seq", "uid", "binary_body", "ex", AudienceReportConst.CLIENT_TYPE, "client_ip", "service_ip", "business", "auth_key", StartupReportKey.AUTH_TYPE, "auth_ip", "auth_appid", "tinyid", "client_port", "flag", "original_id", "original_key", "original_key_type", "original_id_type", "original_auth_appid", "buss_id", "codec"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154, 162, 168, 176, 184, 192, 200}, strArr, new Object[]{0, 0, 0, 0L, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, "", byteStringMicro, 0, 0, 0L, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0L, 0L, 0}, ilive$iLiveRequest.class);
    }

    public ilive$iLiveRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.binary_body = PBField.initBytes(byteStringMicro);
        this.f342140ex = PBField.initBytes(byteStringMicro);
        this.client_type = PBField.initUInt32(0);
        this.client_ip = PBField.initUInt32(0);
        this.service_ip = PBField.initUInt32(0);
        this.business = PBField.initString("");
        this.auth_key = PBField.initBytes(byteStringMicro);
        this.auth_type = PBField.initUInt32(0);
        this.auth_ip = PBField.initUInt32(0);
        this.auth_appid = PBField.initUInt64(0L);
        this.tinyid = PBField.initUInt64(0L);
        this.client_port = PBField.initUInt32(0);
        this.flag = PBField.initUInt32(0);
        this.original_id = PBField.initBytes(byteStringMicro);
        this.original_key = PBField.initBytes(byteStringMicro);
        this.original_key_type = PBField.initUInt32(0);
        this.original_id_type = PBField.initUInt32(0);
        this.original_auth_appid = PBField.initUInt64(0L);
        this.buss_id = PBField.initUInt64(0L);
        this.codec = PBField.initUInt32(0);
    }
}
