package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudConvertidClient$ConvertToXWorldReq extends MessageMicro<FeedCloudConvertidClient$ConvertToXWorldReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id_type", "ids"}, new Object[]{0, ""}, FeedCloudConvertidClient$ConvertToXWorldReq.class);
    public final PBEnumField id_type = PBField.initEnum(0);
    public final PBRepeatField<String> ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
