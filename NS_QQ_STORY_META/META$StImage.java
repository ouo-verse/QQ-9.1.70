package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StImage extends MessageMicro<META$StImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"url", "width", "height", "vecImageUrl", "fileId"}, new Object[]{"", 0, 0, null, ""}, META$StImage.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBRepeatMessageField<META$StImageUrl> vecImageUrl = PBField.initRepeatMessage(META$StImageUrl.class);
    public final PBStringField fileId = PBField.initString("");
}
