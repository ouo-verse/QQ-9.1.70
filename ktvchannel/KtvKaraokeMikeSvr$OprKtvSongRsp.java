package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$OprKtvSongRsp extends MessageMicro<KtvKaraokeMikeSvr$OprKtvSongRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"err_info", "mike_id", "req_timestamp"}, new Object[]{null, "", 0}, KtvKaraokeMikeSvr$OprKtvSongRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBStringField mike_id = PBField.initString("");
    public final PBUInt32Field req_timestamp = PBField.initUInt32(0);
}
