package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$QueryUserRequest extends MessageMicro<GameStrategyQAInvite$QueryUserRequest> {
    public static final int QUERY_CHECK_TITLE = 1;
    public static final int QUERY_GURU_CONFIG = 4;
    public static final int QUERY_QUALIFICATION = 8;
    public static final int QUERY_UIN_LIST = 2;
    public static final int QUERY_UNSPECIFIED = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"query", "appid", "uins"}, new Object[]{0, 0, 0L}, GameStrategyQAInvite$QueryUserRequest.class);
    public final PBEnumField query = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
