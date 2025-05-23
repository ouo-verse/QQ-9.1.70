package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$AddSongListReq extends MessageMicro<KtvDataSvr$AddSongListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", AudienceReportConst.ROOM_ID, "song_mid"}, new Object[]{0L, "", ""}, KtvDataSvr$AddSongListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField song_mid = PBField.initString("");
}
