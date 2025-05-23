package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMemberSvr$BatchGetMemberInfoReq extends MessageMicro<KtvKaraokeMemberSvr$BatchGetMemberInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin_list"}, new Object[]{0L}, KtvKaraokeMemberSvr$BatchGetMemberInfoReq.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
