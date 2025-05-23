package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$ExtraIcon extends MessageMicro<CircleSearchExhibition$ExtraIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"icon_type", "text", "text_color", "background_color"}, new Object[]{0, "", "", ""}, CircleSearchExhibition$ExtraIcon.class);
    public final PBEnumField icon_type = PBField.initEnum(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField background_color = PBField.initString("");
}
