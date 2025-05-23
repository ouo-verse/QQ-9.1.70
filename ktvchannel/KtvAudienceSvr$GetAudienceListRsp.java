package ktvchannel;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$GetAudienceListRsp extends MessageMicro<KtvAudienceSvr$GetAudienceListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"total_num", PictureConst.KEY_HAS_MORE, "passback", "user_list", "msg"}, new Object[]{0L, 0, "", null, null}, KtvAudienceSvr$GetAudienceListRsp.class);
    public final PBUInt64Field total_num = PBField.initUInt64(0);
    public final PBUInt32Field has_more = PBField.initUInt32(0);
    public final PBStringField passback = PBField.initString("");
    public final PBRepeatMessageField<KtvAudienceSvr$AudienceInfo> user_list = PBField.initRepeatMessage(KtvAudienceSvr$AudienceInfo.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413014msg = new KtvCommon$ErrMsg();
}
