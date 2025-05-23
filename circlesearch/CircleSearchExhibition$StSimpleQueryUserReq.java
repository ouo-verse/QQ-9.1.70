package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSimpleQueryUserReq extends MessageMicro<CircleSearchExhibition$StSimpleQueryUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"count", "attach_info", "word"}, new Object[]{0, "", ""}, CircleSearchExhibition$StSimpleQueryUserReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField word = PBField.initString("");
}
