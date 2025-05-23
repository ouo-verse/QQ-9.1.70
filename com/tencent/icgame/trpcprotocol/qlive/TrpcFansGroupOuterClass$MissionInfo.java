package com.tencent.icgame.trpcprotocol.qlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcFansGroupOuterClass$MissionInfo extends MessageMicro<TrpcFansGroupOuterClass$MissionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"upper_limit", "cur_score", "name", "mission_score", "action", "icon"}, new Object[]{0, 0, "", 0, null, ""}, TrpcFansGroupOuterClass$MissionInfo.class);
    public final PBUInt32Field upper_limit = PBField.initUInt32(0);
    public final PBUInt32Field cur_score = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field mission_score = PBField.initUInt32(0);
    public TrpcFansGroupOuterClass$MissionAction action = new MessageMicro<TrpcFansGroupOuterClass$MissionAction>() { // from class: com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$MissionAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "value"}, new Object[]{0, ""}, TrpcFansGroupOuterClass$MissionAction.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField value = PBField.initString("");
    };
    public final PBStringField icon = PBField.initString("");
}
