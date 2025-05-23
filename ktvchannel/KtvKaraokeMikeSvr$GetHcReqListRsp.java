package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$GetHcReqListRsp extends MessageMicro<KtvKaraokeMikeSvr$GetHcReqListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"err_info", "vct_req_info"}, new Object[]{null, null}, KtvKaraokeMikeSvr$GetHcReqListRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBRepeatMessageField<Mem$UserInfo> vct_req_info = PBField.initRepeatMessage(Mem$UserInfo.class);
}
