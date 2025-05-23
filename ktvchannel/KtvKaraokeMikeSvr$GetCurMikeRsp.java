package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$GetCurMikeRsp extends MessageMicro<KtvKaraokeMikeSvr$GetCurMikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{"err_info", "mike_info", "sequence_id", "is_wait_mike", "get_curmike_interval", "cur_timestamp", "ext_info"}, new Object[]{null, null, 0L, 0, 0, 0, null}, KtvKaraokeMikeSvr$GetCurMikeRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public KtvKaraokeMikeSvr$KTVMikeInfo mike_info = new KtvKaraokeMikeSvr$KTVMikeInfo();
    public final PBUInt64Field sequence_id = PBField.initUInt64(0);
    public final PBInt32Field is_wait_mike = PBField.initInt32(0);
    public final PBInt32Field get_curmike_interval = PBField.initInt32(0);
    public final PBUInt32Field cur_timestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<KtvCommon$KVItem> ext_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
