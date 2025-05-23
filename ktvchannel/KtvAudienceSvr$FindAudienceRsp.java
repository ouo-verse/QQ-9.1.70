package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$FindAudienceRsp extends MessageMicro<KtvAudienceSvr$FindAudienceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "users_info"}, new Object[]{null, null}, KtvAudienceSvr$FindAudienceRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413013msg = new KtvCommon$ErrMsg();
    public final PBRepeatMessageField<KtvAudienceSvr$AudienceInfo> users_info = PBField.initRepeatMessage(KtvAudienceSvr$AudienceInfo.class);
}
