package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$TabData extends MessageMicro<CircleSearchExhibition$TabData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "text", "text_color"}, new Object[]{1, "", ""}, CircleSearchExhibition$TabData.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField text = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
}
