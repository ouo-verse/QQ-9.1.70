package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ApplyMikeRsp extends MessageMicro<KtvKaraokeMikeSvr$ApplyMikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"err_info", "mike_id", AudienceReportConst.ROOM_ID, "song_mid"}, new Object[]{null, "", "", ""}, KtvKaraokeMikeSvr$ApplyMikeRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBStringField mike_id = PBField.initString("");
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField song_mid = PBField.initString("");
}
