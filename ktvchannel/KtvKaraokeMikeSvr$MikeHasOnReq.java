package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$MikeHasOnReq extends MessageMicro<KtvKaraokeMikeSvr$MikeHasOnReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58}, new String[]{"mike_id", AudienceReportConst.ROOM_ID, "role_type", "device_type", "song_mid", "file_mid", "ext_info"}, new Object[]{"", "", 0, 0, "", "", null}, KtvKaraokeMikeSvr$MikeHasOnReq.class);
    public final PBStringField mike_id = PBField.initString("");
    public final PBStringField room_id = PBField.initString("");
    public final PBInt32Field role_type = PBField.initInt32(0);
    public final PBInt32Field device_type = PBField.initInt32(0);
    public final PBStringField song_mid = PBField.initString("");
    public final PBStringField file_mid = PBField.initString("");
    public final PBRepeatMessageField<KtvCommon$KVItem> ext_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
