package ktvchannel;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$RoomInfo extends MessageMicro<KtvKaraokeRoomSvr$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"admin_uin", AudienceReportConst.ROOM_ID, WadlProxyConsts.CHANNEL, "kv_list", "admin_tiny_id"}, new Object[]{0L, "", null, null, 0L}, KtvKaraokeRoomSvr$RoomInfo.class);
    public final PBUInt64Field admin_uin = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
    public KtvCommon$Channel channel = new KtvCommon$Channel();
    public final PBRepeatMessageField<KtvCommon$KVItem> kv_list = PBField.initRepeatMessage(KtvCommon$KVItem.class);
    public final PBUInt64Field admin_tiny_id = PBField.initUInt64(0);
}
