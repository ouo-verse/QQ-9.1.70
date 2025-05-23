package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$RoomTabInfo extends MessageMicro<PremadesTeamServerOuterClass$RoomTabInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"name", EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "h5_link", "tab_red_point_info", "id"}, new Object[]{"", 0, "", null, ""}, PremadesTeamServerOuterClass$RoomTabInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBEnumField tab_type = PBField.initEnum(0);
    public final PBStringField h5_link = PBField.initString("");
    public PremadesTeamServerOuterClass$RoomTabRedPointInfo tab_red_point_info = new MessageMicro<PremadesTeamServerOuterClass$RoomTabRedPointInfo>() { // from class: com.tencent.icgame.trpc.yes.common.PremadesTeamServerOuterClass$RoomTabRedPointInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"is_show", "frequency_type", "frequency_rate", "red_point_type", "proposal", "id"}, new Object[]{Boolean.FALSE, 0, 0, 0, "", ""}, PremadesTeamServerOuterClass$RoomTabRedPointInfo.class);
        public final PBBoolField is_show = PBField.initBool(false);
        public final PBEnumField frequency_type = PBField.initEnum(0);
        public final PBInt32Field frequency_rate = PBField.initInt32(0);
        public final PBEnumField red_point_type = PBField.initEnum(0);
        public final PBStringField proposal = PBField.initString("");

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f116203id = PBField.initString("");
    };

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f116202id = PBField.initString("");
}
