package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$MikeHasOnRsp extends MessageMicro<KtvKaraokeMikeSvr$MikeHasOnRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"err_info", "mike_id", "sequence_id"}, new Object[]{null, "", 0L}, KtvKaraokeMikeSvr$MikeHasOnRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBStringField mike_id = PBField.initString("");
    public final PBUInt64Field sequence_id = PBField.initUInt64(0);
}
