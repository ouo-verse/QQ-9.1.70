package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StTrans4TinyidRsp extends MessageMicro<INTERFACE$StTrans4TinyidRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tinyidOpenids"}, new Object[]{null}, INTERFACE$StTrans4TinyidRsp.class);
    public final PBRepeatMessageField<INTERFACE$StTinyidOpenidPair> tinyidOpenids = PBField.initRepeatMessage(INTERFACE$StTinyidOpenidPair.class);
}
