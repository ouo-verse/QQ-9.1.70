package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$GetTabListRsp extends MessageMicro<KtvDataSvr$GetTabListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tab_list", "msg"}, new Object[]{null, null}, KtvDataSvr$GetTabListRsp.class);
    public final PBRepeatMessageField<KtvDataSvr$TabItem> tab_list = PBField.initRepeatMessage(KtvDataSvr$TabItem.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413019msg = new KtvCommon$ErrMsg();
}
