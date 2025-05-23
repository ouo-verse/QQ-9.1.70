package QC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$SetRecommendItemRsp extends MessageMicro<AioBubbleRecom$SetRecommendItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "payInfo"}, new Object[]{0, null}, AioBubbleRecom$SetRecommendItemRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public AioBubbleRecom$PayInfo payInfo = new AioBubbleRecom$PayInfo();
}
