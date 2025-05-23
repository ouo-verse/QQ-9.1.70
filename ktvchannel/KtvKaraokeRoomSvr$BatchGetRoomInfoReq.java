package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$BatchGetRoomInfoReq extends MessageMicro<KtvKaraokeRoomSvr$BatchGetRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"room_id_list"}, new Object[]{""}, KtvKaraokeRoomSvr$BatchGetRoomInfoReq.class);
    public final PBRepeatField<String> room_id_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
