package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloBattleRoomInfo extends MessageMicro<SmobaDataOuterClass$YoloBattleRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"roomid", "curmemnum", "maxmemnum", "memberlist", "battleinfo"}, new Object[]{null, 0, 0, null, null}, SmobaDataOuterClass$YoloBattleRoomInfo.class);
    public SmobaDataOuterClass$RoomID roomid = new SmobaDataOuterClass$RoomID();
    public final PBInt32Field curmemnum = PBField.initInt32(0);
    public final PBInt32Field maxmemnum = PBField.initInt32(0);
    public final PBRepeatMessageField<SmobaDataOuterClass$RoomMemberInfo> memberlist = PBField.initRepeatMessage(SmobaDataOuterClass$RoomMemberInfo.class);
    public SmobaDataOuterClass$RoomBattleInfo battleinfo = new MessageMicro<SmobaDataOuterClass$RoomBattleInfo>() { // from class: com.tencent.icgame.trpc.yes.common.SmobaDataOuterClass$RoomBattleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"mapacntnum", "maptype", "mapid", "pkai", "iswarmbattle"}, new Object[]{0, 0, 0, 0, 0}, SmobaDataOuterClass$RoomBattleInfo.class);
        public final PBUInt32Field mapacntnum = PBField.initUInt32(0);
        public final PBUInt32Field maptype = PBField.initUInt32(0);
        public final PBUInt32Field mapid = PBField.initUInt32(0);
        public final PBUInt32Field pkai = PBField.initUInt32(0);
        public final PBUInt32Field iswarmbattle = PBField.initUInt32(0);
    };
}
