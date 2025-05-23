package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$Retain extends MessageMicro<ExperienceSvipServerPB$Retain> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56, 66, 74}, new String[]{"aid", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "cancel", "show_timing", "title", "day_limit", "week_limit", "description", "img"}, new Object[]{"", null, null, 0, "", 0, 0, "", ""}, ExperienceSvipServerPB$Retain.class);
    public final PBRepeatField<String> aid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public ExperienceSvipServerPB$Guide confirm = new MessageMicro<ExperienceSvipServerPB$Guide>() { // from class: com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Guide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"text", "type", "value", "aid"}, new Object[]{"", 0, "", ""}, ExperienceSvipServerPB$Guide.class);
        public final PBStringField text = PBField.initString("");
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField value = PBField.initString("");
        public final PBStringField aid = PBField.initString("");
    };
    public ExperienceSvipServerPB$Guide cancel = new MessageMicro<ExperienceSvipServerPB$Guide>() { // from class: com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Guide
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"text", "type", "value", "aid"}, new Object[]{"", 0, "", ""}, ExperienceSvipServerPB$Guide.class);
        public final PBStringField text = PBField.initString("");
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField value = PBField.initString("");
        public final PBStringField aid = PBField.initString("");
    };
    public final PBRepeatField<Integer> show_timing = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field day_limit = PBField.initInt32(0);
    public final PBInt32Field week_limit = PBField.initInt32(0);
    public final PBStringField description = PBField.initString("");
    public final PBStringField img = PBField.initString("");
}
