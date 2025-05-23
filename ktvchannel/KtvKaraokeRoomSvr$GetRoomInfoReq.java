package ktvchannel;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$GetRoomInfoReq extends MessageMicro<KtvKaraokeRoomSvr$GetRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", WadlProxyConsts.CHANNEL, "act_type", "info"}, new Object[]{0L, null, 0, null}, KtvKaraokeRoomSvr$GetRoomInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public KtvCommon$Channel channel = new KtvCommon$Channel();
    public final PBEnumField act_type = PBField.initEnum(0);
    public KtvKaraokeRoomSvr$RoomInfo info = new KtvKaraokeRoomSvr$RoomInfo();
}
