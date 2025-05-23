package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$blackUserMsg extends MessageMicro<LiveChatCheck$blackUserMsg> {
    public static final int PUNISH_LAUNCH_REASON_FIELD_NUMBER = 4;
    public static final int PUNISH_LAUNCH_TIME_FIELD_NUMBER = 3;
    public static final int PUNISH_LOGIN_REASON_FIELD_NUMBER = 2;
    public static final int PUNISH_LOGIN_TIME_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"punish_login_time", "punish_login_reason", "punish_launch_time", "punish_launch_reason"}, new Object[]{0, "", 0, ""}, LiveChatCheck$blackUserMsg.class);
    public final PBUInt32Field punish_login_time = PBField.initUInt32(0);
    public final PBStringField punish_login_reason = PBField.initString("");
    public final PBUInt32Field punish_launch_time = PBField.initUInt32(0);
    public final PBStringField punish_launch_reason = PBField.initString("");
}
