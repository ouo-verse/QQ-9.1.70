package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$CorrectionInfo extends MessageMicro<CircleSearchExhibition$CorrectionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"correction_word", "correction"}, new Object[]{"", Boolean.FALSE}, CircleSearchExhibition$CorrectionInfo.class);
    public final PBStringField correction_word = PBField.initString("");
    public final PBBoolField correction = PBField.initBool(false);
}
