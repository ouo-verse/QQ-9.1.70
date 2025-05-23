package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$Location extends MessageMicro<INTERFACE$Location> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"latitude", "longitude", "coordinates_type"}, new Object[]{0, 0, 0}, INTERFACE$Location.class);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
    public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
}
