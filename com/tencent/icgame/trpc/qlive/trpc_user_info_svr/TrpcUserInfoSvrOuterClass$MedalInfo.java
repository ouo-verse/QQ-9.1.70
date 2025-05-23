package com.tencent.icgame.trpc.qlive.trpc_user_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcUserInfoSvrOuterClass$MedalInfo extends MessageMicro<TrpcUserInfoSvrOuterClass$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72, 80}, new String[]{"medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_version", "medal_level", "medal_bg", "medal_frame"}, new Object[]{0, "", "", 0, 0L, 0L, 0, 0, 0, 0}, TrpcUserInfoSvrOuterClass$MedalInfo.class);
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBStringField medal_name = PBField.initString("");
    public final PBStringField medal_face_small = PBField.initString("");
    public final PBUInt32Field medal_type = PBField.initUInt32(0);
    public final PBUInt64Field medal_start_time = PBField.initUInt64(0);
    public final PBUInt64Field medal_end_time = PBField.initUInt64(0);
    public final PBUInt32Field medal_version = PBField.initUInt32(0);
    public final PBUInt32Field medal_level = PBField.initUInt32(0);
    public final PBUInt32Field medal_bg = PBField.initUInt32(0);
    public final PBUInt32Field medal_frame = PBField.initUInt32(0);
}
