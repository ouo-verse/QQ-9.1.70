package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_new_anchor_follow_interface$FollowActionReq extends MessageMicro<ilive_new_anchor_follow_interface$FollowActionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"anchor_uin", AudienceReportConst.CLIENT_TYPE, "source", "action", "root_roomid", "subroom_id", "anchor_nowid", "id_type"}, new Object[]{0L, 0, 0, 0, 0L, 0L, 0L, 0}, ilive_new_anchor_follow_interface$FollowActionReq.class);
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt64Field root_roomid = PBField.initUInt64(0);
    public final PBUInt64Field subroom_id = PBField.initUInt64(0);
    public final PBUInt64Field anchor_nowid = PBField.initUInt64(0);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
}
