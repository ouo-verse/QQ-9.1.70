package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$WangzheRecord extends MessageMicro<UserProxyCmdOuterClass$WangzheRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{QQPermissionConstants.Permission.AUIDO_GROUP, "use_cache", "update_time"}, new Object[]{null, Boolean.FALSE, 0L}, UserProxyCmdOuterClass$WangzheRecord.class);
    public UserProxyCmdOuterClass$Record record = new MessageMicro<UserProxyCmdOuterClass$Record>() { // from class: com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$Record
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 24, 32, 40, 50}, new String[]{"grade", "win_rate", "games_total", "mvp_total", "best_occupation", "best_heros"}, new Object[]{0L, Double.valueOf(0.0d), 0L, 0L, 0, null}, UserProxyCmdOuterClass$Record.class);
        public final PBInt64Field grade = PBField.initInt64(0);
        public final PBDoubleField win_rate = PBField.initDouble(0.0d);
        public final PBInt64Field games_total = PBField.initInt64(0);
        public final PBInt64Field mvp_total = PBField.initInt64(0);
        public final PBEnumField best_occupation = PBField.initEnum(0);
        public final PBRepeatMessageField<UserProxyCmdOuterClass$UserHeroInfo> best_heros = PBField.initRepeatMessage(UserProxyCmdOuterClass$UserHeroInfo.class);
    };
    public final PBBoolField use_cache = PBField.initBool(false);
    public final PBUInt64Field update_time = PBField.initUInt64(0);
}
