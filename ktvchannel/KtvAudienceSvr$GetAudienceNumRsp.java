package ktvchannel;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$GetAudienceNumRsp extends MessageMicro<KtvAudienceSvr$GetAudienceNumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WidgetCacheConstellationData.NUM, "msg"}, new Object[]{0L, null}, KtvAudienceSvr$GetAudienceNumRsp.class);
    public final PBUInt64Field num = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413015msg = new KtvCommon$ErrMsg();
}
