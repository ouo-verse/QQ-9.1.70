package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$PayInfo extends MessageMicro<ExperienceSvipServerPB$PayInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField logo = PBField.initString("");
    public final PBStringField black_logo = PBField.initString("");
    public final PBRepeatMessageField<ExperienceSvipServerPB$Retain> retain = PBField.initRepeatMessage(ExperienceSvipServerPB$Retain.class);
    public final PBInt32Field recommend_index = PBField.initInt32(0);
    public final PBRepeatField<Integer> recommend_indexs = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBBoolField disable_send = PBField.initBool(false);
    public final PBBoolField disable_askfriend = PBField.initBool(false);
    public final PBBoolField disable_autopay = PBField.initBool(false);
    public final PBBoolField disable_privilege = PBField.initBool(false);
    public final PBBoolField disable_retain = PBField.initBool(false);
    public final PBRepeatMessageField<ExperienceSvipServerPB$MonthInfo> month_info = PBField.initRepeatMessage(ExperienceSvipServerPB$MonthInfo.class);
    public final PBStringField rule = PBField.initString("");
    public final PBBoolField disable_audit = PBField.initBool(false);

    static {
        String[] strArr = {"logo", "black_logo", "retain", "recommend_index", "recommend_indexs", "disable_send", "disable_askfriend", "disable_autopay", "disable_privilege", "disable_retain", "month_info", TransferConfig.ExtendParamFloats.KEY_RULE, "disable_audit"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104}, strArr, new Object[]{"", "", null, 0, 0, bool, bool, bool, bool, bool, null, "", bool}, ExperienceSvipServerPB$PayInfo.class);
    }
}
