package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StVideoUrl extends MessageMicro<META$StVideoUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"levelType", "playUrl", "videoPrior", "videoRate", "transStatus"}, new Object[]{0, "", 0, 0, 0}, META$StVideoUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
}
