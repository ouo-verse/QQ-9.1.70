package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$GetRoomSettingCliRsp extends MessageMicro<OneLiveServerOuterClass$GetRoomSettingCliRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField Status = PBField.initEnum(0);
    public final PBBoolField MingWenSwitch = PBField.initBool(false);
    public final PBEnumField JoinType = PBField.initEnum(0);
    public final PBBoolField CarSwitch = PBField.initBool(false);
    public final PBBoolField VersionSwitch = PBField.initBool(false);
    public final PBUInt64Field RoomID = PBField.initUInt64(0);
    public final PBStringField SchemeUrl = PBField.initString("");
    public final PBStringField GuildID = PBField.initString("");
    public final PBStringField ChannelID = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74}, new String[]{"Status", "MingWenSwitch", "JoinType", "CarSwitch", "VersionSwitch", "RoomID", "SchemeUrl", "GuildID", "ChannelID"}, new Object[]{0, bool, 0, bool, bool, 0L, "", "", ""}, OneLiveServerOuterClass$GetRoomSettingCliRsp.class);
    }
}
