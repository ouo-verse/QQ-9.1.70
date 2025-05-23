package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloBattleOBRouteInfo extends MessageMicro<YoloRoomOuterClass$YoloBattleOBRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"battle_ob_url", "battle_ob_expire_time", "battle_ob_status", "battle_ob_pic_url", "battle_ob_id"}, new Object[]{"", 0L, 0, "", 0L}, YoloRoomOuterClass$YoloBattleOBRouteInfo.class);
    public final PBStringField battle_ob_url = PBField.initString("");
    public final PBUInt64Field battle_ob_expire_time = PBField.initUInt64(0);
    public final PBUInt32Field battle_ob_status = PBField.initUInt32(0);
    public final PBStringField battle_ob_pic_url = PBField.initString("");
    public final PBInt64Field battle_ob_id = PBField.initInt64(0);
}
