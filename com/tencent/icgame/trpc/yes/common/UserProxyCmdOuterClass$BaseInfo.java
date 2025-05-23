package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$BaseInfo extends MessageMicro<UserProxyCmdOuterClass$BaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 66}, new String[]{"nick", "age", LpReport_UserInfo_dc02148.CONSTELLATION, "gender", "birthday", "self_birthday", "age_group", "city"}, new Object[]{"", 0, "", 0, null, null, "", ""}, UserProxyCmdOuterClass$BaseInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField constellation = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public UserProxyCmdOuterClass$Birthday birthday = new MessageMicro<UserProxyCmdOuterClass$Birthday>() { // from class: com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$Birthday
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, UserProxyCmdOuterClass$Birthday.class);
        public final PBUInt32Field year = PBField.initUInt32(0);
        public final PBUInt32Field month = PBField.initUInt32(0);
        public final PBUInt32Field day = PBField.initUInt32(0);
    };
    public UserProxyCmdOuterClass$Birthday self_birthday = new MessageMicro<UserProxyCmdOuterClass$Birthday>() { // from class: com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$Birthday
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, UserProxyCmdOuterClass$Birthday.class);
        public final PBUInt32Field year = PBField.initUInt32(0);
        public final PBUInt32Field month = PBField.initUInt32(0);
        public final PBUInt32Field day = PBField.initUInt32(0);
    };
    public final PBStringField age_group = PBField.initString("");
    public final PBStringField city = PBField.initString("");
}
