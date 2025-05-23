package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptGuessInfo extends MessageMicro<CircleSearchExhibition$PromptGuessInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"name", "reason", "icon", "transfer_info"}, new Object[]{"", 1, null, ""}, CircleSearchExhibition$PromptGuessInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBEnumField reason = PBField.initEnum(1);
    public CircleSearchExhibition$Icon icon = new CircleSearchExhibition$Icon();
    public final PBStringField transfer_info = PBField.initString("");
}
