package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$DeviceInfo extends MessageMicro<CONTAINER_INTERFACE$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"brand", "model", "os"}, new Object[]{"", "", null}, CONTAINER_INTERFACE$DeviceInfo.class);
    public final PBStringField brand = PBField.initString("");
    public final PBStringField model = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public CONTAINER_INTERFACE$OS f24955os = new MessageMicro<CONTAINER_INTERFACE$OS>() { // from class: NS_MINI_INTERFACE.CONTAINER_INTERFACE$OS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "version"}, new Object[]{0, ""}, CONTAINER_INTERFACE$OS.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField version = PBField.initString("");
    };
}
