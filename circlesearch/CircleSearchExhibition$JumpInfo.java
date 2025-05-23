package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$JumpInfo extends MessageMicro<CircleSearchExhibition$JumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"type", "url", "query", "query_source"}, new Object[]{1, "", "", 0}, CircleSearchExhibition$JumpInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
    public final PBStringField query = PBField.initString("");
    public final PBUInt32Field query_source = PBField.initUInt32(0);
}
