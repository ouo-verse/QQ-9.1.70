package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$GameTeamUpBanner extends MessageMicro<GroupTopBannerNotifyPB$GameTeamUpBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 88, 96, 104, 114, 162}, new String[]{"is_multi", "url", "team_leader", "team_num", "team_max_num", "single_group_text", "multi_group_text"}, new Object[]{Boolean.FALSE, "", 0L, 0, 0, "", ""}, GroupTopBannerNotifyPB$GameTeamUpBanner.class);
    public final PBBoolField is_multi = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBUInt64Field team_leader = PBField.initUInt64(0);
    public final PBUInt32Field team_num = PBField.initUInt32(0);
    public final PBUInt32Field team_max_num = PBField.initUInt32(0);
    public final PBStringField single_group_text = PBField.initString("");
    public final PBStringField multi_group_text = PBField.initString("");
}
