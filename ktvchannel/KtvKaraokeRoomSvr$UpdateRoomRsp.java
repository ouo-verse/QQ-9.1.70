package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$UpdateRoomRsp extends MessageMicro<KtvKaraokeRoomSvr$UpdateRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "info"}, new Object[]{null, null}, KtvKaraokeRoomSvr$UpdateRoomRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413029msg = new KtvCommon$ErrMsg();
    public KtvKaraokeRoomSvr$RoomInfo info = new KtvKaraokeRoomSvr$RoomInfo();
}
