package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$GetRoomInfoRsp extends MessageMicro<KtvKaraokeRoomSvr$GetRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64}, new String[]{"msg", "sec_ret", "trtc_info", "info", "member_count", "mike_info", "member_limit", "role_type"}, new Object[]{null, null, null, null, 0L, null, 0, 0}, KtvKaraokeRoomSvr$GetRoomInfoRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413027msg = new KtvCommon$ErrMsg();
    public SecurityInfo$SecurityResult sec_ret = new MessageMicro<SecurityInfo$SecurityResult>() { // from class: ktvchannel.SecurityInfo$SecurityResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int64_action", "str_prompt", "str_detail"}, new Object[]{0L, "", ""}, SecurityInfo$SecurityResult.class);
        public final PBInt64Field int64_action = PBField.initInt64(0);
        public final PBStringField str_prompt = PBField.initString("");
        public final PBStringField str_detail = PBField.initString("");
    };
    public KtvKaraokeRoomSvr$TRTCInfo trtc_info = new MessageMicro<KtvKaraokeRoomSvr$TRTCInfo>() { // from class: ktvchannel.KtvKaraokeRoomSvr$TRTCInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"user_sig", "private_map_key", "sdk_app_id"}, new Object[]{"", "", 0}, KtvKaraokeRoomSvr$TRTCInfo.class);
        public final PBStringField user_sig = PBField.initString("");
        public final PBStringField private_map_key = PBField.initString("");
        public final PBUInt32Field sdk_app_id = PBField.initUInt32(0);
    };
    public KtvKaraokeRoomSvr$RoomInfo info = new KtvKaraokeRoomSvr$RoomInfo();
    public final PBInt64Field member_count = PBField.initInt64(0);
    public KtvKaraokeMikeSvr$KTVMikeInfo mike_info = new KtvKaraokeMikeSvr$KTVMikeInfo();
    public final PBInt32Field member_limit = PBField.initInt32(0);
    public final PBInt32Field role_type = PBField.initInt32(0);
}
