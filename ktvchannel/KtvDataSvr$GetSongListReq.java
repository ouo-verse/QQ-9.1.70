package ktvchannel;

import com.qzone.widget.u;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$GetSongListReq extends MessageMicro<KtvDataSvr$GetSongListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", AudienceReportConst.ROOM_ID, u.COLUMN_TAB_ID, "pass_back"}, new Object[]{0L, "", 0L, ""}, KtvDataSvr$GetSongListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field tab_id = PBField.initUInt64(0);
    public final PBStringField pass_back = PBField.initString("");
}
