package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ProcJoinHcRsp extends MessageMicro<KtvKaraokeMikeSvr$ProcJoinHcRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"err_info", "mike_id"}, new Object[]{null, ""}, KtvKaraokeMikeSvr$ProcJoinHcRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBStringField mike_id = PBField.initString("");
}
