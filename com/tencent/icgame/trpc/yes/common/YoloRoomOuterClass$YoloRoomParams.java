package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tenpay.sdk.util.UinConfigManager;

/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomParams extends MessageMicro<YoloRoomOuterClass$YoloRoomParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 66, 74, 80, 88, 98, 104, 112, 122, 130, 800}, new String[]{"room_type", "is_private", "introduce", "theme", "background", "create_from", "voice_switch", UinConfigManager.KEY_ADS, "room_cover", "guild_id", "channel_id", "channel_name", "sub_create_from", "ignore_online_route", "show_nick", "channel_tinyid", AudienceReportConst.ROOM_ID}, new Object[]{0, 0, "", 0, 0, 0, 0, "", "", 0L, 0L, "", 0, Boolean.FALSE, "", "", 0L}, YoloRoomOuterClass$YoloRoomParams.class);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBInt32Field is_private = PBField.initInt32(0);
    public final PBStringField introduce = PBField.initString("");
    public final PBInt32Field theme = PBField.initInt32(0);
    public final PBInt32Field background = PBField.initInt32(0);
    public final PBInt32Field create_from = PBField.initInt32(0);
    public final PBInt32Field voice_switch = PBField.initInt32(0);
    public final PBStringField notice = PBField.initString("");
    public final PBStringField room_cover = PBField.initString("");
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBStringField show_nick = PBField.initString("");
    public final PBStringField channel_tinyid = PBField.initString("");
    public final PBInt32Field sub_create_from = PBField.initInt32(0);
    public final PBBoolField ignore_online_route = PBField.initBool(false);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
