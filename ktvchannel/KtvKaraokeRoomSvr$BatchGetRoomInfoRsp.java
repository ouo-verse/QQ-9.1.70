package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$BatchGetRoomInfoRsp extends MessageMicro<KtvKaraokeRoomSvr$BatchGetRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info_list"}, new Object[]{null}, KtvKaraokeRoomSvr$BatchGetRoomInfoRsp.class);
    public final PBRepeatMessageField<KtvKaraokeRoomSvr$RoomInfo> info_list = PBField.initRepeatMessage(KtvKaraokeRoomSvr$RoomInfo.class);
}
