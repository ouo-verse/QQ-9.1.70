package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$SetRoomCliReq extends MessageMicro<OneLiveServerOuterClass$SetRoomCliReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 72, 82}, new String[]{"RegInfo", "AnchorID", "Scene", "BackScheme", "ShareQQScheme", "GuildID", "ChannelID", "ShareWxScheme", "AppID", "StartLiveScheme"}, new Object[]{null, 0L, 0, "", "", "", "", "", 0L, ""}, OneLiveServerOuterClass$SetRoomCliReq.class);
    public OneLiveServerOuterClass$SRegisterInfo RegInfo = new MessageMicro<OneLiveServerOuterClass$SRegisterInfo>() { // from class: com.tencent.icgame.trpc.yes.common.OneLiveServerOuterClass$SRegisterInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField RoomTitle = PBField.initString("");
        public final PBStringField CoverImg = PBField.initString("");
        public final PBDoubleField Longitude = PBField.initDouble(0.0d);
        public final PBDoubleField Latitude = PBField.initDouble(0.0d);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 25, 33}, new String[]{"RoomTitle", "CoverImg", "Longitude", "Latitude"}, new Object[]{"", "", valueOf, valueOf}, OneLiveServerOuterClass$SRegisterInfo.class);
        }
    };
    public final PBUInt64Field AnchorID = PBField.initUInt64(0);
    public final PBUInt32Field Scene = PBField.initUInt32(0);
    public final PBStringField BackScheme = PBField.initString("");
    public final PBStringField ShareQQScheme = PBField.initString("");
    public final PBStringField GuildID = PBField.initString("");
    public final PBStringField ChannelID = PBField.initString("");
    public final PBStringField ShareWxScheme = PBField.initString("");
    public final PBUInt64Field AppID = PBField.initUInt64(0);
    public final PBStringField StartLiveScheme = PBField.initString("");
}
