package ktvchannel;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMemberSvr$MemberInfo extends MessageMicro<KtvKaraokeMemberSvr$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uin", INetChannelCallback.KEY_TINY_ID, AudienceReportConst.ROOM_ID, "status"}, new Object[]{0L, 0L, "", 0}, KtvKaraokeMemberSvr$MemberInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
}
