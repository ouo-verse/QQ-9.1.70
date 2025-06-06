package defpackage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes5.dex */
public final class RecommendPool$PenetrateData extends MessageMicro<RecommendPool$PenetrateData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field BizType = PBField.initInt32(0);
    public final PBStringField BizId = PBField.initString("");
    public final PBDoubleField Duration = PBField.initDouble(0.0d);
    public final PBDoubleField Width = PBField.initDouble(0.0d);
    public final PBDoubleField Height = PBField.initDouble(0.0d);
    public final PBStringField CateName = PBField.initString("");
    public final PBStringField SubCateName = PBField.initString("");
    public final PBRepeatField<String> Tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField Title = PBField.initString("");
    public final PBStringField MusicId = PBField.initString("");
    public final PBStringField MusicName = PBField.initString("");

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25, 33, 41, 50, 58, 66, 74, 82, 90}, new String[]{"BizType", "BizId", "Duration", "Width", "Height", "CateName", "SubCateName", "Tags", "Title", "MusicId", "MusicName"}, new Object[]{0, "", valueOf, valueOf, valueOf, "", "", "", "", "", ""}, RecommendPool$PenetrateData.class);
    }
}
