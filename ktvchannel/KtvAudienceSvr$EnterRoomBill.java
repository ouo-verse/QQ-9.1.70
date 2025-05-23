package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$EnterRoomBill extends MessageMicro<KtvAudienceSvr$EnterRoomBill> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_info"}, new Object[]{null}, KtvAudienceSvr$EnterRoomBill.class);
    public KtvAudienceSvr$AudienceInfo user_info = new MessageMicro<KtvAudienceSvr$AudienceInfo>() { // from class: ktvchannel.KtvAudienceSvr$AudienceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58}, new String[]{"uin", AudienceReportConst.ROOM_ID, "timestamps", "last_heartbeats_time", "tinyid", "nick", "nickname"}, new Object[]{0L, "", 0L, 0L, 0L, "", ByteStringMicro.EMPTY}, KtvAudienceSvr$AudienceInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField room_id = PBField.initString("");
        public final PBUInt64Field timestamps = PBField.initUInt64(0);
        public final PBUInt64Field last_heartbeats_time = PBField.initUInt64(0);
        public final PBUInt64Field tinyid = PBField.initUInt64(0);
        public final PBStringField nick = PBField.initString("");
        public final PBBytesField nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
