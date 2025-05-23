package com.tencent.icgame.trpc.qlive.trpc_fans_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcFansGroupOuterClass$LevelInfo extends MessageMicro<TrpcFansGroupOuterClass$LevelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"medal_icon", "level", "pre_level_score", "cur_score", "next_level_score", "has_next_level", "end_time"}, new Object[]{"", 0, 0, 0, 0, Boolean.FALSE, 0L}, TrpcFansGroupOuterClass$LevelInfo.class);
    public final PBStringField medal_icon = PBField.initString("");
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field pre_level_score = PBField.initUInt32(0);
    public final PBUInt32Field cur_score = PBField.initUInt32(0);
    public final PBUInt32Field next_level_score = PBField.initUInt32(0);
    public final PBBoolField has_next_level = PBField.initBool(false);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
}
