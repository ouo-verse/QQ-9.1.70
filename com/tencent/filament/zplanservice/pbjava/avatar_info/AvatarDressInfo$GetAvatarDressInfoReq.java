package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$GetAvatarDressInfoReq extends MessageMicro<AvatarDressInfo$GetAvatarDressInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 66}, new String[]{"req_from", "gender", "req_header", "other_uins", "need_default_avatar", "dress_key", "male_default_dress_key", "female_default_dress_key"}, new Object[]{0, 0, null, "", Boolean.FALSE, null, null, null}, AvatarDressInfo$GetAvatarDressInfoReq.class);
    public final PBInt32Field req_from = PBField.initInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public AvatarDressInfo$ReqHeader req_header = new MessageMicro<AvatarDressInfo$ReqHeader>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$ReqHeader
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 58}, new String[]{"client_version", "trace_id", "client_seq", "client_cpp_version", ReportDataBuilder.KEY_PROTOCOL_VERSION, "cookie_info", "uin"}, new Object[]{"", 0L, 0L, "", 0, null, ""}, AvatarDressInfo$ReqHeader.class);
        public final PBStringField client_version = PBField.initString("");
        public final PBUInt64Field trace_id = PBField.initUInt64(0);
        public final PBUInt64Field client_seq = PBField.initUInt64(0);
        public final PBStringField client_cpp_version = PBField.initString("");
        public final PBInt32Field protocol_version = PBField.initInt32(0);
        public AvatarDressInfo$CookieInfo cookie_info = new MessageMicro<AvatarDressInfo$CookieInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$CookieInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"ip", "port", "token"}, new Object[]{"", 0, 0L}, AvatarDressInfo$CookieInfo.class);

            /* renamed from: ip, reason: collision with root package name */
            public final PBStringField f106418ip = PBField.initString("");
            public final PBUInt32Field port = PBField.initUInt32(0);
            public final PBUInt64Field token = PBField.initUInt64(0);
        };
        public final PBStringField uin = PBField.initString("");
    };
    public final PBRepeatField<String> other_uins = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField need_default_avatar = PBField.initBool(false);
    public AvatarDressInfo$DressKey dress_key = new AvatarDressInfo$DressKey();
    public AvatarDressInfo$DressKey male_default_dress_key = new AvatarDressInfo$DressKey();
    public AvatarDressInfo$DressKey female_default_dress_key = new AvatarDressInfo$DressKey();
}
