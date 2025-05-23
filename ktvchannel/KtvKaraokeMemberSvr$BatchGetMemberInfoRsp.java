package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMemberSvr$BatchGetMemberInfoRsp extends MessageMicro<KtvKaraokeMemberSvr$BatchGetMemberInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"member_list"}, new Object[]{null}, KtvKaraokeMemberSvr$BatchGetMemberInfoRsp.class);
    public final PBRepeatMessageField<KtvKaraokeMemberSvr$MemberInfo> member_list = PBField.initRepeatMessage(KtvKaraokeMemberSvr$MemberInfo.class);
}
