package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptTag extends MessageMicro<CircleSearchExhibition$PromptTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "hot_info"}, new Object[]{"", null}, CircleSearchExhibition$PromptTag.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<CircleSearchExhibition$PromptTagInfo> hot_info = PBField.initRepeatMessage(CircleSearchExhibition$PromptTagInfo.class);
}
