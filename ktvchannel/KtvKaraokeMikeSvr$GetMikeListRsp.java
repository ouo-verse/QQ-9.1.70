package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$GetMikeListRsp extends MessageMicro<KtvKaraokeMikeSvr$GetMikeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"err_info", "vct_mike_info", "sequence_id", "mike_total_num", "apply_total_num"}, new Object[]{null, null, 0L, 0, 0}, KtvKaraokeMikeSvr$GetMikeListRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBRepeatMessageField<KtvKaraokeMikeSvr$KTVMikeInfo> vct_mike_info = PBField.initRepeatMessage(KtvKaraokeMikeSvr$KTVMikeInfo.class);
    public final PBUInt64Field sequence_id = PBField.initUInt64(0);
    public final PBUInt32Field mike_total_num = PBField.initUInt32(0);
    public final PBUInt32Field apply_total_num = PBField.initUInt32(0);
}
