package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StImageUrl extends MessageMicro<META$StImageUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"levelType", "url", "width", "height"}, new Object[]{0, "", 0, 0}, META$StImageUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
