package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$NoticeToSvrRsp extends MessageMicro<KtvKaraokeMikeSvr$NoticeToSvrRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret_code"}, new Object[]{0}, KtvKaraokeMikeSvr$NoticeToSvrRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
}
