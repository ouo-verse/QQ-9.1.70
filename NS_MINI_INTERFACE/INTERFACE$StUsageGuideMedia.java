package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUsageGuideMedia extends MessageMicro<INTERFACE$StUsageGuideMedia> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"mediaType", "guideMedias", "autoSlideInterval"}, new Object[]{0, "", 0}, INTERFACE$StUsageGuideMedia.class);
    public final PBEnumField mediaType = PBField.initEnum(0);
    public final PBRepeatField<String> guideMedias = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field autoSlideInterval = PBField.initInt32(0);
}
