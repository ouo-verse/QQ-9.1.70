package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvHeartbeatsSvr$RoomHeartBeatsRsp extends MessageMicro<KtvHeartbeatsSvr$RoomHeartBeatsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg", "heartbeats_interval"}, new Object[]{null, 0L}, KtvHeartbeatsSvr$RoomHeartBeatsRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413022msg = new KtvCommon$ErrMsg();
    public final PBUInt64Field heartbeats_interval = PBField.initUInt64(0);
}
