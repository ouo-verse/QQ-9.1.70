package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ProcJoinHcReq extends MessageMicro<KtvKaraokeMikeSvr$ProcJoinHcReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{AudienceReportConst.ROOM_ID, "hc_tiny_id", "hc_nick_name", "mike_id"}, new Object[]{"", 0L, ByteStringMicro.EMPTY, ""}, KtvKaraokeMikeSvr$ProcJoinHcReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field hc_tiny_id = PBField.initUInt64(0);
    public final PBBytesField hc_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField mike_id = PBField.initString("");
}
